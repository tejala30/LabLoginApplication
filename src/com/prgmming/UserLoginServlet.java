package com.prgmming;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tethippe on 3/22/2016.
 */
@WebServlet(urlPatterns = {"/login"}, name = "UserServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userid");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Cookie userIdCookie = new Cookie("userId", userId);

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserEntity loadedUserEntity = (UserEntity) session.load(UserEntity.class, Integer.parseInt(userId));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");


        if (userName!=null && userName.matches(loadedUserEntity.getUsername())) {
            if (password!=null && password.matches(loadedUserEntity.getPassword())){
                out.println();
                out.println();
                out.println();
                request.setAttribute("status", userName);
                out.println();
                out.println();
                out.println();
                request.setAttribute("userId", userId);
            } else {
                request.setAttribute("status", "fail");
            }
        } else {
            request.setAttribute("status", "fail");
        }


        response.addCookie(userIdCookie);
        dispatcher.forward(request, response);
        tx.commit();
        session.close();
//        HibernateUtilities.getSessionFactory().close();
    }
}
