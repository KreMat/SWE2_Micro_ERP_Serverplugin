/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;

/**
 * @author Matthias
 * 
 */
public interface IContactDao {

	public void create(Contact c);

	public void update(Contact c);

	public Contact read(long id);

	public void delete(long id);

	public List<Contact> loadAllContacts();

	public List<Contact> getContactsBySearchstring(String searchString);

	public List<Contact> getCompaniesByName(String name);

	public List<Contact> getContactsByName(String name);

}
