package com.codingtest.practice.Java3rdEdition.exercise.Ex06;

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student() {}

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    public int getTotal() {
        return kor + eng + math;
    }

    public float getAverage() {
        //return Math.round(getTotal()/3.0f* 10 + 0.05f)  / 10.0f;
        return Math.round(getTotal()/3f * 10 + 0.5f) / 10f;
    }

    public String info() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
    }
}
public class Ex6_3 {
    public static void main(String[] args) {
        Student s = new Student("홍길동",1,1,100,60,76);
        System.out.println(s.info());

    }
}
