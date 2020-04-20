package com.netcracker.task456;
import com.netcracker.repository.CsvLoader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.repository.IRepository;

public class Stream <T extends IPerson>{

    private List<T> repList;

    public Stream(IRepository rep) throws IOException {
        CsvLoader.parseRepository(rep, "src/main/resources/persons.csv");
        this.repList = rep.toList();

    }
    public Map<? extends IDivision, Long> firstQuery (){
     java.util.stream.Stream<T> personStream = repList.stream();
     return personStream.collect(Collectors.groupingBy(
             IPerson::getDivision,Collectors.summingLong(
                     per ->per.getSalary().intValueExact())));
    }
    
    public List<T> secondQuery (){
    	java.util.stream.Stream<T> personStream = repList.stream();
        return  personStream.filter(per->per.getFirstName().substring(0,1).equals("A")&&per.getSalary().intValueExact()>3000 && per.getAge()>30).collect(Collectors.toList());
    }


    public List<T> thirdQuery (){
    	java.util.stream.Stream<T> personStream = repList.stream();
        return  personStream.filter(per->per.getFirstName().substring(0,2).equals("aa")).collect(Collectors.toList());
    }







}