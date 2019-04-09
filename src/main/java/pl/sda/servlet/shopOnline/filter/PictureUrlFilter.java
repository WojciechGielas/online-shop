//package pl.sda.servlet.shopOnline.filter;
//
//import pl.sda.servlet.shopOnline.Product;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@WebFilter(filterName = "pictureUrlFilter", servletNames = {"ProductServlet"})
//public class PictureUrlFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        filterChain.doFilter(servletRequest, servletResponse);
//        final HttpServletRequest req = (HttpServletRequest) servletRequest;
//        if (req.getAttribute("product") != null) {
//            final Product product = (Product) req.getAttribute("product");
//            if (product.getPictureUrl() == null) {
//                product.setPictureUrl("https://png.pngtree.com/element_origin_min_pic/16/07/10/205782414531a9b.jpg");
//            }
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
