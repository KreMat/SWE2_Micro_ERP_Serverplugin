/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;

/**
 * @author Matthias
 * 
 */
public class AddressDaoMock implements IAddressDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address)
	 */
	@Override
	public void create(Address a) {
		a.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address)
	 */
	@Override
	public void update(Address a) {
		a.setId(1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#read
	 * (long)
	 */
	@Override
	public Address read(long id) {
		return new Address();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao#
	 * loadAddressesByContactId(long)
	 */
	@Override
	public List<Address> loadAddressesByContactId(long contactId) {
		List<Address> list = new ArrayList<Address>();
		list.add(new Address());
		return list;
	}

}
