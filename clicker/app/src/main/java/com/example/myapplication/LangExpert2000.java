package com.example.myapplication;

public class LangExpert2000 {
    public Integer getDesc (String lang){
        switch (lang.toLowerCase()){
            case "-1":
                return -1;
            case "1":
                return 1;
            case "2":
                return 2;
            case "5":
                return 5;
            case "10":
                return 10;
            case "100":
                return 100;
            default:
                return 1;
        }
    }
}