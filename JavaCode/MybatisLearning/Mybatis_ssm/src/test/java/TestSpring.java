import com.company.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestSpring {

    @Test
    public void testSpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EmployeeService employeeServiceImpl = (EmployeeService) applicationContext.getBean("employeeServiceImpl");
        System.out.println(employeeServiceImpl);
    }
}
