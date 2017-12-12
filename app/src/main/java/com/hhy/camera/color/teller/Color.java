package com.hhy.camera.color.teller;

// renk sınıfı
public class Color {
    private String hexcode;
    private int[] rgb;
    private double[] lab;
    private String name;

    Color(String hexcode, int[] rgb, double[] lab, String name) {
        this.hexcode = hexcode;
        this.rgb = rgb;
        this.lab = lab;
        this.name = name;
    }

    // getter lar
    String getHexcode() {
        return hexcode;
    }
    int[] getRgb() {
        return rgb;
    }
    double[] getLab() {
        return lab;
    }
    public String getName() {
        return name;
    }
}
