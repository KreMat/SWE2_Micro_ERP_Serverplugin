package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.TestHelper;

public class ContactDaoTest {

	private IContactDao contactDao;
	private TestHelper helper;

	@Before
	public void setUp() {
		contactDao = new ContactDao();
		helper = new TestHelper();
	}

	@Test
	public void testCreateContact() {
		Contact c = helper.createDefaultCompany();
		contactDao.create(c);

		Assert.assertTrue(c.getId() != 0);
	}

	@Test
	public void testUpdateContact() {
		Contact c = helper.createDefaultCompany();
		contactDao.create(c);

		Assert.assertTrue(c.getId() != 0);

		String uid = "testUID";
		c.setUid(uid);

		contactDao.update(c);

		Assert.assertEquals(uid, c.getUid());
	}

	@Test
	public void testReadContact() {
		Contact c = helper.createDefaultCompany();
		contactDao.create(c);

		Assert.assertTrue(c.getId() != 0);

		Contact readContact = contactDao.read(c.getId());
		Assert.assertEquals(c.getId(), readContact.getId());
		Assert.assertEquals(c.getCompanyname(), readContact.getCompanyname());
		Assert.assertEquals(c.getUid(), readContact.getUid());
		Assert.assertEquals(c.getBirthday(), readContact.getBirthday());
	}

	@Test
	public void testReadAllContact() {
		Contact c = helper.createDefaultCompany();
		contactDao.create(c);

		Assert.assertTrue(c.getId() != 0);

		List<Contact> all = contactDao.loadAllContacts();
		Assert.assertFalse(all.isEmpty());
	}

	@Test
	public void testDeleteContact() {
		Contact c = helper.createDefaultCompany();
		contactDao.create(c);

		Assert.assertTrue(c.getId() != 0);

		contactDao.delete(c.getId());

		Contact readC = contactDao.read(c.getId());

		Assert.assertNull(readC);
	}
}
