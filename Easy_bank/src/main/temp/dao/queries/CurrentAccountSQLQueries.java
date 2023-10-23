package com.AboussororAbderrahmane.app.dao.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CurrentAccountSQLQueries {
    @Getter
    private static final String _FIND_ALL_CURRENT_ACCOUNTS = "SELECT * FROM current_account c, client cl, employee e WHERE c.code_client = cl.code AND c.code_employe = e.code;";
    @Getter
    private static final String _INSERT_CURRENT_ACCOUNT = "INSERT INTO current_account(number, balance, created_at, account_status, overdraft, code_employe, code_client) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING *;";
    @Getter
    private static final String _DELETE_CURRENT_ACCOUNT = "DELETE FROM current_account WHERE number = ?;";
    @Getter
    private static final String _UPDATE_CURRENT_ACCOUNT_STATUS = "UPDATE current_account SET account_status = ? WHERE number = ? RETURNING *;";
    @Getter
    private static final String _FIND_ACCOUNTS_BY_CLIENT = "SELECT * FROM current_account c, client cl WHERE c.code_client = cl.code AND cl.code = ?;";
    @Getter
    private static final String _FIND_ACCOUNT_BY_ID = "SELECT * FROM current_account WHERE number = ?;";
    @Getter
    private static final String _UPDATE_ACCOUNT_BALANCE = "UPDATE current_account SET balance = ? WHERE number = ? RETURNING *";
    @Getter
    private static final String _UPDATE_CURRENT_ACCOUNT = "UPDATE current_account SET balance = ?, created_at = ?, account_status = ?, overdraft = ? WHERE number = ? RETURNING *;";
}
