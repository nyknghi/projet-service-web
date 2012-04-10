package servlet;

import facade.AuteurFacade;
import facade.ClientFacade;
import facade.IGestionnaire;
import gestionnaire.GesBooks;
import gestionnaire.GesBooksServiceLocator;
import gestionnaire.PaiementService;
import gestionnaire.PaiementServiceServiceLocator;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.json.JSONException;
import org.json.JSONObject;


public class Controller extends HttpServlet{
	InitialContext ctx;

	private static final long serialVersionUID = 1L;
	static IGestionnaire gest;
	static GesBooks sellingService;
	static PaiementService bankService;

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
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case 0:
			try {
				connexion(request, response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			try {
				connexion(request, response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			break;
		}
	}

	protected void connexion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, JSONException {
		boolean success = false;
		String type = request.getParameter("type");
		String pwd = request.getParameter("pwd");
		String login = request.getParameter("login");
		HttpSession session = request.getSession();

		if(type.equals("AUTEUR")){
			AuteurFacade auteur = gest.rechercherAuteurParLogin(login, pwd);
			if(auteur!=null){
				success = true;
				session.setAttribute("clientType", "Auteur");
				session.setAttribute("user", auteur);
			}
		}
		else if (type.equals("CLIENT")){
			ClientFacade client = gest.rechercherClientParLogin(login, pwd);
			if(client!=null){
				success = true;
				session.setAttribute("clientType", "Client");
				session.setAttribute("user", client);
			}
		}
		JSONObject jMsg = new JSONObject();
		if (!success) {
			String message = "Login et/ou mot de passe incorrect";
			request.setAttribute("errorMessage", message);
			jMsg.put("msg", "<br /> Erreur de Traitement, la requete n'a pu être effectué <br />");
			jMsg.put("code", "0");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		} else {
			jMsg.put("msg", " connexion reussi");	
			jMsg.put("code", "1");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}
	}

	public void init() throws ServletException {
		try {
			ctx = new InitialContext();
			ctx.addToEnvironment(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			ctx.addToEnvironment(InitialContext.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			ctx.addToEnvironment(InitialContext.PROVIDER_URL,"jnp://localhost:1099");
			this.connecterRMI();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void connecterRMI(){

		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			Registry r = LocateRegistry.getRegistry();
			gest = (IGestionnaire) r.lookup("rmi://localhost/GestionnaireServeur");
			bankService = (PaiementService) new PaiementServiceServiceLocator().getPaiementService();
			sellingService = (GesBooks) new GesBooksServiceLocator().getGesBooks();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
