/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetContactsBySearchstringRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetContactsBySearchstringResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetContactsBySearchstringCommand extends AbstractCommand implements
		ICommand {

	public GetContactsBySearchstringCommand() {
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
		String jsonRequest = getJsonRequest(request);
		GetContactsBySearchstringRequest r = gson.fromJson(jsonRequest,
				GetContactsBySearchstringRequest.class);
		List<ContactDto> contactList = dtoMapper.mapContacts(contactService
				.getContactsBySearchstring(r.getSearchString()));
		GetContactsBySearchstringResponse response = new GetContactsBySearchstringResponse();
		response.setContacts(contactList);
		return createResponse(response);
	}

}
