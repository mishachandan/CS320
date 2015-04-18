package config;



public class Constants {

	
	public static String JOBSAPP = "jobsApp";
	public static String JOBS = "jobs";
    public static String TEMPLATE_HEAD= "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8' /><title>CS 320</title>"+
    							"<link href='views/tomcat.css' rel='stylesheet' type='text/css' />    </head> "+
    							"<body><div id='wrapper'><div id='upper' class='curved container'><div id='notice'><img src='views/csula.png' alt='[csu la logo]' style='height:20%;width:20%' />"+
    							"<div id='asf-box'><h1> Cal State LA </h1><h2>Department of Computer Science</h2> </div> </div>"+
    							"<br class='separator' /></div><div id='lower'><div id='low-docs'><div class='curved container'><h4>CSS 320  Assignments</h4><h3></h3>";
    
    public static String TEMPLATE_TAIL= "<br/><ul><lh>API</lh><li><a href='http://tomcat.apache.org/tomcat-8.0-doc/'>Tomcat 8.0 JavaDocs</a></li></ul></div></div></div><br class='separator' /></div><p class='copyright'>Copyright &copy;1999-Apache Software Foundation.  All Rights Reserved</p></div></body></html>";
    
    public static String TEMPLATE_HEAD_HTML= "<link href=' "+Config.applicationURL+"views/tomcat.css' rel='stylesheet' type='text/css' />   "+
			"<body><div id='wrapper'><div id='upper' class='curved container'><div id='notice'><img src=' "+Config.applicationURL+"views/csula.png' alt='[csu la logo]' style='height:20%;width:20%' />"+
			"<div id='asf-box'><h1> Cal State LA </h1><h2>Department of Computer Science</h2> </div> </div>"+
			"<br class='separator' /></div><div id='lower'><div id='low-docs'><div class='curved container'><h4>CSS 320  Assignments</h4><h3></h3>";
    public static String TEMPLATE_TAIL_HTML= "<br/><ul><lh>API</lh><li><a href='http://tomcat.apache.org/tomcat-8.0-doc/'>Tomcat 8.0 JavaDocs</a></li></ul></div></div></div><br class='separator' /></div><p class='copyright'>Copyright &copy;1999-Apache Software Foundation.  All Rights Reserved</p></div>";
	
	
	public static String getJOBSAPP() {
		return JOBSAPP;
	}
	public static String getTEMPLATE_HEAD() {
		return TEMPLATE_HEAD;
	}
	public static String getTEMPLATE_TAIL() {
		return TEMPLATE_TAIL;
	}
	public static String getTEMPLATE_HEAD_HTML() {
		return TEMPLATE_HEAD_HTML;
	}
	public static String getTEMPLATE_TAIL_HTML() {
		return TEMPLATE_TAIL_HTML;
	}
    
}
