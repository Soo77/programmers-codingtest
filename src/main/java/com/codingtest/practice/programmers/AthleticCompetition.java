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
            }
            sortedMapList.add(tempMap);
        }

        //220928 정렬후 최소한의 숫자로 잘라서 Hashmap에 넣고 List로 만들었다.

        //220929 Thinking...

        //220930 아악 회사에서 코딩했는데 못붙여넣었다.
        //어떻게 했냐면.. sort한 맵 리스트를 하나씩 돌아가며 hashmap을  기준으로삼고
        //기준 해쉬맵을 뺀 나머지 hashmap들을 또다른 리스트에 넣는다.
        //그리고 기준으로 삼은 해쉬맵에서 가장높은점수+나머지 해쉬맵에서 기준삼은 해쉬맵의 최고점수의 학생번호를 뺀 나머지 점수를
        //더하려고하는중이었는데.. 곧 입력하겠다.

        List<Integer> finalScoreList = new ArrayList<>();
        for(int i=0; i<sortedMapList.size(); i++) {
            List<HashMap<Integer,Integer>> theOtherMapList = new ArrayList<>();
            List<Integer> exceptStudentList = new ArrayList<>();

            int finalScore = 0;
            int highScoreStudent = Collections.max(sortedMapList.get(i).entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            exceptStudentList.add(highScoreStudent);
            finalScore += sortedMapList.get(i).get(highScoreStudent);
            for(int j=0; j<sortedMapList.size(); j++) {
                if(j!=i) {
                    theOtherMapList.add(sortedMapList.get(j));
                }
            }

            System.out.println(i+"번째를 제외한 맵의 리스트 theOtherMapList:"+theOtherMapList.toString());


            for(int j=0; j<theOtherMapList.size(); j++) {
                int tempScoreStudentNum = 0;
                //제거해야할 학생수만큼 돌며
                //제거할 학생을 제거하기(이렇게 말하니까 무섭다)
                //중복된 학생을 제거하기 ㅠㅠㅋㅋㅋ
                //말은 제거지만 값을 -1로 설정해주기
                for(int k=0; k<exceptStudentList.size(); k++)
                    if (theOtherMapList.get(j).containsKey(exceptStudentList.get(k))) {
                        int tempScore = theOtherMapList.get(j).get(exceptStudentList.get(k));
                        theOtherMapList.get(j).put(exceptStudentList.get(k), -1); //첫번째 높았던 학생점수를 100 -> -1으로 만들어버림
                        tempScoreStudentNum = Collections.max(theOtherMapList.get(j).entrySet(), Comparator.comparingInt(Entry::getValue)).getKey();

                        System.out.println("몇이신데요tempScoreStudentNum:" + tempScoreStudentNum);
                        //두번째로 높은 점수 더하게함.
                        finalScore += theOtherMapList.get(j).get(tempScoreStudentNum);
                        //exceptStudentList.add(tempScoreStudentNum);
                        //점수다시 되돌려주기
                        theOtherMapList.get(j).put(exceptStudentList.get(k), tempScore);
                    } else {
                        tempScoreStudentNum = Collections.max(theOtherMapList.get(j).entrySet(), Comparator.comparingInt(Entry::getValue)).getKey();
                        int tempScore = theOtherMapList.get(j).get(tempScoreStudentNum);
                        finalScore += tempScore;
                        //점수다시 되돌려주기
                        theOtherMapList.get(j).put(tempScoreStudentNum, tempScore);
                    }
                exceptStudentList.add(tempScoreStudentNum);
            }

            System.out.println("중복학생을 제거한 theOtherMapList:"+theOtherMapList.toString());
            System.out.println("highScoreStudent:"+highScoreStudent);
            System.out.println("finalScore:"+finalScore);
            System.out.println("exceptStudentList:"+exceptStudentList.toString());
            finalScoreList.add(finalScore);
        }


        System.out.println("파이널점수리스트:"+finalScoreList.toString());



        //종목수만큼 짜르기(꼭 안해도될 비교하지않게)
        //배열자르기
        //int[] arr = {0,1,2,3,4,5};.
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
        //int answer2 = AthleticCompetition.solution(ability2);
        System.out.println("답은?"+answer);
//        System.out.println("답은?"+answer2);

    }
}
