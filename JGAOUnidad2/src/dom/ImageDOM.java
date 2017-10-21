package dom;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Image;


public class ImageDOM {
	private String pathFile = "C:\\Users\\gerardo\\eclipse-workspace\\JGAOUnidad2\\src\\data\\images.xml";
	public void add(Image data) {
		
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element images = document.getDocumentElement();
				
				//CREATE player TAG
				
				Element image = document.createElement("image");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				image.appendChild(id);
				// create type tag
				
				Element type = document.createElement("type");
				type.appendChild(document.createTextNode(data.getType()));
				image.appendChild(type);
				
					// create category tag
				
				Element category = document.createElement("category");
				category.appendChild(document.createTextNode(data.getCategory()));
				image.appendChild(category);
				
				//create height tag
				
				Element height = document.createElement("height");
				height.appendChild(document.createTextNode(String.valueOf(data.getHeight())));
				image.appendChild(height);
				
				images.appendChild(image);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("image");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element image = (Element)nodelist.item(i);
				if (image.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					image.getParentNode().removeChild(image);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Image data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("image");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element image = (Element)nodelist.item(i);
				if (image.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					image.getElementsByTagName("type").item(0).setTextContent(data.getType());
					image.getElementsByTagName("category").item(0).setTextContent(data.getCategory());
					image.getElementsByTagName("height").item(0).setTextContent(String.valueOf(data.getHeight()));
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Image findById(String id) {
		Image image = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("image");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					image = new Image();
					image.setId(id);
					image.setType(s.getElementsByTagName("type").item(0).getTextContent());
					image.setCategory(s.getElementsByTagName("category").item(0).getTextContent());
					image.setHeight(Integer.parseInt(s.getElementsByTagName("height").item(0).getTextContent()));
					
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public  List<Image> getImages(){
		
		List<Image> images = new ArrayList<Image>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("image");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Image image = new Image();
			image.setId(s.getElementsByTagName("id").item(0).getTextContent());
			image.setType(s.getElementsByTagName("type").item(0).getTextContent());
			image.setHeight(Integer.parseInt(s.getElementsByTagName("height").item(0).getTextContent()));
			image.setCategory(s.getElementsByTagName("category").item(0).getTextContent());
			
			images.add(image);
			
		}
		return images;
	}
}
