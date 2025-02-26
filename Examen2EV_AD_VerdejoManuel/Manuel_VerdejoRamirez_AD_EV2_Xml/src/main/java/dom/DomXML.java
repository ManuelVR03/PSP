package dom;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomXML {

	private Document documento;
	
	public DomXML() throws ParserConfigurationException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = docFactory.newDocumentBuilder();
		this.documento = constructor.newDocument();
	}
	
	public DomXML(String fichero) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = docFactory.newDocumentBuilder();
		this.documento = constructor.parse(fichero);
	}

	public Document getDocumento() {
		return documento;
	}

	public void setDocumento(Document documento) {
		this.documento = documento;
	}
	
	// Método escribirArchivo, envía el documento XML a un archivo
	public void escribirArchivo(String nombreFichero) throws TransformerException {
		TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
		Transformer transformador = fabricaTransformador.newTransformer();
		//Añadimos identación
		transformador.setOutputProperty(OutputKeys.INDENT, "yes");
		transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		
		// Archivo donde guardamos el XML
		File archivo = new File(nombreFichero);
		// Fuente de datos, en este caso el documento XML
		DOMSource origen = new DOMSource(documento);
		// Resultado, el cual almacena en el archivo indicado
		StreamResult destino = new StreamResult(archivo);
		// Transforammos de la fuente DOM al resultado, lo que almacena todo en el archivo
		transformador.transform(origen, destino);
	}
	
	// Envía el contenido a la consola
	public void escribirArchivo() throws TransformerException {
		TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
		Transformer transformador = fabricaTransformador.newTransformer();
		//Añadimos identación
		transformador.setOutputProperty(OutputKeys.INDENT, "yes");
		transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		
		DOMSource origen = new DOMSource(documento);
		StreamResult destino = new StreamResult(System.out);
		transformador.transform(origen, destino);
	}
	
	
	//
	public String convertirString() throws TransformerException {
		TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
		Transformer transformador = fabricaTransformador.newTransformer();
		//Añadimos identación
		transformador.setOutputProperty(OutputKeys.INDENT, "yes");
		transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		
		StringWriter writer = new StringWriter();
		DOMSource origen = new DOMSource(documento);
		StreamResult destino = new StreamResult(writer);
		transformador.transform(origen, destino);
		String output = writer.getBuffer().toString();
		
		return output;
	}
	
	
	

}
