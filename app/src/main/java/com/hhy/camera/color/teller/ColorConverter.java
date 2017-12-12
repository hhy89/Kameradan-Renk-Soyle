package com.hhy.camera.color.teller;

// renkleri birbirine döndürme sınıfı
// rgb <==> xyz <==> lab
public class ColorConverter {

    private static final double XYZ_WHITE_REFERENCE_X = 95.047;
    private static final double XYZ_WHITE_REFERENCE_Y = 100;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883;
    private static final double XYZ_EPSILON = 0.008856;
    private static final double XYZ_KAPPA = 903.3;

    // convert rgb to lab
    static double[] RgbToLab(int r, int g, int b) {
        // First we convert RGB to XYZ
        double[] outXyz = RgbToXyz(r, g, b);
        // outLab now contains XYZ
        // outLab now contains LAB representation
        return XyzToLab(outXyz[0], outXyz[1], outXyz[2]);
    }
    // convert rgb to xyz
    private static double[] RgbToXyz(int r, int g, int b) {
        double[] outXyz = {0, 0, 0};

        double sr = r / 255.0;
        sr = sr < 0.04045 ? sr / 12.92 : Math.pow((sr + 0.055) / 1.055, 2.4);
        double sg = g / 255.0;
        sg = sg < 0.04045 ? sg / 12.92 : Math.pow((sg + 0.055) / 1.055, 2.4);
        double sb = b / 255.0;
        sb = sb < 0.04045 ? sb / 12.92 : Math.pow((sb + 0.055) / 1.055, 2.4);

        outXyz[0] = 100 * (sr * 0.4124 + sg * 0.3576 + sb * 0.1805);
        outXyz[1] = 100 * (sr * 0.2126 + sg * 0.7152 + sb * 0.0722);
        outXyz[2] = 100 * (sr * 0.0193 + sg * 0.1192 + sb * 0.9505);

        return outXyz;
    }
    // convert xyz to lab
    private static double[] XyzToLab(double x, double y, double z) {
        double[] outLab = {0, 0, 0};

        x = pivotXyzComponent(x / XYZ_WHITE_REFERENCE_X);
        y = pivotXyzComponent(y / XYZ_WHITE_REFERENCE_Y);
        z = pivotXyzComponent(z / XYZ_WHITE_REFERENCE_Z);
        outLab[0] = Math.max(0, 116 * y - 16);
        outLab[1] = 500 * (x - y);
        outLab[2] = 200 * (y - z);

        return outLab;
    }
    private static double pivotXyzComponent(double component) {
        return component > XYZ_EPSILON
                ? Math.pow(component, 1 / 3.0)
                : (XYZ_KAPPA * component + 16) / 116;
    }
    // convert lab to rgb
    public static int[] LabToRgb(final double l, final double a, final double b) {
        double[] result = LabToXyz(l, a, b);
        return XyzToRgb(result[0], result[1], result[2]);
    }
    // convert lab to xyz
    private static double[] LabToXyz(double l, double a, double b) {
        double[] outXyz = {0, 0, 0};

        final double fy = (l + 16) / 116;
        final double fx = a / 500 + fy;
        final double fz = fy - b / 200;

        double tmp = Math.pow(fx, 3);
        final double xr = tmp > XYZ_EPSILON ? tmp : (116 * fx - 16) / XYZ_KAPPA;
        final double yr = l > XYZ_KAPPA * XYZ_EPSILON ? Math.pow(fy, 3) : l / XYZ_KAPPA;

        tmp = Math.pow(fz, 3);
        final double zr = tmp > XYZ_EPSILON ? tmp : (116 * fz - 16) / XYZ_KAPPA;

        outXyz[0] = xr * XYZ_WHITE_REFERENCE_X;
        outXyz[1] = yr * XYZ_WHITE_REFERENCE_Y;
        outXyz[2] = zr * XYZ_WHITE_REFERENCE_Z;

        return outXyz;
    }
    // convert xyz to rgb
    private static int[] XyzToRgb(double x, double y, double z) {
        double r = (x * 3.2406 + y * -1.5372 + z * -0.4986) / 100;
        double g = (x * -0.9689 + y * 1.8758 + z * 0.0415) / 100;
        double b = (x * 0.0557 + y * -0.2040 + z * 1.0570) / 100;

        r = r > 0.0031308 ? 1.055 * Math.pow(r, 1 / 2.4) - 0.055 : 12.92 * r;
        g = g > 0.0031308 ? 1.055 * Math.pow(g, 1 / 2.4) - 0.055 : 12.92 * g;
        b = b > 0.0031308 ? 1.055 * Math.pow(b, 1 / 2.4) - 0.055 : 12.92 * b;

        int red = constrain((int) Math.round(r * 255), 0, 255);
        int green = constrain((int) Math.round(g * 255), 0, 255);
        int blue = constrain((int) Math.round(b * 255), 0, 255);

        return new int[]{red, green, blue};
    }
    private static int constrain(int amount, int low, int high) {
        return amount < low ? low : (amount > high ? high : amount);
    }
}
