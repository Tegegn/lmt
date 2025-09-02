package com.ttf.lmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Arrays;

@SpringBootApplication
public class LmtApplication extends SpringBootServletInitializer {

  static boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    char[] char1 = str1.toCharArray();
    char[] char2 = str2.toCharArray();
    Arrays.sort(char1);
    Arrays.sort(char2);
    return Arrays.equals(char1, char2);
//		int count= 0;
//		for(char c: chars){
//			if(str2.contains(String.valueOf(c))){
//				count++;
//			}
//		}
//		return count == str1.length();
  }

  static char firstNonRepeatedChar(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (i == 0 && (!input.substring(1).contains(String.valueOf(input.charAt(i))))) {
        return input.charAt(i);
      } else if (!input.substring(0, i).contains(String.valueOf(input.charAt(i))) || !input
          .substring(i + 1).contains(String.valueOf(input.charAt(i)))) {
        return input.charAt(i);
      }
//			if(input.substring())
////			String movingString = input.substring(i+1);
////			if (!movingString.contains(String.valueOf(input.charAt(i)))){
////				return movingString.charAt(0);
////			}
    }
    return ' ';
  }

  public static void main(String[] args) {
//		boolean ans = isAnagram("amy","aym");
//		System.out.printf("Ans: " + ans);
    SpringApplication.run(LmtApplication.class, args);
//
    //System.out.println("wwhhattev".substring(0,1));
    System.out.println("Char at: " + (Character) firstNonRepeatedChar("wwhhattev"));
  }

}
