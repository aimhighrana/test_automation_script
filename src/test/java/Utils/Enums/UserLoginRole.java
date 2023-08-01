package Utils.Enums;

public enum UserLoginRole {
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
