package com.AboussororAbderrahmane.app.dao.scripts.PersonDAO;

import com.AboussororAbderrahmane.app.dao.queries.EmployeeSQLQueries;
import com.AboussororAbderrahmane.app.model.person.Client;
import com.AboussororAbderrahmane.app.model.person.Employee;
import com.AboussororAbderrahmane.app.model.person.Person;
import com.AboussororAbderrahmane.app.util.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.AboussororAbderrahmane.app.dao.queries.EmployeeSQLQueries.*;

public class EmployeeDAO  implements IPersonDAO{
    @Override
    public Optional<Person> save(Person entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> update(Person entity) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Optional<Person> findById(String s) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EmployeeSQLQueries.get_FIND_BY_ID());)
        {
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Person client = employeeInfo(resultSet);
                return Optional.of(client);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Employee employeeInfo(ResultSet resultSet) throws SQLException {
        String code = resultSet.getString("code");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
        String phoneNumber = resultSet.getString("phone_number");
        String email = resultSet.getString("email");
        LocalDate recruitedAt = resultSet.getDate("recruited_at").toLocalDate();
        return new Employee(code, firstName, lastName,birthDate, phoneNumber, email, recruitedAt);
    }
}
