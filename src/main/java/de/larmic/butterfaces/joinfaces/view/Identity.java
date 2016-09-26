package de.larmic.butterfaces.joinfaces.view;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Identity {

    private String userName;
    private boolean loggedIn;

    public String login(String userName, String password) {
        this.loggedIn = "admin".equals(userName) && "admin".equals(password);
        this.userName = loggedIn ? userName : null;
        return loggedIn ? "/secure/index.jsf?faces-redirect=true" : null;
    }

    public String logout() {
        loggedIn = false;
        userName = null;

        return "/login.jsf?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
}
