package cookiesSessions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * An {@link HttpServlet} with several additional utility methods. Used by
 * several servlet examples.
 */
@SuppressWarnings("serial")
public class CookieBaseServlet extends HttpServlet {

	/**
	 * Returns the current date and time in a short format.
	 *
	 * @return current date and time
	 */
	public static String getDate() {
		String format = "yyyy-MM-dd"; //"yyyy-MM-dd hh:mm";
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(Calendar.getInstance().getTime());
	}

	/**
	 * Prepares the HTTP response by setting the content type and adding header
	 * HTML code.
	 *
	 * @param title
	 *            - web page title
	 * @param response
	 *            - HTTP response
	 * @throws IOException
	 * @see #finishResponse(HttpServletRequest, HttpServletResponse)
	 */
	public static void prepareResponse(String title, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html><head>");
		out.println("\t<title>" + title + "</title>");
		out.println("<content=\"text/html;charset=utf-8\">");
		out.println("</head>");
		out.println("<body>");
	}

	/**
	 * Finishes the HTTP response by adding footer HTML code and setting the
	 * response code.
	 *
	 * @param request
	 *            - HTTP request
	 * @param response
	 *            - HTTP response
	 * @throws IOException
	 * @see #prepareResponse(String, HttpServletResponse)
	 */
	public static void finishResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.println("");
		out.println("</body>");
		out.println("</html>");
		out.flush();

		response.setStatus(HttpServletResponse.SC_OK);
		// flushBuffer
		// Forces any content in the buffer to be written to the client.
		// A call to this method automatically commits the response, meaning
		// the status code and headers will be written.
		response.flushBuffer();
	}

	/**
	 * Gets the cookies form the HTTP request, and maps the cookie key to the
	 * cookie value.
	 *
	 * @param request
	 *            - HTTP request from web server
	 * @return map from cookie key to cookie value
	 */
	public Map<String, String> getCookieMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();

		// request.getCookies()
		// Returns an array containing all of the Cookie objects the client sent
		// with this request. This method returns null if no cookies were sent.
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				map.put(cookie.getName(), cookie.getValue());
			}
		}
		return map;
	}

	/**
	 * Clears all of the cookies included in the HTTP request.
	 *
	 * @param request
	 *            - HTTP request
	 * @param response
	 *            - HTTP response
	 */
	public void clearCookies(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
}