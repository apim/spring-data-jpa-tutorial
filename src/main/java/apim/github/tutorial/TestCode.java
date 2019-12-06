package apim.github.tutorial;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		CustomerDAO dao = (CustomerDAO) ctx.getBean("customerDAO");
		dao.addCustomer(new Customer(70, "Alex", 3750));
		dao.addCustomer(new Customer(80, "Luis", 4250));
		List<Customer> list = dao.getAllCustomers();
		for (Customer c : list) {
			System.out.println(c.getId() + ": " + c.getName() + " : " + c.getBalance());
		}
		list = dao.getSelectedCustomers(5000);
		for (Customer c : list) {
			System.out.println(c.getId() + ": " + c.getName() + " : " + c.getBalance());
		}
		ctx.close();
	}

}