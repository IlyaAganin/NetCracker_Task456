package com.netcracker.soap;

import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WebServiceClient {
	 public static void main(String[] args) throws MalformedURLException{

	        URL url = new URL("http://localhost:8080/wss/persons?wsdl");

	        QName qname = new QName("http://ws.SOAP.company.com/","WebServiceImplService");

	        Service service = Service.create(url,qname);

	        WebServiceInterface webserv = service.getPort(WebServiceInterface.class);

	        System.out.println(webserv.getUserNameById(1));
	        System.out.println(webserv.getCountUsersByAge(25));

	    }

}
