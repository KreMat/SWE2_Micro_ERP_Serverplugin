/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.Uris;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.CreateOrUpdateContactCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.CreateOrUpdateInvoiceCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetCompaniesByNameCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetContactByIdCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetContactsByNameCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetContactsBySearchstringCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetInvoicesByContactIdCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetInvoicesBySearchstringCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.ICommand;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class CommandFactory {

	private static final Map<String, ICommand> uriMatcher;

	static {
		uriMatcher = new HashMap<String, ICommand>();

		uriMatcher.put(Uris.CREATE_OR_UPDATE_CONTACT,
				new CreateOrUpdateContactCommand());
		uriMatcher.put(Uris.CREATE_OR_UPDATE_INVOICE,
				new CreateOrUpdateInvoiceCommand());
		uriMatcher.put(Uris.COMPANIES_BY_NAME, new GetCompaniesByNameCommand());
		uriMatcher.put(Uris.CONTACT_BY_ID, new GetContactByIdCommand());
		uriMatcher.put(Uris.CONTACTS_BY_NAME, new GetContactsByNameCommand());
		uriMatcher.put(Uris.CONTACTS_BY_SEARCHSTRING,
				new GetContactsBySearchstringCommand());
		uriMatcher.put(Uris.INVOICES_BY_CONTACTID,
				new GetInvoicesByContactIdCommand());
		uriMatcher.put(Uris.INVOICES_BY_SEARCHSTRING,
				new GetInvoicesBySearchstringCommand());
	}

	public static ICommand createCommand(Uri uri) {
		return uriMatcher.get(extractPath(uri.getPath()));
	}

	private static String extractPath(String path) {
		return path.split("/")[2];
	}

}
