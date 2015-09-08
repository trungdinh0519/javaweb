package javaweb.customer.action;

import javaweb.action.BaseAction;
import javaweb.customer.bo.CustomerBo;
import javaweb.customer.model.Customer;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class ListCustomerAction extends BaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        CustomerBo customerBo = (CustomerBo) getWebApplicationContext().getBean("customerBo");

        DynaActionForm dynaCustomerListForm = (DynaActionForm) form;

        List<Customer> list = customerBo.findAllCustomer();

        dynaCustomerListForm.set("customerList", list);

        return mapping.findForward("success");

    }
}
