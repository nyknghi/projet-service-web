package test;

import gestionnaire.IGestionnaire;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	public static void main(String[] args){
		Context ctx;
		IGestionnaire gest;
		try {
			ctx = new InitialContext();
			ctx.addToEnvironment(InitialContext.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			ctx.addToEnvironment(InitialContext.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");
			ctx.addToEnvironment(InitialContext.PROVIDER_URL,
					"jnp://localhost:1099");
			gest = (IGestionnaire) ctx.lookup("Gestionnaire/remote");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
}
