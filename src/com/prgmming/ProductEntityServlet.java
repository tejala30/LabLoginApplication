package com.prgmming;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by tethippe on 3/23/2016.
 */
@WebServlet(urlPatterns = {"/productentity"}, name = "ProductEntityServlet")
public class ProductEntityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductEntity> entities;

        HttpSession sess = request.getSession(false);
        Integer userId = Integer.parseInt(sess.getAttribute("userId").toString());

        System.out.println(userId);

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT * FROM protein_tracker.product where userId = :user_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(ProductEntity.class);
        query.setParameter("user_id", userId);
        entities = query.list();
        tx.commit();
        session.close();
//        HibernateUtilities.getSessionFactory().close();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entity_index.jsp");
//        getServletContext().setAttribute("entities", entities);
        request.setAttribute("entities", entities);
        dispatcher.forward(request, response);
    }
}
