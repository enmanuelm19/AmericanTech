package util;

public class StarRating {

	private String star1,star2,star3,star4,star5;
	public StarRating(){};
	
	public StarRating(String star1, String star2, String star3, String star4, String star5){
		this.star1=star1;
		this.star2=star2;
		this.star3=star3;
		this.star4=star4;
		this.star5=star5;
	}
	
	public String getStar1() {
		return star1;
	}

	public void setStar1(String star1) {
		this.star1 = star1;
	}

	public String getStar2() {
		return star2;
	}

	public void setStar2(String star2) {
		this.star2 = star2;
	}

	public String getStar3() {
		return star3;
	}

	public void setStar3(String star3) {
		this.star3 = star3;
	}

	public String getStar4() {
		return star4;
	}

	public void setStar4(String star4) {
		this.star4 = star4;
	}

	public String getStar5() {
		return star5;
	}

	public void setStar5(String star5) {
		this.star5 = star5;
	}
	
}
