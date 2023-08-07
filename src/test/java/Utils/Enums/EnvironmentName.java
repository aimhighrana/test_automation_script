package Utils.Enums;

import java.io.Serializable;

public enum EnvironmentName implements Serializable {
	QAA, QAM, QAR, SAND;

	@Override
	public String toString() {
		switch (this) {
		case QAA:
			return "QAA";
		case QAM:
			return "QAM";
		case QAR:
			return "QAR";
		case SAND:
			return "SAND";
		default:
			return "Unknown";
		}
	}
	
	public EnvironmentName getEnvironment(String envName) {
		if(envName.equals(QAM.toString())) {return QAM;}
		else if(envName.equals(QAR.toString())) {return QAR;}
		else if(envName.equals(QAA.toString())) {return QAA;}
		else if(envName.equals(SAND.toString())) {return SAND;}		
		else
		{return QAR;}
	}
}
