/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;

/**
 * @author Matthias
 * 
 */
public class InvoiceRowDaoMock implements IInvoiceRowDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#create
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow)
	 */
	@Override
	public void create(InvoiceRow r) {
		r.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#update
	 * (at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow)
	 */
	@Override
	public void update(InvoiceRow r) {
		r.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#read
	 * (long)
	 */
	@Override
	public InvoiceRow read(long id) {
		return new InvoiceRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#delete
	 * (long)
	 */
	@Override
	public void delete(long id) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#
	 * loadRowsByInvoiceId(long)
	 */
	@Override
	public List<InvoiceRow> loadRowsByInvoiceId(long id) {
		List<InvoiceRow> list = new ArrayList<InvoiceRow>();
		list.add(new InvoiceRow());
		list.add(new InvoiceRow());
		return list;
	}

}
