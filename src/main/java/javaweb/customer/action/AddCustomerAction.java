package javaweb.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javaweb.action.BaseAction;
import javaweb.customer.bo.CustomerBo;
import javaweb.customer.form.CustomerForm;
import javaweb.customer.model.Customer;

public class AddCustomerAction extends BaseAction {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        logger.info("Get Business Object.");

        CustomerBo customerBo = (CustomerBo) getWebApplicationContext().getBean("customerBo");

        CustomerForm customerForm = (CustomerForm) form;
        Customer customer = new Customer();

        // copy customerform to model
        BeanUtils.copyProperties(customer, customerForm);

        // save it
        customerBo.addCustomer(customer);

        return mapping.findForward("success");

    }
}
