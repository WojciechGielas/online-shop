package pl.sda.servlet.shopOnline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDb userdb;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String userName = httpServletRequest.getParameter("userName");
        String password = httpServletRequest.getParameter("password");

        Optional<User> optionalUser = userdb.checkLogin(userName, password);
        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            httpServletRequest.getSession().setAttribute("user", user);
            httpServletResponse.sendRedirect("/page");
        } else {
            httpServletRequest.setAttribute("error", true);
            httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(httpServletRequest, httpServletResponse);
        }

    }

    @Override
    public void init() throws ServletException {
        userdb = UserDb.getInstance();

    }
}
