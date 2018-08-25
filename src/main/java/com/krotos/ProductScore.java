package com.krotos;

public class ProductScore {
    private short score;
    private static final short MIN = 0;
    private static final short MAX = 5;

    public void setScore(short score) {
        if (score < MIN || score > MAX) {
            throw new IllegalArgumentException();
        }
        this.score = score;
    }

    public short getScore() {
        return score;
    }

}
