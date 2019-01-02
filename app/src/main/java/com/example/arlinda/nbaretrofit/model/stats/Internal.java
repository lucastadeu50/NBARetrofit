package com.example.arlinda.nbaretrofit.model.stats;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Internal{

	@SerializedName("eventName")
	private String eventName;

	@SerializedName("xslt")
	private String xslt;

	@SerializedName("pubDateTime")
	private String pubDateTime;

	public void setEventName(String eventName){
		this.eventName = eventName;
	}

	public String getEventName(){
		return eventName;
	}

	public void setXslt(String xslt){
		this.xslt = xslt;
	}

	public String getXslt(){
		return xslt;
	}

	public void setPubDateTime(String pubDateTime){
		this.pubDateTime = pubDateTime;
	}

	public String getPubDateTime(){
		return pubDateTime;
	}

	@Override
 	public String toString(){
		return 
			"Internal{" + 
			"eventName = '" + eventName + '\'' + 
			",xslt = '" + xslt + '\'' + 
			",pubDateTime = '" + pubDateTime + '\'' + 
			"}";
		}
}