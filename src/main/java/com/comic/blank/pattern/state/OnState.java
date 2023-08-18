package com.comic.blank.pattern.state;

/**
 * 开关状态：开
 */
public class OnState implements State {

    private static final State INSTANCE = new OnState();

    public static State instance() {
        return INSTANCE;
    }

    @Override
    public void control(Button button) {
        //更新Button中开关的状态
        button.setState(OffState.instance());
        System.out.println("开灯...");
    }

}
