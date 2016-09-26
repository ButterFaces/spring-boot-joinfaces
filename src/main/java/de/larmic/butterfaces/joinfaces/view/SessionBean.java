package de.larmic.butterfaces.joinfaces.view;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SessionBean {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getButterFaces() {
        return "Hello ButterFaces 2.1.11";
    }

}
