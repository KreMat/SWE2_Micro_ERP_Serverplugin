/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthias
 * 
 */
public class GetAllContactsDto {

	private List<ContactDto> contacts = new ArrayList<ContactDto>();

	/**
	 * @return the contacts
	 */
	public List<ContactDto> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts
	 *            the contacts to set
	 */
	public void setContacts(List<ContactDto> contacts) {
		this.contacts = contacts;
	}

}
