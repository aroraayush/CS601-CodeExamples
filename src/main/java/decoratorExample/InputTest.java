package decoratorExample;

import java.io.*;

/** From Head First, Design Patterns book. Decorator Example. */
public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;

		try (InputStream in =
				new LowerCaseInputStream(
					new BufferedInputStream(
						new FileInputStream("src/main/java/decoratorExample/test.txt")))) {

			while((c = in.read()) > 0 ) {
				System.out.print((char)c);
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
