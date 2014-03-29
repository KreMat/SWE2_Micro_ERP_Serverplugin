package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.enums.AddressType;

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

	public Invoice createDefaultInvoice() {
		Invoice i = new Invoice();
		i.setNr("nr");
		i.setCreationdate(System.currentTimeMillis());
		i.setDuedate(System.currentTimeMillis());
		i.setComment("comment");
		i.setInformation("info");
		i.setContactId(1);
		return i;
	}

	public InvoiceRow createDefaultInvoiceRow() {
		InvoiceRow row = new InvoiceRow();
		row.setName("name");
		row.setAmount(5d);
		row.setPrice(12.3d);
		row.setUst(20d);
		row.setInvoiceId(1);
		return row;
	}
}
