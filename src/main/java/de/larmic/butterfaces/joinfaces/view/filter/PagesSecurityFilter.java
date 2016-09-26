package de.larmic.butterfaces.joinfaces.view.filter;

import de.larmic.butterfaces.joinfaces.view.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Revision: $Revision$
 */
@Component
public class PagesSecurityFilter implements Filter {

    @Autowired
    private Identity identity;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/secure/") && !identity.isLoggedIn()) {
            try {
                response.sendRedirect(request.getContextPath() + "/login.jsf?faces-redirect=true");
                return;
            } catch (IllegalStateException e) {
                // logger
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}
