package com.comic.blank;

/**
 * @author ..w-chen..
 */
public class Type {

    private TypeEnum type;

    private enum TypeEnum{
        ZERO,ONE
    };

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getTypeString() {
        switch (type) {
            case ZERO:
                return "ZERO";
            case ONE:
                return "ONE";
            default:
                return "OTHER";
        }
    }

}
