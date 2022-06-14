package com.example.common;

public class Url {

	public static class AUTH {
		
		public final static String AUTH = "/auth";

		public final static String LOGIN = AUTH + "/login";
		public final static String LOGIN_JSP = AUTH + "login";

		public final static String LOG_OUT = AUTH + "/logout";

		public final static String PROC = AUTH + "/login-proc";
	}
	
	public static class MAIN {
		
		public final static String MAIN = "/";
		public final static String MAIN_JSP = "main";
	}
	
	public static class POSTMAN {
		
		public final static String PARAM = "/test";
	}
}
