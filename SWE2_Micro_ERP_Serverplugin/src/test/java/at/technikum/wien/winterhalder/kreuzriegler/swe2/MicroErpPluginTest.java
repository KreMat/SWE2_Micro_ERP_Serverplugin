package at.technikum.wien.winterhalder.kreuzriegler.swe2;

import java.io.ByteArrayInputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetContactsBySearchstringRequest;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Method;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Protocol;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Version;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPRequest;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.UriImpl;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

import com.google.gson.Gson;

public class MicroErpPluginTest extends Assert {

	private MicroErpPlugin plugin;

	@Before
	public void setUp() {
		plugin = new MicroErpPlugin();
	}

	@Test
	public void testSearch() {
		Request r = new HTTPRequest();
		r.setMethod(Method.POST);

		// Obj -> JSON
		Gson gson = new Gson();
		String req = "request="
				+ gson.toJson(new GetContactsBySearchstringRequest("uid"));

		r.setContentLength(req.length());
		r.setContentType(MicroERPConstants.MIME_JSON);
		r.setBody(new ByteArrayInputStream(req.getBytes()));

		Uri uri = new UriImpl(8088, Protocol.HTTP, Version.V1_1, "localhost");
		uri.setPath("/micro/" + Uris.CONTACTS_BY_SEARCHSTRING);

		Response response = plugin.request(uri, r);
		assertNotNull(response);
	}
}
