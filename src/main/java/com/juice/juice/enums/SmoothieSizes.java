package com.juice.juice.enums;

public enum SmoothieSizes {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    SmoothieSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getSizes() {
        return sizes;
    }

    private final String sizes;
}
