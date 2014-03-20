/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.domain;

/**
 * @author Matthias
 * 
 */
public class InvoiceRow extends AbstractEntity {

	// CONTRACT
	public static final String NAME = "rowname";
	public static final String AMOUNT = "amount";
	public static final String PRICE = "price";
	public static final String UST = "ust";
	public static final String FK_INVOICE_ID = "invoice_id";
	public static final String TABLE = "invoicerow";

	private String name;

	private Double amount;

	private Double price;

	private Double ust;

	private long invoiceId;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the ust
	 */
	public Double getUst() {
		return ust;
	}

	/**
	 * @param ust
	 *            the ust to set
	 */
	public void setUst(double ust) {
		this.ust = ust;
	}

	/**
	 * @return the invoiceId
	 */
	public long getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId
	 *            the invoiceId to set
	 */
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

}
