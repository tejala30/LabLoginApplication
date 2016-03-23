package com.prgmming;

import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tethippe on 3/22/2016.
 */
@WebServlet(urlPatterns = {"/entity"}, name = "EntityServlet")
public class UserEntityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserEntity> entities;

        Session session = HibernateUtilities.getSessionFactory().openSession();

        entities = session.createCriteria(UserEntity.class).list();

//        session.getTransaction().commit();
        session.close();
        HibernateUtilities.getSessionFactory().close();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entity_index.jsp");
//        getServletContext().setAttribute("entities", entities);
        request.setAttribute("entities", entities);
        dispatcher.forward(request, response);
    }


}
