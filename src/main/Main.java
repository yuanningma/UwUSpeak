package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uwu.UwUTranslator;

public class Main {
	public static void main(String[] args) throws IOException {
		
		new Main(args).run();
	}
	
	private Main(String[] args) {

	}
	public void run() throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String line;
		 UwUTranslator translator = new UwUTranslator();

		 
//		 h.testPrint();
		 while ((line = br.readLine()) != null) {
			 System.out.println(translator.translateString(line));
		 }
	}
}