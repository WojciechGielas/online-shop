package pl.sda.servlet.model;

import pl.sda.servlet.model.User;
import pl.sda.servlet.model.UserBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class NewServlet extends HttpServlet {

    UserBase userbase;
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String name = httpServletRequest.getParameter("name");
        List<User> users = userbase.getUsers();
        if (name != null){
            users = users.stream()
                    .filter(i -> i.getName().equalsIgnoreCase("name"))
                    .collect(Collectors.toList());
        }

        httpServletResponse.getWriter().print(users);

        httpServletRequest.setAttribute("user", users.get(0));
        httpServletRequest.getRequestDispatcher("/WEB-INF/index.jsp").forward(httpServletRequest, httpServletResponse);


        }





    @Override
    public void init() throws ServletException {
        User user = new User(30, "Jan", "Janowski");
        User user2 = new User(31, "Kuba", "Kubowski");
        User user3 = new User(32, "Piotr", "Piotrowski");

        userbase = UserBase.getInstance();
        userbase.addUser(user);
        userbase.addUser(user2);
        userbase.addUser(user3);



    }
}
