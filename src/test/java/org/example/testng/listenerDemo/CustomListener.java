package org.example.testng.listenerDemo;

import org.testng.IExecutionListener;

public class CustomListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        long endTime = System.currentTimeMillis();
        System.out.println("****   ***      finished execution at- " + endTime + "***  ***");

    }

    @Override
    public void onExecutionFinish() {
        long startTime = System.currentTimeMillis();
        System.out.println("****   ***      finished execution at- " + startTime + "***  ***");
    }
}
