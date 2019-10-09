package be.weve.testgenerator.obsolete.generator.impl;

import be.weve.testgenerator.obsolete.generator.Config;

public class IntType extends NumericType 	{
	
	protected StringBuilder body(StringBuilder sb, String attName) {
		sb = addLine(sb, Config.convert(attName), 100);
		sb = addLine(sb, Config.convert(attName), -10);
		sb = addLine(sb, Config.convert(attName), 0);
		return sb;
	}
	
	protected StringBuilder addLine(StringBuilder sb, String attForMethod, Object testValue) {
		sb.append("\tclassUnderTest.set" + attForMethod + "(" + new Integer(testValue.toString()).intValue() + ");");
		sb.append(Config.NEWLINE);
		sb.append("\tassertTrue("+ new Integer(testValue.toString()).intValue() + "==" + "classUnderTest.get" + attForMethod + "());");
		sb.append(Config.NEWLINE);
		return sb;
	}

}
