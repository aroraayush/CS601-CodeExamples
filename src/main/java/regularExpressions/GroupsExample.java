package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupsExample {
	public static void main(String[] args) {

		// example 1
		System.out.println("Example 1 ===============");
		String str = "Hello: This is a Test:1, 2, 3";

		// by default the matching is greedy as not reluctant quantifier (?) added
		Pattern p1 = Pattern.compile("(.*):(.*)");

		Matcher m1 = p1.matcher(str);
		if (m1.find()) {
			System.out.println(m1.group(0));
			System.out.println(m1.group(1));
			System.out.println(m1.group(2));

		}

		// example 2
		System.out.println("Example 2===============");

		// ? made this quantifier "reluctant"
		Pattern p2 = Pattern.compile("(.*?):");
		Matcher m2 = p2.matcher(str);
		if (m2.find()) {
			System.out.println(m2.group(0));
			System.out.println(m2.group(1));
			System.out.println(m2.group(2));
		}

	}
}
