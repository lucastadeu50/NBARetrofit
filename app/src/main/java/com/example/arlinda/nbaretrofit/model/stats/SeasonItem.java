package com.example.arlinda.nbaretrofit.model.stats;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class SeasonItem{

	@SerializedName("total")
	private Total total;

	@SerializedName("teams")
	private List<TeamsItem> teams;

	@SerializedName("seasonYear")
	private int seasonYear;

	public void setTotal(Total total){
		this.total = total;
	}

	public Total getTotal(){
		return total;
	}

	public void setTeams(List<TeamsItem> teams){
		this.teams = teams;
	}

	public List<TeamsItem> getTeams(){
		return teams;
	}

	public void setSeasonYear(int seasonYear){
		this.seasonYear = seasonYear;
	}

	public int getSeasonYear(){
		return seasonYear;
	}

	@Override
 	public String toString(){
		return 
			"SeasonItem{" + 
			"total = '" + total + '\'' + 
			",teams = '" + teams + '\'' + 
			",seasonYear = '" + seasonYear + '\'' + 
			"}";
		}
}