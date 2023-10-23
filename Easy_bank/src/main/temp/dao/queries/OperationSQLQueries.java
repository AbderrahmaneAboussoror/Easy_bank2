package com.AboussororAbderrahmane.app.dao.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OperationSQLQueries {
    @Getter
    private static final String _FIND_BY_ID = "SELECT * FROM operation WHERE number = ?;";
    @Getter
    private static final String _INSERT_OPERATION = "INSERT INTO operation (created_at, price, payment, employee_code, current_account_number, saving_account_number) VALUES (?, ?, ?, ?, ?, ?) RETURNING *;";
    @Getter
    private static final String _DELETE_OPERATION = "DELETE FROM operation WHERE number = ?";
}
