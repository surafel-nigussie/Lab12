package servlet;

import dao.ProductDAO;
import dao.UserDAO;
import model.ProductModel;
import model.UserModel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    private ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDAO = new UserDAO();
        productDAO = new ProductDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userDAO.authenticateUser(username, password)) {
            req.getSession().setAttribute("UserModel", new UserModel(username, password));

            if (req.getParameter("remember_me") != null) {
                Cookie cookie_username = new Cookie("username", username);
                cookie_username.setMaxAge(60 * 60 * 24 * 31);
                resp.addCookie(cookie_username);

                Cookie cookie_remember_me = new Cookie("remember_me", "true");
                cookie_remember_me.setMaxAge(60 * 60 * 24 * 31);
                resp.addCookie(cookie_remember_me);

                Cookie cookie_coupon = new Cookie("Coupon", "$100");
                cookie_coupon.setMaxAge(60 * 60 * 24 * 31);
                resp.addCookie(cookie_coupon);
            } else {
                Cookie cookie_username = new Cookie("username", null);
                cookie_username.setMaxAge(0);
                resp.addCookie(cookie_username);

                Cookie cookie_remember_me = new Cookie("remember_me", null);
                cookie_remember_me.setMaxAge(0);
                resp.addCookie(cookie_remember_me);
            }

            req.setAttribute("productList", productDAO.getAllProducts());
            req.getRequestDispatcher("views/products.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Invalid username and/or password.");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
    }
}