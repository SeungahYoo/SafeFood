package mvc.vo;

import java.util.ArrayList;
import java.util.List;

//vo(value object: 값을 저장하기 위한 객체)
//table 안의 레코드 한건에 해당
public class Member {
	private String id, name, address, tel, password;
	private String[] allergies;
	private List<String> codes;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Member() {}
	public Member(String id, String name, String address, String tel, String password, String[] allergies) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.password = password;
		this.allergies = allergies;
		this.codes = new ArrayList<>();
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String[] getAllergies() {
		return allergies;
	}
	public void setAllergies(String[] allergies) {
		this.allergies = allergies;
	}
	public List<String> getCodes() {
		return codes;
	}
	public void setCodes(List<String> codes) {
		this.codes = codes;
	}
	
}
