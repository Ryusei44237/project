package Bean;

public class post {

	private String id;
	private String contents;
	private String img;
	private String tags_id;
	private String account_id;
	private String address;
	private String create_at;




	public post(String id, String contents, String img, String tags_id, String account_id, String address, String create_at ) {

		this.id = id;
		this.contents = contents;
		this.img = img;
		this.tags_id = tags_id;
		this.account_id = account_id;
		this.address = address;
		this.create_at = create_at;

	}


	public post(String contents, String img, String tags_id, String account_id, String address, String create_at ) {

		this.contents = contents;
		this.img = img;
		this.tags_id = tags_id;
		this.account_id = account_id;
		this.address = address;
		this.create_at = create_at;

	}


	public post(String contents, String img, String tags_id, String address, String create_at ) {

		this.contents = contents;
		this.img = img;
		this.tags_id = tags_id;
		this.address = address;
		this.create_at = create_at;

	}


	public post(String contents, String tags_id ) {

		this.contents = contents;
		this.tags_id = tags_id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public String getId() {

		return id;

	}

	public void setContents(String contents) {

		this.contents = contents;

	}

	public String getContents() {

		return contents;

	}

	public void setImg(String img) {

		this.img = img;

	}

	public String getImg() {

		return img;

	}

	public void setTags_Id(String tags_id) {

		this.tags_id = tags_id;

	}

	public String getTags_Id() {

		return tags_id;

	}

	public void setAccount_Id(String account_id) {

		this.account_id = account_id;

	}

	public String getAccount_Id() {

		return account_id;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public String getAddress() {

		return address;

	}

	public void setCreate_At(String create_at) {

		this.create_at = create_at;

	}

	public String getCreate_At() {

		return create_at;

	}


}
