package com.mnl.myanmarcurrencyformatconverter;

import java.util.Scanner;

public class MyanmarCurrencyConverter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter number : ");
			int inputNumber = sc.nextInt();
	
			if (inputNumber < 0 || inputNumber > 999999) {
				System.out.println("Number out of range. Please enter 0 to 999999 !!!");
			} else if (inputNumber == 0) {
				System.out.println("သုည");
			} else {
				convert(inputNumber);
			}
		} catch (Exception e) {
			System.out.println("Please Enter NUMBER Only!!!");
		}
			
		sc.close();
	}

	static void convert(int inputNumber) {

		String[] mmWords = { "", "တစ်", "နှစ်", "သုံး", "လေး", "ငါး", "ခြောက်", "ခုနစ်", "ရှစ်", "ကိုး", "တစ်ဆယ်",
				"တစ်ဆယ့်တစ်", "တစ်ဆယ့်နှစ်", "တစ်ဆယ့်သုံး", "တစ်ဆယ့်လေး", "တစ်ဆယ့်ငါး", "တစ်ဆယ့်ခြောက်", "တစ်ဆယ့်ခုနစ်",
				"တစ်ဆယ့်ရှစ်", "တစ်ဆယ့်ကိုး" };
		String[] mmTen = { "", "တစ်ဆယ်", "နှစ်ဆယ်", "သုံးဆယ်", "လေးဆယ်", "ငါးဆယ်", "ခြောက်ဆယ်", "ခုနစ်ဆယ်", "ရှစ်ဆယ်",
				"ကိုးဆယ်" };
		String[] mmHundred = { "", "တစ်ရာ", "နှစ်ရာ", "သုံးရာ", "လေးရာ", "ငါးရာ", "ခြောက်ရာ", "ခုနစ်ရာ", "ရှစ်ရာ",
				"ကိုးရာ" };
		String[] mmThousand = { "", "တစ်ထောင်", "နှစ်ထောင်", "သုံးထောင်", "လေးထောင်", "ငါးထောင်", "ခြောက်ထောင်",
				"ခုနစ်ထောင်", "ရှစ်ထောင်", "ကိုးထောင်" };
		String[] mmThaung = { "", "တစ်သောင်း", "နှစ်သောင်း", "သုံးသောင်း", "လေးသောင်း", "ငါးသောင်း", "ခြောက်သောင်း",
				"ခုနစ်သောင်း", "ရှစ်သောင်း", "ကိုးသောင်း" };
		String mmThein = "သိန်း";

		int khuDigit = inputNumber % 10;
		int salDigit = (inputNumber / 10) % 10;
		int yarDigit = (inputNumber % 1000) / 100;
		int htaungDigit = (inputNumber % 10000) / 1000;
		int thaungDigit = (inputNumber % 100000) / 10000;
		int theinDigit = inputNumber / 100000;

//		System.out.println(lastDigit + "\t" + num1 + "\t" + num2);

		if (inputNumber < 20) {
			System.out.println(mmWords[inputNumber] + " ကျပ်");
		} else if (inputNumber >= 20 && inputNumber < 100) {
			System.out.println(mmTen[salDigit] + " " + mmWords[khuDigit] + " ကျပ်");
		} else if (inputNumber >= 100 && inputNumber <= 999) {
			System.out.println(mmHundred[yarDigit] + " " + mmTen[salDigit] + " " + mmWords[khuDigit] + " ကျပ်");
		} else if (inputNumber >= 1000 && inputNumber <= 9999) {
			System.out.println(mmThousand[htaungDigit] + " " + mmHundred[yarDigit] + " " + mmTen[salDigit] + " "
					+ mmWords[khuDigit] + " ကျပ်");
		} else if (inputNumber >= 10000 && inputNumber <= 99999) {
			System.out.println(mmThaung[thaungDigit] + " " + mmThousand[htaungDigit] + " " + mmHundred[yarDigit] + " "
					+ mmTen[salDigit] + " " + mmWords[khuDigit] + " ကျပ်");
		} else {
			System.out.println(mmWords[theinDigit] + mmThein + " " + mmThaung[thaungDigit] + " " + mmThousand[htaungDigit]
							+ " " + mmHundred[yarDigit] + " " + mmTen[salDigit] + " " + mmWords[khuDigit] + " ကျပ်");
		}
	}
}
