package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class Locators extends BasePage {

	public Locators(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// <! Login Page Locators !>
	public static String userNameField = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input";
	public static String continueButton = "//span[contains(text(),'Continue')]";

	public static String usePasswordButton = "//p[normalize-space()='Use password']";
	public static String PasswordField = "//input[@type='password']";
	public static String nPasswordField = "//input[@type='password']";
	public static String loginBtn = "//span[contains(text(),'Login')]";
	public static String qaEnv = "//p[contains(text(),'QA')]";
	public static String dataTab = "//div[@class='mat-list-item-content'][contains(text(),\"Data\")]";
	public static String search = "//input[@placeholder='Search Data'] | //input[@placeholder='Search data']";
	public static String materialMaster = "//p[normalize-space()='Material Master']";
	public static String newRecordBtn = "//span[contains(text(),'New record')] | //div[@class='f-col state-container']//div[@class='f-row']";
	public static String revUsernameField = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input";
	public static String RevPwdField = "//p[normalize-space()='Password']//..//..//..//input";
	public static String userPasswordLink = "//p[contains(text(),'Use password')]";
	public static String materialNumFromTbl = "//table//tr[1]//td[3]";
	public static String actionIconForFirstValue = "//tbody/tr[1]/td[1]//..//button//span//mat-icon";
	public static String duplicateRecordHeader = "//h4[normalize-space()='Duplicate records']";
	public static String continueDuplicateRecord="//span[normalize-space()='Continue']";
	public static String profileIcon="//div[@class='mat-card-avatar ng-star-inserted mdo-small']";
	public static String signOut="//span[contains(text(),'Sign out')]";
	
	public static String defaultView=	"//h4[contains (text(), 'Default view')]";
	public static String viewDropDownIcon = "//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']//mat-icon[@role='img'][normalize-space()='caret-down']";

	public static String approveVal = "//button[normalize-space()='Approve']";
	public static String approveDropDownIcon = "//span[normalize-space()='Approve']//..//..//..//..//mat-icon";
	public static String sendForCorrectionOption = "//button[normalize-space()='Send for correction']";
	public static String rejectionCommentBox = "//div[contains(text(),'Comments')]//..//..//textarea";
	public static String submitButtonRejectionFlow  = "//span[normalize-space()='Submit']";
	public static String draft = " //button[contains(text(),'Save as draft')]";
	public static String myRrequestHeader ="//h4[normalize-space()='My requests']";
	public static String edit = "//button[contains(text(),'Edit')]";
	public static String materrialMasterRecordOption = "//button[normalize-space()='Copy Of Material Master - QA']";
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
	public static String materialMasterRoleValue = "//button[normalize-space()='Copy Of Material Master - QA'] | //button[normalize-space()='MaterialCreationFlow']";

	public static String industrySec = "//p[normalize-space()='Industry sector']//..//..//div//input | //p[normalize-space()='Industry Sector']//..//..//div//input";
	public static String materialGroup = "//p[normalize-space()='Material Group']//..//..//div//input";
	public static String generateDesc = "//span[contains(text(),'Generate description')]";
	public static String claS = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]";
	public static String classval = "(//span[@class='mat-option-text'])[1]";
	public static String summaryVal = "//button[contains(text(),' Summary ')]";
	public static String loading = "//p[normalize-space()='Loading Group']//..//..//mat-icon";

	public static String copy = "//button[contains(text(),'Copy')] | //button[normalize-space()='Copy']";
	public static String copyButton = "//button//span[contains(text(),'Copy')]";
	public static String recordno = "//mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	public static String plantD = "//div[1]/div[1]/pros-transaction-hierarchy-list[1]/div[1]/mat-tree[1]/mat-tree-node[2]/div[1]/div[1]";
	public static String plantDatatwo = "//div[1]/mat-tree[1]/mat-tree-node[3]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String valuationD = "//mat-tree-node[5]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String copyBtn = "//span[contains(text(),'Copy')]";
	public static String newRecordTitle = "//div[1]/div[1]/div[2]/div[1]/lib-text-line[1]/h4[1]";
	public static String newPlantD = "//div[1]/mat-tree[1]/mat-tree-node[3]/div[1]/div[1]/lib-text-line[1]/p[1]";
	public static String sourceListDescription = "//p[normalize-space()='Source - List']//..//..//input[@placeholder='Select any one...']";
	public static String dropValue = "//div[@role='listbox']//mat-option[2]";
	public static String dropValue1 ="//div[@role='listbox']//mat-option[1]";
	public static String sequentialMaterialOption =  "//button[normalize-space()='SequentialMaterial']";

	public static String summaryFirstOption =  "//div[@role='menu']//div[1]/div[1]/button[1]";

	public static String xPlantMaterialStatusField = "//p[normalize-space()='X-Plant Material Status']//..//..//div//input";
	public static String dropValue3 = "//div[@role='listbox']//mat-option[3]//span";
	public static String plusStorageData ="//p[text()='Storage Data ']//..//..//mat-icon[text()='plus']";
	public static String firstOptionStorageData ="//label[@for='mat-checkbox-275-input']//span[@class='mat-checkbox-inner-container']";
	public static String manufacturerPartNum ="//p[@class='xsmall strong ng-star-inserted'][normalize-space()='Manufacturer Part Number']//..//..//..//div//input";
	public static String dropValueLoading = "//span[@class='mat-option-text']//..//..//mat-option//span[1]";
	public static String plantdataPlusIcon = "//p[normalize-space()='Plant Data']//..//..//..//..//p[contains(text(),'Add')]";
	public static String plantvalue = "//span[contains(text(),' 0004 -- PLANT 0004')]";
	public static String applyBtn = "//span[contains(text(),' Apply ')]";
	public static String mrpType = "//p[normalize-space()='MRP Type']//..//..//mat-icon";
	public static String mrpTypeField = "//p[contains(text(),'MRP Type')]";
	public static String valuationPlusIcon = "//p[normalize-space()='Valuation Data']//..//..//..//..//p[contains(text(),'Add')]";
	public static String valuationFirstOption = "//lib-filter-option[1]//label[@class='mat-checkbox-layout'][1]";
	public static String valCat = "//p[normalize-space()='Valuation Cat.']//..//..//div//input";
	public static String newCheckbox = "//span[contains(text(),'NEW -- NEW')]";
	public static String submitBtn = "//span[contains(text(),'Submit')]";
	
	public static String viewPLog = "//button[normalize-space()='View process log']";
	public static String completedViewProcessLog = "//span[normalize-space()='Completed']//..//..//..//..//p[contains(text(),'View changes')] | //span[normalize-space()='Completed']//..//..//..//..//..//p[contains(text(),'View changes')]";
	public static String viewEmailLogs = "//mat-expansion-panel[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[2]/lib-text-line[2]/p[1]";
	public static String viewPotentialOwner = "(//lib-text-line//P[text()=' View '])[1]";
	public static String firstPotentialOwner = "(//div[normalize-space()=''])[1]";

	public static String viewDetailsHeader = "//h4[normalize-space()='View details']";
	public static String firstRecordOfEmailLogs = "//div[@class='message-list f-col']//tr[1]//td";
	public static String closeIconForProcessLog = "//h4[normalize-space()='View process log']//..//..//..//..//mat-icon";
	public static String closeIconForSummary ="//mat-icon[@class='mat-icon notranslate mdo-icons-light mat-icon-no-color ng-star-inserted'][normalize-space()='times']";
	public static String crossIconS = "//lib-button[@icon='times']";
	public static String crossIconViewEmailLogs = "//h4[normalize-space()='View details']//..//..//..//..//mat-icon";
	public static String instanceDiagramIcon = "(//mat-expansion-panel-header[1]//span[1]//mat-icon[text()='diagram-subtask'])[1]";
	public static String processFlowHeader = "//h4[contains(text(),'Process flow')]";
	public static String instanceDiagramImage = "//draggable[1]/div[1]/img[1]";
	public static String closeIconProcessFlow = "//h4[contains(text(),'Process flow')]//..//..//..//..//mat-icon";
	public static String closeIcoForViewChange = "//h4[normalize-space()='View changes']//..//..//..//..//mat-icon";
	public static String firstActionIconForInbox = "//tbody/tr[1]/td[2]/lib-button-group[1]/ul[1]/li[1]/lib-button[1]/button[1]/span[1]/mat-icon[1]";
	public static String approveBtn = "//button[contains(text(),'Approve')]";
	public static String sequentialHeader = "//h4[contains(text(),'SequentialMaterial')]";
	public static String planingCycleField = "//p[normalize-space()='Planning Cycle']//..//..//..//input";
	public static String lastForecastField = "//p[normalize-space()='Last forecast']//..//..//..//input";
	public static String dnuFixedPeriods = "//p[normalize-space()='DNU Fixed periods']//..//..//..//input";
	public static String unitOfWeightField = "//p[normalize-space()='Unit of Weight']//..//..//div//input";
	public static String volumeUnitField = "//p[normalize-space()='Volume unit']//..//..//div//input";

	public static String approveButton = "//span[contains(text(),' Approve ')]";
	public static String claim = "//button[contains(text(),'Claim')]";
	public static String unclaim = "//button[normalize-space()='Unclaim']";
	public static String processLogOption = "//button[normalize-space()='Process log']";
	public static String lblText = "//div[@class='display-heading ng-star-inserted']";
	public static String dChange = "//button[contains(text(),' Description Change ')]";
	public static String viewProcessLogOption = "//button[contains(text(),' View process log ')] | //button[normalize-space()='Process log']";
	public static String processLog = "//button[contains(text(),'Process log')]";
	public static String processLogStatus = "(//p[@class='base no-wrap ng-star-inserted'])[1]";
	public static String ccrsicon = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/lib-button[1]/button[1]";
	public static String dSearchBox = "//pros-primary-navigation[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]/input[1]";
	public static String apply = "//p[contains(text(),'Apply')]";
	public static String thDot = "//tbody/tr[1]/td[2]/lib-button[1]/button[1]/span[1]/mat-icon[1]";
	public static String fieldNameHeader = "//th[normalize-space()='Field Name']";
	public static String beforeChangeHeader = "//th[normalize-space()='Before Change']";
	public static String afterChangeHeader = "//th[normalize-space()='After Change']";

	public static String processLogTitle = "//mat-expansion-panel-header/span[1]/mat-panel-title[1]/div[1]";

	public static String dateProcessLog ="//div[1]/div[2]/div[1]/lib-text-line[1]/p[1]";

	public static String timeProcessLog ="//div[1]/div[2]/div[1]/lib-text-line[2]/p[1]";
	public static String commentIconProcessLog = "//lib-button[contains(@libtooltip, 'comments')]";
	public static String chatBoxComment = "//pros-chat-editor[@class='chat-editor-outer']";
	public static String externalIcon = "//lib-button[@icon='external-link-alt']";
	public static String statusCom = "//span[normalize-space()='Completed']";
	
	public static String headerData = "//p[normalize-space()='Header data']";
	public static String design = "//h2[contains(text(),'Design')]";
	public static String pTitle = "//h4[contains(text(),' Process log ')]";
	public static String currentDate = "//p[contains(text(),'%s')]";
	public static String statusSuccessTxt = "//span[contains(text(),'SUCCESS')]";
	public static String crossP = "//lib-button[@icon='times']//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']";
	// Flow tab locators
	public static String flowtab = "//div[contains(text(),' Flows ')]";
	public static String manageFlowBtn = "//span[contains(text(),'Manage flows')]";
	public static String spac = "//div[@class='container-fluid container-cards-pf']";
	public static String spacRecord = "//div[@class='container-fluid container-cards-pf']";
	public static String searchB = "//pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]//input";

	public static String applySearch = "//p[normalize-space()='Apply']";

	public static String clearSearch = "//div[@class='mdo-search-pill f-row']//mat-icon[@role='img'][normalize-space()='times']";

	public static String searchPlaceHolder ="//input[@data-placeholder='Search']";

	public static String log = "//input[@id='user_submit']";
	 public static String usenameProd = "//mat-sidenav-container[1]/mat-sidenav-content[1]/pros-login[1]/div[1]/div[1]/form[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]";
	 public static String prodEnv = "//p[contains(text(),'Production')]";

	// List Page Search

	public static String createdOnFilter = "//th[@id='DATECREATED']//pros-inline-table-column-filter";
	public static String date3 = "//div[normalize-space()='3']";
	public static String endDateTab = "//div[contains(text(),'End')]";
	public static String date10 = "//div[normalize-space()='10']";
	public static String modifiedOnFilter = "//th[@id='DATEMODIFIED']//pros-inline-table-column-filter";
	public static String firstValuematerialMaster = "//tbody/tr[1]/td[3]//p";

	public static String filterIcon = "//mat-icon[normalize-space()='filter']";

	public static String isNotFilter = "//span[normalize-space()='Is not']";

	public static String filterIndustrySector = "//p[normalize-space()='Industry Sector'] | //p[normalize-space()='Industry sector']";

	public static String sapMaterialNumberFilter = "//p[normalize-space()='SAP Material Number']";

	public static String sapMaterialNumberInputField = "//lib-chip-list[@class='chips-list']//textarea";

	public static String viewIntegrationLogs = "//p[normalize-space()='View integration logs']";

	public static String integrationLogsHeader = "//h4[normalize-space()='Integration log']";

	public static String closeIntegrationLogsView = "//h4[normalize-space()='Integration log']//..//..//..//..//mat-icon";
	public static String valueFMCG_IndustrySectorFilter = "//mat-list-item[3]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";

	public static String valuationDataHierarchy = "//mat-tree-node[4]//div[1]//div[1]//lib-text-line[1]//p[1]//label";
	public static String plantDataSelected = "//mat-tree-node[3]//div[1]//div[1]//lib-text-line[1]//p[1]//label//span//input[@aria-checked='true']";
	public static String applyFilterButton = "//span[normalize-space()='Apply']";

	public static String filterMaterialType = "//p[normalize-space()='Material Type']";

	public static String valueSparePart_MaterialTypeFilter = "//mat-list-item[2]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";

	public static String filterMaterialDesc = "//p[normalize-space()='Material Description']";

	public static String input_MaterialDescFilter = "//h4[normalize-space()='Material Description']//..//..//..//input";

	public static String filterBaseUnitOfMeasure = "//p[normalize-space()='Base Unit of measure'] | //p[normalize-space()='Base Unit of Measure']";

	public static String valuePercentage_BaseUnitFilter = "//mat-list-item[2]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]";

	public static String clearAppliedFiler = "//span[@class='filter-text ng-star-inserted']//..//mat-icon[normalize-space()='times']";

	public static String clearSearchField 	="//div[@class='mdo-search-pill f-row']//mat-icon[@role='img'][normalize-space()='times']";
	public static String filterStatusDropdown =  "//th[@id='STATUS']//input[@placeholder='Filter']";

	public static String firstValueOfStatus =  "//tbody/tr[1]/td[8]";

	public static String clearIconForStatusFilter = "//th[@id='STATUS']//mat-icon[@role='img'][normalize-space()='times']";

	public static String filterModifiedByDropdown =  "//tr[2]//th[7][@id='USERMODIFIED']";

	public static String firstValueOfModifiedBy =  "//tbody/tr[1]/td[7]";

	public static String clearIconForModifiedByFilter = "//mat-icon[@class='mat-icon notranslate mdo-icons-light mat-icon-no-color'][normalize-space()='times']";

	public static String threeDotsAdvanceFilter = "//lib-button[@type='plain']//mat-icon[@role='img'][normalize-space()='ellipsis-h']";

	public static String resetButton = "//button[normalize-space()='Reset']";

	public static String confirmButton = "//span[normalize-space()='Confirm']";

	public static String appliedIndusScetoryFilter = "//span[normalize-space()='Industry Sector'] | //span[normalize-space()='Industry sector']";


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

	public static String flowMaterialMasterRecordoption = "//lib-section[@text='Flows']//..//button[2]";

	public static String closeIcon = "//div[@class='root']//div[@class='f-row breadcrum-toolbar']//mat-icon[normalize-space()='times']";

	public static String formClassnClassTypeOption = "//lib-section[@text='Flows']//..//button[3]";
	public static String classType1 = "//p[normalize-space()='Class Type1']";

	public static String downloadTemplatesOption = "//button[normalize-space()='Download templates']";
	public static String descriptionOption = "//div[@class='scroll-height']//button[2]";


	// Home page

	public static String homeTab = "//div[@class='mat-list-item-content']//..//div[contains(text(),'Home')]";
	public static String inboxMenu = "//lib-text-line[contains(text(),'Inbox')]";
	public static String inProgressMenu = "//lib-text-line[normalize-space()='In progress']";
	public static String completedMenu = "//lib-text-line[normalize-space()='Completed']";
	public static String myReqTab = "//lib-text-line[contains(text(),'My requests')]";
	public static String systemErrorsTab = "//lib-text-line[normalize-space()='System Errors']";
	public static String searchSystemErrorsTab = "//lib-search[@placeholder='Search']//div[@class='mdo-search-pill f-row']//input";
	public static String clearSearchSystemErrorsTab = "//div[@class='mdo-search-pill f-row']//mat-icon[@role='img'][normalize-space()='times']";
	public static String retriggerIcon = "(//mat-icon[text()='arrow-rotate-right'])[1]";
	public static String successRetrigger = "//div[@class='mdo-notice f-row mdo-notice-success']";

	public static String flowFilter ="//span[normalize-space()='Flow']";
	public static String taskFilter = "//span[normalize-space()='Task type']";
	public static String firstOptionFilter ="//div[@class='options']//lib-filter-option[1]//div[1]//label";

	// Material creation

	public static String materialCreationRecord = "//button[normalize-space()='Material Creation Process']";

	public static String materialTypeField = "//p[normalize-space()='Material Type']//..//..//div//input";

	public static String materialGroupField ="//p[normalize-space()='Material Group']//..//..//div//input";

	public static String industrySectorField = "//p[normalize-space()='Industry sector']//..//..//div//input | //p[normalize-space()='Industry Sector']//..//..//div//input";

	public static String plantDataAddHierarchy = "//p[normalize-space()='Plant Data']//..//..//..//p[normalize-space()='Add...']";

	public static String plantDataOption0002 = "//span[contains (text(),'0002')]";
	public static String searchBoxHierarchy = "//div[@class='dropdown-search-wrapper']//mat-icon[@role='img'][normalize-space()='search']//..//input";

	public static String selectSearchedOption = "//span[@class='mat-checkbox-inner-container']";

	public static String valuationDataAddHierarchy = "//p[normalize-space()='Valuation Data']//..//..//..//p[normalize-space()='Add...']";

	public static String valuationTypeField = "//p[normalize-space()='Valuation Type']//..//..//div//input";

	public static String scenarioIdDisabled = "//div[@class='f-col mdo-field mdo-disabled']//input";

	public static String searchClassDropdown = "//div[@class='mat-chip-list-wrapper']//input";

	public static String searchBoxClassDropdown = "//div[@class='dropdown-search-wrapper ng-star-inserted']//div[@class='mdo-search-pill f-row']//input[@placeholder='Search']";

	public static String selectFirstValueClassDropdown = "//lib-filter-option[1]//div[1]";

	public static String firstOptionSearchClass = "//lib-chip[@class='lib-chip ng-star-inserted']//span";

	public static String typeAttributes ="//td[normalize-space()='Type']";
	public static String gritAttributes ="//td[normalize-space()='Grit']";
	public static String plantData0001 ="//p[normalize-space()='Plant:0001 -- PLANT 0001']";
	public static String valuationDataNA ="//p[normalize-space()='Valuation Type:N.A -- Not Applicable']";

	public static String addPlantData =	"//p[normalize-space()='Plant Data']//..//..//..//p[normalize-space()='Add...']";

	public static String searchPlantData  ="//div[@class='dropdown-search-wrapper']//mat-icon[@role='img'][normalize-space()='search']//..//input";

	public static String storageDataAdd  ="//p[normalize-space()='Storage Data']//..//..//..//p[normalize-space()='Add...']";

	public static String valuationDataAdd  ="//p[normalize-space()='Valuation Data']//..//..//..//p[normalize-space()='Add...']";

	public static String firstOptionFromHierarchy  ="//lib-filter-option[1]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[2]";

	public static String searchedPantValue = "//span[@class='mat-checkbox-inner-container']";

	public static String addRowLanguageGrid = "//h4[normalize-space()='Language Grid']//..//..//mat-icon[text()='plus']";
	public static String languageInput = "//p[normalize-space()='Language']//..//..//div//input";
	public static String germanLanguage = "//span[normalize-space()='de -- German']";
	public static String materialDescFormView = "//mat-label[@class='mdo-field-label mdo-required ng-star-inserted']//p[@class='xsmall strong ng-star-inserted'][normalize-space()='Material Description']//..//..//..//div//input";
	public static String saveFormView = "//div[@class='mdo-constrained-right']//lib-button[@type='major']";
	public static String actionIconLanguage = "//td[@role='cell']//lib-button[@type='plain']//mat-icon[@role='img'][normalize-space()='ellipsis-h']";
	public static String deleteRowOption = "//button[normalize-space()='Delete Row']";
	public static String errorMessage ="//div[@class='mdo-notice f-row mdo-notice-error']";
	public static String viewRecord = "//span[@class='info-link']";

	//Duplicacy rule
	public static String materialDescReviewer = "//p[normalize-space()='Material Description']//..//..//..//input";
	public static String generateDescriptionLabel ="//h4[normalize-space()='Generate description']";
	public static String divisionField = "//p[normalize-space()='Division']//..//..//div//input";
	public static String materialDesclLabel = "//p[normalize-space()='Material Description']";
	public static String manufacturerField = "//p[normalize-space()='Manufacturer Part Number']//..//..//..//input";
	public static String oldMaterialNumField = "//p[normalize-space()='Old Material Number']//..//..//..//input";
	public static String grossWeightField = "//p[normalize-space()='Gross weight']//..//..//..//input";
	public static String grossWeightLabel = "//p[normalize-space()='Gross weight']";

	public static String authorizationGroupField ="//p[normalize-space()='Authorization Group']//..//..//..//..//input";

	public static String volumeField = "//p[normalize-space()='Volume']//..//..//..//input";

	public static String duplicateRecordFirst = "//tr[1]/td[2]/lib-text-line[1]/p[1]";
	public static String approveButtonReviewer = "//span[normalize-space()='Approve']";

	public static String classField = "//p[normalize-space()='Class']//..//..//input";
	public static String bearingBallClassOption  ="//span[normalize-space()='Bearing - Ball']";

	public static String typeField  ="//p[normalize-space()='Type']//..//..//div//input";

	public static String widthField  ="//p[normalize-space()='Width']//..//..//div//input";

	public static String seriesField  ="//p[normalize-space()='Series']//..//..//div//input";

	public static String insideDiameterField  ="//p[normalize-space()='INSIDE DIAMETER']//..//..//div//input";

	public static String outsideDiameterField  ="//p[normalize-space()='OUTSIDE DIAMETER']//..//..//div//input";

	public static String cageMaterialField  ="//p[normalize-space()='CAGE MTERIAL']//..//..//div//input";

	public static String manufacturerFieldDesc  ="//p[normalize-space()='MANUFACTURER']//..//..//div//input";

	public static String modelNumberField  ="//p[normalize-space()='Model Number']//..//..//..//input";

	public static String rowField  ="//p[normalize-space()='ROW']//..//..//div//input";

	public static String partNumberField  ="//p[normalize-space()='Part number']//..//..//..//input";

	public static String shortDescriptionField  ="//p[normalize-space()='Short description']//..//..//..//input";
	public static String qaFormOption  = "//button[normalize-space()='QA Form']";
	public static String longDescriptionField  ="//div[contains (text(),'Long description')]//..//..//div//textarea";
	@FindBy(xpath = "//p[normalize-space()='Industry Sector']")
	protected WebElement filterIndustrySector1;


	}
