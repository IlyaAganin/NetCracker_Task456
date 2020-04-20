package com.netcracker.soap;

import javax.xml.ws.Endpoint;

import java.io.IOException;

public class WebServerPublisher {
	
    public static void main(String[] args) throws IOException {
        Endpoint.publish("http://localhost:8080/wss/persons", new WebServiceImpl());

    }

}
