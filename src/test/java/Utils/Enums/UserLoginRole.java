package Utils.Enums;

import java.io.Serializable;

public enum UserLoginRole  implements Serializable {
	INITIATOR, REVIEWER, APPROVER;

	@Override
	public String toString() {
		switch (this) {
		case INITIATOR:
			return "Initiator";
		case REVIEWER:
			return "Reviewer";
		case APPROVER:
			return "Approver";
		default:
			return "Unknown";
		}
	}
}
