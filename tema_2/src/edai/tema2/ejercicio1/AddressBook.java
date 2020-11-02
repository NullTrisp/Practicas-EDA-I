package edai.tema2.ejercicio1;

public class AddressBook {

	private List<Contact> contactList;

	public AddressBook() {
		this.contactList = new List<Contact>();
	}

	public void addContact(Contact contact) {
		this.contactList.insert(contact, -1);
	}

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
	 * Method to return an specific contact (lastname , firstname)
	 * @param name name of the desired contact
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
