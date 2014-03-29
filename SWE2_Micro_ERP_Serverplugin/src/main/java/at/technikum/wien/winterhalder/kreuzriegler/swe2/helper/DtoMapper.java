package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetAllContactsResponse;

public class DtoMapper {

	public GetAllContactsResponse mapAllContacts(List<Contact> contacts) {
		GetAllContactsResponse dto = new GetAllContactsResponse();
		dto.setContacts(mapContacts(contacts));
		return dto;
	}

	public ContactDto mapContact(Contact c) {
		ContactDto dto = new ContactDto();
		try {
			BeanUtils.copyProperties(dto, c);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		return dto;
	}

	public List<ContactDto> mapContacts(List<Contact> contacts) {
		List<ContactDto> result = new ArrayList<ContactDto>();
		for (Contact c : contacts) {
			result.add(mapContact(c));
		}
		return result;
	}

}
