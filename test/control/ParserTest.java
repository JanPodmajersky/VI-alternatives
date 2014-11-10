package control;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testParser() {
		StaxParse p = new StaxParse();
		p.parse("sample_text.xml");
		
		assertEquals("XML should be parsed correctly name = Bigfoot","Bigfoot" , p.Name);
		assertEquals("XML should be parsed correctly alternative = Sasquatch","Sasquatch" , p.strAlternativeName);
	}

}
