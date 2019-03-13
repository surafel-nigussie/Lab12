package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (null == req.getSession(false)) {
            req.setAttribute("message", "Session timeout.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
