package qa.qamentor.commands;

public interface OR {

	
	
	public static String LOGIN_BUTTON = "loginFormRexButton";//id
	public static String CHOICE_LOGO = "/a[@class='navbar-brand']";
	public static String LOGIN_PAGE_TITLE = "//div[@class='logo-modal']";
	public static String USER_NAME = "username";//id
	public static String PASS_WORD = "password";//id
	public static String LOGIN_SUBMIT = "validateLogin";//id
	 
	
	public static String ON_COMMERCE_LOGO = "//img[contains(@id,'image') and contains(@src,'logo')]";
	public static String ON_COMMERCE_USER_NAME = "username";//ByName
	public static String ON_COMMERCE_PASS_WORD = "password";//ByName
	public static String ON_COMMERCE_LOGIN_SUBMIT = "//a[contains(@class,'login-btn-home')]";
	public static String ON_COMMERCE_HOME_PAGE_TITLE = "//td[@class='loyScreenTitle']";
	
	
	public static String ETIHAD_GUEST_LOGO = "//span[@title='Etihad Guest']";
	public static String ETIHAD_LOGIN_BUTTON = "loginFormRexButton";//id
	public static String CITRIX_LOGIN_LOGO = "//div[@id='logonbox-logoimage']";
	public static String CITRIX_USER_NAME = "login";//ByName
	public static String CITRIX_PASS_WORD = "passwd";//ByName
	public static String CITRIX_LOGON_BUTTON = "Log_On";//id
	public static String ETIHAD_USER_MENU = "//li[contains(@class,'dropdown li-profile')]";
	public static String REDIRECT_ETIHAD_GUEST_LOGO ="//a[@class='logo']";
	public static String ETIHAD_USER_NAME = "GuestLoginForm_Username";//ByName
	public static String ETIHAD_PASS_WORD = "GuestLoginForm_Password";//ByName
	public static String ETIHAD_LOGON_BUTTON = "guestLoginSubmitButton";//id
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String ENTER_SITE_BUTTON = "//a[contains(text(),'I am over 18')]";
	public static String LOGO = "//img[@class='brandLogo']";
	public static String SIGN_IN_LINK = "//a[text()='Sign In']";
	public static String LOGIN_POPUP_TITLE = "//h2[@class='modal-title']";
	
	public static String USERNAME_TEXTBOX = "loginUsername";
	public static String PASSWORD_TEXTBOX = "loginPassword";
	
	public static String SIGN_IN_BUTTON = "//a[text()='sign in']";
	public static String LOGGED_USERNAME = "//li[@id='authenticatedUserMenu']/a/span[text()='";
	public static String LOGGED_USERNAME_1 = "']";
	public static String LOGOUT_BUTTON = "//span[text()='Logout']";
	
	public static String MODEL_RESULT_CONNECTION ="//div[@class='search-result-card'][4]//div[@class='result-item']//div[@class='result-card']/div[@class='thumb-overlay']//div[contains(@class,'result-connections')]";
	public static String MODEL_RESULT_SUBJECT ="//div[@class='search-result-card'][4]//div[@class='result-item']//div[@class='result-card']/div[@class='thumb-overlay']//div[contains(@class,'result-subject')]";
	public static String MODEL_RESULT_NAME ="//div[@class='search-result-card'][4]//div[@class='result-item']//div[@class='result-card']/div[@class='thumb-overlay']//div[contains(@class,'result-name')]";
	public static String RANDOM_MODEL ="//div[@class='search-result-card'][2]//div[@class='result-item']/div/a/div/img";
	public static String SELECTED_MODEL_TITLE ="//h1[contains(@ng-if,'profileType')]";
	public static String RANDOM_MODEL_1 ="//div[@class='search-result-card'][1]//div[@class='result-item']/div/a/div/img";
	public static String RANDOM_MODEL_5 ="//div[@class='search-result-card'][6]//div[@class='result-item']/div/a/div/img";
	public static String RANDOM_MODEL_6 ="//div[@class='search-result-card'][7]//div[@class='result-item']/div/a/div/img";	
	public static String GO_PRIVATE_BUTTON ="//button[text()='Go Private']";
	public static String PRIVATE_CHAT_POPUP_TITLE ="//h3[contains(text(),'Enter private chat with')]";
	public static String START_PRIVATE_CHAT_BUTTON ="//button[contains(text(),'Start Private Chat')]";
	public static String MENU_HOME = "//a[text()='home']";
 
	public static String END_PRIVATE_SHOW_BUTTON = "//a[contains(text(),'End Private Show')]";
	public static String END_PRIVATE_CHAT_POPUP_TITLE = "//h3[contains(text(),'End this Private Chat')]";
	public static String END_PRIVATE_CHAT_BUTTON = "//button[text()='End Private Chat']";
	public static String END_SPY_CHAT_SHOW_BUTTON = "//a[text()='home']";
	public static String END_SPY_CHAT_POPUP_TITLE = "//a[text()='home']";
	public static String END_SPY_CHAT_BUTTON = "//a[text()='home']";
	
	public static String SPY_SHOWS_TAB = "//div[@id='browse-tabs']//span[@id='spyshows']";
	public static String SPY_SHOWS_PAGE_TITLE = "//h1[@id='browse-header']/strong[contains(text(),'Spy on Private Cam Shows')]";
	public static String SPY_SHOWS_MODEL = "//div[@class='search-result-card'][1]//div[@class='result-item']/div/a/div/img";
	public static String SPY_SHOWS_MODEL_1 = "//div[@class='search-result-card'][2]//div[@class='result-item']/div/a/div/img";
	public static String SPY_SHOWS_MODEL_2 = "//div[@class='search-result-card'][3]//div[@class='result-item']/div/a/div/img";
	public static String SPY_SHOWS_MODEL_SUBJECT = "//div[@class='search-result-card'][1]//div[@class='result-item']//div[@class='result-card']/div[@class='thumb-overlay']//div[contains(@class,'result-subject')]";
	public static String SPY_SHOWS_MODEL_NAME = "//div[@class='search-result-card'][1]//div[@class='result-item']//div[@class='result-card']/div[@class='thumb-overlay']//div[contains(@class,'result-name')]";
	public static String SPY_ON_THIS_PRIVATE_SHOW_BUTTON = "//a[contains(text(),'Spy on This Private Show')]";
	public static String SPY_CHAT_POPUP_TITLE = "//h3[contains(text(),'Enter spy chat with')]";
	public static String START_SPY_CHAT_BUTTON = "//button[contains(text(),'Start Spy Chat')]";
	
	
	
	
		
}
 	