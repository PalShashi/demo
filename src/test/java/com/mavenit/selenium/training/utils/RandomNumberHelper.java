package com.mavenit.selenium.training.utils;

import java.util.Random;

public class RandomNumberHelper {


    public int generateRandomNumber(int size)
    {
        return new Random().nextInt(size-1);
    }

    public void generateRN(int size){
        Random r =new Random();
        r.nextInt(size-1);
    }
}
