package com.codingtest.practice.baekjoon.Algorithm.bfs;

import java.util.*;

/*
* equals와 hashCode는 왜 같이 재정의해야 할까?
*
*
* Object 클래스의 hashCode 메서드는 객체의 고유한 주소 값을 int 값으로 변환하기 때문에
* 객체마다 다른 값을 리턴한다. 두개의 Car 객체는 equals로 비교도 하기 전에 서로 다른 hashCode 메서드의
* 리턴값으로 인해 다른 객체로 판단된 것이다.
*
*
* */

public class Car {
	private final String name;

	public Car(String name) {
		this.name = name;
	}

	// intellij Generate 기능 사용
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public static void main(String[] args){
		Set<Car> cars = new HashSet<>();
		List<Car> carList = new ArrayList<>();
		cars.add(new Car("foo"));
		cars.add(new Car("foo"));
		if(carList.contains("test")) {

		}
		// true 출력
		System.out.println(cars.size());
	}
}