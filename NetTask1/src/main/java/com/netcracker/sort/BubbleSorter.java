package com.netcracker.sort;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import ru.vsu.lab.repository.IRepository;

/**
 * Bubble sort
 */
@XmlRootElement
public class BubbleSorter<T> implements ISorted<T> {
	
	
	public final static Logger LOG = LoggerFactory.getLogger(BubbleSorter.class);
	 
    /**
     * method which sort containers 
     * @param repository 
     * @param comparator 
     */
    @Override
    public void sort(final IRepository<T> repository,
                     final Comparator<T> comparator) {
    	
    	LOG.debug("[BubleSorter: {} {}]", repository, comparator);
        int personLenght = 0;
        for (Object iPerson : repository.toList()) {
            if (iPerson != null) {
                personLenght++;
            }
        }
        for (int i = personLenght - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((comparator.compare(repository.get(j),
                        repository.get(j + 1))) > 0) {
                    T tempPerson = repository.get(j);
                    repository.set(j, repository.get(j + 1));
                    repository.set(j + 1, tempPerson);
                }

            }
        }
    }
}
