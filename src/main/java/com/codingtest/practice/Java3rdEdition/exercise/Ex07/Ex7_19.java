package com.codingtest.practice.Java3rdEdition.exercise.Ex07;

/*
* 7-21
* Movable, ObjectX
* null, Movable인터페이스를 구현한 클래스 또는 그 자손의 인스턴스
* */
public class Ex7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
/*        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());*/

        b.summary();
    }
}

class Buyer {
    int money = 1000;
    Product[] cart = new Product[3];
    int i = 0;

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("잔액이 부족하여 "+p+"을/를 살수 없습니다.");
            return;
        }

        money -= p.price;
        add(p);

    }

    void add(Product p) {
        if(i >= cart.length) {

            Product[] cart2 = new Product[cart.length*2];
            System.arraycopy(cart,0,cart2,0,cart.length);
            cart = cart2;
        }

        cart[i] = p;
        i++;
    }

    void summary() {
        System.out.print("구입한 물건:");
        int buyMoney = 0;
        for(int i=0; i<cart.length; i++) {
            if(cart[i] == null) break;
            System.out.print(cart[i].toString() + ",");
            buyMoney += cart[i].price;
        }
        System.out.print("\n사용한 금액:" + buyMoney);
        System.out.print("\n남은 금액:" + (money));
    }
}

class Product {
    int price ;

    Product(int price) {
        this.price = price;
    }
}

class Tv extends Product {
    Tv() {super(100);}

    public String toString() {return "Tv";}
}

class Computer extends Product {
    Computer() { super(200); }

    public String toString() { return "Computer"; }
}

class Audio extends Product {
    Audio() { super(50); }

    public String toString() {return "Audio"; }
}