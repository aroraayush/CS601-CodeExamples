package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherSimpleExample {
	public static void main(String[] args) {
		try {
			Pattern p = Pattern.compile("[a-z]+");
			String text = "Now is the time";
//		String text = "now is the time";
//			String exceptionText = "1a01010200304";
		Matcher m = p.matcher(text);
//			Matcher m = p.matcher(exceptionText);

			boolean flag1 = m.matches();
			boolean flag2 = m.lookingAt();
			System.out.println(flag1 + " " + flag2);

			while (m.find()) {
//			System.out.println("group 0: " + m.group(0));
			// The substring begins at the specified beginIndex and extends to
			// the character at index endIndex – 1.
			String s = text.substring(m.start(), m.end());
//				String s = exceptionText.substring(m.start(), m.end());
				System.out.println("Found: " + s + "*");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
