package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.TestHelper;

public class InvoiceDaoTest {

	private IInvoiceDao invoiceDao;
	private TestHelper helper;

	@Before
	public void setUp() {
		invoiceDao = new InvoiceDao();
		helper = new TestHelper();

		ContactDao contactDao = new ContactDao();
		contactDao.create(helper.createDefaultCompany());
	}

	@Test
	public void testCreateInvoice() {
		Invoice i = helper.createDefaultInvoice();
		invoiceDao.create(i);

		Assert.assertTrue(i.getId() != 0);
	}

	@Test
	public void testUpdateInvoice() {
		Invoice i = helper.createDefaultInvoice();
		invoiceDao.create(i);

		Assert.assertTrue(i.getId() != 0);

		String nr = "newNR";
		i.setNr(nr);

		invoiceDao.update(i);

		Assert.assertEquals(nr, i.getNr());
	}

	@Test
	public void testReadInvoice() {
		Invoice i = helper.createDefaultInvoice();
		invoiceDao.create(i);

		Assert.assertTrue(i.getId() != 0);

		Invoice readInvoice = invoiceDao.read(i.getId());
		Assert.assertEquals(i.getId(), readInvoice.getId());
		Assert.assertEquals(i.getNr(), readInvoice.getNr());
		Assert.assertEquals(i.getCreationdate(), readInvoice.getCreationdate());
		Assert.assertEquals(i.getDuedate(), readInvoice.getDuedate());
		Assert.assertEquals(i.getComment(), readInvoice.getComment());
		Assert.assertEquals(i.getInformation(), readInvoice.getInformation());
		Assert.assertEquals(i.getContactId(), readInvoice.getContactId());
	}

	@Test
	public void testReadInvoicesByContactId() {
		Invoice i = helper.createDefaultInvoice();
		invoiceDao.create(i);

		Assert.assertTrue(i.getId() != 0);

		List<Invoice> all = invoiceDao.loadInvoicesByContactId(1);
		Assert.assertFalse(all.isEmpty());
	}

	@Test
	public void testDeleteInvoice() {
		Invoice i = helper.createDefaultInvoice();
		invoiceDao.create(i);

		Assert.assertTrue(i.getId() != 0);

		invoiceDao.delete(i.getId());

		Invoice readI = invoiceDao.read(i.getId());

		Assert.assertNull(readI);
	}
}
