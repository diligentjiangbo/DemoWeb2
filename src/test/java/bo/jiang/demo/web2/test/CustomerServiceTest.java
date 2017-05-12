package bo.jiang.demo.web2.test;

import bo.jiang.demo.web2.helper.DatabaseHelper;
import bo.jiang.demo.web2.model.Customer;
import bo.jiang.demo.web2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shumpert.jiang
 * @date 2017/5/11 0011 10:26
 * CustomerService单元测试
 */
public class CustomerServiceTest {

  private final CustomerService customerService;

  public CustomerServiceTest() {
    customerService = new CustomerService();
  }

  @Before
  public void init() {
    DatabaseHelper.executeSqlFile("sql/customer_init.sql");
  }

  @Test
  public void getCustomerListTest() throws Exception {
    List<Customer> customerList = customerService.getCustomerList();
    Assert.assertEquals(2, customerList.size());
  }

  @Test
  public void getCustomerTest() throws Exception {
    long id = 1;
    Customer customer = customerService.getCustomer(id);
    Assert.assertNotNull(customer);
  }

  @Test
  public void createCustomerTest() throws Exception {
    Map<String, Object> fieldMap = new HashMap<String, Object>();
    fieldMap.put("name", "customer100");
    fieldMap.put("contact", "John");
    fieldMap.put("telephone", "13512345678");
    boolean result = customerService.createCustomer(fieldMap);
    Assert.assertTrue(result);
  }

  @Test
  public void updateCustomerTest() throws Exception {
    long id = 1;
    Map<String, Object> fieldMap = new HashMap<String, Object>();
    fieldMap.put("contact", "Eric");
    boolean result = customerService.updateCustomer(id, fieldMap);
    Assert.assertTrue(result);
  }

  @Test
  public void deleteCustomerTest() throws Exception {
    long id = 1;
    boolean result = customerService.deleteCustomer(id);
    Assert.assertTrue(result);
  }

}
