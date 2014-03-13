package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetAllContactsResponse;

public class DtoMapper {

	public GetAllContactsResponse mapAllContacts(List<Contact> contacts) {
		GetAllContactsResponse dto = new GetAllContactsResponse();
		for (Contact c : contacts) {
			dto.getContacts().add(mapContact(c));
		}
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

}
