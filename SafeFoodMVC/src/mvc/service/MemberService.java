package mvc.service;

import java.util.ArrayList;
import java.util.List;

import mvc.vo.Member;
//client(MemberController)를 위한 서비스 제공 메소드가 표시되는 인터페이스
//MemberController)를 위한 서비스 제공 메소드가 표시되는 인터페이스
//MemberController가 이용가능한 메소드 목록
public interface MemberService {
	/**
	 * instance된 모든 회원 정보 목록 조회
	 * @return 모든 회원 정보 목록
	 */
    public ArrayList<Member> selectAll();
    /**
     * 입력받은 회원 정보 객체를 통한 회원 정보 추가
     * @param m 추가할 회원 정보 객체
     */
    public void insert(Member m);
    /**
     * 입력 받은 회원 정보를 통한 회원 정보 추가
     * @param id 아이디
     * @param name 회원 이름
     * @param address 회원 주소
     * @param tel 회원 연락처 
     * @param password 회원 비밀번호
     * @param allergies 회원 알레르기 정보
     */
    public void insert(String id, String name, String address, String tel, String password , String[] allergies);
    /**
     * 입력받은 회원 아이디와 일치하는 회원 정보 반환
     * @param id 조회할 회원 아이디
     * @return 입력받은 회원 아이디와 일치하는 회원 정보
     */
    public Member selectOne(String id);
    /**
     * 입력받은 회원 정보 객체를 통한 회원 정보 수정
     * @param m 수정할 회원 정보 객체
     */
    public void modify(Member m);
    /**
     * 입력받은 회원 정보를 통한 회원 정보 수정
     * @param id 아이디
     * @param name 회원 이름
     * @param address 회원 주소
     * @param tel 회원 연락처 
     * @param password 회원 비밀번호
     * @param allergies 회원 알레르기 정보
     */
    public void modify(String id, String name, String address, String tel, String password , String[] allergies );
    /**
     * 입력받은 회원 아이디 정보를 통한 회원 탈퇴
     * @param id 삭제할 회원 아이디 정보
     */
    public void delete(String id);
    /**
     * 조건과 검색어와 일치하는 회원 정보 목록 반환
     * @param condition 조건
     * @param word 검색어
     * @return 조건과 검색어와 일치하는 회원 정보 목록 
     */
    public ArrayList<Member> search(String condition, String word);
    /**
     * 회원 아이디와 일치하는 회원 섭취 식품 코드 목록 추가
     * @param id 회원 아이디
     * @param code 식품 코드 번호
     * @return 회원 섭취 식품 코드 목록
     */
    public List<String> addFood(String id , String code);
    /**
     * 회원 아이디와 일치하는 회원 섭취 식품 코드 목록 반환
     * @param id 회원 아이디
     * @return 회원 섭취 식품 코드 목록
     */
    public List<String> getFoods(String id);
}
