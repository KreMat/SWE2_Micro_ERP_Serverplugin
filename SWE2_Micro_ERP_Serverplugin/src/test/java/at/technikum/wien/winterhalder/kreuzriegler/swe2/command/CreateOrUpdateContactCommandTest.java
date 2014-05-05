/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swe2.command;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.ContactService;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.business.commands.CreateOrUpdateContactCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.dao.mock.ContactDaoMock;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.helper.TestHelper;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.CreateOrUpdateContactRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.CreateOrUpdateContactResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

import com.google.gson.Gson;

/**
 * @author Matthias
 * 
 */
public class CreateOrUpdateContactCommandTest extends Assert {

	private CreateOrUpdateContactCommand command;

	private TestHelper helper;

	private Gson gson = new Gson();

	@Before
	public void setUp() {
		command = new CreateOrUpdateContactCommand();
		helper = new TestHelper();
		ContactService contactService = new ContactService();
		contactService.setContactDao(new ContactDaoMock());
		command.setContactService(contactService);
	}

	@Test
	public void testCreateContact() {
		Request r = helper.createRequest(new CreateOrUpdateContactRequest(
				helper.createDefaultContactDto()));
		Response resp = command.handleRequest(null, r);
		String jsonResult = helper.getJsonString(resp);
		CreateOrUpdateContactResponse responseClass = gson.fromJson(jsonResult,
				CreateOrUpdateContactResponse.class);
		assertTrue(responseClass.isStatus());
	}
}
