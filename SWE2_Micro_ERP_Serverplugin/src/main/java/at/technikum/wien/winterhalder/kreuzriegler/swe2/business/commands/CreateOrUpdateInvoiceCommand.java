/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.CreateOrUpdateInvoiceRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.CreateOrUpdateInvoiceResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class CreateOrUpdateInvoiceCommand extends AbstractCommand implements
		ICommand {

	public CreateOrUpdateInvoiceCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		CreateOrUpdateInvoiceRequest r = gson.fromJson(jsonRequest,
				CreateOrUpdateInvoiceRequest.class);

		invoiceService.createOrUpdate(dtoMapper.mapInvoiceDto(r.getInvoice()));

		CreateOrUpdateInvoiceResponse response = new CreateOrUpdateInvoiceResponse();
		return createResponse(response);
	}

}
