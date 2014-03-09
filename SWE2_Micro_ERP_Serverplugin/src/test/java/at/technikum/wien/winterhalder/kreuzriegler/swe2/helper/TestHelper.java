package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;

public class TestHelper {

	public Contact createDefaultCompany() {
		Contact c = new Contact();
		c.setCompanyname("companyName");
		c.setUid("uid");
		return c;
	}
}
