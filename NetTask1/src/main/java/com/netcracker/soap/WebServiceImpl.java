package com.netcracker.soap;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import javax.jws.WebService;

import com.netcracker.repository.CsvLoader;
import com.netcracker.repository.LabFactory;
import com.netcracker.repository.Person;

import java.io.IOException;

@WebService(endpointInterface = "com.netcracker.SOAP.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface {

    public IRepository<IPerson> repository;

    public WebServiceImpl() throws IOException {
        LabFactory factory = new LabFactory();
        this.repository = factory.createRepository(IPerson.class);
        CsvLoader.parseRepository(repository, "src/main/resources/persons.csv");

    }

    @Override
    public String getUserNameById(int id){
        Person person =(Person) repository.get(id);
        return person.getFirstName();

    }
    @Override
    public long getCountUsersByAge(Integer age){
    	repository.toList();
        return repository.toList().stream().filter(x->x.getAge()>25).count();
    }
}
