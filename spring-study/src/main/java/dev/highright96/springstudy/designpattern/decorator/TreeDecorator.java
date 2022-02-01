package dev.highright96.springstudy.designpattern.decorator;

abstract public class TreeDecorator implements ChristmasTree {

    private ChristmasTree christmasTree;

    public TreeDecorator(ChristmasTree christmasTree) {
        this.christmasTree = christmasTree;
    }

    @Override
    public String getDecorations() {
        return christmasTree.getDecorations();
    }
}
