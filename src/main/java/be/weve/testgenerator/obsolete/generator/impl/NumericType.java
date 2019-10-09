package be.weve.testgenerator.obsolete.generator.impl;

import be.weve.testgenerator.obsolete.generator.Config;
import be.weve.testgenerator.obsolete.generator.TypeGenerator;

public abstract class NumericType extends TypeGenerator {
	
	protected abstract StringBuilder addLine(StringBuilder sb, String attForMethod, Object testValue);
	protected abstract StringBuilder body(StringBuilder sb, String attName);
	
	public StringBuilder generateTest(StringBuilder sb, String attName) {
		sb = methodStart(sb, attName);
		sb = body(sb, attName);
		sb = methodEnd(sb);
		return sb;

	}

	private StringBuilder methodStart(StringBuilder sb, String attName) {
		sb.append("@Test");
		sb.append(Config.NEWLINE);
		sb.append("public void test" + Config.convert(attName) + "() {");
		sb.append(Config.NEWLINE);
		return sb;
	}
	
	

	private StringBuilder methodEnd(StringBuilder sb) {
		sb.append("}");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		return sb;
	}

	
}
