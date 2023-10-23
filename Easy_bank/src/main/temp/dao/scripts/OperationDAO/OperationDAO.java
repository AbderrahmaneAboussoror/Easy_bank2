package com.AboussororAbderrahmane.app.dao.scripts.OperationDAO;

import static com.AboussororAbderrahmane.app.dao.queries.OperationSQLQueries.*;

import com.AboussororAbderrahmane.app.dao.scripts.AccountDAO.IAccountDAO;
import com.AboussororAbderrahmane.app.dao.scripts.PersonDAO.IPersonDAO;
import com.AboussororAbderrahmane.app.model.account.Account;
import com.AboussororAbderrahmane.app.model.account.CurrentAccount;
import com.AboussororAbderrahmane.app.model.account.SavingAccount;
import com.AboussororAbderrahmane.app.model.operation.Operation;
import com.AboussororAbderrahmane.app.model.operation.paymentType;
import com.AboussororAbderrahmane.app.model.person.Person;
import com.AboussororAbderrahmane.app.util.db.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OperationDAO implements IOperationDAO{
    private final IAccountDAO iAccountDAO;
    private final IPersonDAO iPersonDAO;
    public OperationDAO(IAccountDAO iAccountDAO, IPersonDAO iPersonDAO) {
        this.iAccountDAO = iAccountDAO;
        this.iPersonDAO = iPersonDAO;
    }
    @Override
    public Optional<Operation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<Operation> update(Operation entity) {
        return Optional.empty();
    }

    @Override
    public List<Operation> findAll() {
        return null;
    }

    @Override
    public Optional<Operation> save(Operation entity) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(OperationSQLQueries.get_INSERT_OPERATION());
                ){
            preparedStatement.setDate(1, java.sql.Date.valueOf(entity.get_createdAt()));
            preparedStatement.setDouble(2, entity.get_price());
            if(entity.get_payment() == paymentType.Withdrawal) {
                double withdrawalAmount = entity.get_price();
                double accountBalance = entity.get_account().get_balance();

                if (withdrawalAmount > accountBalance) { return Optional.empty(); }

                Double newBalance = entity.get_account().get_balance() - entity.get_price();
                entity.get_account().set_balance(newBalance);

                iAccountDAO.updateBalance(entity.get_account());

                preparedStatement.setObject(3, paymentType.Withdrawal, Types.OTHER);
            }
            else {
                Double newBalance = entity.get_account().get_balance() + entity.get_price();
                entity.get_account().set_balance(newBalance);

                iAccountDAO.updateBalance(entity.get_account());

                preparedStatement.setObject(3, paymentType.Deposit, Types.OTHER);
            }
            preparedStatement.setString(4, entity.get_employee().get_code());

            if (entity.get_account() instanceof CurrentAccount c) {
                preparedStatement.setString(5, c.get_number());
                preparedStatement.setString(6, null);
            }
            else {
                preparedStatement.setString(5, null);
                preparedStatement.setString(6, entity.get_account().get_number());
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int number = resultSet.getInt("number");
                LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
                Double price = resultSet.getDouble("price");
                paymentType payment = null;
                switch (resultSet.getString("payment")) {
                    case "Deposit" -> payment = paymentType.Deposit;
                    case "Withdrawal" -> payment = paymentType.Withdrawal;
                }
                String employeeCode = resultSet.getString("employee_code");
                Optional<Person> employee = iPersonDAO.findById(employeeCode);
                String currentAccountNumber = resultSet.getString("current_account_number");
                String savingAccountNumber = resultSet.getString("saving_account_number");

                if (currentAccountNumber != null) {
                    Optional<Account> account = iAccountDAO.findById(currentAccountNumber);
                    return new Operation(number, createdAt, price, payment, (Employee) employee, account, null);
                }
                else {
                    Optional<Account> account = iAccountDAO.findById(savingAccountNumber);
                    return new Operation(number, createdAt, price, payment, (Employee) employee, account, null);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(OperationSQLQueries.get_DELETE_OPERATION())
                ){
            preparedStatement.setInt(1, integer);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
