package bo.jiang.demo.web2.controller;

import bo.jiang.demo.web2.model.Customer;
import bo.jiang.demo.web2.service.CustomerService;
import bo.jiang.demo.web2.util.CastUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shumpert.jiang
 * @date 2017/5/11 0011 10:13
 */
@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerShowServlet.class);

  private CustomerService customerService;

  @Override
  public void init() throws ServletException {
    customerService = new CustomerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long id = CastUtil.castLong(req.getParameter("id"));
    LOGGER.info("recv request /customer_show get id={}", id);
    Customer customer = customerService.getCustomer(id);
    req.setAttribute("customer", customer);
    req.getRequestDispatcher("/WEB-INF/view/customer_show.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO: 2017/5/11 0011
  }
}
