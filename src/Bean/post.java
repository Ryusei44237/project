package Bean;

public class post {

	private int id;
	private String contents;
	private String img;
	private int tags_id;
	private int account_id;
	private String address;
	private String create_at;


	public post() {



	}


	public post(int id, String contents, String img, int tags_id, int account_id, String address, String create_at ) {

		this.id = id;
		this.contents = contents;
		this.img = img;
		this.tags_id = tags_id;
		this.account_id = account_id;
		this.address = address;
		this.create_at = create_at;

	}


	public void setId(int id) {

		this.id = id;

	}

	public int getId() {

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

	public void setTags_Id(int tags_id) {

		this.tags_id = tags_id;

	}

	public int getTags_Id() {

		return tags_id;

	}

	public void setAccount_Id(int account_id) {

		this.account_id = account_id;

	}

	public int getAccount_Id() {

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
