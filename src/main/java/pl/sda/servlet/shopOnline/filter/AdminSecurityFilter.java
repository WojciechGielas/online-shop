package pl.sda.servlet.shopOnline.filter;

import pl.sda.servlet.shopOnline.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "adminSecurity", servletNames = {"AddProductServlet"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final User user = (User) req.getSession().getAttribute("user");
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("POST") || req.getMethod().equalsIgnoreCase("GET")) {
            if (user != null && user.getRoles().contains("admin")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.sendRedirect("/login");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
