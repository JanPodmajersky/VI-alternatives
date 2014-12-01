1. testing
 - run Test/control/ParserTest.java as JUnitTest in Eclipse
 - sample data/test_data.xml is parsed, it is very simple file, consisting just of one alternative, which is checked.

2. modifying test
 - change content of data/test_data.xml file, for updated version of data, consisting just of one alternative
 - modify line 13,14, in Test/control/ParserTest.java
	- assertEquals("XML should be parsed correctly name = YOUR NAME","YOUR NAME" , p.Name);
	- assertEquals("XML should be parsed correctly alternative = YOUR ALT NAME","YOUR ALT NAME" , p.strAlternativeName);