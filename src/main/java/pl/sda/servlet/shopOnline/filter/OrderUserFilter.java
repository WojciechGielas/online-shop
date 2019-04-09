package pl.sda.servlet.shopOnline.filter;


import pl.sda.servlet.shopOnline.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "orderUserFilter", servletNames = {"orderServlet"})
public class OrderUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        final User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getRoles().contains("user")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
