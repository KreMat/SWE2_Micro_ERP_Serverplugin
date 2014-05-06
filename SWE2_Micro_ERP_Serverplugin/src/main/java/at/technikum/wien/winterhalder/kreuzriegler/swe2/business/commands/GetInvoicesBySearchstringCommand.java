/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.dto.InvoiceDto;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetInvoicesBySearchstringRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetInvoicesBySearchstringResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class GetInvoicesBySearchstringCommand extends AbstractCommand implements
		ICommand {

	public GetInvoicesBySearchstringCommand() {
		super();
	}

	@Override
	public Response handleRequest(Uri uri, Request request) {
		String jsonRequest = getJsonRequest(request);
		GetInvoicesBySearchstringRequest r = gson.fromJson(jsonRequest,
				GetInvoicesBySearchstringRequest.class);

		List<InvoiceDto> invoices = new ArrayList<InvoiceDto>();
//		= dtoMapper.mapInvoices(invoiceService
//				.loadInvoicesBySearchstring(r.get));

		GetInvoicesBySearchstringResponse response = new GetInvoicesBySearchstringResponse(
				invoices);
		return createResponse(response);
	}

}
