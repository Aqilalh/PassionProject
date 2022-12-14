package com.juice.juice.enums;

public enum MilkShakesSizes {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String sizes;
    MilkShakesSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getSizes() {
        return sizes;
    }
}
