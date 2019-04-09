package mvc.vo;

public class Food {
	/**식품 코드*/
	private String code;
	/**식품 명*/
	private String name;
	/**식품 제조사*/
	private String maker;
	/**식품 재료*/
	private String material;
	/**식품 이미지 경로*/
	private String image;
	/**일회 제공 량*/
	private double supportpereat;//serving_wt
	/**일회 제공되는 칼로기*/
	private double calory;//nutr_cont1
	/**일회 제공되는 탄수화물*/
	private double carbo;//nutr_cont2
	/**일회 제공되는 단백질*/
	private double protein;//nutr_cont3
	/**일회 제공되는 지방*/
	private double fat;//nutr_cont4
	/**일회 제공되는 당류*/
	private double sugar;//nutr_cont5
	/**일회 제공되는 나트륨*/
	private double natrium;//nutr_cont6
	/**일회 제공되는 콜레스테롤*/
	private double chole;//nutr_cont7
	/**일회 제공되는 포화지방산*/
	private double fattyacid;//nutr_cont8
	/**일회 제공되는 트렌스지방*/
	private double transfat;//nutr_cont9
	/**사용자 알레르기 정보*/
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
