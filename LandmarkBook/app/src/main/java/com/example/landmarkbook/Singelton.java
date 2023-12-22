package com.example.landmarkbook;

public class Singelton {
    private Landmark sentLadmark;
    private static Singelton singelton;
    private Singelton(){}
    public Landmark getSentLadmark(){
        return sentLadmark;
    }
    public void setSentLadmark(Landmark sentLadmark){
        this.sentLadmark = sentLadmark;
    }
    public static Singelton getInstance(){
        if (singelton == null){
            singelton = new Singelton();
        }
        return singelton;
    }
}
