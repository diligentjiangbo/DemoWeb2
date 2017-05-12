package bo.jiang.demo.web2.controller;

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
 * @date 2017/5/11 0011 10:09
 */
@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDeleteServlet.class);

  private CustomerService customerService;

  @Override
  public void init() throws ServletException {
    customerService = new CustomerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long id = CastUtil.castLong(req.getParameter("id"));
    LOGGER.info("recv request /customer_delete get id={}", id);
    boolean flag = customerService.deleteCustomer(id);
    if (flag) {
      LOGGER.info("delete success id={}", id);
    } else {
      LOGGER.info("delete fail id={}", id);
    }
    resp.sendRedirect("/customer");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO: 2017/5/11 0011  
  }
}
