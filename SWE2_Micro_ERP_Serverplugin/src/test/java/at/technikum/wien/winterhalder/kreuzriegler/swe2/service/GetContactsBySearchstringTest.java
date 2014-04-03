package at.technikum.wien.winterhalder.kreuzriegler.swe2.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swe2.Uris;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.request.GetContactsBySearchstringRequest;
import at.technikum.wien.winterhalder.kreuzriegler.swe2.response.GetContactsBySearchstringResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.WebserverConstants;

import com.google.gson.Gson;

/**
 * Diese Tests dienen eher als Integrationstests und benötigen den aktuell
 * laufenden Webserver um erfolgreich ausgeführt werden zu können.
 * 
 * @author Matthias
 * 
 */
public class GetContactsBySearchstringTest extends Assert {

	@Test
	public void testSearchString() throws URISyntaxException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(new URI("http", null, "localhost",
				WebserverConstants.PORT, "/micro/"
						+ Uris.CONTACTS_BY_SEARCHSTRING, null, "anchor"));

		// Obj -> JSON
		Gson gson = new Gson();

		String req = gson.toJson(new GetContactsBySearchstringRequest("uid"));

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("request", req));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		HttpResponse response = client.execute(post);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		StringBuilder sb = new StringBuilder();

		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();

		GetContactsBySearchstringResponse resp = gson.fromJson(sb.toString(),
				GetContactsBySearchstringResponse.class);

		assertNotNull(resp);
	}

}
