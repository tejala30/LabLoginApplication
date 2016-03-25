package com.prgmming;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * Created by tethippe on 3/23/2016.
 */
@WebServlet(urlPatterns = {"/productentity"}, name = "ProductEntityServlet")
public class ProductEntityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductEntity> entities;

        Cookie cookie;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        Integer userId = -1;

        Boolean cookieFound = false;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if( cookies != null ) {
            for (Cookie cooky : cookies) {
                cookie = cooky;
                if ((cookie.getName()).compareTo("userId") == 0) {
                    cookieFound = true;
                    userId = Integer.parseInt(cookie.getValue());

                    Session session = HibernateUtilities.getSessionFactory().openSession();
                    Transaction tx = session.beginTransaction();

                    System.out.println(userId);
                    if (userId == 0) {
                        entities = session.createCriteria(ProductEntity.class).list();
                    } else {
                        String sql = "SELECT * FROM protein_tracker.product where userId = :user_id";
                        SQLQuery query = session.createSQLQuery(sql);
                        query.addEntity(ProductEntity.class);
                        query.setParameter("user_id", userId);
                        entities = query.list();
                    }

                    tx.commit();
                    session.close();

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entity_index.jsp");
                    request.setAttribute("entities", entities);
                    dispatcher.forward(request, response);
//                    return;
                }
            }
        }

        if (!cookieFound) {
            response.sendRedirect("/login.jsp");
        }
    }
}
