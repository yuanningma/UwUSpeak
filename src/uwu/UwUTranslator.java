package uwu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UwUTranslator {
	
	private Set<String> names;
	private List<String> suffixes;
	public UwUTranslator() {
		names = new HashSet<String>();
		suffixes = new ArrayList<String>();
		suffixes.add("-chan");
		suffixes.add("-sama");
		suffixes.add("-senpai");
		suffixes.add("-chama");
	}
	
	// TODO: suffix stuff
//	private HashSet<String> genNames() {
//		
//	}
	
	private boolean startsWithTh(String str) {
		char[] arr = str.toLowerCase().toCharArray();
		if (arr.length < 2) {
			return false;
		}
		if (arr[0] == 't' && arr[1] == 'h') {
			return true;
		}
		return false;
	}
	
	private boolean startsWithM(String str) {
		char[] arr = str.toCharArray();
		if (arr.length < 1) {
			return false;
		}
		if (arr[0] == 'm') {
			return true;
		}
		return false;
	}
	
	private boolean startsWithN(String str) {
		char[] arr = str.toCharArray();
		if (arr.length < 1) {
			return false;
		}
		if (arr[0] == 'n') {
			return true;
		}
		return false;
	}

	public String translateString(String s) {
		String[] splitted = s.split(" ");
		String toret = "";
		
		for (String str: splitted) {
			String fin = str.toLowerCase();
			
			if (startsWithTh(str)) {
				fin = fin.replaceFirst("th", "d");
			} 
//			else if (startsWithM(str)) {
//				fin = fin.replaceFirst("m", "mw");
//			} else if (startsWithN(str)) {
//				fin = fin.replaceFirst("n", "ny");
//			}
			
			fin = fin.replaceAll("l", "w");
			fin = fin.replaceAll("r", "w");
			fin = fin.replaceAll("ove", "uv");
			
			fin = fin.replaceAll("na", "nya");
			fin = fin.replaceAll("ne", "nye");
			fin = fin.replaceAll("ni", "nyi");
			fin = fin.replaceAll("no", "nyo");
			fin = fin.replaceAll("nu", "nyu");
			
			fin = fin.replaceAll("ma", "mya");
			fin = fin.replaceAll("me", "mye");
			fin = fin.replaceAll("mi", "myi");
			fin = fin.replaceAll("mo", "myo");
			fin = fin.replaceAll("mu", "myu");
			
			int mode = 0;
			// I'm reaaaaaally lazy
			String lazy = ("" + fin.toCharArray()[fin.length() - 1]);
			if (lazy.matches("\\?")) {
				// UwU
				mode = 1;
			} else if (lazy.matches("!")) {
				// OwO
				mode = 2;
			} else if (lazy.matches("~")) {
				// OwU
				mode = 3;
			} else if (("" + fin.toCharArray()[fin.length() - 1]).matches("^.*[^a-zA-Z0-9 ].*$")) {
				mode = 4;
			}
			
			// Suffix stuff
			if (names.contains(str.trim().toLowerCase())) {
				// It's a name!
				if (mode == 0) {
					// no punctuation
					fin += "-chama";
				} else {
					// find where to put the suffix!
				}
			}
			if (mode == 1) {
				fin += "? UwU ";
			} else if (mode == 2) {
				fin += "! OwO ";
			} else if (mode == 3) {
				fin += "~ OwU ";
			} else {
				fin += " ";
			}
			toret += fin;

		}
		return toret;
	}
	
	public String translateFile(String path) {
		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				
			}
			return "Success";
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found!");
			return null;
		} catch (IOException e) {
			System.out.println("ERROR: IOException!");
			return null;
		}
		
	}
}
