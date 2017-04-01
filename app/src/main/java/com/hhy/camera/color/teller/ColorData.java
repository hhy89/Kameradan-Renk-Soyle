package com.hhy.camera.color.teller;

import java.util.ArrayList;

// renk veri sınıfı
public class ColorData {
    // renklerin tutulduğu liste ve sınıfı
    public ArrayList<Object> colors;
    public ColorList colorList;
    // renk çevirici
    private ColorConverter colorConverter;

    // ana sınıf
    public ColorData() {
        // renk listesi ve renk çevirici
        colorList = new ColorList();
        colorConverter = new ColorConverter();
        // renkleri getir
        colors = colorList.getColors();
    }

    // renk isimlerini dosya ismine çevir
    public String changeFileName(String colorName) {
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
    public String ColorToString(int[] color) {
        String result = "#";
        for (int i = 0; i < color.length; i++) {
            String part = Integer.toHexString(color[i]);
            if (part.length() == 1) {
                part = "0" + part;
            }
            result = result.concat(part);
        }
        return result;
    }

    // koyu renk mi?
    public boolean isDarkColor(int[] color) {
        if (color[0] * .3 + color[1] * .59 + color[2] * .11 > 150) {
            return false;
        }
        return true;
    }

    // renk ismini getir
    public String getColorName(String color) {
        Color col = colorList.getNameFromHex(color);
        return col.getName();
    }

    // renge en yakın rengi söyle
    public String closestColor(int[] col) {
        int[] bestMatch = new int[3];
        double bestDist = 1000;

        // rengi hesaplamak için lab a dönüştür
        double[] colLab = colorConverter.RgbToLab(col[0], col[1], col[2]);

        // tüm renklere bakarak söyle
        for (int i = 0; i < colors.size(); i++) {
            Color color = (Color) colors.get(i);

            double dist = calculateDist(colLab, color.getLab());
            if (dist < bestDist) {
                bestMatch = color.getRgb();
                bestDist = dist;
            }
        }
        return ColorToString(bestMatch);
    }

    // 2 renk arasındaki uzaklığı hesapla
    // 1. formul = Uzaklık = karekök(xd*xd + yd*yd + zd*zd)
    private double calculateDist(double[] lab1, double[] lab2) {
        return Math.sqrt(
                Math.pow(lab2[0] - lab1[0], 2) +
                Math.pow(lab2[1] - lab1[1], 2) +
                Math.pow(lab2[2] - lab1[2], 2)
        );
    }

}
