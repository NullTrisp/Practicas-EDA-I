package edai.tema2.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edai.tema2.List;
import edai.tema2.Node;

class AddressBookTest {
	private AddressBook addressBook;

	@BeforeEach
	void setUp() {
		addressBook = new AddressBook();
	}

	@Test
	void testAddressBook() {
		final List<String> names = addressBook.getContactNames();
		final Contact contact = addressBook.getContact("");
		assertEquals(0, names.size());
		assertNull(contact);
	}

	@Test
	void testGetContactNames() {
		fillContacts(addressBook);
		final List<String> names = addressBook.getContactNames();
		final List<String> expected = new List<String>();
		expected.insert("Appleseed, John", -1);
		expected.insert("Doe, John", -1);
		expected.insert("Doe, Jane", -1);
		assertEquals(expected.size(), names.size());
		Node<String> currentName = names.getFirst();
		Node<String> currentExpected = expected.getFirst();
		while (currentName != null && currentExpected != null) {
			assertEquals(currentExpected.getData(), currentName.getData());
			currentName = currentName.getNext();
			currentExpected = currentExpected.getNext();
		}
	}

	@Test
	void testGetContact() {
		fillContacts(addressBook);
		assertNotNull(addressBook.getContact("Appleseed, John"));
	}

	private static void fillContacts(AddressBook addressBook) {
		final Contact johnAppleseed = new Contact();
		johnAppleseed.setFirstName("John");
		johnAppleseed.setLastName("Appleseed");
		johnAppleseed.setCompany("Uneatlántico");
		johnAppleseed.setAddress("Calle Isabel Torres 21");
		johnAppleseed.setEmail("john.appleseed@uneatlantico.es");
		addressBook.addContact(johnAppleseed);
		final Contact johnDoe = new Contact();
		johnDoe.setFirstName("John");
		johnDoe.setLastName("Doe");
		johnDoe.setCompany("Ingram Micro");
		johnDoe.setAddress("Plaza Manuel Llano");
		johnDoe.setEmail("john.doe@ingrammicro.com");
		addressBook.addContact(johnDoe);
		final Contact janeDoe = new Contact();
		janeDoe.setFirstName("Jane");
		janeDoe.setLastName("Doe");
		janeDoe.setCompany("Oracle");
		janeDoe.setAddress("Calle Albert Einstein 1");
		janeDoe.setEmail("jane.doe@oracle.com");
		addressBook.addContact(janeDoe);
	}
}