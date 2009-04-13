package net.stsmedia.financemanager.service;

import java.util.List;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Product;

import org.springframework.transaction.annotation.Transactional;

/**
 * This is a service layer interface (actually more of a simple facade). Note
 * that most of these methods are implemented by {@link GenericDAOWithJPA}.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
public interface ProductService {

	List<Product> findAll();

	@Transactional
	void persist(Product entity);

	@Transactional
	void merge(Product entity);

	@Transactional
	void remove(Product entity);

	Product find(Long id);
}
