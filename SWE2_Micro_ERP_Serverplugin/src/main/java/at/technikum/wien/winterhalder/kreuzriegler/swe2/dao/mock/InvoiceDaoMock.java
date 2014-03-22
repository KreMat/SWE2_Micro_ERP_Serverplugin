/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;

/**
 * @author Matthias
 * 
 */
public class InvoiceDaoMock implements IInvoiceDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice)
	 */
	@Override
	public void create(Invoice i) {
		i.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice)
	 */
	@Override
	public void update(Invoice i) {
		i.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#read
	 * (long)
	 */
	@Override
	public Invoice read(long id) {
		return new Invoice();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceDao#
	 * loadAllInvoices()
	 */
	@Override
	public List<Invoice> loadInvoicesByContactId(long contactId) {
		List<Invoice> list = new ArrayList<Invoice>();
		list.add(new Invoice());
		list.add(new Invoice());
		return list;
	}

}
