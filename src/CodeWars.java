import java.util.*;
import java.lang.*;

public class CodeWars {
	// Getting initials for a name
	public static String initials(String name) {
		StringBuilder builder = new StringBuilder();
		String[] ans = name.split(" ");
		for (int i = 0; i < ans.length - 1; i++) {
			builder.append(ans[i].substring(0, 1).toUpperCase() + ".");
		}

		builder.append(
				ans[ans.length - 1].substring(0, 1).toUpperCase() + ans[ans.length - 1].substring(1).toLowerCase());
		return builder.toString();
	}

	// Getting the middle word in a string
	public static String getMiddle(String word) {
		if (word.length() == 1)
			return word.toString();
		if (word.length() % 2 != 0) {
			return Character.toString(word.charAt(word.length() / 2));
		} else
			return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
	}

	// Capitalize the first letter in every word
	public static String capitalizeEveryFirstLeter(String phrase) {
		if (phrase != null && phrase != "") {
			StringBuilder sb = new StringBuilder();
			String[] ans = phrase.split(" ");
			for (int i = 0; i < ans.length; i++) {
				sb.append(ans[i].substring(0, 1).toUpperCase() + ans[i].substring(1).toLowerCase() + " ");
			}
			return sb.substring(0, sb.length() - 1).toString();
		} else
			return null;
	}

	// Find the next square(121 --> 144)
	public static long findNextSquare(long sq) {
		if (Math.pow((long) Math.sqrt(sq), 2) != sq)
			return -1;
		else
			return (long) Math.pow(Math.sqrt(sq) + 1, 2);
	}

	// Can you build the triangle
	public static Boolean isTriangle(int a, int b, int c) {
		return a + b > c && b + c > a && a + c > b;
	}

	// count the population
	public static int nbYear(double p0, double percent, double aug, int p) {
		int yearsToFinish = 0;
		while (p > p0) {
			p0 = p0 + (p0 * percent / 100) + aug;
			yearsToFinish++;
		}
		return yearsToFinish;
	}

	// sum all the digits in the number(128=1+2+8=11 --> 1+1 = 2)
	public static int digital_root(int n) {
		int ans = 0;
		while (n > 0) {
			ans += n % 10;
			n /= 10;
		}
		if (ans > 10)
			return digital_root(ans);
		else
			return ans;
	}

	// casting out 9's
	public static int digital_root_clever(int n) {
		return (n != 0 && n % 9 == 0) ? 9 : n % 9;
	}

	// Strip dubstep song from "WUB"
	public static String SongDecoder(String song) {
		StringBuilder sb = new StringBuilder();
		String ans[] = song.split("WUB");
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		return (sb.substring(0, sb.length() - 1).toString()).replaceAll("\\s+", " ").trim();
	}

	// Return a tribonacci sequence
	public static double[] tribonacci(double[] s, int n) {
		double[] ans;
		ans = new double[n];
		ans[0] = s[0];
		ans[1] = s[1];
		ans[2] = s[2];
		for (int i = 3; i < n; i++) {
			ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
		}
		return ans;
	}

	// Returns a string with words containg numbers and sorted
	// according to these numbers ex. "is2 Thi1s T4est 3a"
	public static String order(String words) {
		String[] ans = words.split(" ");
		StringBuilder sb = new StringBuilder();
		String[] ans1 = new String[ans.length];
		for (int i = 0; i < ans.length; i++) {
			ans1[(Integer.parseInt(ans[i].replaceAll("\\D+", ""))) - 1] = ans[i];
		}
		for (int i = 0; i < ans1.length; i++) {
			sb.append(ans1[i] + " ");
		}
		return sb.toString().trim();
	}

	// find the number which appears odd times in an array
	public static int findIt(int[] A) {
		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length; i++) {
			int ans = A[i];
			int wynik = 0;
			for (int j = 0; j < A.length; j++) {

				if (ans == A[j])
					wynik++;

			}
			if (wynik % 2 == 1)
				return ans;
		}
		return A[0];
	}

	// revert all the 5 or more characters words in a sentence
	public static String spinWords(String sentence) {
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			if ((words[i].length()) < 5)
				sb.append(words[i] + " ");
			else
				sb.append(new StringBuilder(words[i]).reverse() + " ");
		}
		return sb.toString().trim();
	}

	// count occurence of '1'in byte representation of integer
	public static int countBits(int n) {
		String bytes = Integer.toBinaryString(n);
		int counter = 0;
		for (int i = 0; i < bytes.length(); i++) {
			if (bytes.charAt(i) == '1')
				counter++;
		}
		return counter;
	}

	// reduce opposite directions in a string array
	public static String[] dirReduc(String[] arr) {
		List<String> strings = new ArrayList<String>(Arrays.asList(arr));
		int i = 0;
		while (i < strings.size() - 1) {
			// Check if i and i+1 are the same element. If so, remove both
			if ((strings.get(i).equals("NORTH") && strings.get(i + 1).equals("SOUTH"))
					|| (strings.get(i).equals("SOUTH") && strings.get(i + 1).equals("NORTH"))
					|| (strings.get(i).equals("EAST") && strings.get(i + 1).equals("WEST"))
					|| (strings.get(i).equals("WEST") && strings.get(i + 1).equals("EAST"))) {
				// Remove i twice - effectively removes i and i+1
				strings.remove(i);
				strings.remove(i);

				// Move i *back* one index, which is equivalent to
				// moving forward one because we just removed two elements.
				// Prevent i from becoming negative though.
				i = Math.max(0, (i - 1));
			} else {
				i++;
			}
		}
		return strings.toArray(new String[0]);
	}

	public static String[] inArray(String[] array1, String[] array2) {
		SortedSet<String> list = new TreeSet<String>();
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array2[j].contains(array1[i]))
					list.add(array1[i]);
			}
		}
		return list.toArray(new String[0]);
	}

	// make squares out of rectangle
	public static List<Integer> sqInRect(int lng, int wdth) {
		List<Integer> list = new ArrayList<Integer>();
		int sum = lng * wdth;
		int value = (int) Math.floor(Math.sqrt(sum));
		while (value > lng || value > wdth) {
			value--;
		}
		if (lng == wdth)
			return null;
		while (sum > 0) {
			list.add(value);
			sum -= Math.pow(value, 2);
			value = (int) Math.floor(Math.sqrt(sum));
			while (value > lng || value > wdth) {
				value--;
			}

		}
		return list;
	}

	// get MAX and MIN value of an arrays
	public static int[] minMax(int[] arr) {
		Arrays.sort(arr);
		return new int[] { arr[0], arr[arr.length - 1] };
	}

	// reverse polish nottation calculator
	public static double evaluate(String expr) {
		if (expr == "")
			return 0;
		Stack stack = new Stack();
		double a, b;
		double wynik = 0;
		int licznik = 0;
		expr = expr.concat(" ");
		System.out.println(expr);
		String s = "";
		char[] expression = expr.toCharArray();
		for (int i = 0; i < expression.length - 1; i++) {
			// if there is float numbers
			if (Character.isDigit(expression[i]) && expression[i + 1] == '.') {
				stack.push(Double.parseDouble(String.valueOf(expression[i] + "." + expression[i + 2])));
				i = i + 2;
			}
			// if there is more than 1 digits
			else if (Character.isDigit(expression[i]) && Character.isDigit(expression[i + 1])) {
				int k = i;
				while (Character.isDigit(expression[k])) {
					s = s.concat(String.valueOf(expression[k]));
					System.out.println("S= " + s);
					k++;
					licznik++;
				}
				stack.push(Double.parseDouble(String.valueOf(s)));
				i = i + licznik;
			}
			// if there is a simple digit
			else if (Character.isDigit(expression[i])) {
				stack.push(Double.parseDouble(String.valueOf(expression[i])));
			}
			// if there is any operator
			else if (expression[i] != ' ') {
				a = Double.parseDouble(String.valueOf(stack.pop()));
				b = Double.parseDouble(String.valueOf(stack.pop()));
				switch (expression[i]) {
				case '+':
					stack.push(a + b);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '/':
					stack.push(b / a);
					break;
				case '*':
					stack.push(a * b);
					break;
				}
			}
			System.out.println(stack);
		}
		wynik = Double.parseDouble(String.valueOf(stack.pop()));
		return wynik;
	}

	// min and max return functions
	public static int min(int[] list) {
		Arrays.sort(list);
		return list[0];
	}

	public static int max(int[] list) {
		Arrays.sort(list);
		return list[list.length - 1];
	}

	// get sum of multiplies of 3 and 5 in a number
	public static int divisibleByThreeOrFive(int number) {
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i = 3; i < number; i++)
			if (i % 3 == 0 || i % 5 == 0) {
				numbers.add(i);
			}
		int suma = 0;
		for (int value : numbers) {
			suma += value;
		}
		return suma;
	}

	// given two speeds v1 ,v2, lead g (integer > 0) how long will it take B to
	// catch A?
	// result printed as [hours,minutes,seconds]
	public static int[] race(int v1, int v2, int g) {
		if (v1 >= v2)
			return null;
		double time = ((double) g) / (v2 - v1) * 3600;
		int hours = (int) time / 3600;
		int remainder = (int) time - hours * 3600;
		int mins = remainder / 60;
		remainder = remainder - mins * 60;
		int secs = remainder;
		int[] ints = { hours, mins, secs };
		return ints;
	}

	// You are given an array (which will have a length of at least 3, but could
	// be very large) containing integers.
	// The array is either entirely comprised of odd integers or entirely
	// comprised of
	// even integers except for a single integer N.
	// Write a method that takes the array as an argument and returns N.

	static int parityOutlier;

	public static int find(int[] integers) {
		if (Math.abs(integers[0] % 2) + Math.abs(integers[1] % 2) + Math.abs(integers[2] % 2) >= 2) {
			parityOutlier = integers[0];
			for (int i = 1; i < integers.length; i++) {
				if (Math.abs(integers[i] % 2) == 0)
					parityOutlier = integers[i];
			}
		} else {
			parityOutlier = integers[0];
			for (int i = 1; i < integers.length; i++) {
				if (Math.abs(integers[i] % 2) == 1)
					parityOutlier = integers[i];
			}
		}
		return parityOutlier;
	}

}
