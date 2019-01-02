package com.example.arlinda.nbaretrofit.model.stats;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Standard{

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("teamId")
	private String teamId;

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setTeamId(String teamId){
		this.teamId = teamId;
	}

	public String getTeamId(){
		return teamId;
	}

	@Override
 	public String toString(){
		return 
			"Standard{" + 
			"stats = '" + stats + '\'' + 
			",teamId = '" + teamId + '\'' + 
			"}";
		}
}