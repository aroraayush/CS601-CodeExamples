package decoratorExample;

import java.io.*;
/** Modified from Head First, Design Patterns book. Demonstrates Decorator pattern. */
public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		//System.out.print((char)c);
		//System.out.println(c);

		if (Character.isUpperCase(c))
			return Character.toLowerCase(c);
		else
			return c;
	}

	@Override
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset+result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}
}
