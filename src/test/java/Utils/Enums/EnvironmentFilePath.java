package Utils.Enums;

import java.io.Serializable;

public enum EnvironmentFilePath implements Serializable {
	QAA, QAM, QAR, SAND;

	@Override
	public String toString() {
		switch (this) {
		case QAA:
			return "//envQARAuto.properties";
		case QAM:
			return "//envQARAuto.properties";
		case QAR:
			return "//envQAR.properties";
		case SAND:
			return "//envQASB.properties";
		default:
			return "//config.properties";
		}
	}

}
