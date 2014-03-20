/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;

/**
 * @author Matthias
 *
 */
public class InvoiceRowMock implements IInvoiceRowDao {

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#create(at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow)
	 */
	@Override
	public void create(InvoiceRow r) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#update(at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow)
	 */
	@Override
	public void update(InvoiceRow r) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#read(long)
	 */
	@Override
	public InvoiceRow read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.IInvoiceRowDao#loadRowsByInvoiceId(long)
	 */
	@Override
	public List<InvoiceRow> loadRowsByInvoiceId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
