package com.netcracker.sort;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vsu.lab.repository.IRepository;

/**
 * Insert sort
 */
@XmlRootElement
public class InsertSorter<T> implements ISorted<T> {
	
	public final static Logger LOG = LoggerFactory.getLogger(InsertSorter.class);
    /**
     * method which sort containers
     * @param repository
     * @param comparator
     */	
    @Override
    public void sort(final IRepository<T> repository,
                     final Comparator<T> comparator) {
    	
    	LOG.debug("[InsertSorter: {} {}]", repository, comparator);
        int personLength = 0;
        for (T iPerson : repository.toList()) {
            if (iPerson != null) {
                ++personLength;
            }
        }
        for (int i = 1; i < personLength; i++) {
            T current = repository.get(i);
            int j = i - 1;
            while(j >= 0 && comparator.compare(repository.get(j), current) > 0) {
                repository.set(j + 1, repository.get(j));
                j--;
            }
            repository.set(j + 1, current);
        }
    }
}
