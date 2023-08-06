package com.codingtest.practice.docs.d2023;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;

/*
  HttpSessionListener
  Implementations of this interface are notified of changes to the list of
  active sessions in a web application. To receive notification events, the
  implementation class must be configured in the deployment descriptor for the
  web application.

  이 인터페이스의 구현은 웹애플리케이션의 활성 세션 목록에 대한 변경사항을 알립니다.
  변경사항 알림을 수신하려면, 배포서술자(WEB-INF/web.xml)에서 구현 클래스를 구성해야 합니다.



* */

public class d230805 {

}

@WebListener
class SessionConfig implements HttpSessionListener {


}
