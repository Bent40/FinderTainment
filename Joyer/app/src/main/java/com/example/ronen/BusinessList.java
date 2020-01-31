package com.example.ronen;

import java.util.ArrayList;

public class BusinessList {
    ArrayList<Business> Bitches;

    public BusinessList() {
    }

    public BusinessList(ArrayList<Business> bitches) {
        Bitches = bitches;
    }

    public ArrayList<Business> getBitches() {
        return Bitches;
    }

    public void setBitches(ArrayList<Business> bitches) {
        Bitches = bitches;
    }
}
