package Page.ServiceHelper;

import Page.contracts.IAuthenticationService;
import Utils.BasePage;
import Utils.Entity.UserCredential;
import Utils.Enums.UserLoginRole;

public class AuthenticationService extends BasePage implements IAuthenticationService {

	UserCredential userCredential = null;

	public UserCredential getCredentials(UserLoginRole loggedInUserRole) {
		userCredential = new UserCredential();

		switch (loggedInUserRole) {
			case INITIATOR: {
				userCredential.setUsername(getPropertyValue(environmentName+"ReqUserName"));
				userCredential.setPassword(getPropertyValue(environmentName+"ReqPassword"));
				break;
			}
			case REVIEWER: {
				userCredential.setUsername(getPropertyValue(environmentName+"RevUserName"));
				userCredential.setPassword(getPropertyValue(environmentName+"RevPassword"));
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
