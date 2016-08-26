package com.research.string;

public class StringMain {

	public static String reverseRecursively(String str) {

		//base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}


	public static String reverse(String str){
		StringBuilder builder = new StringBuilder();
		char[] chars = str.toCharArray();
		
		for (int i = chars.length - 1 ;i >=0; i--) {
			builder.append(chars[i]);
		}
		
		return builder.toString();
	}


	public static void main(String[] args) {
		String name = "richa";
		System.out.println("Before Reverse "+name);
		name = reverseRecursively(name);
		System.out.println("After Reverse "+name);
		name = reverse(name);
		System.out.println("Reverse Again after Iterative Reverse "+name);
		
		String input = "richa";
		String output = reverse(input);
		if(input.equalsIgnoreCase(output)){
			System.out.println("Input String "+input+" is Palindrome");
		} else {
			System.out.println("Input String "+input+" is not Palindrome");
		}
		
		System.out.println(gcd(2,7));
	}

	static int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
