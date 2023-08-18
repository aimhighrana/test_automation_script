package ServiceHelper;

import org.openqa.selenium.WebDriver;

import Page.AddMaterialMaster;
import Page.Flow;
import Page.HomePage;
import Page.ListPageSearch;
import Page.ListView;
import Page.LoginPage;
import Page.MaterialCreation;
import Page.ProcessLog;
import Page.Workflow11;
import Page.WorkFlowEight;
import contracts.IObjectService;

public class ObjectService implements IObjectService {

	private LoginPage loginPage;
	private AddMaterialMaster materialmaster;
	private ListPageSearch listPageSearch;
	private ProcessLog processLog;
	private ListView listView;
	private MaterialCreation materialCreation;
	private Flow flow;
	private HomePage homePage;
	private Workflow11 workflow11;
	private WorkFlowEight workFlowEight;
	
	public ObjectService(WebDriver webDriver) throws Exception {
		loginPage = new LoginPage(webDriver);
		materialmaster = new AddMaterialMaster(webDriver);
		listPageSearch = new ListPageSearch(webDriver);
		processLog = new ProcessLog(webDriver);
		listView = new ListView(webDriver);
		materialCreation = new MaterialCreation(webDriver);
		flow = new Flow(webDriver);
		homePage = new HomePage(webDriver);	
		workflow11 = new Workflow11(webDriver);
		workFlowEight = new WorkFlowEight(webDriver);
	}
	
	public LoginPage loginPage() {
		return loginPage;
	}

	public AddMaterialMaster materialMaster() {
		return materialmaster;
	}

	public ListPageSearch listPageSearch() {
		return listPageSearch;
	}

	public ProcessLog processLog() {
		return processLog;
	}

	public ListView listView() {
		return listView;
	}

	public MaterialCreation materialCreation() {
		return materialCreation;
	}

	public Flow flow() {
		return flow;
	}

	public HomePage homePage() {
		return homePage;
	}
	
	public Workflow11 workflow11(){
		return workflow11;
	}
	
	public WorkFlowEight workFlowEight() {
		return workFlowEight;
	}

}
