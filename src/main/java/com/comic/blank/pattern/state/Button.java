package com.comic.blank.pattern.state;

import lombok.Setter;

/**
 * 开关, 相当于环境的上下文
 */
@Setter
public class Button {

    private State state;

    public Button() {
        state = OnState.instance();
    }

    public void press() {
        state.control(this);
    }

}
