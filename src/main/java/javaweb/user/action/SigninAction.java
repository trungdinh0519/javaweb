package javaweb.user.action;

import javaweb.action.BaseAction;
import javaweb.user.bo.UserBo;
import javaweb.user.form.SigninForm;
import javaweb.user.model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SigninAction extends BaseAction {
    protected boolean isSignined(HttpSession session) {
        session.getAttribute("auth_user");
        return true;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        // re checked sign in.
        // if (!isSignined()) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>IN here");
        logger.info("signin action process ");

        UserBo userBo = (UserBo) getWebApplicationContext().getBean("userBo");

        SigninForm signForm = (SigninForm) form;
        User user = new User();

        BeanUtils.copyProperties(signForm, user);

        boolean isOk = userBo.signin(user);

        if (!isOk) {
            // store username and in session scope variable
        } else {
            return mapping.findForward("fail");
        }

        // }
        return mapping.findForward("success");

    }


}
