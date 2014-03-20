package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.TestHelper;

public class InvoiceRowDaoTest {

	private IInvoiceRowDao invoiceRowDao;
	private TestHelper helper;

	@Before
	public void setUp() {
		invoiceRowDao = new InvoiceRowDao();
		helper = new TestHelper();

		ContactDao contactDao = new ContactDao();
		contactDao.create(helper.createDefaultCompany());
		InvoiceDao invoiceDao = new InvoiceDao();
		invoiceDao.create(helper.createDefaultInvoice());
	}

	@Test
	public void testCreateInvoiceRow() {
		InvoiceRow r = helper.createDefaultInvoiceRow();
		invoiceRowDao.create(r);

		Assert.assertTrue(r.getId() != 0);
	}

	@Test
	public void testUpdateInvoiceRow() {
		InvoiceRow r = helper.createDefaultInvoiceRow();
		invoiceRowDao.create(r);

		Assert.assertTrue(r.getId() != 0);

		String name = "newName";
		r.setName(name);

		invoiceRowDao.update(r);

		Assert.assertEquals(name, r.getName());
	}

	@Test
	public void testReadInvoiceRow() {
		InvoiceRow r = helper.createDefaultInvoiceRow();
		invoiceRowDao.create(r);

		Assert.assertTrue(r.getId() != 0);

		InvoiceRow readInvoiceRow = invoiceRowDao.read(r.getId());
		Assert.assertEquals(r.getId(), readInvoiceRow.getId());
		Assert.assertEquals(r.getName(), readInvoiceRow.getName());
		Assert.assertEquals(r.getAmount(), readInvoiceRow.getAmount());
		Assert.assertEquals(r.getPrice(), readInvoiceRow.getPrice());
		Assert.assertEquals(r.getUst(), readInvoiceRow.getUst());
		Assert.assertEquals(r.getInvoiceId(), readInvoiceRow.getInvoiceId());
	}

	@Test
	public void testReadInvoiceRowsByInvoiceId() {
		InvoiceRow r = helper.createDefaultInvoiceRow();
		invoiceRowDao.create(r);

		Assert.assertTrue(r.getId() != 0);

		List<InvoiceRow> all = invoiceRowDao.loadRowsByInvoiceId(1);
		Assert.assertFalse(all.isEmpty());
	}

	@Test
	public void testDeleteInvoice() {
		InvoiceRow r = helper.createDefaultInvoiceRow();
		invoiceRowDao.create(r);

		Assert.assertTrue(r.getId() != 0);

		invoiceRowDao.delete(r.getId());

		InvoiceRow readI = invoiceRowDao.read(r.getId());

		Assert.assertNull(readI);
	}
}
