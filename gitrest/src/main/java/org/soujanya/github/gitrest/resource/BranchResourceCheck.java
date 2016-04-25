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
import org.soujanya.github.gitrest.model.Branch;
import org.soujanya.github.gitrest.model.Tree;

@Path("/branchcheck")
public class BranchResourceCheck {
	public final String FILE_NAME = ".travis.yml";

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		Client client = ClientBuilder.newClient();
		String name = client.target("https://api.github.com/repos/ruby/ruby/branches")
				.request(MediaType.APPLICATION_JSON).get(String.class);

		ArrayList<Branch> branches = new ArrayList<Branch>();
		JSONArray jsonArray = new JSONArray(name);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			Branch branch = new Branch();
			branch.setName((String) obj.get("name"));
			JSONObject obj1 = (JSONObject) obj.get("commit");
			branch.setSha((String) obj1.get("sha"));
			branch.setUrl((String) obj1.get("url"));
			branches.add(branch);
			System.out.println(branch);
		}
		String treeString = "https://api.github.com/repos/ruby/ruby/git/trees/";

		ArrayList<String> branchNotHavingYML = new ArrayList<String>();

		for (int i = 0; i < branches.size(); i++) {
			boolean checkIfBranchYML = false;
			Branch branch = branches.get(i);
			String branchResponse = client.target(treeString + branch.getSha()).request(MediaType.APPLICATION_JSON)
					.get(String.class);
			JSONObject obj = new JSONObject(branchResponse);

			System.out.println(obj);

			JSONArray obj1 = (JSONArray) obj.get("tree");
			System.out.println(obj1);
			for (int j = 0; j < obj1.length(); j++) {
				JSONObject obj3 = obj1.getJSONObject(j);
				System.out.println(obj3);
				Tree tree = new Tree();
				tree.setPath((String) obj3.get("path"));
				if (tree.getPath().equals(FILE_NAME)) {
					checkIfBranchYML = true;
				}
			}
			if (checkIfBranchYML == false) {
				branchNotHavingYML.add(branch.getName());
			}

		}

		return branchNotHavingYML.toString();
	}
}
