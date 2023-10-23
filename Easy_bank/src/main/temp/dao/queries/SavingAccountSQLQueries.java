package com.AboussororAbderrahmane.app.dao.queries;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SavingAccountSQLQueries {
    @Getter
    private static final String _FIND_ALL_SAVING_ACCOUNTS = "SELECT * FROM saving_account c, client cl, employee e WHERE c.code_client = cl.code AND c.code_employe = e.code;";
    @Getter
    private static final String _INSERT_SAVING_ACCOUNT = "INSERT INTO saving_account(number, balance, created_at, account_status, interest_rate, code_employe, code_client) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING *;";
    @Getter
    private static final String _DELETE_SAVING_ACCOUNT = "DELETE FROM saving_account WHERE number = ?;";
    @Getter
    private static final String _UPDATE_SAVING_ACCOUNT_STATUS = "UPDATE saving_account SET account_status = ? WHERE number = ? RETURNING *;";
    @Getter
    private static final String _FIND_ACCOUNTS_BY_CLIENT = "SELECT * FROM saving_account c, client cl WHERE c.code_client = cl.code AND cl.code = ?;";
    @Getter
    private static final String _FIND_ACCOUNT_BY_ID = "SELECT * FROM saving_account WHERE number = ?;";
    @Getter
    private static final String _UPDATE_ACCOUNT_BALANCE = "UPDATE saving_account SET balance = ? WHERE number = ? RETURNING *";
    @Getter
    private static final String _UPDATE_SAVING_ACCOUNT = "UPDATE saving_account SET balance = ?, created_at = ?, account_status = ?, interest_rate = ? WHERE number = ? RETURNING *;";
}
