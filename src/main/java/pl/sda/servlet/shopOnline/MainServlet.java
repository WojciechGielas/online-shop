package pl.sda.servlet.shopOnline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet(value = "/page", name = "pageServlet")
public class MainServlet extends HttpServlet {

    private ProductDb db;
    private  int cookieId;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("products", db.getProducts());

        if (httpServletRequest.getCookies()!=null) {
            for (final Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("LastProductView")) {
                    long prodId = Integer.valueOf(cookie.getValue());
                    db.getProducts()
                            .stream()
                            .filter(product -> product.getId().equals(prodId))
                            .findFirst()
                            .ifPresent(product -> httpServletRequest.setAttribute("Last", product));
                }
            }
            httpServletRequest.getRequestDispatcher("/WEB-INF/index.jsp").forward(httpServletRequest, httpServletResponse);

        }

//        Stream.of(httpServletRequest.getCookies())
//                .filter(cookie -> cookie.getName().equals("LastProductView"))
//                .findFirst();
//
    }

    @Override
    public void init() throws ServletException {
        db = ProductDb.getInstance();

    }
}
