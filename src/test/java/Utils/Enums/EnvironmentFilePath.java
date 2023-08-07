package Utils.Enums;

import java.io.Serializable;

public enum EnvironmentFilePath implements Serializable {
	QAA, QAM, QAR, SAND;

	@Override
	public String toString() {
		switch (this) {
		case QAA:			
		case QAM:			
		case QAR:			
		case SAND:
			return "//config.properties";
		default:
			return "//config.properties";
		}
	}

}
