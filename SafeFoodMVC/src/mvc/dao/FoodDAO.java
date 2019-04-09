package mvc.dao;

import java.util.List;

import mvc.vo.Food;

public interface FoodDAO {
	/**
	 * ����(DB, XML)�Ǿ� �ִ� ��ǰ ���� ����� instance�ϴ� �޼ҵ�
	 */
	public void loadData();
	/**
	 * ��ǰ ��� ���� ��ȯ
	 * @return ��ǰ ��� ����
	 */
	public int foodCount();
	/**
	 * instance�� ��� ��ǰ ���� ��� ��ȸ
	 * @return instance�� ��ǰ ���� ���
	 */
	public List<Food> searchAll();
	/**
	 * �Է¹��� �ڵ� ������ ���� instance�� ��ǰ ���� ��ȸ
	 * @param code ��ȸ�� ��ǰ �ڵ�
	 * @return �Է� ��ǰ �ڵ�� ��ġ�ϴ� ��ǰ ����
	 */
	public Food search(String code);
	/**
	 * ���ǰ� �˻��� ������� ��ǰ ���� ��� ��ȸ
	 * @param condition ���� 
	 * @param word �˻���
	 * @return ���� �� �˻���� ��ġ�ϴ� ��ǰ ���� ���
	 */
	public List<Food> search(String condition, String word);
	/**
	 * �� �Ǵ� �߰� ������ ���� ��ǰ ���� ��� ��ȸ
	 * @return �� �Ǵ� �߰� ������ ���� ��ǰ ���� ���
	 */
	public List<Food> searchBest();
	/**
	 * �� �Ǵ� �߰� ������ ���� ��ǰ ������ index ��� ��ȸ
	 * @return �� �Ǵ� �߰� ������ ���� ��ǰ ���� index ���
	 */
	public List<Food> searchBestIndex();
	
}