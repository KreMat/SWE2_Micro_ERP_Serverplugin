/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;

/**
 * @author Matthias
 *
 */
public class AddressDaoMock implements IAddressDao {

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#create(at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address)
	 */
	@Override
	public void create(Address a) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#update(at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address)
	 */
	@Override
	public void update(Address c) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#read(long)
	 */
	@Override
	public Address read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#loadAddressesByContactId(long)
	 */
	@Override
	public List<Address> loadAddressesByContactId(long contactId) {
		// TODO Auto-generated method stub
		return null;
	}

}
