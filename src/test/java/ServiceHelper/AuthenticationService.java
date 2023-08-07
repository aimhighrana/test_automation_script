package ServiceHelper;

import Utils.BasePage;
import Utils.Entity.UserCredential;
import Utils.Enums.UserLoginRole;
import contracts.IAuthenticationService;

public class AuthenticationService extends BasePage implements IAuthenticationService {

	UserCredential userCredential = null;
	
	public UserCredential getCredentials(UserLoginRole loggedInUserRole, String environmentName) {
		userCredential = new UserCredential();

		switch (loggedInUserRole) {
		case INITIATOR: {
			userCredential.setUsername(getPropertyValue(environmentName + "InitiatorUserName"));
			userCredential.setPassword(getPropertyValue(environmentName + "InitiatorPassword"));
			break;
		}
		case REVIEWER: {
			userCredential.setUsername(getPropertyValue(environmentName + "ReviewerUserName"));
			userCredential.setPassword(getPropertyValue(environmentName + "ReviewerPassword"));
			break;
		}
		case APPROVER: {
			userCredential.setUsername(getPropertyValue(environmentName + "ApproverUsername"));
			userCredential.setPassword(getPropertyValue(environmentName + "ApproverPassword"));
			break;
		}
		default: {
			userCredential.setUsername(getPropertyValue(environmentName + "InitiatorUsername"));
			userCredential.setPassword(getPropertyValue(environmentName + "InitiatorPassword"));
			break;
		}
		}
		return userCredential;
	}
}
