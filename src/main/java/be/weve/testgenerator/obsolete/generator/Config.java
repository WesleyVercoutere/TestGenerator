package be.weve.testgenerator.obsolete.generator;

public class Config {
	
	public static final String NEWLINE = "\n";
	
	public static String convert(String attName) {
		return attName.substring(0, 1).toUpperCase() + attName.substring(1);
	}

}
