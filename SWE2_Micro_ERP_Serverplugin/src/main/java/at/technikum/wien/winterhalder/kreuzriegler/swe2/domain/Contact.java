/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.domain;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.enums.AddressType;

/**
 * @author Matthias
 * 
 */
public class Contact extends AbstractEntity {

	// CONTRACT
	public static final String COMPANYNAME = "companyname";
	public static final String UID = "uid";
	public static final String TITLE = "title";
	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	public static final String SUFFIX = "suffix";
	public static final String BIRTHDAY = "birthday";
	public static final String FK_CONTACT_ID = "fk_contact_id";
	public static final String TABLE = "contact";

	private String companyname;

	private String uid;

	private String title;

	private String firstname;

	private String lastname;

	private String suffix;

	private Timestamp birthday;

	private Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();

	private Long companyId;

	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname
	 *            the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the birthday
	 */
	public Timestamp getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the addresses
	 */
	public Map<AddressType, Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(Map<AddressType, Address> addresses) {
		this.addresses = addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = new HashMap<AddressType, Address>();
		for (Address a : addresses) {
			this.addresses.put(a.getType(), a);
		}
	}

	public void addAddress(AddressType key, Address address) {
		this.addresses.put(key, address);
	}
}
