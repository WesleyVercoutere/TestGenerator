package be.weve.testgenerator.obsolete.generator;

public class TestClassGenerator {
	
	private String dto;
	private String shortdto;
	private String pkg;
	
	public TestClassGenerator(String dto, String pkg) {
		this.dto = dto;
		this.pkg = pkg;
		this.shortdto = dto.substring(dto.lastIndexOf(".")+1, dto.length());
	}

	public StringBuilder generateTestClassDefinition() {
		StringBuilder sb = new StringBuilder();

		sb.append("package " + pkg + ";");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		
		sb.append("import static org.junit.Assert.assertEquals;");
		sb.append(Config.NEWLINE);
		sb.append("import static org.junit.Assert.assertFalse;");
		sb.append(Config.NEWLINE);
		sb.append("import static org.junit.Assert.assertNull;");
		sb.append(Config.NEWLINE);
		sb.append("import static org.junit.Assert.assertTrue;");
		sb.append(Config.NEWLINE);
		sb.append("import static org.junit.Assert.fail;");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);

		sb.append("import org.junit.Before;");
		sb.append(Config.NEWLINE);
		sb.append("import org.junit.Test;");
		sb.append(Config.NEWLINE);
		sb.append("import " + dto + ";");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		sb.append("public class " + shortdto + "Test {");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);

		generateSetup(sb);

		return sb;
	}

	private void generateSetup(StringBuilder sb) {
		sb.append("private " + shortdto + " classUnderTest;");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);
		sb.append("@Before");
		sb.append(Config.NEWLINE);
		sb.append("public void setup() {");
		sb.append(Config.NEWLINE);
		sb.append("\tclassUnderTest = new " + shortdto + "();");
		sb.append(Config.NEWLINE);
		sb.append("}");
		sb.append(Config.NEWLINE);
		sb.append(Config.NEWLINE);

	}

}
