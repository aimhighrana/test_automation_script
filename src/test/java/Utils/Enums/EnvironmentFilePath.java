package Utils.Enums;

import java.io.Serializable;

public enum EnvironmentFilePath implements Serializable {
	QAA,
	QAH,
	QAR,
	SAND;
	
	@Override
	public String toString()
	{
		switch(this) {
			case QAA :
			case QAH:
			case QAR:
			case SAND:{
				return  "//config.properties";
			}
			default: return "//config.properties";
		}
	}

}
