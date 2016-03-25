package com.prgmming;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Created by tethippe on 3/25/2016.
 */
@WebServlet(name = "NewUserServlet")
public class NewUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userid");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        String sql = "INSERT into protein_tracker.users VALUES (:user_id, :user_name, :pass_word)";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("user_id", userId);
        query.setParameter("user_name", userName);
        query.setParameter("pass_word", password);
        query.addEntity(UserEntity.class);
        query.executeUpdate();
        tx.commit();
//        session.close();
//
//        Session session1 = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String sql1 = "SELECT count(*) from protein_tracker.users WHERE userId = :user_id";
        SQLQuery query1 = session.createSQLQuery(sql1);
        query1.setParameter("user_id", userId);
//        query1.addEntity(UserEntity.class);
        Integer count = ((BigInteger) query1.uniqueResult()).intValue();
        tx1.commit();

        session.close();

        if (count == 1) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "fail");
        }

//        request.setAttribute("status", "success");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insert_user.jsp");
        dispatcher.forward(request, response);

    }
}
