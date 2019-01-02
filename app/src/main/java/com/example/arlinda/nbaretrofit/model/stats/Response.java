package com.example.arlinda.nbaretrofit.model.stats;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("league")
	private League league;

	@SerializedName("_internal")
	private Internal internal;

	public void setLeague(League league){
		this.league = league;
	}

	public League getLeague(){
		return league;
	}

	public void setInternal(Internal internal){
		this.internal = internal;
	}

	public Internal getInternal(){
		return internal;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"league = '" + league + '\'' + 
			",_internal = '" + internal + '\'' + 
			"}";
		}
}