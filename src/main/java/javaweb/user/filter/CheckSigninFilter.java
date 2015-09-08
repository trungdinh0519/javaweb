package javaweb.user.filter;

import javaweb.user.model.AuthUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckSigninFilter implements Filter {

    protected FilterConfig filterConfig;

    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        //String path = ((HttpServletRequest) request).getRequestURI();
        //	if (path.endsWith("/Signin.do")) {


//			httpRequest.getRequestDispatcher("/Signin.do").forward(request, response);
        //} else {
        AuthUser authUser = (AuthUser) httpRequest.getAttribute("auth_user");
        if (authUser == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Signin.do");

        } else {
            doFilter(request, response, chain);
        }
        //	}


        //}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
