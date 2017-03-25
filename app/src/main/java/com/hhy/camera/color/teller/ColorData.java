package com.hhy.camera.color.teller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;

// renk sınıfı
public class ColorData {
	// renk isim mapi
	protected Map<String,String> nameMap;
	// renklerin integerları
	public ArrayList<int[]> colors;

	// ana sınıf
	public ColorData(Context context) {
		loadColors(context);
	}

	// dosyadan renkleri yükle
	private void loadColors(Context context) {
		nameMap = new HashMap<>();
		colors = new ArrayList<>();
		try {
			InputStream inputStream = context.getResources().openRawResource(R.raw.rgb);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = reader.readLine();
			while (line != null) {
				int split = line.indexOf('#');
				String color = line.substring(split, line.length() - 1);
				String name = line.substring(0, split - 1);
				nameMap.put(color, name);
				colors.add(StringToColor(color));
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	// ismine göre renk değerini getir
	private int[] StringToColor(String str) {
		int[] result = new int[3];
		for (int i = 1; i < str.length(); i += 2) {
			String substring = str.substring(i, i + 2);
			int in = Integer.parseInt(substring, 16);
			result[i / 2] = in;
		}
		return result;
	}

	// integer değerine göre renk ismini getir
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
		return nameMap.get(color);
	}

	// renge en yakın rengi söyle
	public String closestColor(int[] col) {
		int[] bestMatch = new int[3];
		double bestDist = 1000;
		// tüm renklere bakarak söyle
		for (int i = 0; i < colors.size(); i++) {
			double dist = calculateDist(col, colors.get(i));
			if (dist < bestDist) {
				bestMatch = colors.get(i);
				bestDist = dist;
			}
		}
		return ColorToString(bestMatch);
	}

	// 2 nokta arasındaki uzaklığı hesapla
	// 1. formul = Uzaklık = karekök(xd*xd + yd*yd + zd*zd)
	// 2. formul = http://stackoverflow.com/questions/25620837/making-an-rgb-get-closest-colour-algorithm-more-accurate
	// 3. formul = https://www.compuphase.com/cmetric.htm
	private double calculateDist(int[] p1, int[] p2) {
		float sum = 0;

		for (int i = 0; i < p1.length; i++) {
			double diff = p1[i] - p2[i];
			sum += diff * diff;
		}
		return Math.sqrt(sum);

		/*
		int deltaR = p1[0] - p2[0];
		int deltaG = p1[1] - p2[1];
		int deltaB = p1[2] - p2[2];

		sum = (deltaR * deltaR) * 0.2989F
				+ (deltaG * deltaG) * 0.5870F
				+ (deltaB * deltaB) * 0.1140F;

		return Math.sqrt(sum);
		*/
		/*
		int deltaR = p1[0] - p2[0];
		int deltaG = p1[1] - p2[1];
		int deltaB = p1[2] - p2[2];

		sum = (deltaR * deltaR) * 0.28335F
				+ (deltaG * deltaG) * 0.53F
				+ (deltaB * deltaB) * 0.40385F;

		return Math.sqrt(sum);
		*/
		/*
		int rmean = (p1[0] + p2[0]) / 2;
		int deltaR = p1[0] - p2[0];
		int deltaG = p1[1] - p2[1];
		int deltaB = p1[2] - p2[2];

		sum = (((512 + rmean) * deltaR * deltaR) >> 8)
				+ (4 * deltaG * deltaG)
				+ (((767 - rmean) * deltaB * deltaB) >> 8);

		return Math.sqrt(sum);
		*/
	}

}
