package be.weve.testgenerator.generator.impl;

import be.weve.testgenerator.generator.Config;
import be.weve.testgenerator.generator.TypeGenerator;

public class BooleanType extends TypeGenerator {
	
	public StringBuilder generateTest(StringBuilder sb, String attName) {
		sb.append("@Test");
		sb.append(Config.NEWLINE);
		sb.append("public void test" + Config.convert(attName) + "() {");
		sb.append(Config.NEWLINE);
		sb.append("\tassertFalse(classUnderTest.is" + Config.convert(attName) + "());");
		sb.append(Config.NEWLINE);
		sb.append("\tclassUnderTest.set" + Config.convert(attName) + "(true);");
		sb.append(Config.NEWLINE);
		sb.append("\tassertTrue(classUnderTest.is" + Config.convert(attName) + "());");
		sb.append(Config.NEWLINE);
		sb.append("}");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		return sb;

	}

}
