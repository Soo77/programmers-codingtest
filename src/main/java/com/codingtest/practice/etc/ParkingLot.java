package com.codingtest.practice.etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//프로그래머스 주차문제
public class ParkingLot {


    public static int[] solution(int[] fees, String[] records)  {
        int[] answer = {};

        HashMap<String,List<String>> timeMap = new HashMap<>();

        for(int i=0; i<records.length; i++) {
            List<String> timeList = new ArrayList<>();
            String time = records[i].split(" ")[0];
            String car = records[i].split(" ")[1];
            if(!timeMap.isEmpty()) {
                if(timeMap.containsKey(car)) {
                    timeList = timeMap.get(car);
                    timeList.add(time);
                } else {
                    timeList.add(time);
                }
                timeMap.put(car,timeList);
            } else {
                timeList.add(time);
                timeMap.put(car,timeList);
            }


        }
        List<Integer> answerList = new ArrayList<>();
        HashMap<String,Integer> finalAnswerMap = new HashMap<>();
        timeMap.forEach((key,value) -> {
            String carNum = key;
            List<String> timeList = value;
            int len = timeList.size();
            int timeCnt = 0;

            if(timeList.size()%2==0) { //출차해서 주차장에 차가 없는 경우
                for(int i=0; i<len/2; i++) {

                    String date1 = timeList.get((i*2)+1);
                    String date2 = timeList.get(i*2);
                    Date format1 = null;
                    try {
                        format1 = new SimpleDateFormat("hh:mm").parse(date1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Date format2 = null;
                    try {
                        format2 = new SimpleDateFormat("hh:mm").parse(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    long diffMin = (format1.getTime() - format2.getTime()) / 60000;
                    timeCnt+=diffMin;
                }
            } else { // 아직 주차장에 남아있어서 23:59까지 계산할경우
                for(int i=0; i<=len/2; i++) {

                    String date1 = "";
                    if((i*2)+1 > len/2) {
                        date1 = "23:59";
                    } else {
                        date1 = timeList.get((i*2)+1);
                    }
                    String date2 = timeList.get(i*2);

                    Date format1 = null;
                    try {
                        format1 = new SimpleDateFormat("hh:mm").parse(date1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Date format2 = null;
                    try {
                        format2 = new SimpleDateFormat("hh:mm").parse(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    long diffMin = (format1.getTime() - format2.getTime()) / 60000;
                    timeCnt+=diffMin;
                }
            }
            int total = 0;
            int base = fees[0];
            int basefee = fees[1];
            double plustime = fees[2];
            int plusfee = fees[3];
            if(timeCnt >= base) {
                total += basefee + (int)Math.ceil((timeCnt-base)/plustime) * plusfee;
            } else {
                total = basefee;
            }
            //answerList.add(total);
            finalAnswerMap.put(key, total);
        });

        List<String> keySet = new ArrayList<>(finalAnswerMap.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        for (String key : keySet) {
            answerList.add(finalAnswerMap.get(key));
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

        Date format1 = new SimpleDateFormat("HH:mm").parse(date1);
        Date format2 = new SimpleDateFormat("HH:mm").parse(date2);

        long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
        long diffMin = (format1.getTime() - format2.getTime()) / 60000; //분 차이
        long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //시 차이
        long diffDays = diffSec / (24*60*60); //일자수 차이

        System.out.println(diffSec + "초 차이");
        System.out.println(diffMin + "분 차이");
        System.out.println(diffHor + "시 차이");
        System.out.println(diffDays + "일 차이");


        System.out.println("result: "+ Arrays.toString(result));
        System.out.println("result2: "+ Arrays.toString(result2));
        System.out.println("result3: "+ Arrays.toString(result3));

    }
}
