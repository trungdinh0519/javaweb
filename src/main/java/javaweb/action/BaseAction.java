package javaweb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.struts.ActionSupport;

public class BaseAction extends ActionSupport {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected ApplicationContext ctx;

    public ApplicationContext getApplicationContext() {
        if (ctx == null)
            ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());

        return ctx;
    }

    public Object getBean(String name) {
        if (ctx == null)
            ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
        return ctx.getBean(name);
    }

    public ActionForward execute(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
            throws Exception {
        return super.execute(arg0, arg1, arg2, arg3);
    }
}
