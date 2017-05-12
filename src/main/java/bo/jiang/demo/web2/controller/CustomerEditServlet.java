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
import java.util.HashMap;
import java.util.Map;

/**
 * @author shumpert.jiang
 * @date 2017/5/11 0011 10:11
 */
@WebServlet("/customer_edit")
public class CustomerEditServlet extends HttpServlet {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerEditServlet.class);

  private CustomerService customerService;

  @Override
  public void init() throws ServletException {
    customerService = new CustomerService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long id = CastUtil.castLong(req.getParameter("id"));
    LOGGER.info("recv request /customer_edit get id={}", id);
    Customer customer = customerService.getCustomer(id);
    req.setAttribute("customer", customer);
    req.getRequestDispatcher("/WEB-INF/view/customer_edit.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long id = CastUtil.castLong(req.getParameter("id"));
    String name = CastUtil.castString(req.getParameter("name"));
    String contact = CastUtil.castString(req.getParameter("contact"));
    String telephone = CastUtil.castString(req.getParameter("telephone"));
    String email = CastUtil.castString(req.getParameter("email"));
    LOGGER.info("recv request /customer_edit post id={}, name={}, contact={}, telephone={}, email={}",id, name, contact, telephone, email);
    Map<String, Object> map = new HashMap<>();
    map.put("name", name);
    map.put("contact", contact);
    map.put("telephone", telephone);
    map.put("email", email);
    boolean flag = customerService.updateCustomer(id, map);
    if (flag) {
      LOGGER.info("modify success");
    } else {
      LOGGER.warn("modify fail");
    }
    resp.sendRedirect("/customer");
  }
}
