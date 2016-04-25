package org.soujanya.github.gitrest.model;

public class Tag {
	String name;
	String zipBallUrl;
	String tarBallUrl;
	String sha;
	String url;
	String commit;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipBallUrl() {
		return zipBallUrl;
	}

	public void setZipBallUrl(String zipBallUrl) {
		this.zipBallUrl = zipBallUrl;
	}

	public String getTarBallUrl() {
		return tarBallUrl;
	}

	public void setTarBallUrl(String tarBallUrl) {
		this.tarBallUrl = tarBallUrl;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

}
