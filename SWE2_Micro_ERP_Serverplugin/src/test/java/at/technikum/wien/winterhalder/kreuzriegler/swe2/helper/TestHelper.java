package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.AddressType;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;

public class TestHelper {

	public Contact createDefaultCompany() {
		Contact c = new Contact();
		c.setCompanyname("companyName");
		c.setUid("uid");
		return c;
	}

	public Address createDefaultAddress() {
		Address a = new Address();
		a.setCity("City");
		a.setZip("zip");
		a.setStreet("street");
		a.setType(AddressType.PRIMARY);
		a.setContactId(1);
		return a;
	}
}
