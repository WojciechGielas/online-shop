package pl.sda.servlet.shopOnline.filter;

import pl.sda.servlet.shopOnline.User;
import pl.sda.servlet.shopOnline.UserDb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(filterName= "UserNameEmailFilter", servletNames = {"registerServlet"})
public class UserNameAndEmailFilter implements Filter {

    private UserDb userdb;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userdb = UserDb.getInstance();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String userName = req.getParameter("userName");
            String email = req.getParameter("email");
            Optional<User> optionalUser = userdb.checkUser(userName, email);

            if (optionalUser.isPresent()) {
                req.setAttribute("error", "Taki login lub email już istnieje");
                req.getRequestDispatcher("/WEB-INF/register.jsp").forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }


}
