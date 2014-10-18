package control;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	private String Infobox, Name, strAlternativeName;
	
	public Parser(){
		 try {
				File fXmlFile = new File("sample_text.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				NodeList nList = doc.getElementsByTagName("page");
				System.out.println("----------------------------"+nList.getLength());			
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						
						NodeList pageList = eElement.getElementsByTagName("revision");
						
						for (int k = 0; k < pageList.getLength(); k++) {
							String text = ((Element)pageList.item(k)).getElementsByTagName("text").item(0).getTextContent();
						    Pattern r = Pattern.compile("(\\{\\{\\s*Infobox)(.*)(\\}\\})", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
						    Matcher m = r.matcher(text);//

						    //find Infobox
						    if(m.find()) {
						    	String parsedString = m.group(2);
						    	//System.out.println("fachame '"+parsedString);
						    	int leftBrace = 0, rightBrace = 0, endOfString = 0;
						    	
						    	//get just clean Infobox
						    	for (int i = 0, j = 0, n = 0; i < parsedString.length(); i++) {
						            char c = parsedString.charAt(i);
						            if (c == '{') {
						            	++leftBrace; 
						            } else if (c == '}' ) {
						            	if(leftBrace > 0)	
						            		--leftBrace;
						            	else{
						            		++rightBrace;
						            		if( rightBrace == 2){
						            			endOfString = i;
						            			break;
						            		}
						            	}						                
						            }
						        }

						    	if(endOfString > 0)
						    		Infobox = parsedString.substring(0, --endOfString);
						    	else
						    		Infobox = parsedString;
						    	System.out.println("fachame '"+Infobox);

						    	//parse Name 
						    	r = Pattern.compile("(\\|\\s*Name\\s*=)(.*?)(\n)", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
							    m = r.matcher(Infobox);//
							    if(m.find()) {
							    	Name = m.group(2);
							    	System.out.println("nazov '"+Name);
							    }
							    //parse AKA
							    r = Pattern.compile("(\\|\\s*AKA\\s*=)(.*?)(\\|)", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
							    m = r.matcher(Infobox);//
							    if(m.find()) {
							    	strAlternativeName = m.group(2);
							    	System.out.println("alternative names '"+strAlternativeName );
							    }
						    	
						    }
						  
						}
						
						if(pageList != null) continue;
					}
				}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
			  
	}

}
