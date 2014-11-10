package control;

import java.util.List;


public class Core {

	public static void main(String[] args) {
				
		/*
		StaxParse sp = new StaxParse();
		sp.parse("enwiki-latest-pages-articles5_best.xml");//enwiki-latest-pages-articles5_best.xml; sample_orig.xml, enwiki-latest-pages-articles2.xml
		
		*/
		SearchLucene SL = new SearchLucene("indexDir","output_big_all.json");
		
		//SL.createIndex();
		//SL.Test();
		
		SL.search("Name", "Volkswagen Golf",10);
		
		//SL.search("Alternative", "",500);
		
		//SL.find();
		
		 

		
		
	}

}
