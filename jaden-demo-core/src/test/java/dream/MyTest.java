package dream;

import com.jaden.CoreApplication;
import com.jaden.dream.proxy.Account;
import com.jaden.dream.proxy.IAccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CoreApplication.class)
@RunWith(SpringRunner.class)
public class MyTest {
    @Autowired
    private IAccountService accountService;

    @org.junit.Test
    public void mytest() {
        System.out.println("jaden");
    }

    @Test
    public void testFindAccountAll(){
        /*ApplicationContext context = new ClassPathXmlApplicationContext("application.yml");
        IAccountService accountService = (IAccountService) context.getBean("proxyAccountService");
        Account account = new Account();
        account.setId(1);
        account.setMoney(500D);
        account.setName("aaa");
        accountService.updateAccount(account);*/
    }
    @Test
    public void testFindAccountAll1(){
        Account account = new Account();
        account.setId(1);
        account.setMoney(900D);
        account.setName("aaa");
        accountService.updateAccount(account);
    }


}
