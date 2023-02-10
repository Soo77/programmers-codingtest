package com.codingtest.practice.Java3rdEdition.exercise.Ex02;


public class Ex2_9 {
    public static void main(String[] args) {

    }
}

/*
* 2-9
* byte b = 10; -128~127
* short s = 1; -32768~32767,
* char ch = 'A'; 0~65535
* int i = 100; -20억 ~ 20억
* long l = 1000L; ~800경 ~ 800경
* float f ; -3.4x10^38 ~ 3.4x10^38
* double d ;
* d , e
*
* 2-10 char타입의 변수에 저장될 수 있는 정수 값의 범위?
* 0~65535
* char는 2byte(2*8=16bit)이므로 '2의 16제곱'개의 값을 표현할 수 있다.
* 2의 16제곱은 65536개이며, 0을 포함해야하므로 0~65535(모두 65536개)가
* char범위가 된다.
*
* 2-11 다음중 변수를 잘못 초기화 한 것은?
* a, b, c, d'
* a. byte b = 256; // byte의 범위(-128~127)를 넘는 값으로 초기화 할 수 없음.
* b. char c = ''; // char는 반드시 한 개의 문자를 지정해야함.
* c. char answer = 'no'; // char에 두 개의 문자를 저장할 수 없음.
* d. float f = 3.14 // 접미사f를 붙이거나 형변환 필요.
* >> 접미사가 있는 자료형은 long, float, double 모두 세 개의 자료형이며,
* 접미사는 대소문자를 구별하지 않는다. double은 접미사를 생략할 수 있으므로
* float리터럴에는 반드시 접미사를 붙여야한다.
*
* 2-12
* public static void main(String[] args) a
* 배열을 의미하는 기혿인 '[]'는 타입 뒤에 붙여도 되고 변수명 뒤에 붙여도
* 되기 때문에 'String[] args'와 'String args[]'는 같은 뜻이다.
* 자세한 내용은 '5장 배열(Arrays)'에서 자세히 설명할 것이다.
* a,b,c,e
*
* 2-13 타입과 기본값
* float f = 0.0f;
* long l = 0L;
* String s = null;
*
*
*
* */