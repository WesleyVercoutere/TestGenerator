package be.weve.testgenerator.obsolete.generator.impl;

import be.weve.testgenerator.obsolete.generator.Config;

public class FloatType extends NumericType {
	
	protected StringBuilder body(StringBuilder sb, String attName) {
		sb = addLine(sb, Config.convert(attName), 100.0f);
		sb = addLine(sb, Config.convert(attName), -10.0f);
		sb = addLine(sb, Config.convert(attName), 0.0f);
		return sb;
	}
	
	protected StringBuilder addLine(StringBuilder sb, String attForMethod, Object testValue) {
		sb.append("\tclassUnderTest.set" + attForMethod + "(" + new Float(testValue.toString()).floatValue() + "f);");
		sb.append(Config.NEWLINE);
		sb.append("\tassertEquals("+ new Float(testValue.toString()).floatValue() + "f, " + "classUnderTest.get" + attForMethod + "(), 0.001f);");
		sb.append(Config.NEWLINE);
		return sb;
	}

}
