package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel p = new PersonDomainModel();
	private static LocalDate birthday = LocalDate.of(1998, 06, 11);


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new PersonDomainModel();
		p.setFirstName("Owen");
		p.setLastName("Martin");
		p.setStreet("Madison");
		p.setPostalCode(07023);
		p.setCity("Fanwood");
		p.setBirthday(birthday);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		p = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addtest() {
		PersonDomainModel p = new PersonDomainModel();
		PersonDAL.addPerson(p);
	}
	@Test
	public void gettest() {
		PersonDomainModel p = new PersonDomainModel();
		PersonDAL.addPerson(p);
		
		String FirstName = p.getFirstName();
		assertEquals("Owen", FirstName);
	}
	@Test
	public void deletetest() {
		PersonDomainModel p = new PersonDomainModel();
		PersonDAL.addPerson(p);
		
		PersonDAL.deletePerson(p.getPersonID());
	}
	@Test
	public void updatetest() {
		PersonDomainModel p = new PersonDomainModel();
		PersonDAL.addPerson(p);
		
		p.setFirstName( "Oscar");
		PersonDAL.updatePerson(p);
		assertTrue(PersonDAL.getPerson(p.getPersonID()).getFirstName() == "Oscar");
	}
}
