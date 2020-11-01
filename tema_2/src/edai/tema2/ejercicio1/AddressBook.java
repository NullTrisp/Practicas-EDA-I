package edai.tema2.ejercicio1;

public class AddressBook {

	private List<Contact> contactList;

	public AddressBook() {
		this.contactList = new List<Contact>();
	}

	public void addContact(Contact contact) {
		this.contactList.insert(contact, this.contactList.size());
	}

	public List<String> getContactNames() {
		List<String> contactNames = new List<String>();
		/*
		 * Node<Contact> contacts = this.contactList.getFirst();
		 * contactNames.insert(contacts.getData().getFirstName(), 0); for (int i = 0; i
		 * < this.contactList.size(); i++) {
		 * contactNames.insert(contacts.getNext().getData().getFirstName(), i + 1); }
		 */
		return contactNames;
	}

	public Contact getContact(String name) {
		Node<Contact> namee = this.contactList.getFirst();
		for (int i = 0; i < this.contactList.size(); i++) {
			namee.getNext().getData().getFirstName();
		}
		return null;
	}
}
