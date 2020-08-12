package com.naren.java2xml;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBExample {
	public static void main(String[] args) {

	  Customer customer = new Customer();
	  customer.setId(100);
	  customer.setName("mkyong");
	  customer.setAge(29);
	  Staff staff = createStaff();

	  try {

		File file = new File("//Users//naren//Documents//Narendra//Work//Java8//json//file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Staff.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(staff, file);
		jaxbMarshaller.marshal(staff, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }

	}

	private static Staff createStaff() {

		Staff staff = new Staff();

		staff.setName("mkyong");
		staff.setAge(38);
		staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
		Map<String, BigDecimal> salary = new HashMap() {{
			put("2010", new BigDecimal(10000));
			put("2012", new BigDecimal(12000));
			put("2018", new BigDecimal(14000));
		}};
		staff.setSalary(salary);
		staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

		return staff;

	}
}