package at.technikum.wien.winterhalder.kreuzriegler.swe2.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Address;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Invoice;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.InvoiceRow;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.AddressDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.InvoiceDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.InvoiceRowDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.enums.AddressType;

public class DtoMapper {

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

	public List<InvoiceDto> mapInvoices(List<Invoice> invoices) {
		List<InvoiceDto> result = new ArrayList<InvoiceDto>();
		for (Invoice i : invoices) {
			result.add(mapInvoice(i));
		}
		return result;
	}

	public InvoiceDto mapInvoice(Invoice i) {
		InvoiceDto dto = new InvoiceDto();
		try {
			BeanUtils.copyProperties(dto, i);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		for (InvoiceRow r : i.getRows()) {
			dto.getRows().add(mapInvoiceRow(r));
		}
		return dto;
	}

	private InvoiceRowDto mapInvoiceRow(InvoiceRow r) {
		InvoiceRowDto dto = new InvoiceRowDto();
		try {
			BeanUtils.copyProperties(dto, r);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		return dto;
	}

	public Contact mapContactDto(ContactDto dto) {
		Contact contact = new Contact();
		try {
			BeanUtils.copyProperties(contact, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		for (Entry<AddressType, AddressDto> a : dto.getAddresses().entrySet()) {
			contact.addAddress(a.getKey(), mapAddressDto(a.getValue()));
		}
		return contact;
	}

	public Address mapAddressDto(AddressDto dto) {
		Address a = new Address();
		try {
			BeanUtils.copyProperties(a, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		return a;
	}

	public Invoice mapInvoiceDto(InvoiceDto dto) {
		Invoice invoice = new Invoice();
		try {
			BeanUtils.copyProperties(invoice, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		for (InvoiceRowDto r : dto.getRows()) {
			invoice.addRow(mapInvoiceRowDto(r));
		}
		return invoice;
	}

	public InvoiceRow mapInvoiceRowDto(InvoiceRowDto dto) {
		InvoiceRow row = new InvoiceRow();
		try {
			BeanUtils.copyProperties(row, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException(e);
		}
		return row;
	}

}
