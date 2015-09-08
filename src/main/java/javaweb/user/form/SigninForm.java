package javaweb.user.form;

import org.apache.struts.action.ActionForm;

/**
 * ActionForm for signin page.
 *
 * @author admin
 */
public class SigninForm extends ActionForm {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * User name
     */
    private String username = null;

    /**
     * Password
     */
    private String password = null;

    /**
     * Constructor.
     */
    public SigninForm() {
        super();
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
