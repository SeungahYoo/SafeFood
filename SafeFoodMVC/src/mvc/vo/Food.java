package mvc.vo;

public class Food {
	/**��ǰ �ڵ�*/
	private String code;
	/**��ǰ ��*/
	private String name;
	/**��ǰ ������*/
	private String maker;
	/**��ǰ ���*/
	private String material;
	/**��ǰ �̹��� ���*/
	private String image;
	/**��ȸ ���� ��*/
	private double supportpereat;//serving_wt
	/**��ȸ �����Ǵ� Į�α�*/
	private double calory;//nutr_cont1
	/**��ȸ �����Ǵ� ź��ȭ��*/
	private double carbo;//nutr_cont2
	/**��ȸ �����Ǵ� �ܹ���*/
	private double protein;//nutr_cont3
	/**��ȸ �����Ǵ� ����*/
	private double fat;//nutr_cont4
	/**��ȸ �����Ǵ� ���*/
	private double sugar;//nutr_cont5
	/**��ȸ �����Ǵ� ��Ʈ��*/
	private double natrium;//nutr_cont6
	/**��ȸ �����Ǵ� �ݷ����׷�*/
	private double chole;//nutr_cont7
	/**��ȸ �����Ǵ� ��ȭ�����*/
	private double fattyacid;//nutr_cont8
	/**��ȸ �����Ǵ� Ʈ��������*/
	private double transfat;//nutr_cont9
	/**����� �˷����� ����*/
	private String allergy;
	
	public Food() {
	}

	public Food(String code, String name, String maker, String material, String image) {
		this.code = code;
		this.name = name;
		this.maker = maker;
		this.material = material;
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getSupportpereat() {
		return supportpereat;
	}

	public void setSupportpereat(double supportpereat) {
		this.supportpereat = supportpereat;
	}

	public double getCalory() {
		return calory;
	}

	public void setCalory(double calory) {
		this.calory = calory;
	}

	public double getCarbo() {
		return carbo;
	}

	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getNatrium() {
		return natrium;
	}

	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}

	public double getChole() {
		return chole;
	}

	public void setChole(double chole) {
		this.chole = chole;
	}

	public double getFattyacid() {
		return fattyacid;
	}

	public void setFattyacid(double fattyacid) {
		this.fattyacid = fattyacid;
	}

	public double getTransfat() {
		return transfat;
	}

	public void setTransfat(double transfat) {
		this.transfat = transfat;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	@Override
	public String toString() {
		return "Food [code=" + code + ", name=" + name + ", maker=" + maker + ", material=" + material + ", image="
				+ image + ", supportpereat=" + supportpereat + ", calory=" + calory + ", carbo=" + carbo + ", protein="
				+ protein + ", fat=" + fat + ", sugar=" + sugar + ", natrium=" + natrium + ", chole=" + chole
				+ ", fattyacid=" + fattyacid + ", transfat=" + transfat + ", allergy=" + allergy + "]";
	}

}
