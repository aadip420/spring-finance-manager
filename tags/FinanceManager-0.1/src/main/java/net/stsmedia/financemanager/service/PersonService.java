package net.stsmedia.financemanager.service;

import java.util.List;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Person;
import net.stsmedia.financemanager.service.impl.PersonServiceImpl;

import org.springframework.transaction.annotation.Transactional;

/**
 * This is a service layer interface (actually more of a simple 
 * facade). Note that most of these methods are implemented by
 * {@link GenericDAOWithJPA}. 
 * 
 * The findByLastName method has been added to demonstrate how 
 * a custom method is implemented in {@link PersonServiceImpl}.
 * 
 * @author Stefan Schmidt
 *
 */
public interface PersonService{
	
	List<Person> findAll();
	
	List<Person> findByLastName(String lastName);
	
	@Transactional
	void persist(Person entity);
	
	@Transactional
	void merge(Person entity);
	
	@Transactional
	void remove(Person entity);

	Person find(Long id);
}
