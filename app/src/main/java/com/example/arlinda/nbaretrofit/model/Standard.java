package com.example.arlinda.nbaretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Standard {


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(String heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(String heightInches) {
        this.heightInches = heightInches;
    }

    public String getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(String heightMeters) {
        this.heightMeters = heightMeters;
    }

    public String getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(String weightPounds) {
        this.weightPounds = weightPounds;
    }

    public String getWeightKilograms() {
        return weightKilograms;
    }

    public void setWeightKilograms(String weightKilograms) {
        this.weightKilograms = weightKilograms;
    }

    public String getDateOfBirthUTC() {
        return dateOfBirthUTC;
    }

    public void setDateOfBirthUTC(String dateOfBirthUTC) {
        this.dateOfBirthUTC = dateOfBirthUTC;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personId='" + personId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", jersey='" + jersey + '\'' +
                ", isActive='" + isActive + '\'' +
                ", pos='" + pos + '\'' +
                ", heightFeet='" + heightFeet + '\'' +
                ", heightInches='" + heightInches + '\'' +
                ", heightMeters='" + heightMeters + '\'' +
                ", weightPounds='" + weightPounds + '\'' +
                ", weightKilograms='" + weightKilograms + '\'' +
                ", dateOfBirthUTC='" + dateOfBirthUTC + '\'' +
                '}';
    }

    @SerializedName("firstName")
    @Expose
    String firstName;

    @SerializedName("lastName")
    @Expose
    String lastName;

    @SerializedName("personId")
    @Expose
    String personId;

    @SerializedName("teamId")
    @Expose
    String teamId;

    @SerializedName("jersey")
    @Expose
    String jersey;

    @SerializedName("isActive")
    @Expose
    String isActive;



    @SerializedName("pos")
    @Expose
    String pos;


    @SerializedName("heightFeet")
    @Expose
    String heightFeet ;

    @SerializedName("heightInches")
    @Expose
    String heightInches ;

    @SerializedName("heightMeters")
    @Expose
    String heightMeters;

    @SerializedName("weightPounds")
    @Expose
    String weightPounds;

    @SerializedName("pubDateTime")
    @Expose
    String weightKilograms ;

    @SerializedName("dateOfBirthUTC")
    @Expose
    String dateOfBirthUTC;
}
