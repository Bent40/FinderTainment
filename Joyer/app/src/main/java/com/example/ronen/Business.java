package com.example.ronen;

public class Business {

    int BusinessID;
    String Name;
    String Address;
    float MatchPrecent;

    public Business() {
    }

    public Business(int businessID, String name, String address, float matchPrecent) {
        BusinessID = businessID;
        Name = name;
        Address = address;
        MatchPrecent = matchPrecent;
    }

    public int getBusinessID() {
        return BusinessID;
    }

    public void setBusinessID(int businessID) {
        BusinessID = businessID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getMatchPrecent() {
        return MatchPrecent;
    }

    public void setMatchPrecent(float matchPrecent) {
        MatchPrecent = matchPrecent;
    }
}
