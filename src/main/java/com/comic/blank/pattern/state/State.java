package com.comic.blank.pattern.state;

/**
 * 开关状态的接口
 */
public interface State {

    /**
     * 控制电灯的方法
     * @param button 开关
     */
    void control(Button button);

}
