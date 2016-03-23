package com.prgmming;

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
@WebServlet(urlPatterns = {"/logout"}, name = "LogoutServlet")
public class UserLogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie;
        Cookie[] cookies = null;
        cookies = request.getCookies();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if( cookies != null ){
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (Cookie cooky : cookies) {
                cookie = cooky;
                if ((cookie.getName()).compareTo("userId") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.print("Deleted cookie: " +
                            cookie.getName() + "<br/>");
                }
                out.print("Name : " + cookie.getName() + ",  ");
                out.print("Value: " + cookie.getValue() + " <br/>");
            }
        }else{
            out.println(
                    "<h2>No cookies founds</h2>");
        }

        response.sendRedirect("/index.jsp");
    }
}
