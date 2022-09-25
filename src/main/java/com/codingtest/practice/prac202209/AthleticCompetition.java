package com.codingtest.practice.prac202209;

import java.util.*;

public class AthleticCompetition {

    public static int solution(int[][] ability) {
        int answer = 0;

        int sportsCnt = ability[0].length;//3
        int studentCnt = ability.length;//5

        int cutLen = 0;
        if(studentCnt >= sportsCnt) {
            cutLen = sportsCnt;
        } else {
            cutLen = studentCnt;
        }

        int[][] score = new int[sportsCnt][studentCnt];
        //int[][] score = new int[studentCnt][sportsCnt];

        for(int i=0; i<sportsCnt; i++) {
            for(int j=0; j<studentCnt; j++) {
                score[i][j] = ability[j][i];
            }
        }

        //java.util.Arrays.deepToString() 메소드를 이용하면
        //간단하게 2차원 배열의 값을 문자열로 반환받아서 출력할 수 있다.
        System.out.println("이차원배열뽑기:"+Arrays.deepToString(score));
        System.out.println("그럼 이건 몬데?"+Arrays.toString(score[0]));
        System.out.println("그럼 이건 몬데?"+Arrays.toString(score[1]));

        //내림차순 정렬
        //방법1
        //Integer[] IntegerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        //Arrays.sort(IntegerArr, Collections.reverseOrder());
        //int intarray[] = Arrays.stream(IntegerArr).mapToInt(i->i).toArray();
        //방법2
        //arr = Arrays.stream(IntegerArr).boxed().sorted(Collections.reverseOrder())
        //.mapToInt(Integer::intValue).toArray();

        for(int i=0; i<sportsCnt; i++) {
            Integer[] tempArr = Arrays.stream(score[i]).boxed().toArray(Integer[]::new);
            Arrays.sort(tempArr, Collections.reverseOrder());
            score[i] = Arrays.stream(tempArr).mapToInt(Integer::intValue).toArray();
        }
        System.out.println("뽑아보갔어:"+Arrays.deepToString(score));

        //종목수만큼 짜르기(꼭 안해도될 비교하지않게)
        //배열자르기
        //int[] arr = {0,1,2,3,4,5};
        //int position = 3;
        //int[] arr1 = Arrays.copyOfRange(arr,0,position);
        //int[] arr2 = Arrays.copyOfRange(arr,position,arr.length);
        //arr1 -> [0,1,2]
        //arr2 -> [3,4,5]
        for(int i=0; i<sportsCnt; i++) {
            score[i] = Arrays.copyOfRange(score[i],0,cutLen);
        }
        System.out.println("자른후:"+Arrays.deepToString(score));
        //오 잘 잘라졌다!!! 뜨헉
        //아 사람 안겹치게 해야하는데...ㅎ. .ㅎ.ㅎ.어떻게해야하지?



        return answer;
    }

    public static void main(String[] args) {

        int[][] ability1 = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int[][] ability2 = {{20, 30}, {30, 20}, {20, 30}};



        int answer = AthleticCompetition.solution(ability1);
        int answer2 = AthleticCompetition.solution(ability2);
        System.out.println("답은?"+answer);
        System.out.println("답은?"+answer2);

    }
}
