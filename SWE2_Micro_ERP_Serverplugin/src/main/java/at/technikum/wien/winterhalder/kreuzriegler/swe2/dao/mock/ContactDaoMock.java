/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;

/**
 * @author Matthias
 * 
 */
public class ContactDaoMock implements IContactDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact)
	 */
	@Override
	public void create(Contact c) {
		c.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact)
	 */
	@Override
	public void update(Contact c) {
		c.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#read
	 * (long)
	 */
	@Override
	public Contact read(long id) {
		return new Contact();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao#
	 * loadAllContacts()
	 */
	@Override
	public List<Contact> loadAllContacts() {
		List<Contact> list = new ArrayList<Contact>();
		list.add(new Contact());
		list.add(new Contact());
		return list;
	}

	@Override
	public List<Contact> getContactsBySearchstring(String searchString) {
		List<Contact> list = new ArrayList<Contact>();
		list.add(new Contact());
		list.add(new Contact());
		return list;
	}

}
