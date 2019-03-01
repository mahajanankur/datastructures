package com.sb.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read = br.readLine();
		int num = Integer.parseInt(read);
		System.out.println(2);
		System.out.println(3);
		for (int i = 2; i <= num; i++) {
			boolean prime = false;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					prime = false;
					break;
				}
				else {
					prime = true;
				}

			}
			if (prime) {
				System.out.println(i);
			}
		}
	}
}
