/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business;

import java.util.List;
import java.util.Map.Entry;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.enums.AddressType;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.factory.DaoFactory;

/**
 * @author Matthias
 * 
 */
public class ContactService {

	private IContactDao contactDao;

	private IAddressDao addressDao;

	public ContactService() {
		contactDao = DaoFactory.createContactDao();
		addressDao = DaoFactory.createAddressDao();
	}

	public void create(Contact c) {
		contactDao.create(c);
		for (Entry<AddressType, Address> a : c.getAddresses().entrySet()) {
			addressDao.create(a.getValue());
		}
	}

	public void update(Contact c) {
		contactDao.update(c);
		for (Entry<AddressType, Address> aEntry : c.getAddresses().entrySet()) {
			Address a = aEntry.getValue();
			if (a.getId() != 0) {
				addressDao.update(a);
			} else {
				addressDao.create(a);
			}
		}
	}

	public void createOrUpdate(Contact c) {
		if (c.getId() != 0) {
			update(c);
		} else {
			create(c);
		}
	}

	public Contact read(long id) {
		Contact c = contactDao.read(id);
		c.setAddresses(addressDao.loadAddressesByContactId(id));
		return c;
	}

	public void delete(long id) {
		for (Entry<AddressType, Address> a : read(id).getAddresses().entrySet()) {
			addressDao.delete(a.getValue().getId());
		}
		contactDao.delete(id);
	}

	public List<Contact> loadAllContacts() {
		return contactDao.loadAllContacts();
	}

	public List<Contact> getContactsBySearchstring(String searchString) {
		List<Contact> contacts = contactDao
				.getContactsBySearchstring(searchString);
		return getAddresses(contacts);
	}

	public List<Contact> getCompaniesByName(String name) {
		List<Contact> contacts = contactDao.getCompaniesByName(name);
		return getAddresses(contacts);
	}

	public List<Contact> getContactsByName(String name) {
		List<Contact> contacts = contactDao.getContactsByName(name);
		return getAddresses(contacts);
	}

	private List<Contact> getAddresses(List<Contact> contacts) {
		for (Contact c : contacts) {
			c.setAddresses(addressDao.loadAddressesByContactId(c.getId()));
		}
		return contacts;
	}

}
