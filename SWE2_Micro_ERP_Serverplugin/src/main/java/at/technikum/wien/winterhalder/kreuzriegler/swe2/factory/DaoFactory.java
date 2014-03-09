/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.impl.ContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.ContactDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.InvoiceDaoMock;

/**
 * @author Matthias
 * 
 */
public class DaoFactory {

	private static final boolean MOCK = false;

	public static IInvoiceDao createInvoiceDao() {
		if (MOCK) {
			return new InvoiceDaoMock();
		}
		// TODO return Impl
		return null;
	}

	public static IContactDao createContactDao() {
		if (MOCK) {
			return new ContactDaoMock();
		}
		return new ContactDao();
	}

}
