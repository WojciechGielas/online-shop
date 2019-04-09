package pl.sda.servlet.shopOnline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet (urlPatterns = "/order", name = "orderServlet")
public class OrderServlet extends HttpServlet {
    private OrderDb orderDb;
    private ProductDb productDb;

    @Override
    public void init() throws ServletException {
        orderDb = OrderDb.getInstance();
        productDb = ProductDb.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String adress = httpServletRequest.getParameter("adress");
        User user = ((User) httpServletRequest.getSession().getAttribute("user"));
        Map<Product, Integer> cart = (Map<Product, Integer>) httpServletRequest.getSession().getAttribute("cart");

        boolean allOk = true;

        for(Map.Entry<Product, Integer> product : cart.entrySet()){
            Optional<Product> first = productDb.getProducts().stream()
                    .filter(prod-> prod.getId().equals(product.getKey().getId()))
                    .findFirst();
            if(first.isPresent()){
                Product existingProd = first.get();
                if(existingProd.getQuantity() - product.getValue()>=0){
                }else{
                    httpServletResponse.sendRedirect("error");
                    allOk = false;
                    break;
                }
            }else{
                httpServletResponse.sendRedirect("error");
                allOk = false;
                break;
            }
        }
        if(allOk){
            orderDb.addNewOrder(cart, adress, user.getEmail());
            httpServletResponse.sendRedirect("/orders");
        }

    }
}
