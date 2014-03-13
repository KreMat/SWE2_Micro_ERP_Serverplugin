/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;

/**
 * @author Matthias
 * 
 */
public interface IAddressDao {

	public void create(Address a);

	public void update(Address c);

	public Address read(long id);

	public void delete(long id);

	public List<Address> loadAddressesByContactId(long contactId);

}
