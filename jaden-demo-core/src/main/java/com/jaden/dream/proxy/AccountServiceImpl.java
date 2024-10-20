package com.jaden.dream.proxy;

import com.jaden.dream.trascation.MyTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	@Autowired
    MyTransactionManager transactionManager;
    @Autowired
    IAccountDao accountDao;
    @Autowired
    private ConnectionUtils connectionUtils;
	
	@Override
    public void updateAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.updateAccount(account);
            int a = 1/0; // 模拟业务层出错
            transactionManager.commitTransaction();
        }catch (Exception e){
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        }finally {
            transactionManager.release();
        }
    }
}
