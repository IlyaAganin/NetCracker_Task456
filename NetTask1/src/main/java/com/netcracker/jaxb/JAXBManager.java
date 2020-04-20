package com.netcracker.jaxb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netcracker.repository.CsvLoader;
import com.netcracker.repository.Division;
import com.netcracker.repository.LabFactory;
import com.netcracker.repository.Person;
import com.netcracker.repository.Repository;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class JAXBManager {
	
	 private static Logger LOG = LoggerFactory.getLogger(JAXBManager.class);

	    public IPersonRepository read(){
	        return null;
	    }

	    public void writeToXml(){
	        LOG.debug("[ write: ]");
	        try {
	            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, Division.class, Repository.class);
	            File file = new File("./file.xml");
	            LabFactory factory = new LabFactory();
	            IRepository<IPerson> base = factory.createRepository(IPerson.class);
	            CsvLoader.parseRepository(base, "src/main/resources/persons.csv");
	            Marshaller marshaller = jaxbContext.createMarshaller();
	            marshaller.marshal(base, file);
	        } catch (JAXBException | IOException e) {
	            LOG.error("[JAXBException| IOException: {}]", e);
	            e.printStackTrace();
	        }
	    }

}
