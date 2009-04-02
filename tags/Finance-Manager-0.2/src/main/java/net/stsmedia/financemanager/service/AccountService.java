package net.stsmedia.financemanager.service;

import java.util.List;

import net.stsmedia.financemanager.dao.GenericDAOWithJPA;
import net.stsmedia.financemanager.domain.Account;

import org.springframework.transaction.annotation.Transactional;

/**
 * This is a service layer interface (actually more of a simple facade). Note
 * that most of these methods are implemented by {@link GenericDAOWithJPA}.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
public interface AccountService {

	List<Account> findAll();

	@Transactional
	void persist(Account entity);

	@Transactional
	void merge(Account entity);

	@Transactional
	void remove(Account entity);

	Account find(Long id);
}
