/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.io.ByteArrayInputStream;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.MicroERPConstants;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetAllContactsResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

import com.google.gson.Gson;

/**
 * @author Matthias
 * 
 */
public class GetAllContactsCommand extends AbstractCommand implements ICommand {

	public GetAllContactsCommand() {
		super();
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
		GetAllContactsResponse dto = dtoMapper.mapAllContacts(contactService
				.loadAllContacts());
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		r.setContentLength(json.length());
		r.setContentType(MicroERPConstants.MIME_JSON);
		r.setBody(new ByteArrayInputStream(json.getBytes()));
		return r;
	}

}
