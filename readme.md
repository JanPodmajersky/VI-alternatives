1. Installing
	Extarct the files into eclipse project.
	
	Core
		- the main usage
	StaxParse
		- Parser of wikipedia articles
	SearchLucene
		- create of indexes and searching for specific string
		
2. Example	
		StaxParse sp = new StaxParse();
		sp.parse("enwiki-latest-pages-articles5_best.xml");//parse of articles
		
		SearchLucene SL = new SearchLucene("indexDir","output_big_all.json");//create index on outputfile, the names reamin always the same
		
		SL.createIndex();
		SL.Stats();
		
		SL.search("Name", "Eskrima",10);//search in names
		SL.search("Alternative", "pes",500);//search in alternative names
			

2. modifying test
 - download new dataset
 - change content of data/test_data.xml file, for updated version of data, consisting just of one aBigfoot wiki article

3. testing
 - run Test/control/ParserTest.java as JUnitTest in Eclipse
 - sample data/test_data.xml is parsed, it is very simple file, consisting just of one alternative, which is checked.
 