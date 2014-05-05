package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.enums.AddressType;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPRequest;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

import com.google.gson.Gson;

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

	public Request createRequest(Object request) {
		HTTPRequest r = new HTTPRequest();
		Gson gson = new Gson();
		String requestString = "request=" + gson.toJson(request);

		r.setBody(new ByteArrayInputStream(requestString
				.getBytes(StandardCharsets.UTF_8)));
		r.setContentLength(requestString.length());
		return r;
	}

	public ContactDto createDefaultContactDto() {
		ContactDto dto = new ContactDto();
		dto.setFirstname("firstname");
		dto.setLastname("lastname");
		dto.setBirthday(123456);
		return dto;
	}

	public String getJsonString(Response resp) {
		InputStreamReader reader = new InputStreamReader(resp.getBody());
		try {
			StringWriter wr = new StringWriter();
			for (long i = 0; i < resp.getContentLength(); i++) {
				wr.write(reader.read());
			}
			wr.close();
			return URLDecoder.decode(wr.toString(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
