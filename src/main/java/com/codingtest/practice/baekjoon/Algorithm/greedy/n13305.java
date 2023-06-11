package com.codingtest.practice.baekjoon.Algorithm.greedy;

import java.io.*;

public class n13305 {
    public static void main(String[] args) throws IOException {


        int cityCnt = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cityCnt = Integer.parseInt(bf.readLine());
        long[] distance = new long[cityCnt-1];
        long[] oilPrice = new long[cityCnt];

        String[] tempD = bf.readLine().split(" ");

        for(int i=0; i<distance.length; i++) {
            distance[i] = Long.parseLong(tempD[i]);
        }

        String[] tempP = bf.readLine().split(" ");

        for(int i=0; i<oilPrice.length; i++) {
            oilPrice[i] = Long.parseLong(tempP[i]);
        }

        long totalPrice = 0;
        long minCost = oilPrice[0];

        for(int i=0; i<cityCnt - 1; i++) {
            if(oilPrice[i] < minCost) {
                minCost = oilPrice[i];
            }

            totalPrice += (minCost * distance[i]);
        }


        /*long nowPrice = 0;
        long minPrice = 0;
        long totalPrice = 0;

        Loop1 :
        for(int i=0; i<oilPrice.length - 2; i++) {


            nowPrice = oilPrice[i];
            long[] sortArr = Arrays.copyOfRange(oilPrice, i, oilPrice.length - 2);
            //Integer[] beforeSortArr = Arrays.stream(oilPrice).boxed().toArray(Integer[]::new);

            Arrays.sort(sortArr);
            minPrice = sortArr[0];

            //System.out.println(Arrays.toString(beforeSortArr));
            //System.out.println(Arrays.toString(sortArr));


            //int minIdx = Arrays.asList(beforeSortArr).indexOf(minPrice);
            //System.out.println("i:"+i+", nowPrice:"+nowPrice +",minPrice:"+minPrice+ ",minIdx:"+ minIdx);


            if(nowPrice > minPrice) {
                //System.out.println("nowPrice:"+nowPrice+", distance["+i+"]:"+distance[i]);
                totalPrice += nowPrice * distance[i];
                //System.out.println("1:totalPrice"+totalPrice);
            } else {
                //System.out.println("@@@:"+(distance.length - 1)+",minIdx:"+minIdx);
                for(int j=i; j<distance.length - 1; j++) {
                    //System.out.println("j:"+j);
                    //System.out.println("nowPrice:"+nowPrice+", distance["+j+"]:"+distance[j]);
                    totalPrice += nowPrice * distance[j];
                    //System.out.println("2:totalprice:"+totalPrice);

                    //System.out.println("@@j:"+(j + 1)+",oilPricelen:"+ (oilPrice.length - 2));
                    if((j+1) == (oilPrice.length - 2)) {
                        if(minPrice >= oilPrice[oilPrice.length - 2]) {
                            totalPrice += oilPrice[oilPrice.length - 2] * distance[j+1];
                        } else {
                            totalPrice += minPrice * distance[j+1];
                        }
                    }

                }

                break Loop1;
            }





        }*/




        bw.write(String.valueOf(totalPrice));
        bw.flush();


    }
}
