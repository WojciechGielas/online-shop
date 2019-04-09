package pl.sda.servlet.shopOnline.filter;

import pl.sda.servlet.shopOnline.Order;
import pl.sda.servlet.shopOnline.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "counterOrderFilter", servletNames = {"orderServlet"})
public class CounterOrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getSession().getAttribute("orderServlet") == null) {
            req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(servletRequest, servletResponse);
        } else {
            boolean hasProducts = ((Map<Product, Integer>) req.getSession().getAttribute("cart")).size() > 0;

            if (hasProducts) {
                filterChain.doFilter(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
