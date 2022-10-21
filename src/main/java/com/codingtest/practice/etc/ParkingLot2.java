package com.codingtest.practice.etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
8888
//프로그래머스 주차문제
public class ParkingLot2 {


    public static int[] solution(int[] fees, String[] records) throws ParseException {
        int[] answer = {};

        HashMap<String, Integer> carNumMap = new HashMap<>();
        int lastTimeMin = 0;
        String date2 = "23:59";
        Date format2 = new SimpleDateFormat("HH:mm").parse(date2);
        long lastTime = ((format2.getTime() / 60000) +540);  //분으로 변환
        lastTimeMin = (int)lastTime;
        System.out.println("lastTimeMin:"+lastTimeMin);
        for(int i=0; i<records.length; i++) {
            String time = records[i].split(" ")[0];
            String carNum = records[i].split(" ")[1];
            String inout = records[i].split(" ")[2];

            String date = time;

            Date format = new SimpleDateFormat("HH:mm").parse(date);
            long min = ((format.getTime() / 60000) +540); //분으로 변환
            int intMin = (int)min;

            if(!carNumMap.isEmpty() && carNumMap.containsKey(carNum)) {

                if(inout.equals("IN")) {
                    carNumMap.put(carNum,carNumMap.get(carNum)-intMin);
                } else {
                    carNumMap.put(carNum,carNumMap.get(carNum)+intMin);
                }

            } else {
                carNumMap.put(carNum,-intMin);
            }




        }

        carNumMap.forEach((key,value) ->{
            if(value <= 0) {
                carNumMap.put(key, carNumMap.get(key) +1439);
            }

        });

        carNumMap.forEach((key,value) ->{
            System.out.println("계산전"+key+":"+value);
        });

        carNumMap.forEach((key,value) ->{

            int total = 0;
            int base = fees[0];
            int basefee = fees[1];
            double plustime = fees[2];
            int plusfee = fees[3];
            if(carNumMap.get(key) >= base) {
                total += basefee + (int)Math.ceil((carNumMap.get(key)-base)/plustime) * plusfee;
            } else {
                total = basefee;
            }
            //answerList.add(total);
            carNumMap.put(key, total);

        });

        carNumMap.forEach((key,value) ->{
            System.out.println("계산후"+key+":"+value);
        });

        List<Integer> answerList = new ArrayList<>();
        HashMap<String,Integer> finalAnswerMap = new HashMap<>();

        List<String> keySet = new ArrayList<>(carNumMap.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        for (String key : keySet) {
            answerList.add(carNumMap.get(key));
        }
        answer = answerList.stream().mapToInt(i->i).toArray();

        return answer;

    }

    public static void main(String[] args) throws ParseException {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"};

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};

        int[] fees3 = {1, 10, 1, 11};
        String[] records3 = {"00:00 1234 IN", "00:02 1234 OUT"};

        int[] result = solution(fees, records);
        int[] result2 = solution(fees2, records2);
        int[] result3 = solution(fees3, records3);

        String date1 = "11:00";
        String date2 = "13:30";
        String[] dateArr = {"11:00","13:30","09:00","06:00"};

        Date format1 = new SimpleDateFormat("HH:mm").parse(date1);
        Date format2 = new SimpleDateFormat("HH:mm").parse(date2);



        for(int i=0; i<dateArr.length; i++) {
            Date format = new SimpleDateFormat("HH:mm").parse(dateArr[i]);
            System.out.println(dateArr[i]+":"+((format.getTime()/60000)+540));
        }
        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24*60*60); //일자수 차이

        System.out.println("format1:"+format1.getTime()/60000);
        System.out.println("format2:"+format2.getTime()/60000);



        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");


        System.out.println("result: "+ Arrays.toString(result));
        System.out.println("result2: "+ Arrays.toString(result2));
        System.out.println("result3: "+ Arrays.toString(result3));

    }
}
