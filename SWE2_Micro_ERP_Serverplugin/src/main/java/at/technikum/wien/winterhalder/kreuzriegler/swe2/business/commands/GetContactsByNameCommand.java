/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetContactsByNameRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetContactsByNameResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetContactsByNameCommand extends AbstractCommand implements
		ICommand {

	public GetContactsByNameCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		GetContactsByNameRequest r = gson.fromJson(jsonRequest,
				GetContactsByNameRequest.class);

		List<ContactDto> contacts = dtoMapper.mapContacts(contactService
				.getContactsByName(r.getName()));

		GetContactsByNameResponse response = new GetContactsByNameResponse(
				contacts);
		return createResponse(response);
	}

}
