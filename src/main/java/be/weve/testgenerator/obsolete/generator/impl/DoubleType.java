package be.weve.testgenerator.obsolete.generator.impl;

import be.weve.testgenerator.obsolete.generator.Config;

public class DoubleType extends NumericType {
	
	protected StringBuilder body(StringBuilder sb, String attName) {
		sb = addLine(sb, Config.convert(attName), 100.0d);
		sb = addLine(sb, Config.convert(attName), -10.0d);
		sb = addLine(sb, Config.convert(attName), 0.0d);
		return sb;
	}
	
	protected StringBuilder addLine(StringBuilder sb, String attForMethod, Object testValue) {
		sb.append("\tclassUnderTest.set" + attForMethod + "(" + new Double(testValue.toString()).doubleValue() + ");");
		sb.append(Config.NEWLINE);
		sb.append("\tassertEquals("+ new Double(testValue.toString()).doubleValue() + ", " + "classUnderTest.get" + attForMethod + "(), 0.001d);");
		sb.append(Config.NEWLINE);
		return sb;
	}

}
