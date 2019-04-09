package pl.sda.servlet.shopOnline.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName= "ValidateEmailFilter", servletNames = {"registerServlet"})
public class ValidateEmailFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("POST")) {

            String email = req.getParameter("email");
            if (!validateEmail(email)) {
                req.setAttribute("error", "niepoprawny adres email");
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

    private boolean validateEmail(final String email) {
        if (email == null) {
            return false;
        }
        return validateEmailRegEx(email);

    }

    private boolean validateEmailRegEx(final String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();

    }
}
