package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class Locators extends BasePage {

	public Locators(RemoteWebDriver driver) {
//		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
//        PageFactory.initElements(finder, this);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// <! Login Page Locators !>
	public static String userNameField = "//input[@id='mat-input-1']";
	public static String continueButton = "//span[contains(text(),'Continue')]";
	public static String PasswordField = "//input[@id='mat-input-3']";
	public static String nPasswordField = "//input[@type='password']";
	public static String loginBtn = "//span[contains(text(),'Login')]";
	public static String qaEnv = "//p[contains(text(),'QA')]";
	public static String dataTab = "//div//div[contains(text(),' Data ')]";
	public static String homeTab = "//div[@class='mat-list-item-content']//..//div[contains(text(),'Home')]";
	public static String search = "//input[@placeholder='Search Data'] | //input[@placeholder='Search data']";
	public static String materialMaster = "//p[contains(text(),'Material Master')]";
	public static String newRecordBtn = "//span[contains(text(),'New record')] | //div[@class='f-col state-container']//div[@class='f-row']";
	public static String revUsernameField = "//input[@id='mat-input-3']";
	public static String conBtn = "//span[contains(text(),'Continue')]";
	public static String RevPwdField = "//input[@id='mat-input-5']";
	public static String userPasswordLink = "//p[contains(text(),'Use password')]";
	public static String materialNumFromTbl = "//table//tr[1]//td[3]";
	public static String actionIconForFirstValue = "//tbody/tr[1]/td[1]//..//button//span//mat-icon";
	public static String duplicateRecordHeader = "//h4[normalize-space()='Duplicate records']";
	public static String continueDuplicateRecord="//span[normalize-space()='Continue']";
	public static String profileIcon="//div[@class='mat-card-avatar ng-star-inserted mdo-small']";
	public static String signOut="//span[contains(text(),'Sign out')]";

	public static String approveVal = "//button[contains(text(),'Approve')]";
	public static String approveDropDownIcon = "//span[normalize-space()='Approve']//..//..//..//..//mat-icon";
	public static String sendForCorrectionOption = "//button[normalize-space()='Send for correction']";
	public static String rejectionCommentBox = "//div[contains(text(),'Comments')]//..//..//textarea";
	public static String submitButtonRejectionFlow  = "//span[normalize-space()='Submit']";
	public static String draft = " //button[contains(text(),'Save as draft')]";
	public static String myRrequestHeader ="//h4[normalize-space()='My requests']";
	//public static String actionIconForFirstValue = "//tbody/tr[1]/td[2]/lib-button[1]/button[1]";
	public static String edit = "//button[contains(text(),'Edit')]";
	public static String materrialMasterRecordOption = "//button[normalize-space()='Material Master Record']";
	public static String statusFilter = "//th[@id='STATUS']//input[@placeholder='Filter']";
	public static String uSaveBtn = "//span[contains(text(),'Save')]";
	public static String allerros = "//h4[contains(text(),'All errors')]";
	public static String expandHeaderData = "//mat-icon[normalize-space()='chevron_right']";
	public static String expandPlantData = "//mat-icon[normalize-space()='chevron_right'][1]";
	public static String expandPlant = "//mat-icon[normalize-space()='chevron_right']";
	public static String expandValuationData = "//mat-icon[normalize-space()='chevron_right']";
	public static String materialMasterNum= "//tbody/tr[1]/td[3]";
	
	// <! New record Page Locators !>
	public static String dMaterialMaster = "//p[contains(text(),'Material Master')]";
	public static String materialMasterroleValue = "//button[contains(text(),' Material Master Record  ')] | //button[normalize-space()='MaterialCreationFlow']";
	
	public static String industrySec = "//p[normalize-space()='Industry Sector']//..//..//div//input";
	public static String materialGroup = "//p[normalize-space()='Material Group']//..//..//div//input";
	public static String materialGroupValue = "//div[@role='listbox']//mat-option[1]";
	public static String is = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[3]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/lib-button-group[1]/ul[1]/li[1]/lib-button[1]/button[1]";
	public static String Isval = "//span[contains(text(),'A -- Plant engin./construction')] | //span[contains(text(),'A -- Plant engin./construction')]";
	public static String oldMaterialNumber = "//mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[3]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1] | //mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[3]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String generateDesc = "//span[contains(text(),'Generate description')]";
	public static String claS = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]";
	public static String classval = "//span[contains(text(),' PIPE ')]| //span[contains(text(),' ADDITIVE ')]";
	public static String summaryval = "//button[contains(text(),' Summary ')]";
	public static String loading = "//p[normalize-space()='Loading Group']//..//..//mat-icon";
	
	public static String inboxMenu = "//lib-text-line[contains(text(),'Inbox')]";
	public static String type = "//pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String container = "//pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[3]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String from = "//div[2]/div[1]/form[1]/div[2]/div[4]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String color = "//div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String com = "//div[2]/div[6]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String cas = "//div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[7]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String fp = "//div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[8]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String pp = "//mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[9]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String grade = "//mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[10]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String sg = "//div[2]/div[1]/form[1]/div[2]/div[11]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String tR = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[12]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String hizardClass = "//div[2]/div[1]/form[1]/div[2]/div[13]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String cert = "//div[2]/div[14]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String features = "//div[2]/div[1]/form[1]/div[2]/div[15]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String featuresEN = "//div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[16]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String featureER = "//div[2]/div[17]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String copy = "//button[contains(text(),'Copy')]";
	public static String recordno = "//mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String plantD = "//div[1]/div[1]/pros-transaction-hierarchy-list[1]/div[1]/mat-tree[1]/mat-tree-node[2]/div[1]/div[1]";
	public static String plantDatatwo = "//div[1]/mat-tree[1]/mat-tree-node[3]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String scenaioID = "//div[1]/div[1]/div[5]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]";
	public static String valuationD = "//mat-tree-node[5]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String copyBtn = "//span[contains(text(),'Copy')]";
	public static String newRecordTitle = "//div[1]/div[1]/div[2]/div[1]/lib-text-line[1]/h4[1]";
	public static String newPlantD = "//div[1]/mat-tree[1]/mat-tree-node[3]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String newValuationD = "//mat-tree-node[5]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String down = "//mat-tree-node[4]/div[1]/div[1]/button[1]/span[1]/mat-icon[1]";
	public static String divisionValue = "//div[@role='listbox']//mat-option[1]";
	public static String productAllocation = "//div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[6]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String productallocationValue = "//div[@role='listbox']//mat-option[1]";
	public static String unitofWeight = "//mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[4]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[12]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String uG = "//span[contains(text(),' G -- Gram ')]";
	public static String xplantMaterialStatus = "//mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[7]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String dropValue = "//div[@role='listbox']//mat-option[2]";
	public static String dropValueLoading = "//div[@role='listbox']//mat-option[1]";
	public static String volumeUnit = "//div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[15]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String plantdataPlusIcon = "//p[normalize-space()='Plant Data']//..//..//lib-button[1]//button[1]";
	public static String plantvalue = "//span[contains(text(),' 0004 -- PLANT 0004')]";
	public static String applyBtn = "//span[contains(text(),' Apply ')]";
	public static String mrpType = "//p[normalize-space()='MRP Type']//..//..//mat-icon";
	public static String mrpController = "//mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[7]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[3]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String valuationPlusIcon = "//p[normalize-space()='Valuation Data']//..//..//mat-icon";
	public static String valCat = "//p[normalize-space()='Valuation Cat.']//..//..//div//input";
	public static String newCheckbox = "//span[contains(text(),'NEW -- NEW')]";
	public static String submitBtn = "//span[contains(text(),'Submit')]";
	
	public static String viewPLog = "//button[normalize-space()='View process log']";
	public static String completedViewProcessLog = "//span[normalize-space()='Completed']//..//..//..//..//p[contains(text(),'View changes')] | //span[normalize-space()='Completed']//..//..//..//..//..//p[contains(text(),'View changes')]";
	public static String closeIconForrPrrocessLog = "//lib-button[@icon='times']//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']";
	public static String crossIconS = "//lib-button[@icon='times']";
	public static String closeIcoForViewChange = "//pros-view-changes[@class='ng-star-inserted']//mat-icon[@role='img'][normalize-space()='times']";
	public static String firstActionIconForInbox = "//tbody/tr[1]/td[2]/lib-button-group[1]/ul[1]/li[1]/lib-button[1]/button[1]/span[1]/mat-icon[1]";
	public static String approveBtn = "//button[contains(text(),'Approve')]";
	public static String approveButton = "//span[contains(text(),' Approve ')]";
	public static String approveStatus = "//mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[1]/div[22]/div[2]/div[2]/div[1]/div[4]/div[1]/lib-label[1]/span[1]";
	public static String claim = "//button[contains(text(),'Claim')]";
	public static String unclaim = "//button[normalize-space()='Unclaim']";
	public static String myReqTab = "//lib-text-line[contains(text(),'My requests')]";
	public static String processLogOption = "//button[normalize-space()='Process log']";
	public static String lblText = "//div[@class='display-heading ng-star-inserted']";
	public static String apStatus = "//div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[2]/div[2]/div[1]/div[3]/div[1]";
	public static String sBox = "//mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-task-list-datatable[1]/div[1]/div[2]/lib-chip-list[1]/div[1]/lib-search[1]/div[1]";
	
	public static String dChange = "//button[contains(text(),' Description Change ')]";
	public static String viewProcessLogOption = "//button[contains(text(),' View process log ')]";
	public static String processLog = "//button[contains(text(),'Process log')]";
	public static String processLogStatus = "(//p[@class='base no-wrap ng-star-inserted'])[1]";
	public static String materialFuseAutomation = "//button[text()=' Material Fuse Automation/Material Fuse Automation ']";
	public static String industrysector = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[2]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/lib-button-group[1]/ul[1]/li[1]/lib-button[1]/button[1]";
	public static String industrySectorValue = "//span[text()=' C -- Chemical isndustry ']";
	public static String GenerateDescriptionBtn = "//span[contains(text(),'Generate description')]";
	public static String classfield = "//input[@data-placeholder='Select class']";
	public static String classValue = "//span[contains(text(),'BALL - BEARING')]";
	public static String row = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]";
	public static String rowValue = "//span[contains(text(),' ANGLR CNTCT -- ANGULAR CONTACT ')]";
	public static String typebox = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[3]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]";
	public static String ccrsicon = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/lib-button[1]/button[1]";
	public static String typevalue = "//div[@id='cdk-overlay-6']//mat-option[2]";
	public static String width = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[4]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String widthValue = "//div[@id='cdk-overlay-7']//mat-option[2]";
	public static String series = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[5]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String seriesvalue = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]";
	public static String insideMeter = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[6]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String insideMetervalue = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]//mat-option[1]";
	public static String outsideMeter = "//div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[7]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]";
	public static String outsideMeterValue = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]//mat-option[1]";
	public static String sazeMaterial = "//div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[8]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String sezeMaterialValue = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]";
	public static String manu = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[9]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String manuValue = "//html[1]/body[1]/div[1]/div[1]/div[1]/div[1]";
	public static String saveBtn = "//span[contains(text(),' Save ')]";
	public static String modelNumber = "//div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[11]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String partNumber = "/html[1]/body[1]/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[4]/div[2]/pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[10]/div[1]/div[1]/pros-transaction-input[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	public static String continueBtn = "//div[1]/ng-component[1]/pros-duplicate-records-datatable[1]/div[1]/div[1]/lib-button[2]/button[1]";
	public static String data = "//mat-sidenav-content[1]/pros-primary-navigation[1]/div[1]/div[2]/mat-nav-list[1]/mat-list-item[2]";
	public static String searchBox = "/html[1]/body[1]/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-primary-navigation[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]/input[1]";
	public static String dSearchBox = "//pros-primary-navigation[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]/input[1]";
	public static String apply = "//p[contains(text(),'Apply')]";
	public static String materialHeaderXpath = "/html[1]/body[1]/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-primary-navigation[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/pros-secondary-navbar[1]/div[1]/mat-card[1]/div[6]/mat-accordion[1]/cdk-virtual-scroll-viewport[1]/div[1]/mat-expansion-panel[3]/mat-expansion-panel-header[1]";
	public static String tblRecord = "//tbody/tr[1]/td[2]";
	
	public static String thDot = "//tbody/tr[1]/td[2]/lib-button[1]/button[1]/span[1]/mat-icon[1]";
	public static String viewProcessLog = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/button[5]";
	public static String processLogTitle = "//mat-expansion-panel-header/span[1]/mat-panel-title[1]/div[1]";
	public static String statusCom = "//span[normalize-space()='Completed']";
	
	public static String viewchng = "//mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/lib-text-line[1]/p[1]";
	public static String headerData = "//p[contains(text(),'Header data')]";
	public static String creationDate = "//td[contains(text(),'Creation Date')]//..//td[3]";
	public static String beforechangeDate = "//td[contains(text(),'Creation Date')]//..//td[2]";
	public static String crossIcon = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-view-changes[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/lib-button[1]/button[1]";
	public static String crossIcon1 = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-audit[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/lib-button[1]/button[1]";
	public static String summary = "//body/div[1]/div[2]/div[1]/d public static String usenameProd = \"//mat-sidenav-container[1]/mat-sidenav-content[1]/pros-login[1]/div[1]/div[1]/form[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]\";iv[1]/div[1]/button[3]";
	public static String mfi = "//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]";
	public static String industrySectorField = "//div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[2]/div[1]/pros-transaction-dropdown[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String design = "//h2[contains(text(),'Design')]";
	public static String langcheckbox = "//thead/tr[1]/th[1]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";
	public static String purchaseCheckbox = "//thead/tr[1]/th[1]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";
	public static String lngdelButton = "//table[1]/thead[1]/tr[1]/th[2]/div[1]/lib-button[1]/button[1]/span[1]";
	public static String purDelButton = "//body[1]/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[2]/pros-transaction-dataset-tab[1]/div[1]/div[3]/pros-transaction-tabs[1]/div[1]/div[2]/mat-accordion[7]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/pros-tab-transaction[1]/div[1]/div[1]/div[1]/div[1]/pros-transaction-grid[1]/div[1]/div[4]/table[1]/thead[1]/tr[1]/th[2]/div[1]/lib-button[1]/button[1]";
	public static String pTitle = "//h4[contains(text(),' Process log ')]";
	public static String currentDate = "//p[contains(text(),'%s')]";
	public static String statusSuccessTxt = "//span[contains(text(),'SUCCESS')]";
	public static String crossP = "//lib-button[@icon='times']//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']";
	// flow tab locators
	public static String flowtab = "//div[contains(text(),' Flows ')]";
	public static String manageFlowBtn = "//span[contains(text(),'Manage flows')]";
	public static String spac = "//div[@class='container-fluid container-cards-pf']";
	public static String spacRecord = "//div[@class='container-fluid container-cards-pf']";
	public static String searchB = "//pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]//input";
	public static String user = "//input[@id='user_email_login']";
	public static String passs = "//input[@id='user_password']";
	public static String log = "//input[@id='user_submit']";
	public static String c = "//body[1]/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/lib-button[1]/button[1]";
	 public static String usenameProd = "//mat-sidenav-container[1]/mat-sidenav-content[1]/pros-login[1]/div[1]/div[1]/form[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	 public static String prodEnv = "//p[contains(text(),'Production')]";

	// List Page Search

	public static String createdOnFilter = "//th[@id='DATECREATED']//pros-inline-table-column-filter";
	public static String date3 = "//div[normalize-space()='3']";
	public static String endDateTab = "//div[contains(text(),'End')]";
	public static String date10 = "//div[normalize-space()='10']";
	public static String modifiedOnLabel = "//p[normalize-space()='Modified on']";
	public static String modifiedOnFilter = "//th[@id='DATEMODIFIED']//pros-inline-table-column-filter";
	public static String firstValuematerialMaster = "//tbody/tr[1]/td[1]//..//p";

	public static String filterIcon = "//mat-icon[normalize-space()='filter']";

	public static String isNotFilter = "//span[normalize-space()='Is not']";

	public static String filterIndustrySector = "//p[normalize-space()='Industry Sector']";

	public static String valueFMCG_IndustrySectorFilter = "//mat-list-item[3]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";

	public static String applyFilterButton = "//span[normalize-space()='Apply']";

	public static String filterMaterialType = "//p[normalize-space()='Material Type']";

	public static String valueSparePart_MaterialTypeFilter = "//mat-list-item[2]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";

	public static String filterMaterialDesc = "//p[normalize-space()='Material Description']";

	public static String input_MaterialDescFilter = "//h4[normalize-space()='Material Description']//..//..//..//input";

	public static String filterBaseUnitOfMeasure = "//p[normalize-space()='Base Unit of Measure']";

	public static String valuePercentage_BaseUnitFilter = "//mat-list-item[2]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";

	public static String clearAppliedFiler = "//span[@class='filter-text ng-star-inserted']//..//mat-icon[normalize-space()='times']";


	public static String filterStatusDropdown =  "//th[@id='STATUS']//input[@placeholder='Filter']";

	public static String firstValueOfStatus =  "//tbody/tr[1]/td[8]";

	public static String clearIconForStatusFilter = "//th[@id='STATUS']//mat-icon[@role='img'][normalize-space()='times']";

	public static String filterModifiedByDropdown =  "//th[@id='USERMODIFIED']//input[@placeholder='Filter']";

	public static String firstValueOfModifiedBy =  "//tbody/tr[1]/td[7]";

	public static String clearIconForModifiedByFilter = "//mat-icon[@class='mat-icon notranslate mdo-icons-light mat-icon-no-color'][normalize-space()='times']";

	public static String threeDotsAdvanceFilter = "//lib-button[@type='plain']//mat-icon[@role='img'][normalize-space()='ellipsis-h']";

	public static String resetButton = "//button[normalize-space()='Reset']";

	public static String confirmButton = "//span[normalize-space()='Confirm']";

	public static String appliedIndusScetoryFilter = "//p[@class='base no-wrap ng-star-inserted'][normalize-space()='Industry Sector']";


	public static String threeDotsIconAppliedFilter = "//mat-icon[@class='mat-icon notranslate mdo-icons mat-icon-no-color'][normalize-space()='ellipsis-h']";

	public static String saveAsOption = "//button[normalize-space()='Save as...']";

	public static String filterNameInput = "//p[contains (text(), 'Filter name')]//..//..//..//input";

	public static String saveButtonFilterPopup = "//span[normalize-space()='Save']";

	public static String storedFiltersIcon = "//mat-icon[normalize-space()='layer-group']";

	public static String cancelButtonFilterPopup = "//span[normalize-space()='Cancel']";

	public static String firstvalueCreatedOnDateInTable = "//tbody/tr[1]/td[4]";
	public static String createdOnSortFilter = "//p[normalize-space()='Created on']";
	public static String deleteSavedFilters = "//button[normalize-space()='Delete']";
	public static String paginationValue = "//div[@class='f-row list-pagination ng-star-inserted']//p";
	public static String manufacturerPartNumFilterTab = "//p[normalize-space()='Manufacturer Part Number']";
	public static String inputManufacturerPartNumFilter = "//h4[normalize-space()='Manufacturer Part Number']//..//..//..//input";

	// List View


	public static String dropDownViewICon = "//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']//mat-icon[@role='img'][normalize-space()='caret-down']";

	public static String newViewOption = "//button[normalize-space()='New view']";

	public static String inputViewName = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input";

	public static String saveButtonView = "//span[normalize-space()='Save']";

	public static String defaultViewOption = "//button[normalize-space()='Default view']";

	public static String settingIcon = "//mat-icon[normalize-space()='cog']";

	public static String threeDotsIconForView = "//div[@class='f-row breadcrum-toolbar']//mat-icon[normalize-space()='ellipsis-h']";

	public static String deleteViewOption = "//button[normalize-space()='Delete view']";

	public static String confirmDeleteView = "//span[normalize-space()='Confirm']";

	public static String nextPage = "//div[@class='f-row mdo-pagination']//lib-button[@icon='chevron-right']";

	public static String summaryOption = "//button[normalize-space()='Summary']";

	public static String flowMaterialMasterRecordoption = "//button[normalize-space()='Material Master Record']";

	public static String closeIcon = "//div[@class='root']//div[@class='f-row breadcrum-toolbar']//mat-icon[normalize-space()='times']";

	public static String formClassnClassTypeOption = "//button[normalize-space()='Class and Class Type']";
	public static String classType1 = "//p[normalize-space()='Class Type1']";

	public static String downloadTemplatesOption = "//button[normalize-space()='Download templates']";
	public static String descriptionOption = "//button[normalize-space()='Description']";


}
