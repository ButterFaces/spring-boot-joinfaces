package de.larmic.butterfaces.joinfaces.view;

import org.springframework.web.context.annotation.RequestScope;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScope
public class LoginBean {

    @Inject
    private Identity identity;

    private String userName = "admin";
    private String password = "admin";

    public String login() {
       return identity.login(userName, password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
