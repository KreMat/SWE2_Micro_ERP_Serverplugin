/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.domain.Contact;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetContactByIdRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetContactByIdResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetContactByIdCommand extends AbstractCommand implements ICommand {

	public GetContactByIdCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		GetContactByIdRequest r = gson.fromJson(jsonRequest,
				GetContactByIdRequest.class);

		Contact contact = contactService.read(r.getContactId());

		GetContactByIdResponse response = new GetContactByIdResponse(
				dtoMapper.mapContact(contact));
		return createResponse(response);
	}

}
