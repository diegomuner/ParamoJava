package com.casino;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:///C:/ParamoJava/Casino/src/main/resources/${env}.properties" }) // mention the property file name


public interface Environment extends Config {
	@DefaultValue("https://demo.casino")
	String url();
	

	String username();

	String password();
	

	@Key("db.hostname")
	String getDBHostname();

	@Key("db.port")
	int getDBPort();

	@Key("db.username")
	String getDBUsername();

	@Key("db.password")
	String getDBPassword();

}
