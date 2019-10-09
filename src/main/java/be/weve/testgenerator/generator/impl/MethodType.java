package be.weve.testgenerator.generator.impl;


import be.weve.testgenerator.generator.Config;
import be.weve.testgenerator.generator.TypeGenerator;

public class MethodType extends TypeGenerator {
	
	public StringBuilder generateTest(StringBuilder sb, String mName) {
		sb.append("@Test");
		sb.append(Config.NEWLINE);
		sb.append("public void test" + Config.convert(mName) + "() {");
		sb.append(Config.NEWLINE);
		sb.append("\tfail(\"Not yet implemented\");");
		sb.append(Config.NEWLINE);
		sb.append("}");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		return sb;

	}

}
