package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {
    private boolean timeUp = false;
    private Timer timer;

    public void startTimer(int seconds) {
        timer = new Timer();
        timeUp = false;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
            }
        }, seconds * 1000);
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public boolean isTimeUp() {
        return timeUp;
    }
}
