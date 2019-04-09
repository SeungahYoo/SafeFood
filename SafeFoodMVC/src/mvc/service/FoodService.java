package mvc.service;

import java.util.List;
import mvc.vo.Food;

public interface FoodService {
	/**
	 * ��ǰ ���� ��� ��ȯ
	 * @return ��ǰ ���� ���
	 */
	public List<Food> searchAll();
	/**
	 * ��ǰ �ڵ�� ��ġ�ϴ� ��ǰ ���� ��ȯ
	 * @param code ��ǰ �ڵ� ����
	 * @return ��ǰ ���� 
	 */
	public Food search(String code);
	/**
	 * ���ǰ� �˻���� ��ġ�ϴ� ��ǰ ���� ��� ��ȯ
	 * @param condition ����
	 * @param word �˻���
	 * @return ���ǰ� �˻���� ��ġ�ϴ� ��ǰ ���� ���
	 */
	public List<Food> search(String condition, String word);
	/**
	 * �� �Ǵ� �߰��� ���� ���� ��ǰ ���� ��� ��ȯ
	 * @return �� �Ǵ� �߰��� ���� ���� ��ǰ ���� ���
	 */
	public List<Food> searchBest();
	/**
	 * �� �Ǵ� �߰��� ���� ���� ��ǰ ���� index ��� ��ȯ
	 * @return �� �Ǵ� �߰��� ���� ���� ��ǰ ���� index ���
	 */
	public List<Food> searchBestIndex();
}