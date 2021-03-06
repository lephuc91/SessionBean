package com.example.SessionBean.servlet;

import com.example.SessionBean.businesslogic.ShoppingCartBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartClient",
    urlPatterns = {"/ShoppingCartClient"})
public class ShoppingCartClient extends HttpServlet {
    @EJB
    ShoppingCartBean shoppingCart;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingCartClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Starting Shopping Cart test ... </h1>");

            out.println("<h1>ShoppingCart Lookup </h1>");
            out.println("<h1>Adding Wine Item </h1>");
            shoppingCart.addWineItem("Zinfadel");
            out.println("<h1>Printing Cart Items </h1>");
            ArrayList cartItems = shoppingCart.getCartItems();
            for (String wine: (List<String>) cartItems)
            {
                out.println("<h1>" + wine + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        finally {
            out.close();
        }


    }
}
