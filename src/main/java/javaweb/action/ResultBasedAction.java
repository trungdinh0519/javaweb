/**
 *
 */
package javaweb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

/**
 * @author admin
 */
public abstract class ResultBasedAction extends ActionSupport {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        Result result = (Result) execute(mapping, form, request);
        if (result == null) {
            throw new Exception("Result expected.");
        }

        result.applyResult(request, response);

        // Finally, we don't want Struts to execute the forward
        return null;
    }

    public abstract Result execute(ActionMapping mapping, ActionForm form, HttpServletRequest request) throws Exception;
}