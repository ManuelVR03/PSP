package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import dom.DomXML;

public class Test_MostrarXml {

	public static void main(String[] args) {
			DomXML documento;
			try {
				System.out.println("***** DATOS NOVIEMBRE *****");
				documento = new DomXML("./Fuentes/datos_noviembre.xml");
				documento.escribirArchivo();
				System.out.println("\n***** DATOS DICIEMBRE *****");
				documento = new DomXML("./Fuentes/datos_diciembre.xml");
				documento.escribirArchivo();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
