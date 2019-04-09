package mvc.service;

import java.util.ArrayList;
import java.util.List;

import mvc.vo.Member;
//client(MemberController)�� ���� ���� ���� �޼ҵ尡 ǥ�õǴ� �������̽�
//MemberController)�� ���� ���� ���� �޼ҵ尡 ǥ�õǴ� �������̽�
//MemberController�� �̿밡���� �޼ҵ� ���
public interface MemberService {
	/**
	 * instance�� ��� ȸ�� ���� ��� ��ȸ
	 * @return ��� ȸ�� ���� ���
	 */
    public ArrayList<Member> selectAll();
    /**
     * �Է¹��� ȸ�� ���� ��ü�� ���� ȸ�� ���� �߰�
     * @param m �߰��� ȸ�� ���� ��ü
     */
    public void insert(Member m);
    /**
     * �Է� ���� ȸ�� ������ ���� ȸ�� ���� �߰�
     * @param id ���̵�
     * @param name ȸ�� �̸�
     * @param address ȸ�� �ּ�
     * @param tel ȸ�� ����ó 
     * @param password ȸ�� ��й�ȣ
     * @param allergies ȸ�� �˷����� ����
     */
    public void insert(String id, String name, String address, String tel, String password , String[] allergies);
    /**
     * �Է¹��� ȸ�� ���̵�� ��ġ�ϴ� ȸ�� ���� ��ȯ
     * @param id ��ȸ�� ȸ�� ���̵�
     * @return �Է¹��� ȸ�� ���̵�� ��ġ�ϴ� ȸ�� ����
     */
    public Member selectOne(String id);
    /**
     * �Է¹��� ȸ�� ���� ��ü�� ���� ȸ�� ���� ����
     * @param m ������ ȸ�� ���� ��ü
     */
    public void modify(Member m);
    /**
     * �Է¹��� ȸ�� ������ ���� ȸ�� ���� ����
     * @param id ���̵�
     * @param name ȸ�� �̸�
     * @param address ȸ�� �ּ�
     * @param tel ȸ�� ����ó 
     * @param password ȸ�� ��й�ȣ
     * @param allergies ȸ�� �˷����� ����
     */
    public void modify(String id, String name, String address, String tel, String password , String[] allergies );
    /**
     * �Է¹��� ȸ�� ���̵� ������ ���� ȸ�� Ż��
     * @param id ������ ȸ�� ���̵� ����
     */
    public void delete(String id);
    /**
     * ���ǰ� �˻���� ��ġ�ϴ� ȸ�� ���� ��� ��ȯ
     * @param condition ����
     * @param word �˻���
     * @return ���ǰ� �˻���� ��ġ�ϴ� ȸ�� ���� ��� 
     */
    public ArrayList<Member> search(String condition, String word);
    /**
     * ȸ�� ���̵�� ��ġ�ϴ� ȸ�� ���� ��ǰ �ڵ� ��� �߰�
     * @param id ȸ�� ���̵�
     * @param code ��ǰ �ڵ� ��ȣ
     * @return ȸ�� ���� ��ǰ �ڵ� ���
     */
    public List<String> addFood(String id , String code);
    /**
     * ȸ�� ���̵�� ��ġ�ϴ� ȸ�� ���� ��ǰ �ڵ� ��� ��ȯ
     * @param id ȸ�� ���̵�
     * @return ȸ�� ���� ��ǰ �ڵ� ���
     */
    public List<String> getFoods(String id);
}
