package com.example.SessionBean.servlet;

import com.example.SessionBean.businesslogic.SearchFacade;
import com.example.SessionBean.businesslogic.SearchFacadeBean;
import com.example.SessionBean.businesslogic.ShopperCountBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchFacadeClient",
        urlPatterns = {"/SearchFacadeClient"})
public class SearchFacadeClient extends HttpServlet {
    @EJB
    SearchFacade searchFacade;

    @EJB
    ShopperCountBean shopperCount;

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

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchFacadeClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Starting Search Facade test ... </h1>");
            out.println("<h1>SearchFacade Lookup</h1>");
            out.println("<h1>Searching wines</h1>");
            List winesList = searchFacade.wineSearch("Red");
            out.println("<h1>Printing wines list</h1>");
            for (String wine : (List<String>) winesList)
            {
                out.println("<h1>" + wine + "</h1>");
            }
            System.out.println("Printing Shopper Count after incrementing it ...");
            shopperCount.incrementShopperCount();
            out.println("<h1>" + shopperCount.getShopperCount() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        finally {
            out.close();
        }


    }
}
