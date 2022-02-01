package dev.highright96.springstudy.designpattern.decorator;

public class Main {

    public static void main(String[] args) {
        ChristmasTree tree = new DefaultChristmasTree();
        System.out.println(tree.getDecorations());

        ChristmasTree treeWithLights = new Lights(new DefaultChristmasTree());
        System.out.println(treeWithLights.getDecorations());

        ChristmasTree treeWithLightsAndFlowers = new Flowers(new Lights(new DefaultChristmasTree()));
        System.out.println(treeWithLightsAndFlowers.getDecorations());
    }
}
