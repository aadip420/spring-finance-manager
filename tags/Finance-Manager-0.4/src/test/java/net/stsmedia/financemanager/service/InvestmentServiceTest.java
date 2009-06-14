package net.stsmedia.financemanager.service;

import static org.junit.Assert.assertEquals;
import net.stsmedia.financemanager.domain.Investment;
import net.stsmedia.financemanager.domain.Loan;
import net.stsmedia.financemanager.domain.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * A simple integration test for {@link InvestmentService}.
 * 
 * @author Stefan Schmidt
 * @since 0.2
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration(locations = { "classpath:FinanceManager-test.xml" })
public class InvestmentServiceTest {

	@Autowired
	private InvestmentService investmentService;

	@Autowired
	private ProductService productService;

	@Autowired
	private PersonService personService;

	private Investment investment;

	@Before
	public void setup() {
		investment = DataSeeder.generateInvestment();

		if (investment.getProduct() instanceof Loan) {
			for (Person person : ((Loan) investment.getProduct()).getLenders()) {
				personService.persist(person);
			}
		}

		productService.persist(investment.getProduct());
	}

	@Test
	@Rollback
	public void testFindAll() {
		investmentService.persist(investment);
		assertEquals(1, investmentService.findAll().size());
	}

	@Test
	@Rollback
	public void testPersist() {
		investmentService.persist(investment);
		assertEquals(1, investmentService.findAll().size());
	}
}
