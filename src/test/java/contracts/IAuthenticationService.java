package contracts;

import Utils.Entity.UserCredential;
import Utils.Enums.UserLoginRole;

public interface IAuthenticationService {
	UserCredential getCredentials(UserLoginRole loggedInUserRole, String environmentName);
}
