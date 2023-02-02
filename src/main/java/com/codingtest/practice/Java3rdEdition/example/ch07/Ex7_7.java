package com.codingtest.practice.Java3rdEdition.example.ch07;

class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrr~");
    }

    void stop() {
        System.out.println("stop!!!!");
    }
}

class FireEngine extends Car { // 소방차
    void water() {
        System.out.println("water!!!");
    }
}

public class Ex7_7 {
    public static void main(String[] args) {
        Car car = new Car();
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;
        //FireEngine fe3 = (FireEngine)car;
        if(fe instanceof Car) {
            System.out.println("11true");
            fe = (FireEngine)car;
            System.out.println(fe.toString());
        }
        //System.out.println(fe3.toString());

        fe.water();

        if(fe instanceof FireEngine) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        car = fe; // car = (Car)fe; 에서 형변환이 생략됨.
        //car.water(); //컴파일 에러!! Car타입의 참조변수로는 water()를 호출할 수 없다.
        fe2 = (FireEngine)car; // 자손타입 <- 조상타입. 형변환 생략 불가.
        fe2.water();

        System.out.println((int)10.99999);
    }
}
