package po;

import java.util.ArrayList;

public class Player {
	String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	String name;
	String birthday;
	String age;
	String birthplace;
	String weight;
	String enternba;
	String pick;
	String height;
	ArrayList<SeasonPre> seasonPres=new ArrayList<>();
	ArrayList<SeasonSum> seasonSums=new ArrayList<>();
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getEnternba() {
		return enternba;
	}
	public void setEnternba(String enternba) {
		this.enternba = enternba;
	}
	public String getPick() {
		return pick;
	}
	public void setPick(String pick) {
		this.pick = pick;
	}
	public ArrayList<SeasonPre> getSeasonPres() {
		return seasonPres;
	}
	public void setSeasonPres(ArrayList<SeasonPre> seasonPres) {
		this.seasonPres = seasonPres;
	}
	public ArrayList<SeasonSum> getSeasonSums() {
		return seasonSums;
	}
	public void setSeasonSums(ArrayList<SeasonSum> seasonSums) {
		this.seasonSums = seasonSums;
	}
	
}
