package com.gerson.design.observable.test;

/**
 * @author gezz
 * @description
 * @date 2020/5/27.
 */
public class RegisterEvent {

    private String user;
    private String passwd;

    public RegisterEvent(String user, String passwd) {
        this.user = user;
        this.passwd = passwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "RegisterEvent{" +
                "user='" + user + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
