package edai.tema2.ejercicio1;

public class AddressBook {

	private List<Contact> contactList;

	public AddressBook() {
		this.contactList = new List<Contact>();
	}

	/**
	 * Method to add a contact to the current address book
	 * @param contact Contact to add
	 */
	public void addContact(Contact contact) {
		this.contactList.insert(contact, -1);
	}

	/**
	 * Method to return all contact names (lastname, firstname)
	 * @return List with all the contact names
	 */
	public List<String> getContactNames() {
		Node<Contact> current = this.contactList.getFirst();
		List<String> names = new List<String>();
		String aux;
		while (current != null) {
			aux = current.getData().getLastName() + ", " + current.getData().getFirstName();
			names.insert(aux, -1);
			current = current.getNext();
		}

		return names;
	}

	/**
	 * Method to return an specific contact
	 * @param name name of the desired contact (lastname , firstname)
	 * @return null if not found or the contact object
	 */
	public Contact getContact(String name) {
		Node<Contact> current = this.contactList.getFirst();
		String aux;
		while (current != null) {
			aux = current.getData().getLastName() + ", " + current.getData().getFirstName();
			if (name.equals(aux)) {
				return current.getData();
			}
			current = current.getNext();
		}

		return null;
	}
}
