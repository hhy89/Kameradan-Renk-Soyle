package com.hhy.camera.color.teller;

import java.util.ArrayList;

// renk veri sınıfı
class ColorData {
    // renklerin tutulduğu liste ve sınıfı
    private ArrayList<Color> colors;
    private ColorList colorList;

    // ana sınıf
    ColorData() {
        // renk listesi ve renk çevirici
        colorList = new ColorList();
        // renkleri getir
        colors = colorList.getColors();
    }

    // renk isimlerini dosya ismine çevir
    String changeFileName(String colorName) {
        String fileName = colorName.replace("ğ", "g");
        fileName = fileName.replace("ü", "u");
        fileName = fileName.replace("ş", "s");
        fileName = fileName.replace("ı", "i");
        fileName = fileName.replace("ç", "c");
        fileName = fileName.replace("ö", "o");
        fileName = fileName.replace(" ", "_");

        return fileName;
    }

    // rengi hex code a çevir
    private String ColorToString(int[] color) {
        String result = "#";

        for (int aColor : color) {
            String part = Integer.toHexString(aColor);
            if (part.length() == 1) {
                part = "0" + part;
            }
            result = result.concat(part);
        }
        return result;
    }

    // koyu renk mi?
    boolean isDarkColor(int[] color) {
        return !(color[0] * .3 + color[1] * .59 + color[2] * .11 > 150);
    }

    // renk ismini getir
    String getColorName(String color) {
        Color col = colorList.getNameFromHex(color);
        return col.getName();
    }

    // renge en yakın rengi söyle
    String closestColor(int[] col) {
        int[] bestMatch = new int[3];
        double bestDist = 1000;

        // rengi hesaplamak için lab a dönüştür
        double[] colLab = ColorConverter.RgbToLab(col[0], col[1], col[2]);

        // tüm renklere bakarak söyle
        for (Color color : colors) {
            double dist = calculateDist(colLab, color.getLab());
            if (dist < bestDist) {
                bestMatch = color.getRgb();
                bestDist = dist;
            }
        }
        return ColorToString(bestMatch);
    }

    private double calculateDist(double[] lab1, double[] lab2) {
        return Math.sqrt(
                Math.pow(lab2[0] - lab1[0], 2) +
                        Math.pow(lab2[1] - lab1[1], 2) +
                        Math.pow(lab2[2] - lab1[2], 2)
        );
    }

}
