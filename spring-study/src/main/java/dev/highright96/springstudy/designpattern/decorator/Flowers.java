package dev.highright96.springstudy.designpattern.decorator;

public class Flowers extends TreeDecorator {

    public Flowers(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String getDecorations() {
        return super.getDecorations() + "꽃 ";
    }
}
