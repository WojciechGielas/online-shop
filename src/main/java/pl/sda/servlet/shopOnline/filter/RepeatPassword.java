package pl.sda.servlet.shopOnline.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ValidateEmailFilter", servletNames = {"registerServlet"})
public class RepeatPassword implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String password = req.getParameter("password");
            String repeatPassword = req.getParameter("repeatPassword");
            if (!password.equals(repeatPassword)) {
                req.setAttribute("error", "zle powtorzone haslo");
                req.getRequestDispatcher("/WEB-INF/register.jsp").forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
