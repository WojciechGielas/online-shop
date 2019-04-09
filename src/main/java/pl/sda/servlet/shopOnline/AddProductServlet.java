package pl.sda.servlet.shopOnline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addProduct", name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    private ProductDb db;


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    String name = httpServletRequest.getParameter("name");
    Long price = Long.valueOf(httpServletRequest.getParameter("price"));
    String description = httpServletRequest.getParameter("description");
    String category = httpServletRequest.getParameter("category");
    int quantity = Integer.valueOf(httpServletRequest.getParameter("quantity"));

    long id = ProductDb.getInstance().addNewProduct(name, description, price, category, quantity, null);

    httpServletResponse.sendRedirect("/Product?id="+id);
    }
}
