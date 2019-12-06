package apim.github.tutorial;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	private CustomerRepository repository;

	public CustomerRepository getRepository() {
		return repository;
	}

	@Resource
	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void addCustomer(Customer c) {
		repository.save(c);
	}

	@Transactional
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@Transactional
	public List<Customer> getSelectedCustomers(int balance) {
		return repository.findSelectedBalances(balance);
	}

}
