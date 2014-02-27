/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

/**
 * @author Matthias
 * 
 */
public class MicroErpPlugin implements Pluggable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable
	 * #request(at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.
	 * interfaces.Uri,
	 * at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain
	 * .interfaces.Request)
	 */
	@Override
	public Response request(Uri uri, Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable
	 * #start()
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable
	 * #stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
