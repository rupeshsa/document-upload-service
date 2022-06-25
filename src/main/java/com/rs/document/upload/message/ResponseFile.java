package com.rs.document.upload.message;

public class ResponseFile {
	private String name;
	private String url;
	private String type;
	private String user;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	private String comment;
	private String uploadDate;
	private long size;

	public ResponseFile(String name, String url, String type, String user, String comment, String uploadDate,
			long size) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
		this.user = user;
		this.comment = comment;
		this.uploadDate = uploadDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
