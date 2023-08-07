package ServiceHelper;

import contracts.IAuthenticationService;
import Utils.BasePage;
import Utils.Entity.UserCredential;
import Utils.Enums.*;

public class AuthenticationService extends BasePage implements IAuthenticationService{

	UserCredential userCredential = null;

	public UserCredential getCredentials(UserLoginRole loggedInUserRole) {
		userCredential = new UserCredential();

		switch (loggedInUserRole) {
			case INITIATOR: {
				userCredential.setUsername(getPropertyValue("initiatorUsername"));
				userCredential.setPassword(getPropertyValue("initiatorPassword"));
				break;
			}
			case REVIEWER: {
				userCredential.setUsername(getPropertyValue("reviewerUsername"));
				userCredential.setPassword(getPropertyValue("reviewerPassword"));
				break;
			}
			case APPROVER: {
				userCredential.setUsername(getPropertyValue("approverUsername"));
				userCredential.setPassword(getPropertyValue("approverPassword"));
				break;
			}
			default: {
				userCredential.setUsername(getPropertyValue("initiatorUsername"));
				userCredential.setPassword(getPropertyValue("initiatorPassword"));
				break;
			}
		}
		return userCredential;
	}
}
