
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
    
 @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session=httpRequest.getSession();
        
        String email=(String)session.getAttribute("email");
        if(email==null){
            HttpServletResponse httpResponse=(HttpServletResponse)response;
            httpResponse.sendRedirect("login");
            return;
        }
        
     //this code will execute before the servlet.
        
     //forward on to the servlet or next filter
            chain.doFilter(request, response);
      
     //this code will execute after the servlet
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
  
    }

    @Override
    public void destroy() {
  
    }

  
}
