package com.mstr.objects;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mtaf.utilities.Reporter;

	public class ObjectRepository {
		static DocumentBuilderFactory docBuilderFactory = null;
	    static DocumentBuilder docBuilder = null;
	    static  Document doc = null;

		public static String getIdentify(String objectName) throws Throwable
		{   
			try
			{
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse (new File(System.getProperty("user.dir")+"\\src\\com\\mstr\\objects\\ObjectRepository.xml"));
			 boolean flag=false;
			 NodeList listOfObject = doc.getElementsByTagName("object");
			 for(int s=0; s<listOfObject.getLength() ; s++){


		         Node firstOjectNode = listOfObject.item(s);
		         if(firstOjectNode.getNodeType() == Node.ELEMENT_NODE){


		             Element firstObjectElement = (Element)firstOjectNode;

		             //-------
		             NodeList firstNameList = firstObjectElement.getElementsByTagName("name");
		             Element firstNameElement = (Element)firstNameList.item(0);

		             NodeList textFNList = firstNameElement.getChildNodes();
		             String name=((Node)textFNList.item(0)).getNodeValue().trim();
		            
		            
		             if(name.equals(objectName))
		             {   flag=true;
		            	 NodeList lastNameList = firstObjectElement.getElementsByTagName("identifyBy");
		                 Element lastNameElement = (Element)lastNameList.item(0);
		                 NodeList textLNList = lastNameElement.getChildNodes();
		                 String identification=((Node)textLNList.item(0)).getNodeValue().trim();
		                 if(identification=="")
		                 {
		                	 Reporter.failureReport("The XML Object does not have a identifyBy attribute value for the Object"+objectName,"");
		                 }
		            	 return identification;
		            	
		             }
		             else
		             {
		            	 
		            	 
		            		 
		            		 continue;
		             }
		             
		         }
		         
			 }
			 if(!flag)
			 {
				 System.out.println("there was no tag with "+objectName+" value");
			 }
			
			return "";
			}
			catch(Exception e)
			{
				Reporter.failureReport("The XML File does not have a Object with name "+objectName,"");
				return "";
			}
		}
		public static String getLocation(String objectName) throws Throwable
		{   try
		    {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse (new File(System.getProperty("user.dir")+"\\src\\com\\mstr\\objects\\ObjectRepository.xml"));
			 NodeList listOfObject = doc.getElementsByTagName("object");
			 boolean flag=false;
			 for(int s=0; s<listOfObject.getLength() ; s++){


		         Node firstOjectNode = listOfObject.item(s);
		         if(firstOjectNode.getNodeType() == Node.ELEMENT_NODE){


		             Element firstObjectElement = (Element)firstOjectNode;

		             //-------
		             NodeList firstNameList = firstObjectElement.getElementsByTagName("name");
		             Element firstNameElement = (Element)firstNameList.item(0);

		             NodeList textFNList = firstNameElement.getChildNodes();
		             String name=((Node)textFNList.item(0)).getNodeValue().trim();
		             if(name.equals(objectName))
		             {   flag=true;
		            	 NodeList lastNameList = firstObjectElement.getElementsByTagName("value");
		                 Element lastNameElement = (Element)lastNameList.item(0);
		                 NodeList textLNList = lastNameElement.getChildNodes();
		                 String identification=((Node)textLNList.item(0)).getNodeValue().trim();
		                 if(identification=="")
		                 {
		                	 Reporter.failureReport("The XML Object does not have a value attribute value for the Object "+objectName,"");
		                 }
		            	 return identification;
		             }
		             else
		             {
		            	 continue;
		             }
		             
		         }
			 }
			 if(!flag)
			 {
				 System.out.println("There was no tag with "+objectName+" value");
			 }
				 
			
			return "";
			}
		catch(Exception e)
		{
			Reporter.failureReport("The XML Object does not have a Object with name "+objectName,"");
			return "";
		}
		
		}
		
	
	}



