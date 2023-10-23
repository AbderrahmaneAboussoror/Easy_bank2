package com.AboussororAbderrahmane.app.dao.scripts.AccountDAO;

import com.AboussororAbderrahmane.app.dao.scripts.PersonDAO.IPersonDAO;
import com.AboussororAbderrahmane.app.model.account.Account;
import com.AboussororAbderrahmane.app.model.account.AccountStatus;
import com.AboussororAbderrahmane.app.model.account.SavingAccount;
import com.AboussororAbderrahmane.app.model.person.Client;
import com.AboussororAbderrahmane.app.model.person.Person;
import com.AboussororAbderrahmane.app.util.db.DatabaseConnection;

import static com.AboussororAbderrahmane.app.dao.queries.SavingAccountSQLQueries.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SavingAccountDAO implements IAccountDAO{
    private final IPersonDAO iPersonDAO;

    public SavingAccountDAO(IPersonDAO iPersonDAO) {
        this.iPersonDAO = iPersonDAO;
    }
    @Override
    public Optional<Account> update(Account entity) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SavingAccountSQLQueries.get_UPDATE_SAVING_ACCOUNT());
        ) {

            if (entity instanceof SavingAccount s) {
                ResultSet resultSet = accountUpdatePreparing(preparedStatement, s);
                if (resultSet.next()) {
                    Account client = accountInfo(resultSet);
                    return Optional.of(client);
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Account> save(Account entity) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SavingAccountSQLQueries.get_INSERT_SAVING_ACCOUNT());
        ) {
            if (entity instanceof SavingAccount s) {
                ResultSet resultSet = accountPreparing(preparedStatement, s);
                if (resultSet.next()) {
                    Account account = accountInfo(resultSet);
                    return Optional.of(account);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SavingAccountSQLQueries.get_FIND_ALL_SAVING_ACCOUNTS());
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Account account = accountInfo(resultSet);
                accounts.add(account);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Optional<Account> findById(String s) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SavingAccountSQLQueries.get_FIND_ACCOUNT_BY_ID());)
        {
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = accountInfo(resultSet);
                return Optional.of(account);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SavingAccountSQLQueries.get_DELETE_SAVING_ACCOUNT());
        ) {

            preparedStatement.setString(1, s);
            int clientDeleted = preparedStatement.executeUpdate();
            return clientDeleted > 0;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Account accountInfo(ResultSet resultSet) throws SQLException{
        String employeeCode = resultSet.getString("code_employe");
        String clientCode = resultSet.getString("code_client");
        Optional<Person> employee = iPersonDAO.findById(employeeCode);
        Optional<Person> client = iPersonDAO.findById(clientCode);
        String number = resultSet.getString("number");
        Double balance = resultSet.getDouble("balance");
        LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
        AccountStatus accountStatus = null;
        switch (resultSet.getString("account_status")) {
            case "Active" -> accountStatus = AccountStatus.Active;
            case "Frozen" -> accountStatus = AccountStatus.Frozen;
            case "Closed" -> accountStatus = AccountStatus.Closed;
        }
        Double interestRate = resultSet.getDouble("interest_rate");
        return new SavingAccount(number, balance, createdAt, accountStatus, (Employee) employee, (Client) client, interestRate);
    }
    private ResultSet accountUpdatePreparing(PreparedStatement preparedStatement, SavingAccount s) throws SQLException {
        preparedStatement.setDouble(1, s.get_balance());
        preparedStatement.setDate(2, java.sql.Date.valueOf(s.get_createdAt()));
        preparedStatement.setObject(3, s.get_status(), Types.OTHER);
        preparedStatement.setDouble(4, s.get_interestRate());
        preparedStatement.setString(5, s.get_number());
        return preparedStatement.executeQuery();
    }
    private ResultSet accountPreparing(PreparedStatement preparedStatement, SavingAccount s) throws SQLException {
        preparedStatement.setString(1, s.get_number());
        preparedStatement.setDouble(2, s.get_balance());
        preparedStatement.setDate(3, java.sql.Date.valueOf(s.get_createdAt()));
        preparedStatement.setObject(4, s.get_status(), Types.OTHER);
        preparedStatement.setDouble(5, s.get_interestRate());
        preparedStatement.setString(6, s.get_employee().get_code());
        preparedStatement.setString(7, s.get_client().get_code());
        return preparedStatement.executeQuery();
    }
}
