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
	@FindBy(xpath = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input")
	protected WebElement userNameField;
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	protected WebElement continueButton;
	@FindBy(xpath = "//p[normalize-space()='Use password']")
	protected WebElement usePasswordButton;
	@FindBy(xpath = "//input[@type='password']")
	protected WebElement PasswordField;
	@FindBy(xpath = "//input[@type='password']")
	protected WebElement nPasswordField;
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	protected WebElement loginBtn;
	@FindBy(xpath = "(//div[@class='mat-list-item-content'])[1]")
	protected WebElement optionsAsPerEnv;
	@FindBy(xpath = "//p[normalize-space()='Tenant 1']")
	protected WebElement tenant1Option;
	@FindBy(xpath = "//p[normalize-space()='QA Sandbox']")
	protected WebElement qaSandboxOption;
	@FindBy(xpath = "//p[contains(text(),'QA')]")
	protected WebElement qaEnv;
	@FindBy(xpath = "//div[@class='mat-list-item-content'][contains(text(),'Data')]")
	protected WebElement dataTab;
	@FindBy(xpath = "//input[@placeholder='Search Data'] | //input[@placeholder='Search data']")
	protected WebElement search;
	@FindBy(xpath = "//h4[contains(text(),'Material Master')]")
	protected WebElement materialMasterHeader;
	@FindBy(xpath = "//p[normalize-space()='Material Master']")
	protected WebElement materialMaster;
	@FindBy(xpath = "//span[contains(text(),'New record')] | //div[@class='f-col state-container']//div[@class='f-row']")
	protected WebElement newRecordBtn;
	@FindBy(xpath = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input")
	protected WebElement revUsernameField;
	@FindBy(xpath = "//p[normalize-space()='Password']//..//..//..//input")
	protected WebElement RevPwdField;
	@FindBy(xpath = "//p[contains(text(),'Use password')]")
	protected WebElement userPasswordLink;
	@FindBy(xpath = "//table//tr[1]//td[3]")
	protected WebElement materialNumFromTbl;
	@FindBy(xpath = "//tbody/tr[1]/td[1]//..//button//span//mat-icon")
	protected WebElement actionIconForFirstValue;
	@FindBy(xpath = "//h4[normalize-space()='Duplicate records']")
	protected WebElement duplicateRecordHeader;
	@FindBy(xpath = "//span[normalize-space()='Continue']'")
	protected WebElement continueDuplicateRecord;
	@FindBy(xpath = "//div[@class='mat-card-avatar ng-star-inserted mdo-small']")
	protected WebElement profileIcon;
	@FindBy(xpath = "//span[contains(text(),'Sign out')]")
	protected WebElement signOut;
	@FindBy(xpath = "//h4[contains (text(), 'Default view')]")
	protected WebElement defaultView;
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']//mat-icon[@role='img'][normalize-space()='caret-down']")
	protected WebElement viewDropDownIcon;
	@FindBy(xpath = "//button[normalize-space()='Approve']")
	protected WebElement approveVal;
	@FindBy(xpath = "//span[normalize-space()='Approve']//..//..//..//..//mat-icon")
	protected WebElement approveDropDownIcon;
	@FindBy(xpath = "//button[normalize-space()='Send for correction']")
	protected WebElement sendForCorrectionOption;

	@FindBy(xpath = "//div[contains(text(),'Comments')]//..//..//textarea")
	protected WebElement rejectionCommentBox;
	@FindBy(xpath = "//span[normalize-space()='Submit']")
	protected WebElement submitButtonRejectionFlow;
	@FindBy(xpath = " //button[contains(text(),'Save as draft')]")
	protected WebElement draft;
	@FindBy(xpath = "//h4[normalize-space()='My requests']")
	protected WebElement myRrequestHeader;
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	protected WebElement edit;
	@FindBy(xpath = "//button[normalize-space()='Material Master - QA'] | //button[normalize-space()='MaterialCreationFlow'] | //button[normalize-space()='SequentialMaterial']")
	protected WebElement materialMasterRecordOption;
	@FindBy(xpath = "//th[@id='STATUS']//input[@placeholder='Filter']")
	protected WebElement statusFilter;
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	protected WebElement uSaveBtn;
	@FindBy(xpath = "//h4[contains(text(),'All errors')]")
	protected WebElement allerros;
	@FindBy(xpath = "//mat-icon[normalize-space()='chevron_right']")
	protected WebElement expandHeaderData;
	@FindBy(xpath = "//mat-icon[normalize-space()='chevron_right'][1]")
	protected WebElement expandPlantData;
	@FindBy(xpath = "//mat-icon[normalize-space()='chevron_right']")
	protected WebElement expandPlant;
	@FindBy(xpath = "//mat-icon[normalize-space()='chevron_right']")
	protected WebElement expandValuationData;
	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	protected WebElement materialMasterNum;
	@FindBy(xpath = "//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	protected WebElement searchedValue;

	// <! New record Page Locators !>
	@FindBy(xpath = "//p[contains(text(),'Material Master')]")
	protected WebElement dMaterialMaster;
	@FindBy(xpath = "//button[normalize-space()='Material Master - QA'] | //button[normalize-space()='MaterialCreationFlow']")
	protected WebElement materialMasterRoleValue;
	@FindBy(xpath = "//p[normalize-space()='Industry sector']//..//..//div//input | //p[normalize-space()='Industry Sector']//..//..//div//input")
	protected WebElement industrySec;
	@FindBy(xpath = "//div[@class='mdo-notice f-row mdo-notice-error']")
	protected WebElement errorMessage;

	@FindBy(xpath = "//p[normalize-space()='Material Group']//..//..//div//input")
	protected WebElement materialGroup;
	@FindBy(xpath = "//span[contains(text(),'Generate description')]")
	protected WebElement generateDesc;

	@FindBy(xpath = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
	protected WebElement claS;

	@FindBy(xpath = "//pros-transaction-generate-description[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
	protected WebElement clasval;

	public static String classval = "(//span[@class='mat-option-text'])[1]";
	public static String summaryVal = "//button[contains(text(),' Summary ')]";

	@FindBy(xpath = "//p[normalize-space()='Loading Group']//..//..//mat-icon")
	protected WebElement loading;
	@FindBy(xpath = "//button[contains(text(),'Copy')] | //button[normalize-space()='Copy']")
	protected WebElement copy;

	@FindBy(xpath = "//button//span[contains(text(),'Copy')]")
	protected WebElement copyButton;

	@FindBy(xpath = "//mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	protected WebElement recordno;

	@FindBy(xpath = "//div[1]/div[1]/pros-transaction-hierarchy-list[1]/div[1]/mat-tree[1]/mat-tree-node[2]/div[1]/div[1]")
	protected WebElement plantD;

	@FindBy(xpath = "//div[1]/mat-tree[1]/mat-tree-node[3]/div[1]/div[1]/lib-text-line[1]/p[1]")
	protected WebElement plantDatatwo;

	@FindBy(xpath = "//mat-tree-node[5]/div[1]/div[1]/lib-text-line[1]/p[1]")
	protected WebElement valuationD;
	@FindBy(xpath = "//span[contains(text(),'Copy')]")
	protected WebElement copyBtn;
	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[1]/lib-text-line[1]/h4[1]")
	protected WebElement newRecordTitle;
	@FindBy(xpath = "//div[1]/mat-tree[1]/mat-tree-node[3]/div[1]/div[1]/lib-text-line[1]/p[1]")
	protected WebElement newPlantD;
	@FindBy(xpath = "//p[normalize-space()='Source - List']//..//..//input[@placeholder='Select any one...']")
	protected WebElement sourceListDescription;
	@FindBy(xpath = "//div[@role='listbox']//mat-option[2]")
	protected WebElement dropValue;
	@FindBy(xpath = "//div[@role='listbox']//mat-option[1]")
	protected WebElement dropValue1;
	@FindBy(xpath = "//button[normalize-space()='SequentialMaterial'] | //button[normalize-space()='Material Creation Process'] | //button[normalize-space()='MaterialCreationFlow'] | //button[contains(text(),'Sequential Flow')]")
	protected WebElement sequentialMaterialOption;

	/**
	 * material creation flow fields
	 */
	@FindBy(xpath = "//p[normalize-space()='Material Type']//..//..//div//input")
	protected WebElement materialType;
	@FindBy(xpath = "//p[normalize-space()='X-Plant Material Status']//..//..//div//mat-icon")
	protected WebElement xPlantMaterialStatusField;
	@FindBy(xpath = "//div[@role='listbox']//mat-option[3]//span")
	protected WebElement dropValue3;
	@FindBy(xpath = "//p[text()='Storage Data ']//..//..//mat-icon[text()='plus']")
	protected WebElement plusStorageData;
	@FindBy(xpath = "//label[@for='mat-checkbox-275-input']//span[@class='mat-checkbox-inner-container']")
	protected WebElement firstOptionStorageData;
	@FindBy(xpath = "//p[@class='xsmall strong ng-star-inserted'][normalize-space()='Manufacturer Part Number']//..//..//..//div//input")
	protected WebElement manufacturerPartNum;
	@FindBy(xpath = "//p[normalize-space()='Automation number']//..//..//..//input")
	protected WebElement automationNumberField;
	@FindBy(xpath = "//span[@class='mat-option-text']//..//..//mat-option//span[1]")
	protected WebElement dropValueLoading;
	@FindBy(xpath = "//p[normalize-space()='Plant Data']//..//..//..//..//p[contains(text(),'Add')]")
	protected WebElement plantdataPlusIcon;
	@FindBy(xpath = "//span[contains(text(),' 0004 -- PLANT 0004')]")
	protected WebElement plantvalue;
	@FindBy(xpath = "//span[contains(text(),' Apply ')]")
	protected WebElement applyBtn;
	@FindBy(xpath = "//input[@aria-checked='true']")
	protected WebElement selectedHierarchy;

	@FindBy(xpath = "//p[normalize-space()='MRP Type']//..//..//mat-icon")
	protected WebElement mrpType;
	@FindBy(xpath = "//p[contains(text(),'MRP Type')]")
	protected WebElement mrpTypeField;
	@FindBy(xpath = "//p[normalize-space()='Valuation Data']//..//..//..//..//p[contains(text(),'Add')]")
	protected WebElement valuationPlusIcon;
	@FindBy(xpath = "//lib-filter-option[1]//label[@class='mat-checkbox-layout'][1]")
	protected WebElement valuationFirstOption;

	@FindBy(xpath = "//p[normalize-space()='Valuation Cat.']//..//..//div//input")
	protected WebElement valCat;
	@FindBy(xpath = "//span[contains(text(),'NEW -- NEW')]")
	protected WebElement newCheckbox;
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	protected WebElement submitBtn;
	@FindBy(xpath = "//button[normalize-space()='View process log']")
	protected WebElement viewPLog;
	@FindBy(xpath = "//span[normalize-space()='Completed']//..//..//..//..//p[contains(text(),'View changes')] | //span[normalize-space()='Completed']//..//..//..//..//..//p[contains(text(),'View changes')]")
	protected WebElement completedViewProcessLog;

	@FindBy(xpath = "//mat-expansion-panel[1]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[2]/lib-text-line[2]/p[1]")
	protected WebElement viewEmailLogs;
	@FindBy(xpath = "(//lib-text-line//P[text()=' View '])[1]")
	protected WebElement viewPotentialOwner;
	@FindBy(xpath = "//h4[normalize-space()='View details']")
	protected WebElement viewDetailsHeader;
	@FindBy(xpath = "//div[@class='message-list f-col']//tr[1]//td")
	protected WebElement firstRecordOfEmailLogs;
	@FindBy(xpath = "//h4[normalize-space()='View process log']//..//..//..//..//mat-icon")
	protected WebElement closeIconForProcessLog;
	@FindBy(xpath = "//lib-button[@icon='times']")
	protected WebElement crossIconS;
	@FindBy(xpath = "//h4[normalize-space()='View details']//..//..//..//..//mat-icon")
	protected WebElement crossIconViewEmailLogs;
	@FindBy(xpath = "(//mat-expansion-panel-header[1]//span[1]//mat-icon[text()='diagram-subtask'])[1]")
	protected WebElement instanceDiagramIcon;
	@FindBy(xpath = "//h4[contains(text(),'Process flow')]")
	protected WebElement processFlowHeader;
	@FindBy(xpath = "//draggable[1]/div[1]/img[1]")
	protected WebElement instanceDiagramImage;
	@FindBy(xpath = "//h4[contains(text(),'Process flow')]//..//..//..//..//mat-icon")
	protected WebElement closeIconProcessFlow;
	@FindBy(xpath = "//h4[normalize-space()='View changes']//..//..//..//..//mat-icon")
	protected WebElement closeIcoForViewChange;
	@FindBy(xpath = "//tbody/tr[1]/td[2]/lib-button-group[1]/ul[1]/li[1]/lib-button[1]/button[1]/span[1]/mat-icon[1]")
	protected WebElement firstActionIconForInbox;
	@FindBy(xpath = "//button[contains(text(),'Approve')]")
	protected WebElement approveBtn;
	@FindBy(xpath = "//h4[contains(text(),'SequentialMaterial')]")
	protected WebElement sequentialHeader;
	@FindBy(xpath = "//p[normalize-space()='Planning Cycle']//..//..//..//input")
	protected WebElement planingCycleField;
	@FindBy(xpath = "//p[normalize-space()='Last forecast']//..//..//..//input")
	protected WebElement lastForecastField;
	@FindBy(xpath = "//p[normalize-space()='DNU Fixed periods']//..//..//..//input")
	protected WebElement dnuFixedPeriods;
	@FindBy(xpath = "//p[contains(text(),'Forecast Parameters')]//..//..//lib-text-line//..//..//p[contains(text(),'Add')]")
	protected WebElement addForecastHierarchy;
	@FindBy(xpath = "//p[normalize-space()='Unit of Weight']//..//..//div//button")
	protected WebElement unitOfWeightField;
	@FindBy(xpath = "//p[normalize-space()='Volume unit']//..//..//div//input")
	protected WebElement volumeUnitField;
	@FindBy(xpath = "//span[contains(text(),' Approve ')]")
	protected WebElement approveButton;
	@FindBy(xpath = "//button[contains(text(),'Claim')]")
	protected WebElement claim;
	@FindBy(xpath = "//button[normalize-space()='Unclaim']")
	protected WebElement unclaim;
	@FindBy(xpath = "//button[normalize-space()='Process log']")
	protected WebElement processLogOption;
	@FindBy(xpath = "//div[@class='display-heading ng-star-inserted']")
	protected WebElement lblText;
	@FindBy(xpath = "//button[contains(text(),' Description Change ')]")
	protected WebElement dChange;
	@FindBy(xpath = "//button[contains(text(),' View process log ')] | //button[normalize-space()='Process log']")
	protected WebElement viewProcessLogOption;
	@FindBy(xpath = "//button[contains(text(),'Process log')]")
	protected WebElement processLog;
	@FindBy(xpath = "(//p[@class='base no-wrap ng-star-inserted'])[1]")
	protected WebElement processLogStatus;
	@FindBy(xpath = "//body/pros-root[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/ng-component[1]/pros-transaction-builder[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/lib-button[1]/button[1]")
	protected WebElement ccrsIcon;
	@FindBy(xpath = "//pros-primary-navigation[1]/mat-sidenav-content[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]/input[1]")
	protected WebElement dSearchBox;
	@FindBy(xpath = "//p[contains(text(),'Apply')]")
	protected WebElement apply;
	@FindBy(xpath = "//tbody/tr[1]/td[2]/lib-button[1]/button[1]/span[1]/mat-icon[1]")
	protected WebElement thDot;
	@FindBy(xpath = "//th[normalize-space()='Field Name']")
	protected WebElement fieldNameHeader;
	@FindBy(xpath = "//th[normalize-space()='Before Change']")
	protected WebElement beforeChangeHeader;
	@FindBy(xpath = "//th[normalize-space()='After Change']")
	protected WebElement afterChangeHeader;
	@FindBy(xpath = "//mat-expansion-panel-header/span[1]/mat-panel-title[1]/div[1]")
	protected WebElement processLogTitle;
	@FindBy(xpath = "//lib-button[contains(@libtooltip, 'comments')]")
	protected WebElement commentIconProcessLog;
	@FindBy(xpath = "//pros-chat-editor[@class='chat-editor-outer']")
	protected WebElement chatBoxComment;
	@FindBy(xpath = "//lib-button[@icon='external-link-alt']")
	protected WebElement externalIcon;
	@FindBy(xpath = "//span[normalize-space()='Completed']")
	protected WebElement statusCom;
	@FindBy(xpath = "//p[normalize-space()='Header data']")
	protected WebElement headerData;
	@FindBy(xpath = "//h2[contains(text(),'Design')]")
	protected WebElement design;
	@FindBy(xpath = "//h4[contains(text(),' Process log ')]")
	protected WebElement pTitle;
	@FindBy(xpath = "//p[contains(text(),'%s')]")
	protected WebElement currentDate;

	@FindBy(xpath = "//span[contains(text(),'SUCCESS')]")
	protected WebElement statusSuccessTxt;

	@FindBy(xpath = "//lib-button[@icon='times']//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']")
	protected WebElement crossP;
	@FindBy(xpath = "//div[contains(text(),' Flows ')]")
	protected WebElement flowTab;
	@FindBy(xpath = "//span[contains(text(),'Manage flows')]")
	protected WebElement manageFlowBtn;
	@FindBy(xpath = "//div[@class='container-fluid container-cards-pf']")
	protected WebElement spac;
	@FindBy(xpath = "//div[@class='container-fluid container-cards-pf']")
	protected WebElement spacRecord;
	@FindBy(xpath = "//pros-list-datatable[1]/div[1]/div[2]/div[1]/div[1]/lib-search[1]/div[1]//input")
	protected WebElement searchB;
	@FindBy(xpath = "//p[normalize-space()='Apply']")
	protected WebElement applySearch;
	@FindBy(xpath = "//div[@class='mdo-search-pill f-row']//mat-icon[@role='img'][normalize-space()='times']")
	protected WebElement clearSearch;
	@FindBy(xpath = "//input[@data-placeholder='Search']")
	protected WebElement searchPlaceHolder;

	@FindBy(xpath = "//input[@id='user_submit']")
	protected WebElement log;
	@FindBy(xpath = "//mat-sidenav-container[1]/mat-sidenav-content[1]/pros-login[1]/div[1]/div[1]/form[1]/div[1]/lib-input[1]/div[1]/div[1]/input[1]")
	protected WebElement usernameProd;
	@FindBy(xpath = "//p[contains(text(),'Production')]")
	protected WebElement prodEnv;
	@FindBy(xpath = "//th[@id='DATECREATED']//pros-inline-table-column-filter")
	protected WebElement createdOnFilter;
	@FindBy(xpath = "//div[normalize-space()='3']")
	protected WebElement date3;
	@FindBy(xpath = "//div[contains(text(),'End')]")
	protected WebElement endDateTab;

	@FindBy(xpath = "//div[normalize-space()='10']")
	protected WebElement date10;
	@FindBy(xpath = "//th[@id='DATEMODIFIED']//pros-inline-table-column-filter")
	protected WebElement modifiedOnFilter;
	@FindBy(xpath = "//tbody/tr[1]/td[3]//p")
	protected WebElement firstValueMaterialMaster;
	@FindBy(xpath = "//mat-icon[normalize-space()='filter']")
	protected WebElement filterIcon;
	@FindBy(xpath = "//span[normalize-space()='Is not']")
	protected WebElement isNotFilter;
	@FindBy(xpath = "//p[normalize-space()='Industry Sector'] | //p[normalize-space()='Industry sector']")
	protected WebElement filterIndustrySector;
	@FindBy(xpath = "//p[normalize-space()='SAP Material Number'] | //p[@class='base ng-star-inserted'][normalize-space()='SAP Number']")
	protected WebElement sapMaterialNumberFilter;
	@FindBy(xpath = "//lib-chip-list[@class='chips-list']//textarea")
	protected WebElement sapMaterialNumberInputField;
	@FindBy(xpath = "//p[normalize-space()='View integration logs']")
	protected WebElement viewIntegrationLogs;
	@FindBy(xpath = "//h4[normalize-space()='Integration log']")
	protected WebElement integrationLogsHeader;
	@FindBy(xpath = "//h4[normalize-space()='Integration log']//..//..//..//..//mat-icon")
	protected WebElement closeIntegrationLogsView;
	@FindBy(xpath = "//mat-list-item[3]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]")
	protected WebElement valueFMCG_IndustrySectorFilter;
	@FindBy(xpath = "//mat-tree-node[4]//div[1]//div[1]//lib-text-line[1]//p[1]//label")
	protected WebElement valuationDataHierarchy;
	@FindBy(xpath = "//mat-tree-node[3]//div[1]//div[1]//lib-text-line[1]//p[1]//label//span//input[@aria-checked='true']")
	protected WebElement plantDataSelected;
	@FindBy(xpath = "//span[normalize-space()='Apply']")
	protected WebElement applyFilterButton;
	@FindBy(xpath = "//p[normalize-space()='Material Type']")
	protected WebElement filterMaterialType;
	@FindBy(xpath = "//mat-list-item[2]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]")
	protected WebElement valueSparePart_MaterialTypeFilter;
	@FindBy(xpath = "//p[normalize-space()='Material Description']")
	protected WebElement filterMaterialDesc;
	@FindBy(xpath = "//h4[normalize-space()='Material Description']//..//..//..//input")
	protected WebElement input_MaterialDescFilter;
	@FindBy(xpath = "//p[normalize-space()='Base Unit of measure'] | //p[normalize-space()='Base Unit of Measure']")
	protected WebElement filterBaseUnitOfMeasure;

	@FindBy(xpath = "//mat-list-item[2]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[1]")
	protected WebElement valuePercentage_BaseUnitFilter;
	@FindBy(xpath = "//span[@class='filter-text ng-star-inserted']//..//mat-icon[normalize-space()='times']")
	protected WebElement clearAppliedFiler;
	@FindBy(xpath = "//div[@class='mdo-search-pill f-row']//mat-icon[@role='img'][normalize-space()='times']")
	protected WebElement clearSearchField;
	@FindBy(xpath = "//th[@id='STATUS']//input[@placeholder='Filter']")
	protected WebElement filterStatusDropdown;
	@FindBy(xpath = "//tbody/tr[1]/td[8]")
	protected WebElement firstValueOfStatus;
	@FindBy(xpath = "//th[@id='STATUS']//mat-icon[@role='img'][normalize-space()='times']")
	protected WebElement clearIconForStatusFilter;
	@FindBy(xpath = "//tr[2]//th[7][@id='USERMODIFIED']")
	protected WebElement filterModifiedByDropdown;
	@FindBy(xpath = "//tbody/tr[1]/td[7]")
	protected WebElement firstValueOfModifiedBy;
	@FindBy(xpath = "//mat-icon[@class='mat-icon notranslate mdo-icons-light mat-icon-no-color'][normalize-space()='times']")
	protected WebElement clearIconForModifiedByFilter;
	@FindBy(xpath = "//span[@class='filter-value'][normalize-space()='ellipsis-h']")
	protected WebElement threeDotsAdvanceFilter;
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	protected WebElement resetButton;
	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	protected WebElement confirmButton;
	@FindBy(xpath = "//span[normalize-space()='Industry Sector'] | //span[normalize-space()='Industry sector']")
	protected WebElement appliedIndusSectorFilter;
	@FindBy(xpath = "//mat-icon[@class='mat-icon notranslate mdo-icons mat-icon-no-color'][normalize-space()='ellipsis-h']")
	protected WebElement threeDotsIconAppliedFilter;
	@FindBy(xpath = "//button[normalize-space()='Save as...']")
	protected WebElement saveAsOption;
	@FindBy(xpath = "//p[contains (text(), 'Filter name')]//..//..//..//input")
	protected WebElement filterNameInput;
	@FindBy(xpath = "//span[normalize-space()='Save']")
	protected WebElement saveButtonFilterPopup;
	@FindBy(xpath = "//mat-icon[normalize-space()='layer-group']")
	protected WebElement storedFiltersIcon;
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	protected WebElement cancelButtonFilterPopup;
	@FindBy(xpath = "//tbody/tr[1]/td[4]")
	protected WebElement firstValueCreatedOnDateInTable;
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	protected WebElement deleteSavedFilters;
	@FindBy(xpath = "//div[@class='f-row list-pagination ng-star-inserted']//p")
	protected WebElement paginationValue;
	@FindBy(xpath = "//p[normalize-space()='Manufacturer Part Number']")
	protected WebElement manufacturerPartNumFilterTab;
	@FindBy(xpath = "//h4[normalize-space()='Manufacturer Part Number']//..//..//..//input")
	protected WebElement inputManufacturerPartNumFilter;
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-button mat-button-base mdo-button']//mat-icon[@role='img'][normalize-space()='caret-down']")
	protected WebElement dropDownViewICon;
	@FindBy(xpath = "//button[normalize-space()='New view']")
	protected WebElement newViewOption;
	@FindBy(xpath = "//p[@class='xsmall strong ng-star-inserted']//..//..//..//input")
	protected WebElement inputViewName;
	@FindBy(xpath = "//span[normalize-space()='Save']")
	protected WebElement saveButtonView;
	@FindBy(xpath = "//button[normalize-space()='Default view']")
	protected WebElement defaultViewOption;
	@FindBy(xpath = "//mat-icon[normalize-space()='cog']")
	protected WebElement settingIcon;
	@FindBy(xpath = "//div[@class='f-row breadcrum-toolbar']//mat-icon[normalize-space()='ellipsis-h']")
	protected WebElement threeDotsIconForView;
	@FindBy(xpath = "//button[normalize-space()='Delete view']")
	protected WebElement deleteViewOption;
	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	protected WebElement confirmDeleteView;
	@FindBy(xpath = "//div[@class='f-row mdo-pagination']//lib-button[@icon='chevron-right']")
	protected WebElement nextPage;
	@FindBy(xpath = "//button[normalize-space()='Summary']")
	protected WebElement summaryOption;
	@FindBy(xpath = "//lib-section[@text='Flows']//..//button[2]")
	protected WebElement flowMaterialMasterRecordoption;
	@FindBy(xpath = "//div[@class='root']//div[@class='f-row breadcrum-toolbar']//mat-icon[normalize-space()='times']")
	protected WebElement closeIcon;
	@FindBy(xpath = "//lib-section[@text='Flows']//..//button[3]")
	protected WebElement formClassnClassTypeOption;
	@FindBy(xpath = "//button[normalize-space()='Download templates']")
	protected WebElement downloadTemplatesOption;
	@FindBy(xpath = "//div[@class='scroll-height']//button[2]")
	protected WebElement descriptionOption;

	// Home page
	@FindBy(xpath = "//div[@class='mat-list-item-content']//..//div[contains(text(),'Home')]")
	protected WebElement homeTab;
	@FindBy(xpath = "//lib-text-line[contains(text(),'Inbox')]")
	protected WebElement inboxMenu;
	@FindBy(xpath = "//lib-text-line[normalize-space()='In progress']")
	protected WebElement inProgressMenu;
	@FindBy(xpath = "//lib-text-line[normalize-space()='Completed']")
	protected WebElement completedMenu;
	@FindBy(xpath = "//lib-text-line[contains(text(),'My requests')]")
	protected WebElement myReqTab;
	@FindBy(xpath = "//lib-text-line[normalize-space()='System Errors']")
	protected WebElement systemErrorsTab;
	@FindBy(xpath = "//lib-search[@placeholder='Search']//div[@class='mdo-search-pill f-row']//input")
	protected WebElement searchSystemErrorsTab;
	@FindBy(xpath = "//div[@class='mdo-search-pill f-row']//mat-icon[@role='img'][normalize-space()='times']")
	protected WebElement clearSearchSystemErrorsTab;
	@FindBy(xpath = "(//mat-icon[text()='arrow-rotate-right'])[1]")
	protected WebElement retriggerIcon;
	@FindBy(xpath = "//div[@class='mdo-notice f-row mdo-notice-success']")
	protected WebElement successRetrigger;
	@FindBy(xpath = "//span[normalize-space()='Flow']")
	protected WebElement flowFilter;
	@FindBy(xpath = "//span[normalize-space()='Task type']")
	protected WebElement taskFilter;
	@FindBy(xpath = "//div[@class='options']//lib-filter-option[1]//div[1]//label")
	protected WebElement firstOptionFilter;
	@FindBy(xpath = "//tbody/tr[1]")
	protected WebElement firstRecordFromList;
	@FindBy(xpath = "//lib-section[@text='Flows']//..//button[1]")
	protected WebElement flowList;
	@FindBy(xpath = "//button[normalize-space()='Material Creation Process'] | //button[normalize-space()='MaterialCreationFlow']")
	protected WebElement materialCreationRecord;
	@FindBy(xpath = "//span[normalize-space()='ERSA -- Spare Part']")
	protected WebElement sparePartMaterialOption;
	@FindBy(xpath = "//div[@class='cdk-overlay-pane']")
	protected WebElement successMessageToast;
	@FindBy(xpath = "//p[normalize-space()='Material Group']//..//..//div//input")
	protected WebElement materialGroupField;
	@FindBy(xpath = "//p[normalize-space()='Industry sector']//..//..//div//input | //p[normalize-space()='Industry Sector']//..//..//div//input")
	protected WebElement industrySectorField;
	@FindBy(xpath = "//p[normalize-space()='Plant Data']//..//..//..//p[normalize-space()='Add...']")
	protected WebElement plantDataAddHierarchy;
	@FindBy(xpath = "//p[normalize-space()='Sales Data']//..//..//..//p[normalize-space()='Add...']")
	protected WebElement salesDataAddHierarchy;

	@FindBy(xpath = "//span[contains (text(),'0002')]")
	protected WebElement plantDataOption0002;
	@FindBy(xpath = "//div[@class='dropdown-search-wrapper']//mat-icon[@role='img'][normalize-space()='search']//..//input")
	protected WebElement searchBoxHierarchy;
	@FindBy(xpath = "//div[@class='dropdown-option text-overflow']//label")
	protected WebElement selectSearchedOption;
	@FindBy(xpath = "//p[normalize-space()='Valuation Data']//..//..//..//p[normalize-space()='Add...']")
	protected WebElement valuationDataAddHierarchy;
	@FindBy(xpath = "//lib-text-line[contains(text(),'Sales Organisation:0001 -- Sales Org. 001')]")
	protected WebElement salesOrganisationData;

	@FindBy(xpath = "//div[@class='mat-chip-list-wrapper']//input")
	protected WebElement searchClassDropdown;
	@FindBy(xpath = "//div[@class='dropdown-search-wrapper ng-star-inserted']//div[@class='mdo-search-pill f-row']//input[@placeholder='Search']")
	protected WebElement searchBoxClassDropdown;

	@FindBy(xpath = "//lib-filter-option[1]//div[1]")
	protected WebElement selectFirstValueClassDropdown;
	@FindBy(xpath = "//lib-chip[@class='lib-chip ng-star-inserted']//span")
	protected WebElement firstOptionSearchClass;
	@FindBy(xpath = "//td[normalize-space()='Type']")
	protected WebElement typeAttributes;
	@FindBy(xpath = "//td[normalize-space()='Grit']")
	protected WebElement gritAttributes;
	@FindBy(xpath = "//p[normalize-space()='Plant:0001 -- PLANT 0001']")
	protected WebElement plantData0001;
	@FindBy(xpath = "//p[normalize-space()='Valuation Type:N.A -- Not Applicable']")
	protected WebElement valuationDataNA;
	@FindBy(xpath = "//p[normalize-space()='Plant Data']//..//..//..//p[normalize-space()='Add...']")
	protected WebElement addPlantData;
	@FindBy(xpath = "//div[@class='dropdown-search-wrapper']//mat-icon[@role='img'][normalize-space()='search']//..//input")
	protected WebElement searchPlantData;
	@FindBy(xpath = "//p[normalize-space()='Storage Data']//..//..//..//p[normalize-space()='Add...']")
	protected WebElement storageDataAdd;
	@FindBy(xpath = "//p[normalize-space()='Valuation Data']//..//..//..//p[normalize-space()='Add...']")
	protected WebElement valuationDataAdd;
	@FindBy(xpath = "//lib-filter-option[1]/div[1]/lib-checkbox[1]/mat-checkbox[1]/label[1]/span[2]")
	protected WebElement firstOptionFromHierarchy;
	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
	protected WebElement searchedPantValue;
	@FindBy(xpath = "//h4[normalize-space()='Language Grid']//..//..//mat-icon[text()='plus'] | //h5[normalize-space()='Language Grid']//..//..//mat-icon[text()='plus']")
	protected WebElement addRowLanguageGrid;
	@FindBy(xpath = "//p[normalize-space()='Language']//..//..//div//input")
	protected WebElement languageInput;
	@FindBy(xpath = "//span[normalize-space()='de -- German']")
	protected WebElement germanLanguage;
	@FindBy(xpath = "//span[normalize-space()='ar -- Arabic']")
	protected WebElement arabicLanguage;
	@FindBy(xpath = "//p[normalize-space()='Material Description']//..//..//..//div//input")
	protected WebElement materialDescFormView;
	@FindBy(xpath = "//div[@class='mdo-constrained-right']//lib-button[@type='major']")
	protected WebElement saveFormView;
	@FindBy(xpath = "//td[@role='cell']//lib-button[@type='plain']//mat-icon[@role='img'][normalize-space()='ellipsis-h']")
	protected WebElement actionIconLanguage;
	@FindBy(xpath = "//button[normalize-space()='Delete Row']")
	protected WebElement deleteRowOption;

	@FindBy(xpath = "//span[@class='info-link']")
	protected WebElement viewRecord;
	@FindBy(xpath = "//p[normalize-space()='Material Description']//..//..//..//input")
	protected WebElement materialDescReviewer;
	@FindBy(xpath = "//h5[normalize-space()='Generate description']")
	protected WebElement generateDescriptionLabel;
	@FindBy(xpath = "//p[normalize-space()='Division']//..//..//div//input")
	protected WebElement divisionField;
	@FindBy(xpath = "//p[normalize-space()='Material Description']")
	protected WebElement materialDescLabel;
	@FindBy(xpath = "//p[normalize-space()='Manufacturer Part Number']//..//..//..//input")
	protected WebElement manufacturerField;
	@FindBy(xpath = "//p[normalize-space()='Gross weight']//..//..//..//input | //p[normalize-space()='Gross Weight']//..//..//..//input")
	protected WebElement grossWeightField;
	@FindBy(xpath = "//p[normalize-space()='Net Weight']//..//..//..//input")
	protected WebElement netWeightField;
	@FindBy(xpath = "//p[normalize-space()='Maximum Stock Level']//..//..//..//input")
	protected WebElement maxStockLevelField;
	@FindBy(xpath = "//p[contains(text(),'Procurement Type')]//..//..//mat-icon")
	protected WebElement procurementTypeField;
	@FindBy(xpath = "//p[contains(text(),'Procurement Type')]//..//..//div//input")
	protected WebElement procurementTypeFieldInput;

	@FindBy(xpath = "//p[normalize-space()='General Item Cat. Group']//..//..//mat-icon")
	protected WebElement generalItemCatGroup;

	@FindBy(xpath = "//p[normalize-space()='General Item Cat. Group']//..//..//div//input")
	protected WebElement generalItemCatGroupInput;
	@FindBy(xpath = "//p[contains(text(),'Planned Delivery Time')]//..//..//..//input")
	protected WebElement plannedDeliveryTimeField;
	@FindBy(xpath = "//p[contains(text(),'Reorder Point')]//..//..//..//input")
	protected WebElement reorderPointField;
	@FindBy(xpath = "//p[contains(text(),'Order Unit')]//..//..//..//mat-icon")
	protected WebElement orderUnitField;
	@FindBy(xpath = "//p[contains(text(),'Order Unit')]//..//..//div//input")
	protected WebElement orderUnitFieldVale;
	@FindBy(xpath = "//h5[normalize-space()='HERS Material Grid']//..//..//..//mat-icon[text()='plus']")
	protected WebElement plusIconHersGrid;
	@FindBy(xpath = "//p[normalize-space()='Manufacturer Part Number (Hers)']//..//..//..//input")
	protected WebElement mpnHersGrid;
	@FindBy(xpath = "//lib-input[@class='ng-untouched ng-pristine ng-valid ng-star-inserted']//p[@class='xsmall strong ng-star-inserted'][normalize-space()='Manufacturer']//..//..//..//input")
	protected WebElement manufacturerHersGrid;
	@FindBy(xpath = "//span[normalize-space()='Save']")
	protected WebElement saveHersGrid;

	@FindBy(xpath = "//p[normalize-space()='Gross weight']")
	protected WebElement grossWeightLabel;
	@FindBy(xpath = "//p[normalize-space()='Volume']//..//..//..//input")
	protected WebElement volumeField;
	@FindBy(xpath = "//tr[1]/td[2]/lib-text-line[1]/p[1]")
	protected WebElement duplicateRecordFirst;
	@FindBy(xpath = "//span[normalize-space()='Approve']")
	protected WebElement approveButtonReviewer;
	@FindBy(xpath = "//p[normalize-space()='Class']//..//..//input")
	protected WebElement classField;
	@FindBy(xpath = "//span[normalize-space()='Bearing - Ball']")
	protected WebElement bearingBallClassOption;
	@FindBy(xpath = "//p[normalize-space()='Type']//..//..//div//input")
	protected WebElement typeField;
	@FindBy(xpath = "//p[normalize-space()='Width']//..//..//div//input")
	protected WebElement widthField;
	@FindBy(xpath = "//p[normalize-space()='Series']//..//..//div//input")
	protected WebElement seriesField;
	@FindBy(xpath = "//p[normalize-space()='INSIDE DIAMETER']//..//..//div//input")
	protected WebElement insideDiameterField;
	@FindBy(xpath = "//p[normalize-space()='OUTSIDE DIAMETER']//..//..//div//input")
	protected WebElement outsideDiameterField;
	@FindBy(xpath = "//p[normalize-space()='CAGE MTERIAL']//..//..//div//input")
	protected WebElement cageMaterialField;

	@FindBy(xpath = "//p[normalize-space()='MANUFACTURER']//..//..//div//input")
	protected WebElement manufacturerFieldDesc;
	@FindBy(xpath = "//p[normalize-space()='Model Number']//..//..//..//input")
	protected WebElement modelNumberField;
	@FindBy(xpath = "//p[normalize-space()='ROW']//..//..//div//input")
	protected WebElement rowField;
	@FindBy(xpath = "//p[normalize-space()='Part number']")
	protected WebElement partNumberLabel;
	@FindBy(xpath = "//p[normalize-space()='Part number']//..//..//..//input")
	protected WebElement partNumberField;
	@FindBy(xpath = "//p[normalize-space()='Short description']//..//..//..//input")
	protected WebElement shortDescriptionField;
	@FindBy(xpath = "//p[normalize-space()='Long Description']//..//..//..//input")
	protected WebElement longDescriptionField;
	@FindBy(xpath = "//*[@id=\"right-side-nav-1\"]/div/ng-component/pros-duplicate-records-datatable/div/div[2]/div[3]/table/tbody/tr[1]/td[3]/lib-text-line/p")
	protected WebElement duplicateRecords;
	@FindBy(xpath = "//p[@class='small ng-star-inserted']")
	protected WebElement errorsForRule;
	@FindBy(xpath = "//p[normalize-space()='Fix the following errors to proceed']")
	protected WebElement followingErrorToProceed;
	@FindBy(xpath = "//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div[1]//p")
	protected WebElement errors;
	@FindBy(xpath = "//div[@class='message-list f-col']//tr[1]//td[1]")
	protected WebElement emailRecords;

	@FindBy(xpath = "//div[@class='mdo-notice f-row mdo-notice-info']")
	protected WebElement processLogs;


}