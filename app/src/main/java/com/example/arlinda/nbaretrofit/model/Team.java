package com.example.arlinda.nbaretrofit.model;

import java.io.Serializable;

public class Team implements Serializable {
    String teamId;
    String teamName;
    String imgURL;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }

    public Team(String teamId, String teamName, String imgURL) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.imgURL = imgURL;
    }
}
