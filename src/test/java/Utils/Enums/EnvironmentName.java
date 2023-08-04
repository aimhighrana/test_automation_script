package Utils.Enums;

import java.io.Serializable;

public enum EnvironmentName implements Serializable {
	QAA,
	QAH,
	QAR,	
	SAND;
	
	@Override
	public String toString()
	{
		switch(this) {
		case QAA: return "QAA";
		case QAH: return "QAH";
		case QAR: return "QAR";
		case SAND: return "Sandbox";
		default: return "Unknown";
		}
	}
}
