package com.codingtest.practice.prac202209;

import java.util.*;
import java.util.Map.Entry;

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

        // 20220926 hashmap List가 있어야할것 같다.
        List<HashMap<Integer,Integer>> studentScoreList = new ArrayList<>();


        //학생구분을 위한 "학생번호:점수" 식으로 map으로 변경
        for(int i=0; i<sportsCnt; i++) {
            HashMap<Integer,Integer> studentScoreMap = new HashMap<>();
            for(int j=0; j<studentCnt; j++) {
                studentScoreMap.put(j+1,ability[j][i]);
            }
            studentScoreList.add(studentScoreMap);
        }

        //java.util.Arrays.deepToString() 메소드를 이용하면
        //간단하게 2차원 배열의 값을 문자열로 반환받아서 출력할 수 있다.

        System.out.println("List뽑아보기:"+studentScoreList.toString());

        //int 배열 : 내림차순 정렬
        //방법1
        //Integer[] IntegerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        //Arrays.sort(IntegerArr, Collections.reverseOrder());
        //int intarray[] = Arrays.stream(IntegerArr).mapToInt(i->i).toArray();
        //방법2
        //arr = Arrays.stream(IntegerArr).boxed().sorted(Collections.reverseOrder())
        //.mapToInt(Integer::intValue).toArray();

        //string 배열 : 내림차순 정렬
        // Arrays.sort(arr2, Collections.reverseOrder());

        //MAP value로 내림차순 정렬
        List<HashMap<Integer,Integer>> sortedMapList = new ArrayList<>();
        for(int i=0; i<studentScoreList.size(); i++) {
            Map<Integer, Integer> beforeSortMap = studentScoreList.get(i);
            List<Integer> keySet = new ArrayList<>(beforeSortMap.keySet());
            Collections.sort(keySet, (value1, value2) -> (beforeSortMap.get(value2).compareTo(beforeSortMap.get(value1))));


            HashMap<Integer, Integer> tempMap = new HashMap<>();
            int tempCnt= 0 ;
            for(Integer key : keySet) {
                if(tempCnt < cutLen){
                    tempMap.put(key,beforeSortMap.get(key));
                }
                tempCnt++;
                System.out.println("key: "+key+",value: "+beforeSortMap.get(key));
            }
            System.out.println();
            sortedMapList.add(tempMap);
        }

        //220928 정렬후 최소한의 숫자로 잘라서 Hashmap에 넣고 List로 만들었다.
        System.out.println("정렬후 List뽑아보기:"+sortedMapList.toString());


        //종목수만큼 짜르기(꼭 안해도될 비교하지않게)
        //배열자르기
        //int[] arr = {0,1,2,3,4,5};
        //int position = 3;
        //int[] arr1 = Arrays.copyOfRange(arr,0,position);
        //int[] arr2 = Arrays.copyOfRange(arr,position,arr.length);
        //arr1 -> [0,1,2]
        //arr2 -> [3,4,5]
/*
        for(int i=0; i<sportsCnt; i++) {
            score[i] = Arrays.copyOfRange(score[i],0,cutLen);
        }
        System.out.println("자른후:"+Arrays.deepToString(score));
*/
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
