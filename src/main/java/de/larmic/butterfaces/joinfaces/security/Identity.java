package de.larmic.butterfaces.joinfaces.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Session scoped spring bean represents logged in user with user name and logged in flag.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Identity {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String userName;
    private boolean loggedIn;

    public String login(String userName, String password) {
        log.info("Try to login user {}", userName);
        this.loggedIn = "admin".equals(userName) && "admin".equals(password);

        if (loggedIn) {
            this.userName = userName;
            log.info("User {} logged in.", userName);
            return "/secure/index.jsf?faces-redirect=true";
        } else {
            this.userName = null;
            log.info("User {} not logged in. Bad credentials.", userName);
            return null;
        }
    }

    public String logout() {
        loggedIn = false;
        userName = null;

        log.info("User {} logged out", userName);

        return "/login.jsf?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
}
