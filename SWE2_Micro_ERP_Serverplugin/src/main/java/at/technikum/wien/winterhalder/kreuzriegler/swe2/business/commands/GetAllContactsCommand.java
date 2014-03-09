/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.io.ByteArrayInputStream;

import com.google.gson.Gson;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.MicroERPConstants;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.ContactService;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.GetAllContactsDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.DtoMapper;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetAllContactsCommand implements ICommand {

	private ContactService contactService;
	private DtoMapper dtoMapper;

	public GetAllContactsCommand() {
		contactService = new ContactService();
		dtoMapper = new DtoMapper();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.ICommand
	 * #
	 * handleRequest(at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain
	 * .interfaces.Uri,
	 * at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain
	 * .interfaces.Request)
	 */
	@Override
	public Response handleRequest(Uri uri, Request request) {
		Response r = ResponseBuilder.buildResponse(StatusCode.STATUS_200);
		GetAllContactsDto dto = dtoMapper.mapAllContacts(contactService
				.loadAllContacts());
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		r.setContentLength(json.length());
		r.setContentType(MicroERPConstants.MIME_JSON);
		r.setBody(new ByteArrayInputStream(json.getBytes()));
		return r;
	}

}
