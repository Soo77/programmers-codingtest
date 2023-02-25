package com.codingtest.practice.Java3rdEdition.exercise.Ex08;
/*
*
* 8-10
* 2 4 7
*
* */
class UnsupportedFuctionException extends RuntimeException {
    final private int ERR_CODE;

    UnsupportedFuctionException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    UnsupportedFuctionException(String msg) {
        this(msg, 100);
    }

    public int getERR_CODE() {
        return ERR_CODE;
    }

    public String getMessage() {
        return "[" + ERR_CODE + "]" + super.getMessage();
    }
}

public class Ex8_9 {
    public static void main(String[] args) throws Exception
    {
        throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
    }
}
