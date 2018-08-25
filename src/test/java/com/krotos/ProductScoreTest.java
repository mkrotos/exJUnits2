package com.krotos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductScoreTest {
    ProductScore productScore;

    @BeforeEach
    public void beforeEach() {
        productScore = new ProductScore();
    }

    @Test
    public void create() {
        assertEquals(0, productScore.getScore());
    }

    @Test
    public void setScore() {
        productScore.setScore((short) 3);
        assertEquals(3, productScore.getScore());
    }

    @Test
    public void setScoreMoreThanMax() {
        assertThrows(IllegalArgumentException.class, () -> productScore.setScore((short) 7));
    }

    @Test
    public void setScoreLessThanMin() {
        assertThrows(IllegalArgumentException.class, () -> productScore.setScore((short) -3));
    }

    @Test
    public void setScoreMin() {
        productScore.setScore((short) 0);
        assertEquals(0, productScore.getScore());
    }

    @Test
    public void setScoreMax() {
        productScore.setScore((short) 5);
        assertEquals(5, productScore.getScore());
    }


//    Działa, ale rozwlekłe i nie odporne na błędy
//    @Test
//    public void create(){
//        ProductScore productScore=new ProductScore();
//        if(productScore.getScore()!=0){
//            throw new IllegalArgumentException();
//        }
//    }


}