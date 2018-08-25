package com.krotos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {
    Clock clock;

    @BeforeEach
    public void before(){
        clock=new Clock();
    }
    @Test
    public void create(){
        assertEquals(0,clock.getTime().getHour());
        assertEquals(0,clock.getTime().getMinute());
        assertEquals(0,clock.getTime().getSecond());
    }
    @Test
    public void createWithProperParameters(){
        clock=new Clock(15,10);
        assertEquals(15,clock.getTime().getHour());
        assertEquals(10,clock.getTime().getMinute());
    }
    @Test
    public void createWithHoursLessThan0(){
        assertThrows(DateTimeException.class,()->clock=new Clock(-2,0));
    }
    @Test
    public void createWithHoursMoreThan23(){
        assertThrows(DateTimeException.class,()->clock=new Clock(24,0));
    }
    @Test
    public void createWithMinutesLessThan0(){
        assertThrows(DateTimeException.class,()->clock=new Clock(11,-2));
    }
    @Test
    public void createWithMinutesMoreThan59(){
        assertThrows(DateTimeException.class,()->clock=new Clock(11,66));
    }
    @Test
    public void addMinutes(){
        clock=new Clock(10,10);
        clock.addMinutes(20);
        assertEquals(30,clock.getTime().getMinute());
    }
    @Test
    public void addBigAmountOfMinutes(){
        clock=new Clock(10,10);
        clock.addMinutes(100);
        assertEquals(50,clock.getTime().getMinute());
        assertEquals(11,clock.getTime().getHour());
    }
    @Test
    public void addBiggestAmountOfMinutes(){
        clock=new Clock(10,10);
        clock.addMinutes(30000);
        assertEquals(10,clock.getTime().getMinute());
        assertEquals(6,clock.getTime().getHour());
    }
    @Test
    public void addNegativeMinutes(){
        clock=new Clock(20,20);
        clock.addMinutes(-10);
        assertEquals(10,clock.getTime().getMinute());
    }
    @Test
    public void subtractMinutes(){
        clock=new Clock(20,20);
        clock.subtractMinutes(10);
        assertEquals(10,clock.getTime().getMinute());
    }
    @Test
    public void addClockNull(){
        Clock nullClock=null;
        assertThrows(NullPointerException.class,()->clock.addClock(nullClock));
    }
    @Test
    public void addProperClock(){
        clock=new Clock(10,10);
        Clock newClock=new Clock(10,11);
        clock.addClock(newClock);
        assertEquals(20,clock.getTime().getHour());
        assertEquals(21,clock.getTime().getMinute());
    }
    @Test
    public void addBigClock(){
        clock=new Clock(10,10);
        Clock newClock=new Clock(10,55);
        clock.addClock(newClock);
        assertEquals(21,clock.getTime().getHour());
        assertEquals(5,clock.getTime().getMinute());
    }
    @Test
    public void addBiggestClock(){
        clock=new Clock(10,10);
        Clock newClock=new Clock(20,55);
        clock.addClock(newClock);
        assertEquals(7,clock.getTime().getHour());
        assertEquals(5,clock.getTime().getMinute());
    }

}