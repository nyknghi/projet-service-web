package gestionnaire;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import facade.AuteurFacade;
import facade.ClientFacade;

public class Controller extends HttpServlet{
	InitialContext ctx;

	private static final long serialVersionUID = 1L;
	static IGestionnaire gest;
	static GesBooks sellingService;
	static String[] allCurrency;
	//static PaiementService bankService;

	public Controller() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String opt = request.getParameter("action");
		Integer option = 0;
		if (opt == null)
			option = -1;
		else{
			try{
				option = Integer.parseInt(opt);
			}
			catch(NumberFormatException ex){
				option = -1;
			}
		}

		switch (option) {
		case -1:
			try {
				;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 0:
			connexion(request, response);
			break;
		default:
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			break;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String opt = request.getParameter("action");
		Integer option = 0;
		if (opt == null)
			option = -1;
		else
			option = Integer.parseInt(opt);
		switch (option) {
		case 0:
			connexion(request, response);
			break;
		default:
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			break;
		}
	}

	protected void connexion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		ClientFacade client = gest.rechercherClientParLogin(login, pwd);
		if(client!=null){
			success = true;
			if(client.getType().equals("Auteur")){
				AuteurFacade auteur = gest.rechercherAuteurParId(client.getIdClient());
				session.setAttribute("type", "auteur");
				session.setAttribute("user", auteur);
			}
			else{
				session.setAttribute("type", "client");
				session.setAttribute("user", client);
			}
		}
		if (!success) {
			request.setAttribute("errorMessage", "Login et/ou mot de passe incorrect");
		}
		request.getRequestDispatcher("/index.jsp").forward(request,
					response);
	}

	public void init() throws ServletException {

		this.connecterRMI();

	}

	public void connecterRMI(){
		/*Properties syst = System.getProperties();
		Enumeration test = syst.propertyNames();
		while(test.hasMoreElements()){
			String key = (String)test.nextElement();
			System.out.println(key + "\t -> \t" + syst.getProperty(key));
		}
		String path = System.getProperties().getProperty("user.home");
		System.out.println("chenmin  " + path);*/
		System.setProperty("java.security.policy", "E:/workspace/BooksOnline/src/sec.policy");
		System.setProperty("java.rmi.server.codebase", "file:///workspace/BooksOnline/src/gestionnaire/");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		
		try {
			Registry r = LocateRegistry.getRegistry();
			gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			//bankService = (PaiementService) new PaiementServiceServiceLocator().getPaiementService();
			sellingService = (GesBooks) new GesBooksServiceLocator().getGesBooks();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public void putAllCurrency(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession(true);
		allCurrency = new String[51];
		allCurrency[0] = "AFA"; allCurrency[1] = "ALL"; allCurrency[2] = "DZD";
		allCurrency[3] = "ARS"; allCurrency[4] = "AWG"; allCurrency[5] = "AUD";
		allCurrency[6] = "BSD"; allCurrency[7] = "BHD"; allCurrency[8] = "BDT";
		allCurrency[9] = "BBD"; allCurrency[10] = "BZD"; allCurrency[11]  = "BMD";
	    allCurrency[12]  = "BTN";allCurrency[13]  = "BOB";allCurrency[14]  = "BWP";
	    allCurrency[15]  = "BRL";allCurrency[16]  = "GBP";allCurrency[17]  = "BND";
	    allCurrency[18]  = "BIF";allCurrency[19]  = "XOF";allCurrency[20]  = "XAF";
	    allCurrency[21]  = "KHR";allCurrency[22]  = "CAD";allCurrency[23]  = "CVE";
	    allCurrency[24]  = "KYD";allCurrency[25]  = "CLP";allCurrency[26]  = "CNY";
	    allCurrency[27]  = "COP";allCurrency[28]  = "KMF";allCurrency[29]  = "CRC";
	    allCurrency[30]  = "HRK";allCurrency[31]  = "CUP";allCurrency[32]  = "CYP";
	    allCurrency[33]  = "CZK";allCurrency[34]  = "DKK";allCurrency[35]  = "DJF";
	    allCurrency[36]  = "DOP";allCurrency[37]  = "XCD";allCurrency[38]  = "EGP";
	    allCurrency[39]  = "SVC";allCurrency[40]  = "EEK";allCurrency[41]  = "ETB";
	    allCurrency[42] = "EUR";allCurrency[43]  = "FKP";allCurrency[44]  = "GMD";
	    allCurrency[45]  = "GHC";allCurrency[46]  = "GIP";allCurrency[47]  = "XAU";
	    allCurrency[48]  = "GTQ";allCurrency[49] = "GNF";allCurrency[50]  = "GYD";
	    
	    session.setAttribute("allCurrency", allCurrency);
	    /*allCurrency[0]  = "HTG";
	    allCurrency[0] = "HNL";
	    allCurrency[0]  = "HKD";
	    allCurrency[0] = "HUF";
	    allCurrency[0]  = "ISK";
	    allCurrency[0]  = "INR";
	    allCurrency[0]  = "IDR";
	    allCurrency[0] = "IQD";
	    allCurrency[0]  = "ILS";
	    allCurrency[0]  = "JMD";
	    allCurrency[0]  = "JPY";
	    allCurrency[0]  = "JOD";
	    allCurrency[0]  = "KZT";
	    allCurrency[0] = "KES";
	    allCurrency[0] = "KRW";
	    allCurrency[0]  = "KWD";
	    allCurrency[0]  = "LAK";
	    allCurrency[0] = "LVL";
	    allCurrency[0]  = "LBP";
	    allCurrency[0]  = "LSL";
	    allCurrency[0]  = "LRD";
	    allCurrency[0]  = "LYD";
	    allCurrency[0] = "LTL";
	    allCurrency[0]  = "MOP";
	    allCurrency[0]  = "MKD";
	    allCurrency[0]  = "MGF";
	    allCurrency[0]  = "MWK";
	    allCurrency[0]  = "MYR";
	    allCurrency[0]  = "MVR";
	    allCurrency[0]  = "MTL";
	    allCurrency[0]  = "MRO";
	    allCurrency[0]  = "MUR";
	    allCurrency[0]  = "MXN";
	    allCurrency[0]  = "MDL";
	    allCurrency[0] = "MNT";
	    allCurrency[0]  = "MAD";
	    allCurrency[0]  = "MZM";
	    allCurrency[0]  = "MMK";
	    allCurrency[0]  = "NAD";
	    allCurrency[0]  = "NPR";
	    allCurrency[0]  = "ANG";
	    allCurrency[0]  = "NZD";
	    allCurrency[0]  = "NIO";
	    allCurrency[0]  = "NGN";
	    allCurrency[0]  = "KPW";
	    allCurrency[0]  = "NOK";
	    allCurrency[0]  = "OMR";
	    allCurrency[0]  = "XPF";
	    allCurrency[0]  = "PKR";
	    allCurrency[0]  = "XPD";
	    allCurrency[0]  = "PAB";
	    allCurrency[0]  = "PGK";
	    allCurrency[0]  = "PYG";
	    allCurrency[0] = "PEN";
	    allCurrency[0]  = "PHP";
	    allCurrency[0]  = "XPT";
	    allCurrency[0]  = "PLN";
	    allCurrency[0]  = "QAR";
	    allCurrency[0]  = "ROL";
	    allCurrency[0]  = "RUB";
	    allCurrency[0]  = "WST";
	    allCurrency[0]  = "STD";
	    allCurrency[0]  = "SAR";
	    allCurrency[0]  = "SCR";
	    allCurrency[0]  = "SLL";
	    allCurrency[0]  = "XAG";
	    allCurrency[0]  = "SGD";
	    allCurrency[0]  = "SKK";
	    allCurrency[0]  = "SIT";
	    allCurrency[0]  = "SBD";
	    allCurrency[0]  = "SOS";
	    allCurrency[0]  = "ZAR";
	    allCurrency[0]  = "LKR";
	    allCurrency[0]  = "SHP";
	    allCurrency[0]  = "SDD";
	    allCurrency[0]  = "SRG";
	    allCurrency[0]  = "SZL";
	    allCurrency[0]  = "SEK";
	    allCurrency[0]  = "CHF";
	    allCurrency[0]  = "SYP";
	    allCurrency[0]  = "TWD";
	    allCurrency[0]  = "TZS";
	    allCurrency[0]  = "THB";
	    allCurrency[0]  = "TOP";
	    allCurrency[0]  = "TTD";
	    allCurrency[0]  = "TND";
	    allCurrency[0]  = "TRL";
	    allCurrency[0]  = "USD";
	    allCurrency[0]  = "AED";
	    allCurrency[0]  = "UGX";
	    allCurrency[0]  = "UAH";
	    allCurrency[0]  = "UYU";
	    allCurrency[0]  = "VUV";
	    allCurrency[0]  = "VEB";
	    allCurrency[0]  = "VND";
	    allCurrency[0]  = "YER";
	    allCurrency[0]  = "YUM";
	    allCurrency[0]  = "ZMK";
	    allCurrency[0]  = "ZWD";
	    allCurrency[0]  = "TRY";*/
	}
}
