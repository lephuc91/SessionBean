package com.example.SessionBean.servlet;

import com.example.SessionBean.businesslogic.ShopperCountBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingCountClient",
    urlPatterns = {"/ShopperCountClient"})
public class ShopperCountClient extends HttpServlet {
    @EJB
    ShopperCountBean shopperCount;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            out.println("<title>Servlet ShopperCountClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resetting Shopper Count ... </h1>");
            shopperCount.resetCounter();
            out.println("<h1>Incrementing Shopper Count ... </h1>");
            shopperCount.incrementShopperCount();
            out.println("<h1>Shopper Count: " + shopperCount.getShopperCount() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        finally {
            out.close();
        }


    }
}
