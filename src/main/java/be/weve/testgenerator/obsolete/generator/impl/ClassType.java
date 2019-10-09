package be.weve.testgenerator.obsolete.generator.impl;

import be.weve.testgenerator.obsolete.generator.Config;
import be.weve.testgenerator.obsolete.generator.TypeGenerator;

public class ClassType extends TypeGenerator {

	public StringBuilder generateTest(StringBuilder sb, String attName) {
		sb.append("@Test");
		sb.append(Config.NEWLINE);
		sb.append("public void test" + Config.convert(attName) + "() {");
		sb.append(Config.NEWLINE);
		sb.append("\tassertNull(classUnderTest.get" + Config.convert(attName) + "());");
		sb.append(Config.NEWLINE);
		sb.append("}");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		return sb;

	}
}
