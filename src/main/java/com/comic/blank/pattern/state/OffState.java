package com.comic.blank.pattern.state;

/**
 * 开关状态：关
 */
public class OffState implements State {

    private static final State INSTANCE = new OffState();

    public static State instance() {
        return INSTANCE;
    }

    @Override
    public void control(Button button) {
        //更新Button中开关的状态
        button.setState(OnState.instance());
        System.out.println("关灯...");
    }

}
