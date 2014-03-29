/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.Uris;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetContactsBySearchstringCommand;
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

		uriMatcher.put(Uris.CONTACTS_BY_SEARCHSTRING,
				new GetContactsBySearchstringCommand());
	}

	public static ICommand createCommand(Uri uri) {
		return uriMatcher.get(extractPath(uri.getPath()));
	}

	private static String extractPath(String path) {
		return path.split("/")[2];
	}

}
