package pl.sda.servlet.shopOnline.filter;

import pl.sda.servlet.shopOnline.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebFilter(filterName = "CheckCartIsNotNull", servletNames = {"cart"})
public class CheckCartIsNotNull implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getSession().getAttribute("cart") == null) {
            req.getSession().setAttribute("cart", new HashMap<Product, Integer>());
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
