package gestionnaire;

public class Util {
	static String PATH_USER_DIR=System.getProperty("user.dir");
	static String PATH_POLICY;
	static String PATH_CODEBASE;
	
	public static void execPath(){
		PATH_USER_DIR = PATH_USER_DIR.replaceAll(new String("\\\\"), new String("/"));
		PATH_POLICY = PATH_USER_DIR + "/sec.policy";
		PATH_CODEBASE = "file:///" + PATH_USER_DIR.substring(3, PATH_USER_DIR.length()) + "/gestionnaire/";		
	}
	
	public static void main (String[] args){		
		execPath();
		System.out.println(PATH_USER_DIR);
		System.out.println(PATH_POLICY);
		System.out.println(PATH_CODEBASE);
	}
}
