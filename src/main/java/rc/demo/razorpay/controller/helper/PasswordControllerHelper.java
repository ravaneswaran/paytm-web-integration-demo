package rc.demo.razorpay.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import rc.demo.razorpay.controller.RazorPayController;
import rc.demo.razorpay.models.User;
import rc.demo.razorpay.service.local.UserLocalService;

public class PasswordControllerHelper extends RazorPayController {

	private static final long serialVersionUID = 1L;

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected String getUserPassword(String email){
        User user = UserLocalService.fetchUserBy(email);
        if(null != user){
            return user.getPassword();
        }
        return null;
    }
}
