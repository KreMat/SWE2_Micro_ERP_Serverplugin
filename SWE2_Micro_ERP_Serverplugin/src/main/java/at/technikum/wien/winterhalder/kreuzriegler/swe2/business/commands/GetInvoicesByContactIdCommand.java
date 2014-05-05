/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.InvoiceDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetInvoicesByContactIdRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetInvoicesByContactIdResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetInvoicesByContactIdCommand extends AbstractCommand implements
		ICommand {

	public GetInvoicesByContactIdCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		GetInvoicesByContactIdRequest r = gson.fromJson(jsonRequest,
				GetInvoicesByContactIdRequest.class);

		List<InvoiceDto> invoices = dtoMapper.mapInvoices(invoiceService
				.loadInvoicesByContactId(r.getContactId()));

		GetInvoicesByContactIdResponse response = new GetInvoicesByContactIdResponse();
		response.setInvoices(invoices);
		return createResponse(response);
	}

}
