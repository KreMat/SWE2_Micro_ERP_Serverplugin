/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.ContactDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetCompanysByNameRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetCompanysByNameResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetCompaniesByNameCommand extends AbstractCommand implements
		ICommand {

	public GetCompaniesByNameCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		GetCompanysByNameRequest r = gson.fromJson(jsonRequest,
				GetCompanysByNameRequest.class);

		List<ContactDto> companies = dtoMapper.mapContacts(contactService
				.getCompaniesByName(r.getName()));

		GetCompanysByNameResponse response = new GetCompanysByNameResponse(
				companies);
		return createResponse(response);
	}

}
