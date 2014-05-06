/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.AddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.ContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.InvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.InvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.AddressDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.ContactDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.InvoiceDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.InvoiceRowDaoMock;

/**
 * @author Matthias
 * 
 */
public class DaoFactory {

	private static final boolean MOCK_INVOICE = false;
	private static final boolean MOCK_INVOICE_ROW = false;
	private static final boolean MOCK_ADDRESS = false;
	private static final boolean MOCK_CONTACT = false;

	public static IInvoiceDao createInvoiceDao() {
		if (MOCK_INVOICE) {
			return new InvoiceDaoMock();
		}
		return new InvoiceDao();
	}

	public static IContactDao createContactDao() {
		if (MOCK_CONTACT) {
			return new ContactDaoMock();
		}
		return new ContactDao();
	}

	public static IAddressDao createAddressDao() {
		if (MOCK_ADDRESS) {
			return new AddressDaoMock();
		}
		return new AddressDao();
	}

	public static IInvoiceRowDao createInvoiceRowDao() {
		if (MOCK_INVOICE_ROW) {
			return new InvoiceRowDaoMock();
		}
		return new InvoiceRowDao();
	}

}
