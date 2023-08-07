package Utils.Enums;

import java.io.Serializable;

public enum BrowserOption implements Serializable  {
	CHROME;
	
	@Override
	public String toString() {
		switch (this) {
		case CHROME:
			return "chrome";
		default:
			return "chrome";
		}
	}
	
}
