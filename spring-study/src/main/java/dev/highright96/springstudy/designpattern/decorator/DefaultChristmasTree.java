package dev.highright96.springstudy.designpattern.decorator;

public class DefaultChristmasTree implements ChristmasTree {

    @Override
    public String getDecorations() {
        return "크리스마스 트리 ";
    }
}
