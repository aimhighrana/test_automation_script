package contracts;

import Page.*;

public interface IObjectService {
	public LoginPage loginPage();
	public AddMaterialMaster materialMaster();
	public ListPageSearch listPageSearch();
	public ProcessLog processLog();
	public ListView listView();
	public MaterialCreation materialCreation();
	public Flow flow();
	public HomePage homePage();
	public WorkFlowEight workFlowEight();
}
