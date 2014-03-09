/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.factory;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.GetAllContactsCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.ICommand;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

/**
 * @author Matthias
 * 
 */
public class CommandFactory {

	public static ICommand createCommand(Uri uri) {
		// TODO implement me
		return new GetAllContactsCommand();
	}

}
