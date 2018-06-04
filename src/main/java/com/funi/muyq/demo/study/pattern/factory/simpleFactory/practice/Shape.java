package com.funi.muyq.demo.study.pattern.factory.simpleFactory.practice;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 19:54]
 */
public abstract class Shape {
    /**
     * 画图
     */
    public abstract void draw();

    /**
     * 擦除
     */
    public abstract void erase();

    public static Shape createShape(String name) throws UnsupportShapeException {
        Shape shape = null;
        if ("circle".equalsIgnoreCase(name)) {
            shape = new Circle();
        } else if ("square".equalsIgnoreCase(name)) {
            shape = new Square();
        } else if ("rectangle".equalsIgnoreCase(name)) {
            shape = new Rectangle();
        } else {
            throw new UnsupportShapeException("shape not support");
        }
        return shape;
    }
}
