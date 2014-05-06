/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.CreateOrUpdateContactRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.CreateOrUpdateContactResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class CreateOrUpdateContactCommand extends AbstractCommand implements
		ICommand {

	public CreateOrUpdateContactCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		CreateOrUpdateContactRequest r = gson.fromJson(jsonRequest,
				CreateOrUpdateContactRequest.class);

		contactService.createOrUpdate(dtoMapper.mapContactDto(r.getContact()));

		CreateOrUpdateContactResponse response = new CreateOrUpdateContactResponse();
		return createResponse(response);
	}

}
