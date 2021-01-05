package com.codedifferently.hurt;

public class ErrorCounter {

    public static ErrorCounter instance;
    private int errorCount;
    private ErrorCounter(){}

    public int getErrorCount() {
        return errorCount;
    }

    public static ErrorCounter getInstance() {
        if(instance == null){
            instance = new ErrorCounter();
        }
        return instance;
    }
    public void incrementErrorCount(){
        errorCount++;
    }
}
