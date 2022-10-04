package com.codingtest.practice.prac202209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AthleticCompetition3 {

    //새로운 마음으로 다시..
    public static int solution(int[][] ability) {
        int answer = 0;

        int sportsCnt = ability[0].length;
        int studentCnt = ability.length;

        List<List<Integer>> allScoreList = new ArrayList<>();

        int[] standardStudentNumArr = new int[sportsCnt];
        // 과목별 최고점을 가진 학생 인덱스를 구해서 과목 수만큼의 배열에 넣음.
        for(int i=0; i<sportsCnt; i++) {

            List<Integer> studentScoreList = new ArrayList<>();
            for(int j=0; j<studentCnt; j++) {
                studentScoreList.add(ability[j][i]);
            }
            allScoreList.add(studentScoreList);
            int index = studentScoreList.indexOf(Collections.max(studentScoreList));
            standardStudentNumArr[i] = index;

        }

        List<Integer> scoreList = new ArrayList<>();
        for(int i=0; i<sportsCnt; i++) {
            int scoreSum = 0;
            List<Integer> tempScoreList = allScoreList.get(i);
            int highestStudentNum = standardStudentNumArr[i];
            scoreSum += tempScoreList.get(highestStudentNum);
            for(int j=0; j<sportsCnt-1; j++) {
                tempScoreList.remove(highestStudentNum);
                highestStudentNum = tempScoreList.indexOf(Collections.max(tempScoreList));
                scoreSum += tempScoreList.get(highestStudentNum);
            }
            scoreList.add(scoreSum);
        }
        answer = Collections.max(scoreList);
        return answer;
    }

    public static void main(String[] args) {

        int[][] ability1 = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int[][] ability2 = {{20, 30}, {30, 20}, {20, 30}};



        int answer = AthleticCompetition3.solution(ability1);
        int answer2 = AthleticCompetition3.solution(ability2);
        System.out.println("답은?"+answer);
        System.out.println("답은?"+answer2);

    }
}
