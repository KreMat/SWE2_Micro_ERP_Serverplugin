/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.domain;

/**
 * @author Matthias
 * 
 */
public class InvoiceRow extends AbstractEntity {

	private String name;

	private double amount;

	private double price;

	private double ust;

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
	public double getAmount() {
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
	public double getPrice() {
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
	public double getUst() {
		return ust;
	}

	/**
	 * @param ust
	 *            the ust to set
	 */
	public void setUst(double ust) {
		this.ust = ust;
	}

}
