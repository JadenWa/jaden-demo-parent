package com.jaden.dream.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
   @Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
    public void updateAccount(Account account) {
            //queryRunner.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
