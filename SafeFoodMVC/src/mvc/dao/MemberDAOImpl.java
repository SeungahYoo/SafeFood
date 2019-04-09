package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.vo.Member;

// CRUD작업을 하는 DAO
public class MemberDAOImpl implements IMemberDAO {
	private ArrayList<Member> list;

	public MemberDAOImpl() {
		super();
		this.list = new ArrayList<>();
		// dummy data
		 this.list.add(new Member("ssafy", "tommy", "seoul", "010-2345-4567","1234", new String[]{"우유","게","땅콩","소맥분","감자전분","고춧가루"} ));
	     this.list.add(new Member("456", "jane kimberly", "la", "010-7890-4567","1111", new String[]{"새우","참치","연어"} ));
	     this.list.add(new Member("789", "billy joel", "london", "010-1111-2222","qwerty", new String[]{"돼지고기","닭고기","소고기"} ));
	}

	@Override
	public ArrayList<Member> selectAll() {
		return this.list;
	}

	@Override
	public Member selectOne(String id) {
		for (Member m : list)
			if (m.getId().equals(id))
				return m;
		return null;
	}

	@Override
	public void insert(Member m) {
		this.list.add(m);
	}

	@Override
	public void delete(String id) {
		for (Member m : list)
			if (m.getId().equals(id)) {
				list.remove(m);
				break;
			}
	}

	@Override
	public void modify(Member m) {
		for (Member m2 : list)
			if (m2.getId().equals(m.getId())) {
				m2.setName(m.getName());
				m2.setAddress(m.getAddress());
				m2.setTel(m.getTel());
				break;
			}
	}

	@Override
	public ArrayList<Member> search(String condition, String word) {
		ArrayList<Member> ret = new ArrayList<>();
		for (Member m2 : list)
			if ((condition.equals("주소") || condition.equals("address")) && m2.getAddress().contains(word)) {
				ret.add(m2);
			} else if ((condition.equals("이름") || condition.equals("name")) && m2.getName().contains(word)) {
				ret.add(m2);
			}
		return ret;
	}

	@Override
	public void insert(String id, String name, String address, String tel, String password, String[] allergies) {
		this.list.add(new Member(id, name, address, tel, password, allergies));
	}

	@Override
	public void modify(String id, String name, String address, String tel, String password, String[] allergies) {
		Member m = selectOne(id); // 회원 검색
		if(m != null) { // 회원 정보가 존재할 경우 
			m.setName(name);
			m.setAddress(address);
			m.setTel(tel);
			m.setPassword(password);
			m.setAllergies(allergies);
		}
	}

	@Override
	public List<String> addFood(String id, String code) {
		Member m = selectOne(id);
		m.getCodes().add(code);
		return m.getCodes();
	}

	@Override
	public List<String> getFoods(String id) {
		Member m = selectOne(id);
		return m.getCodes();
	}
}
