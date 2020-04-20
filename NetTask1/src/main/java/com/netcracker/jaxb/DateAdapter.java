package com.netcracker.jaxb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class DateAdapter extends XmlAdapter<String, LocalDate>{
	
	private static Logger LOG = LoggerFactory.getLogger(DateAdapter.class);
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }
    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }

}
