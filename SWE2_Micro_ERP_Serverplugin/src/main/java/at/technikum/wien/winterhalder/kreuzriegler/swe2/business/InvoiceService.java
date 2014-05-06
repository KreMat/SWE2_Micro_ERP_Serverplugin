/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.factory.DaoFactory;

/**
 * @author Matthias
 * 
 */
public class InvoiceService {

	private IInvoiceDao invoiceDao;
	private IInvoiceRowDao invoiceRowDao;

	public InvoiceService() {
		invoiceDao = DaoFactory.createInvoiceDao();
		invoiceRowDao = DaoFactory.createInvoiceRowDao();
	}

	public void create(Invoice i) {
		invoiceDao.create(i);
		for (InvoiceRow row : i.getRows()) {
			invoiceRowDao.create(row);
		}
	}

	public void update(Invoice i) {
		invoiceDao.update(i);
		for (InvoiceRow row : i.getRows()) {
			if (row.getId() != 0) {
				invoiceRowDao.update(row);
			} else {
				invoiceRowDao.create(row);
			}
		}
	}

	public void createOrUpdate(Invoice invoice) {
		if (invoice.getId() != 0) {
			update(invoice);
		} else {
			create(invoice);
		}
	}

	public Invoice read(long id) {
		Invoice i = invoiceDao.read(id);
		i.setRows(invoiceRowDao.loadRowsByInvoiceId(id));
		return i;
	}

	public void delete(long id) {
		for (InvoiceRow row : invoiceDao.read(id).getRows()) {
			invoiceRowDao.delete(row.getId());
		}
		invoiceDao.delete(id);
	}

	public List<Invoice> loadInvoicesByContactId(long contactId) {
		List<Invoice> invoices = invoiceDao.loadInvoicesByContactId(contactId);
		for (Invoice i : invoices) {
			i.setRows(invoiceRowDao.loadRowsByInvoiceId(i.getId()));
		}
		return invoices;
	}

}
