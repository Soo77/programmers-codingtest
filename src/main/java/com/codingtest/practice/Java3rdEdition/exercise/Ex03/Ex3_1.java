package com.codingtest.practice.Java3rdEdition.exercise.Ex03;

public class Ex3_1 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        char c = 'A';

        System.out.println(1 + x << 33);
        // 3 << 33
        System.out.println(y >= 5 || x <0 && x > 2);
        // &&는 or 보다 우선순위가 높다.
        System.out.println(y += 10  - x++);
        // y = y + (10 - 2) = 5+8=13 // x = 3
        System.out.println(x+=2);
        // 4XX
        // x = x+2 = 5
        System.out.println(!('A' <= c && c<= 'Z'));
        // trueXX
        // false
        System.out.println('C'-c);
        // 32
        // 'C' - 'A' = 2
        System.out.println('5'-'0'); //53 - 48 = 5
        System.out.println(c+1);
        // 65+1 = 66
        /*
        * 'A'+1 이항연산자의 성질(int보다 작은 타입은 int로 변환 후 연산)
        * 때문에 'A'는 문자코드 값인 65로 변환되어 '65+1'을 수행하여
        * 66을 결과로 얻는다.
        * */
        System.out.println(++c);
        // 66XX
        /*
        * 단항연산자인 '++'은 이항연산자와 달리 int보다 작은 타입도 형변환을 하지 않는다.
        * (이항연산자는 연산을 위해 피연산자 스택을 사용하는데 이 과정에서 형변환이 발생하는 것이다.
        * 반면에, 단항연산자인 증가연산자 ++ 는 피연산자스택을 사용하지 않으므로 형변환도
        * 발생하지 않는다.) 그래서 println은 변수 c를 숫자(int)로 출력하는 것이 아니라 문자로 출력한다.
        * 변수 c에 저장된 문자가 'A' 이므로 문자코드의 값이 1 증가되어 66이  변수 c에
        * 저장된다.
        * 변수 c에 저장된 것은 문자코드, 즉 정수값이다. println은 이 값을 타입에 따라
        * 어떻게 출력할지를 결정한다. 만일 문자타입이면 저장된 값(문자코드)에 해당하는
        * 문자를 출력하고 숫자라면 숫자로 출력한다.
        *
        *
        *
        * */
        System.out.println(c++);
        //66XX
        /*
        * 단항연산자++이 후휘형인 경우에는 println()에 의해서 변수 c가
        * 출력된 후에 c에 저장된 값이 증가하므로 문자 'B'가 출력된 후에
        * 변수 c의 값이 1증가해서 문자 'C'가 저장된다.
        *
        * */
        System.out.println(c); //
    }
}
