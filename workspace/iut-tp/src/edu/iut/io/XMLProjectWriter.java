package edu.iut.io;


import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.iut.app.ExamEvent;


//EX 1 Completer la classe

public class XMLProjectWriter {
    
    

    public XMLProjectWriter(){}
    
    public void save(ArrayList<ExamEvent> data, java.io.File xmlfile)   {        
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document= builder.newDocument();
	
	        Element root = document.createElement("agenda.xml");
	        document.appendChild(root);
	
	        for(int i = 0;i<data.size();i++) {
	          Element event = document.createElement("examEvent");
	          
	          event.setAttribute("date", data.get(i).getDate().toString());
	          
	          Element eventRoom = document.createElement("classroom");
	          eventRoom.setAttribute("number", data.get(i).getClassroom().getClassRoomNumber());
	          
	          Element eventStudent=document.createElement("student");
	          eventStudent.setAttribute("firstname", data.get(i).getStudent().getFirstname());
	          eventStudent.setAttribute("lastname", data.get(i).getStudent().getLastname());
	    	  eventStudent.setAttribute("emailname", data.get(i).getStudent().getEmail());
	    	  eventStudent.setAttribute("phonename", data.get(i).getStudent().getPhone());
	          
	          Element eventJury=document.createElement("jury");
	          for(int j=0;j<data.get(i).getJury().size();j++){
	        	  Element eventContenu=document.createElement("jury"+j);
	        	  eventContenu.setAttribute("firstname", data.get(i).getJury().get(j).getFirstname());
	        	  eventContenu.setAttribute("lastname", data.get(i).getJury().get(j).getLastname());
	        	  eventContenu.setAttribute("emailname", data.get(i).getJury().get(j).getEmail());
	        	  eventContenu.setAttribute("phonename", data.get(i).getJury().get(j).getPhone());
	        	  eventJury.appendChild(eventContenu);
	          }
	          
	          Element eventDoc=document.createElement("documents");
	          for(int j=0;j<data.get(i).getDocuments().size();j++){
	        	  Element eventContenu=document.createElement("doc"+j);
	        	  eventContenu.setAttribute("uri", data.get(i).getDocuments().get(j).getDocumentURI());
	        	  eventDoc.appendChild(eventContenu);
	          }
	          
	          event.appendChild(eventRoom);
	          event.appendChild(eventStudent);
	          event.appendChild(eventJury);
	          event.appendChild(eventDoc);
	          root.appendChild(event);
	        }
	        document.appendChild(root);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
	        Transformer transformer;
			try {
				transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(document); 
		        StreamResult output = new StreamResult(xmlfile); 
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
		        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); 
		        try {
					transformer.transform(source, output);
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        
    }
}