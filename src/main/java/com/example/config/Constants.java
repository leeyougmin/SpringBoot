package com.example.config;

public interface Constants {

	/** Static Resource Default Package classpath */
	public static final String STATIC_PATH = "classpath:/static";
	
	/** Static Resources */
	public final static String[] STATIC_RES = {
			"/js"
			, "/css"
			, "/images"
			, "/fonts"
	};

	public final static int SESSION_TIME_OUT = 30; // min
	
	/**
	 *  STATIC_RESOURCES_URL_PATTERNS Order By ({@code CLASSPATH_RESOURCE_LOCATIONS} )
	 *  @see #CLASSPATH_RESOURCE_LOCATIONS
	 */
	public final static String[] STATIC_RESOURCES_URL_PATTERNS = {
			STATIC_RES[0] + "/**"
			, STATIC_RES[1] + "/**"
			, STATIC_RES[2] + "/**"
			, STATIC_RES[3] + "/**"
	};
	
	/**
	 * CLASSPATH_RESOURCE_LOCATIONS Order By ({@code STATIC_RESOURCES_URL_PATTERN})
	 * @see #STATIC_RESOURCES_URL_PATTERNS
	 */
	public final static String[] CLASSPATH_RESOURCE_LOCATIONS = {
			STATIC_PATH + STATIC_RES[0] + "/"
			, STATIC_PATH + STATIC_RES[1] + "/"
			, STATIC_PATH + STATIC_RES[2] + "/"
			, STATIC_PATH + STATIC_RES[3] + "/"
	};

}
