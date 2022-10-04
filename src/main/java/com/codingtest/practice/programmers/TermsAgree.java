package com.codingtest.practice.prac202209;

import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

public class TermsAgree {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int [terms.length];
        Calendar cal = Calendar.getInstance();
        List<Integer> answerList = new ArrayList<>();

        int todayYear = Integer.parseInt(today.substring(0,4));
        int todayMonth = Integer.parseInt(today.substring(5,7));
        int todayDate = Integer.parseInt(today.substring(8,10));

        HashMap<String, Integer> termPeriodMap = new HashMap<>();
        for(String s : terms) {
            String termName = s.split(" ")[0];
            int period = Integer.parseInt(s.split(" ")[1]);
            termPeriodMap.put(termName, period);
        }

        for (int i = 0; i < privacies.length; i++) {
            String startDate = privacies[i].split(" ")[0];
            int year = Integer.parseInt(startDate.substring(0,4));
            int month = Integer.parseInt(startDate.substring(5,7));
            int date = Integer.parseInt(startDate.substring(8,10));
            String term = privacies[i].split(" ")[1];

            cal.set(year,month,date);

            int termPeriod = termPeriodMap.get(term);
            cal.add(Calendar.MONTH,termPeriod);
            Calendar resultCal = Calendar.getInstance();

            if(date == 1) {
                resultCal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, 28);
            } else {
                resultCal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)-1);
            }

            Date fianlEndDate = null;
            if(resultCal.get(Calendar.MONTH) == 0) {
                if(cal.get(Calendar.DATE) == 1) {
                    fianlEndDate = new Date((cal.get(Calendar.YEAR)-1),12,28);
                } else {
                    fianlEndDate = new Date((cal.get(Calendar.YEAR)-1),12,(cal.get(Calendar.DATE)-1));
                }
            } else {
                fianlEndDate = new Date(resultCal.get(Calendar.YEAR),resultCal.get(Calendar.MONTH),resultCal.get(Calendar.DATE));
            }

            Date todayDATE = new Date(todayYear,todayMonth,todayDate);
            int compareValue = todayDATE.compareTo(fianlEndDate);

            if(compareValue == 1) {
                answerList.add(i+1);
            }

        }

        int[] finalAnswer = new int[answerList.size()];
        for(int i=0; i<finalAnswer.length; i++) {
            finalAnswer[i] = answerList.get(i);
        }


        return finalAnswer;
    }

    public static void main(String[] args) {

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3", "D 8"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        //String[] privacies = {"2021.05.01 D","2021.12.03 B", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int answer[] = TermsAgree.solution(today, terms, privacies);
        int answer2[] = TermsAgree.solution(today2, terms2, privacies2);
        for(Integer i : answer) {
            System.out.print(i + ", ");
        }

        for(Integer i : answer2) {
            System.out.print(i + ", ");
        }
    }
}
