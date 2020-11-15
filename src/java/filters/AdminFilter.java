/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author 789438
 */
public class AdminFilter implements Filter {
    
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
     
      //execute before the servlet or next filter
      HttpServletRequest httpRequest=(HttpServletRequest) request;
      HttpSession session=httpRequest.getSession();
      String email= (String) session.getAttribute("email");
      
      AccountService account =new AccountService();
      User user = account.get(email);
      if(user.getRole().getRoleId() != 1){
     HttpServletResponse httpResponse =(HttpServletResponse) response;
      httpResponse.sendRedirect("notes");
      return;
      }
     
            chain.doFilter(request, response); //execute servlet or next filter
      //execute after servlet or the previous filter.
        }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void destroy() {
     
    }
        
       
        }
    
  

