package com.example.arlinda.nbaretrofit.model.stats;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Stats{

	@SerializedName("regularSeason")
	private RegularSeason regularSeason;

	@SerializedName("careerSummary")
	private CareerSummary careerSummary;

	@SerializedName("latest")
	private Latest latest;

	public void setRegularSeason(RegularSeason regularSeason){
		this.regularSeason = regularSeason;
	}

	public RegularSeason getRegularSeason(){
		return regularSeason;
	}

	public void setCareerSummary(CareerSummary careerSummary){
		this.careerSummary = careerSummary;
	}

	public CareerSummary getCareerSummary(){
		return careerSummary;
	}

	public void setLatest(Latest latest){
		this.latest = latest;
	}

	public Latest getLatest(){
		return latest;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"regularSeason = '" + regularSeason + '\'' + 
			",careerSummary = '" + careerSummary + '\'' + 
			",latest = '" + latest + '\'' + 
			"}";
		}
}