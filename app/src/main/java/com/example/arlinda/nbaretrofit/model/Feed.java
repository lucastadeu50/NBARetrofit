package com.example.arlinda.nbaretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed {
    public Internal get_internal() {
        return _internal;
    }

    public void set_internal(Internal _internal) {
        this._internal = _internal;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "_internal=" + _internal +
                ", league=" + league +
                '}';
    }

    @SerializedName("_internal")
    @Expose
    private Internal _internal;
    @SerializedName("league")
    @Expose
    private League league;
}
