package org.soujanya.github.gitrest.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/tag")
public class TagResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		Client client = ClientBuilder.newClient();
		String name = client.target("https://api.github.com/repos/ruby/ruby/tags").request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		ArrayList<String> tags = new ArrayList<String>();
		JSONArray jsonArray = new JSONArray(name);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			String names = (String) obj.get("name");
			tags.add(names);

		}
		return tags.toString();
	}
}
