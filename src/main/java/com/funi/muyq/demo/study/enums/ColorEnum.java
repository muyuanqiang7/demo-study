package com.funi.muyq.demo.study.enums;

/**
 * @Package: [com.funi.muyq.demo.study.enumsColorEnum]
 * @Description: [枚举的用法]
 * @Author: [yuanqiang.mou@funi365.com]
 * @CreateDate: [2018/5/31 10:27]
 * @UpdateUser: []
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version: [v1.0]
 */

/**
 * 1.常量
 */
public enum ColorEnum {
    RED, GREEN, BLANK, YELLOW
}


/**
 * 2.switch 语句 JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举
 */
enum Signal {
    RED("1"), GREEN("2"), YELLOW("3");
    private String code;

    Signal(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return name() + "-" + this.code;
    }
}

/**
 * 3.向枚举中添加新方法
 * 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。
 * 4.枚举覆盖方法
 */
enum Color {
    RED(1, "红色"), GREEN(2, "绿色"), BLANK(3, "黑色"), YELLOW(4, "黄色");
    private String name;
    private int status;

    Color(int status, String name) {
        this.name = name;
        this.status = status;
    }

    // 普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getStatus() == index) {
                return c.name;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return String.valueOf(this.status) + "-" + this.name;
    }
}

enum ColorInterface implements Behaviour {
    RED(1, "红色"), GREEN(2, "绿色"), BLANK(3, "黑色"), YELLOW(4, "黄色");

    private int status;
    private String name;

    ColorInterface(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public void print() {
        System.out.println(String.valueOf(this.status) + "-" + this.name);
    }

    public String getInfo() {
        return this.name;
    }
}

/**
 * 5.实现接口
 * 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 */
interface Behaviour {
    void print();

    String getInfo();
}

/**
 * 6.使用接口组织枚举
 */
interface Food {
    enum CoffeeEnum implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum DessertEnum implements Food {
        FRUIT, CAKE, GELATO
    }
}

class TrafficLight {

    public static Signal change(Signal signal) {
        switch (signal) {
            case RED:
                signal = Signal.GREEN;
                break;
            case YELLOW:
                signal = Signal.RED;
                break;
            case GREEN:
                signal = Signal.YELLOW;
                break;
        }
        return signal;
    }
}

/**
 * 7.关于枚举集合的使用
 * java.util.EnumSet和java.util.EnumMap是两个枚举集合。EnumSet保证集合中的元素不重复；EnumMap中的 key是enum类型，而value则可以是任意类型
 * 查看JDK或者Thinking in java
 * tips:
 * 枚举的比较是可以使用==
 * 因为在Enum类里面，已经重写了equals方法，而方法里面比较就是直接使用==
 */
class EnumTest {
    public static void main(String[] args) {
        Signal color = Signal.GREEN;
        //通过名称获取枚举实例
        System.out.println(Signal.valueOf("GREEN"));
        System.out.println(color.ordinal());
        System.out.println(color.getCode());
        System.out.println(color.name());
        System.out.println(TrafficLight.change(color).getCode());
        System.out.println(Color.BLANK.toString());
        ColorInterface.BLANK.print();
        for (Food.DessertEnum dessertEnum : Food.DessertEnum.values()) {
            System.out.print(dessertEnum + "  ");
        }
    }
}

