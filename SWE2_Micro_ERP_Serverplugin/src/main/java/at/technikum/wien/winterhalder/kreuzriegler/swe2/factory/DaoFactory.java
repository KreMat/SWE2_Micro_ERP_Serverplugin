/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IContactDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.ContactDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.InvoiceDaoMock;

/**
 * @author Matthias
 * 
 */
public class DaoFactory {

	private static final boolean MOCK = true;

	public IInvoiceDao createInvoiceDao() {
		if (MOCK) {
			return new InvoiceDaoMock();
		}
		// TODO return Impl
		return null;
	}

	public IContactDao createContactDao() {
		if (MOCK) {
			return new ContactDaoMock();
		}
		// TODO return Impl
		return null;
	}

}
