package com.example.arlinda.nbaretrofit.model.stats;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class League{

	@SerializedName("standard")
	private Standard standard;

	public void setStandard(Standard standard){
		this.standard = standard;
	}

	public Standard getStandard(){
		return standard;
	}

	@Override
 	public String toString(){
		return 
			"League{" + 
			"standard = '" + standard + '\'' + 
			"}";
		}
}