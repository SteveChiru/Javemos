import org.javemos.ssmcrud.pojo.Customer;
import org.javemos.ssmcrud.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml"
                        ,"classpath:applicationContext-dao.xml"})
@Controller
public class serviceTest {

    @Autowired
    private CustomerService customerService;

    //通过客户id获取客户信息
    @Test
    public void getCustomerById(){
        Customer customer = customerService.getCustomerById(14L);
        System.out.println(customer);
    }

}
