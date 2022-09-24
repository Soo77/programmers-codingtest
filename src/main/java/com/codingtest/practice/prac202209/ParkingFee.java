package com.codingtest.practice.prac202209;

import java.util.HashMap;

public class ParkingFee {


    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        // 기본요금
        int basicFee = fees[1];
        System.out.println(basicFee);

        HashMap<String, String[]> carNumMap = new HashMap<>();

        for(String s : records) {
            String carNum = s.split(" ")[1];
            if(!carNumMap.containsKey(carNum)) {
                carNumMap.put(carNum, records);
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(ParkingFee.solution(fees, records));
    }
}
