package com.krotos;

import java.time.LocalTime;

public class Clock {
    private LocalTime time;

    public Clock() {
        time = LocalTime.of(0, 0);
    }

    public Clock(int hours, int minutes) {
        time = LocalTime.of(hours, minutes);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(int hours, int minutes) {
        this.time = LocalTime.of(hours, minutes);
    }

    public void addMinutes(int minutes) {
        time = time.plusMinutes(minutes);
    }

    public void subtractMinutes(int minutes) {
        time = time.minusMinutes(minutes);
    }

    public void addClock(Clock clock) {
        time = time.plusHours(clock.getTime().getHour()).plusMinutes(clock.getTime().getMinute()).plusSeconds(clock.getTime().getSecond());
    }


}
