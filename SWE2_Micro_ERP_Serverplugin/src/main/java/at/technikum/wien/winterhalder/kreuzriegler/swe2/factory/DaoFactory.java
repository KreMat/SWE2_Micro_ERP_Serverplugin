/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IAddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.AddressDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.ContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.AddressDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.ContactDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.InvoiceDaoMock;

/**
 * @author Matthias
 * 
 */
public class DaoFactory {

	private static final boolean MOCK_INVOICE = false;
	private static final boolean MOCK_ADDRESS = false;
	private static final boolean MOCK_CONTACT = false;

	public static IInvoiceDao createInvoiceDao() {
		if (MOCK_INVOICE) {
			return new InvoiceDaoMock();
		}
		// TODO return Impl
		return null;
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

}
