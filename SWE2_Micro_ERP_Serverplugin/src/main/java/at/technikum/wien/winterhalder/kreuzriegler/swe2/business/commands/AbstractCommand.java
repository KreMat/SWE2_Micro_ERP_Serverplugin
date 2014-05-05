/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URLDecoder;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.MicroERPConstants;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.ContactService;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.InvoiceService;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.DtoMapper;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

import com.google.gson.Gson;

/**
 * @author Matthias
 * 
 */
public abstract class AbstractCommand {

	protected ContactService contactService;
	protected InvoiceService invoiceService;
	protected DtoMapper dtoMapper;
	protected Gson gson;

	protected AbstractCommand() {
		contactService = new ContactService();
		invoiceService = new InvoiceService();
		dtoMapper = new DtoMapper();
		gson = new Gson();
	}

	protected Response createResponse(Object dto) {
		Response r = ResponseBuilder.buildResponse(StatusCode.STATUS_200);
		String json = gson.toJson(dto);
		r.setContentLength(json.length());
		r.setContentType(MicroERPConstants.MIME_JSON);
		r.setBody(new ByteArrayInputStream(json.getBytes()));
		return r;
	}

	protected String getJsonRequest(Request request) {
		InputStreamReader reader = new InputStreamReader(request.getBody());
		try {
			StringWriter wr = new StringWriter();
			for (long i = 0; i < request.getContentLength(); i++) {
				wr.write(reader.read());
			}
			wr.close();
			String decodedParams = URLDecoder.decode(wr.toString(), "UTF-8");
			if (decodedParams.startsWith("request=")) {
				return decodedParams.replaceFirst("request=", "");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the contactService
	 */
	public ContactService getContactService() {
		return contactService;
	}

	/**
	 * @param contactService
	 *            the contactService to set
	 */
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	/**
	 * @return the invoiceService
	 */
	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	/**
	 * @param invoiceService
	 *            the invoiceService to set
	 */
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	/**
	 * @return the dtoMapper
	 */
	public DtoMapper getDtoMapper() {
		return dtoMapper;
	}

	/**
	 * @param dtoMapper
	 *            the dtoMapper to set
	 */
	public void setDtoMapper(DtoMapper dtoMapper) {
		this.dtoMapper = dtoMapper;
	}

	/**
	 * @return the gson
	 */
	public Gson getGson() {
		return gson;
	}

	/**
	 * @param gson
	 *            the gson to set
	 */
	public void setGson(Gson gson) {
		this.gson = gson;
	}

}
