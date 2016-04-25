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

@Path("/branch")
public class BranchResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		Client client = ClientBuilder.newClient();
		String name = client.target("https://api.github.com/repos/ruby/ruby/branches")
				.request(MediaType.APPLICATION_JSON).get(String.class);
		ArrayList<String> branches = new ArrayList<String>();
		JSONArray jsonArray = new JSONArray(name);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			String names = (String) obj.get("name");
			branches.add(names);

		}
		System.out.println(branches.toString()); 
		return branches.toString();
	}
}
