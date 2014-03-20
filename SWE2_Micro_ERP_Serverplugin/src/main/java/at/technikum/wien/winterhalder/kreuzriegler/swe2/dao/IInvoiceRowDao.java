/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;

/**
 * @author Matthias
 * 
 */
public interface IInvoiceRowDao {

	public void create(InvoiceRow r);

	public void update(InvoiceRow r);

	public InvoiceRow read(long id);

	public void delete(long id);

	public List<InvoiceRow> loadRowsByInvoiceId(long id);

}
