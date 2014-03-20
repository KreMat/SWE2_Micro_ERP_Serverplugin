/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dao;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;

/**
 * @author Matthias
 * 
 */
public interface IInvoiceDao {

	public void create(Invoice i);

	public void update(Invoice i);

	public Invoice read(long id);

	public void delete(long id);

	public List<Invoice> loadInvoicesByContactId(long contactId);

}
