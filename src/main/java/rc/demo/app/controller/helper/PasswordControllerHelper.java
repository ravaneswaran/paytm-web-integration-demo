package rc.demo.app.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import rc.demo.app.controller.PaytmController;
import rc.demo.app.local.service.UserLocalService;
import rc.demo.app.models.User;

public class PasswordControllerHelper extends PaytmController {

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
