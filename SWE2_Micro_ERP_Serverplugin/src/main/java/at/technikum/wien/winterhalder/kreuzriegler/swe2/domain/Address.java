/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.domain;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.enums.AddressType;

/**
 * @author Matthias
 * 
 */
public class Address extends AbstractEntity {

	// CONTRACT
	public static final String TYPE = "type";
	public static final String ZIP = "zip";
	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String FK_CONTACT_ID = "contact_id";
	public static final String TABLE = "address";

	private AddressType type;

	private String zip;

	private String city;

	private String street;

	private long contactId;

	/**
	 * @return the type
	 */
	public AddressType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(AddressType type) {
		this.type = type;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
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

}
