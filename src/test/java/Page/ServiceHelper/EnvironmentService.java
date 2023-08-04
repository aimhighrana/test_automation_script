package Page.ServiceHelper;

import Page.contracts.IEnvironmentService;
import Utils.BasePage;
import Utils.Enums.EnvironmentFilePath;
import Utils.Enums.EnvironmentName;

public class EnvironmentService extends BasePage implements IEnvironmentService {

	public void getEnvironmentProperties(String environmentName) {
		if (environmentName.equals(EnvironmentName.SAND.toString())) {
			getConfigPropertiesForEnvironment(EnvironmentFilePath.SAND.toString());
		} else if (environmentName.equals(EnvironmentName.QAA.toString())) {
			getConfigPropertiesForEnvironment(EnvironmentFilePath.QAA.toString());
		} else if (environmentName.equals(EnvironmentName.QAR.toString())) {
			getConfigPropertiesForEnvironment(EnvironmentFilePath.QAR.toString());
		} else if (environmentName.equals(EnvironmentName.QAH.toString())) {
			getConfigPropertiesForEnvironment(EnvironmentFilePath.QAH.toString());
		} else {
			getConfigPropertiesForEnvironment(EnvironmentFilePath.QAR.toString());
		}
	}
}
