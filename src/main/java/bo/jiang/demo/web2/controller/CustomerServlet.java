package bo.jiang.demo.web2.controller;

import bo.jiang.demo.web2.model.Customer;
import bo.jiang.demo.web2.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shumpert.jiang
 * @date 2017/5/11 0011 10:12
 * 进入客户列表界面
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServlet.class);

  private CustomerService customerService;

  @Override
  public void init() throws ServletException {
    customerService = new CustomerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LOGGER.info("recv request /customer get");
    List<Customer> customerList = customerService.getCustomerList();
    req.setAttribute("customerList", customerList);
    req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO: 2017/5/11 0011  
  }
}
