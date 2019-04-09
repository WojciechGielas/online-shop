package pl.sda.servlet.shopOnline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/register", name ="registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserDb userdb;


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/register.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String userName = httpServletRequest.getParameter("userName");
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
//        String repeatPassword = httpServletRequest.getParameter("repeatPassword");

//        Optional<User> optionalUser = userdb.checkUser(userName, email);
//        if (!validateEmail(email)) {
//            httpServletRequest.setAttribute("error", "incorrectly filled form");
//            httpServletRequest.getRequestDispatcher("/WEB-INF/register.jsp").forward(httpServletRequest, httpServletResponse);
//        (!optionalUser.isPresent() && password.equals(repeatPassword)
            User user = userdb.addNewUser(userName, email, password, Arrays.asList("User"));
            httpServletRequest.getSession().setAttribute("user", user);
            httpServletResponse.sendRedirect("/page");


//        } else {
//            httpServletRequest.setAttribute("error", "taki login lub email juz istnieje");
//            httpServletRequest.getRequestDispatcher("/WEB-INF/register.jsp").forward(httpServletRequest, httpServletResponse);
//        }
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

    @Override
    public void init() throws ServletException {
        userdb = UserDb.getInstance();
    }
}
