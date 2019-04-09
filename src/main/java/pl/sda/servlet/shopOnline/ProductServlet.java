package pl.sda.servlet.shopOnline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/Product", name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductDb db;


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        List<Product> products = db.getProducts();

        if (httpServletRequest.getParameter("id") != null) {
            Long idParameter = Long.valueOf(httpServletRequest.getParameter("id"));
            Optional<Product> first = products.stream().filter(p -> p.getId().equals(idParameter)).findFirst();
            if (first.isPresent()) {
                Product product = first.get();
                httpServletRequest.setAttribute("product", product);
                httpServletResponse.addCookie(new Cookie("LastProductView", String.valueOf(idParameter)));
                httpServletRequest.getRequestDispatcher("/WEB-INF/product.jsp").forward(httpServletRequest, httpServletResponse);
            } else {
                httpServletRequest.getRequestDispatcher("/page").forward(httpServletRequest, httpServletResponse);
            }
        } else {
            httpServletRequest.getRequestDispatcher("/page").forward(httpServletRequest, httpServletResponse);
        }


    }

    @Override
    public void init() throws ServletException {
        db = ProductDb.getInstance();

    }


}

