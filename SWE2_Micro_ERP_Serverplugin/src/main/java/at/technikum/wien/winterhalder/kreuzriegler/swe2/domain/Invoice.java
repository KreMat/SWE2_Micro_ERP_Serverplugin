/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthias
 * 
 */
public class Invoice extends AbstractEntity {

	// CONTRACT
	public static final String NR = "nr";
	public static final String CREATIONDATE = "creationdate";
	public static final String DUEDATE = "duedate";
	public static final String COMMENT = "comment";
	public static final String INFORMATION = "information";
	public static final String FK_CONTACT_ID = "contact_id";
	public static final String TABLE = "invoice";

	private String nr;

	private long creationdate;

	private long duedate;

	private String comment;

	private String information;

	private long contactId;

	private List<InvoiceRow> rows = new ArrayList<InvoiceRow>();

	/**
	 * @return the nr
	 */
	public String getNr() {
		return nr;
	}

	/**
	 * @param nr
	 *            the nr to set
	 */
	public void setNr(String nr) {
		this.nr = nr;
	}

	/**
	 * @return the creationdate
	 */
	public long getCreationdate() {
		return creationdate;
	}

	/**
	 * @param creationdate
	 *            the creationdate to set
	 */
	public void setCreationdate(long creationdate) {
		this.creationdate = creationdate;
	}

	/**
	 * @return the duedate
	 */
	public long getDuedate() {
		return duedate;
	}

	/**
	 * @param duedate
	 *            the duedate to set
	 */
	public void setDuedate(long duedate) {
		this.duedate = duedate;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the information
	 */
	public String getInformation() {
		return information;
	}

	/**
	 * @param information
	 *            the information to set
	 */
	public void setInformation(String information) {
		this.information = information;
	}

	/**
	 * @return the rows
	 */
	public List<InvoiceRow> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<InvoiceRow> rows) {
		this.rows = rows;
	}

	/**
	 * @return the contactId
	 */
	public long getContactId() {
		return contactId;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public void addRow(InvoiceRow row) {
		rows.add(row);
	}

}
