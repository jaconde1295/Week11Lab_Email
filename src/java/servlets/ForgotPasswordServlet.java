/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author 631503
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
          
        AccountService as = new AccountService();
        
        String email = request.getParameter("email");
        String path = "/WEB-INF/emailtemplates/forgotpassword.html";
        boolean isTrue = as.forgotPassword(email, path);
        
        if(isTrue == true)
        {
            request.setAttribute("email", email);
            request.setAttribute("message", "If the address you entered is valid, you will receive an email very soon.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
    }

   

}
