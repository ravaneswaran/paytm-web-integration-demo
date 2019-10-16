package rc.demo.app.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import rc.demo.app.controller.PaytmController;
import rc.demo.app.local.service.UserLocalService;

public class RegistrationControllerHelper extends PaytmController {

	private static final long serialVersionUID = 1L;

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected int registerUser(String firstName, String middleInitial, String lastName, String emailId, String password){
        return UserLocalService.registerUser(firstName, middleInitial, lastName, emailId, password);
    }
}
