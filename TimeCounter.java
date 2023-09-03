package org.example;

public class  TimeCounter {
    private boolean isRunning = false;
    private int seconds = 0;
    private Thread timerThread;
    public void startTimer() {
        isRunning = true;
        timerThread = new Thread(() -> {
            while (isRunning) {
                try {
                    Thread.sleep(1000);
                    seconds++;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }
    public void stopTimer() {
        isRunning = false;
        try {
            timerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getElapsedTime() {
        return seconds;
    }
    public void resetTimer() {
        seconds = 0;
    }
}