package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.TestHelper;

public class AddressDaoTest {

	private IAddressDao addressDao;
	private TestHelper helper;

	@Before
	public void setUp() {
		addressDao = new AddressDao();
		helper = new TestHelper();
	}

	@Test
	public void testCreateAddress() {
		Address a = helper.createDefaultAddress();
		addressDao.create(a);

		Assert.assertTrue(a.getId() != 0);
	}

	@Test
	public void testUpdateAddress() {
		Address a = helper.createDefaultAddress();
		addressDao.create(a);

		Assert.assertTrue(a.getId() != 0);

		String city = "testCity";
		a.setCity(city);

		addressDao.update(a);

		Assert.assertEquals(city, a.getCity());
	}

	@Test
	public void testReadAddress() {
		Address a = helper.createDefaultAddress();
		addressDao.create(a);

		Assert.assertTrue(a.getId() != 0);

		Address readAddress = addressDao.read(a.getId());
		Assert.assertEquals(a.getId(), readAddress.getId());
		Assert.assertEquals(a.getCity(), readAddress.getCity());
		Assert.assertEquals(a.getStreet(), readAddress.getStreet());
		Assert.assertEquals(a.getZip(), readAddress.getZip());
		Assert.assertEquals(a.getType(), readAddress.getType());
		Assert.assertEquals(a.getContactId(), readAddress.getContactId());
	}

	@Test
	public void testReadAddressesByContactId() {
		Address a = helper.createDefaultAddress();
		addressDao.create(a);

		Assert.assertTrue(a.getId() != 0);

		List<Address> all = addressDao.loadAddressesByContactId(1);
		Assert.assertFalse(all.isEmpty());
	}

	@Test
	public void testDeleteAddress() {
		Address a = helper.createDefaultAddress();
		addressDao.create(a);

		Assert.assertTrue(a.getId() != 0);

		addressDao.delete(a.getId());

		Address readA = addressDao.read(a.getId());

		Assert.assertNull(readA);
	}
}
