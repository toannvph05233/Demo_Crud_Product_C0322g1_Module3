package controller;

import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    public static List<Product> products = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        products.add(new Product(1,500,"BMW","https://cdn.motor1.com/images/mgl/3WW1j1/s3/2022-bmw-i7.jpg"));
        products.add(new Product(2,300,"Toyota","https://c8n8e4j6.rocketcdn.me/wp-content/uploads/2022/05/2023_Toyota_4Runner_40th_Anniversary-1.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        RequestDispatcher dispatcher;
        switch (action){
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                for (Product p:products) {
                    if (p.getId() == id){
                        products.remove(p);
                        break;
                    }
                }
                resp.sendRedirect("/product");
                break;
            case "create":
                dispatcher = req.getRequestDispatcher("createProduct.jsp");
                dispatcher.forward(req,resp);
                break;
            default:
                req.setAttribute("products", products);
                dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int price = Integer.parseInt(req.getParameter("price"));
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        products.add(new Product(id,price,name,img));

        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,resp);

    }
}
