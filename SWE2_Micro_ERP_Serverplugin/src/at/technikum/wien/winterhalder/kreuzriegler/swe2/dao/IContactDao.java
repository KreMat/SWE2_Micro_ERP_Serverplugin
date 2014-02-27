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

	public Contact create(Contact c);

	public Contact update(Contact c);

	public Contact read(long id);

	public void delete(long id);

	public List<Contact> loadAllContacts();

}
