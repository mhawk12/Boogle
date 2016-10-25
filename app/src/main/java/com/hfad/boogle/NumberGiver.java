package com.hfad.boogle;

import java.util.Random;

/**
 * Created by Nishant on 10/22/16.
 */

public class NumberGiver {

    //String[] charArray = new String[49];
   // StringBuilder x = new StringBuilder();
    public int[] getAllNumbers()
    {
        int[] randomNumbers = new int[64];
        Random rand = new Random();
        for(int i =0 ;i< 64 ;i++ )
           // randomNumbers[i] =rand.nextInt((700 - 0) + 1) + 0;
            randomNumbers[i] =rand.nextInt((699 - 17) + 1) + 17;

            return randomNumbers;
    }

    /*public int[][] getAllNumbersin2D()
    {
        int[][] int2DArray = new int[8][8];
        int[] randomNumbers = new int[64];
        randomNumbers = getAllNumbers();
        int k=0;
        for(int i = 0; i< 8; i++)
        {
            for(int j =0; j < 8; j++)
            {
             int2DArray[i][j]= randomNumbers[k];
          //    x.append(String.valueOf(int2DArray[i][j]));
                k++;
            }
        }
        return  int2DArray;
    }/*

/*
    public int getRandomX()
    {
        Random rand = new Random();
        return (rand.nextInt((5 - 1) + 1) + 1);
    }

    public int getRandomY()
    {
        Random rand = new Random();
        return (rand.nextInt((5 - 1) + 1) + 1);
    }

*/

}
