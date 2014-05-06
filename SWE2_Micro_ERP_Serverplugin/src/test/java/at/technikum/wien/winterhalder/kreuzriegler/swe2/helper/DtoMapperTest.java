package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;

public class DtoMapperTest {

	private TestHelper helper;
	private DtoMapper mapper;

	public DtoMapperTest() {
		mapper = new DtoMapper();
		helper = new TestHelper();
	}

	@Test
	public void testMapAllContacts() {
		List<Contact> list = new ArrayList<Contact>();
		list.add(helper.createDefaultCompany());
		list.add(helper.createDefaultCompany());
		list.add(helper.createDefaultCompany());

		List<ContactDto> contacts = mapper.mapContacts(list);

		Assert.assertFalse(contacts.isEmpty());

	}
}
