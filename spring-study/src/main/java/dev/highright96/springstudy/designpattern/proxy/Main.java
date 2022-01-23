package dev.highright96.springstudy.designpattern.proxy;

public class Main {

    public static void main(String[] args) {
        Image image1 = new ProxyImage("test1.png");
        Image image2 = new ProxyImage("test2.png");

        //실제로 사용되는 시점에 로딩되고 보여준다
        image1.displayImage();
        System.out.println();
        image2.displayImage();
    }
}
