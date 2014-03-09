/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.factory.DaoFactory;

/**
 * @author Matthias
 * 
 */
public class ContactService {

	private IContactDao contactDao;

	public ContactService() {
		contactDao = DaoFactory.createContactDao();
	}

	public void create(Contact c) {
		contactDao.create(c);
	}

	public void update(Contact c) {
		contactDao.update(c);
	}

	public Contact read(long id) {
		return contactDao.read(id);
	}

	public void delete(long id) {
		contactDao.delete(id);
	}

	public List<Contact> loadAllContacts() {
		return contactDao.loadAllContacts();
	}

}
