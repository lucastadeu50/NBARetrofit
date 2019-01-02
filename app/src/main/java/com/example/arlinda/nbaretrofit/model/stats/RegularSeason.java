package com.example.arlinda.nbaretrofit.model.stats;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RegularSeason{

	@SerializedName("season")
	private List<SeasonItem> season;

	public void setSeason(List<SeasonItem> season){
		this.season = season;
	}

	public List<SeasonItem> getSeason(){
		return season;
	}

	@Override
 	public String toString(){
		return 
			"RegularSeason{" + 
			"season = '" + season + '\'' + 
			"}";
		}
}