package javaweb.user.model;

import java.util.Calendar;
import java.util.Date;

public class AuthUser {
    private String username;
    private Date signinTime;

    public AuthUser() {
        super();
    }

    public boolean isTimeout() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -30);

        return signinTime.compareTo(now.getTime()) > 0;
    }

    public boolean isActive() {
        return true;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the signinTime
     */
    public Date getSigninTime() {
        return signinTime;
    }

    /**
     * @param signinTime the signinTime to set
     */
    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }
}
