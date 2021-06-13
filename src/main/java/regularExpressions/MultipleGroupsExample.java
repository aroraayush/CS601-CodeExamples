package regularExpressions;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/** Example from: http://tutorials.jenkov.com/java-regex/matcher.html */

public class MultipleGroupsExample {

	public static void main(String[] args) {

		String text = "John writes about this, and John Doe writes about that, and John Wayne writes about everything.";

		// No reluctant quantifier mentioned, so this will be greedy.
		// Will go till last , or .  and then back off
//		String patternString1 = "(John) (.+)[,\\.]";

		// reluctant quantifier
		// Will stop at first , or .  and then try to take more
//		String patternString1 = "(John) (.+?)[,\\.]";

		// Will take only 1 character
//		String patternString1 = "(John) (.+?)"; // try this one too to see what it will do

		// Will take next chracters till space. Observer spaces in the patterns
		String patternString1 = "(John) (.+?) "; // try this one too to see what it will do

		Pattern pattern = Pattern.compile(patternString1);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found:");
//			System.out.println("group 0: " + matcher.group(0));
//			System.out.println("group 1: " + matcher.group(1));
			System.out.println("group 2: " + matcher.group(2));
			System.out.println("");

		}
		
		


	}
}
