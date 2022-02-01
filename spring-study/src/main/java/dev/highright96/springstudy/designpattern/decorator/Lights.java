package dev.highright96.springstudy.designpattern.decorator;

public class Lights extends TreeDecorator {

    public Lights(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String getDecorations() {
        return super.getDecorations() + "전구 ";
    }
}
