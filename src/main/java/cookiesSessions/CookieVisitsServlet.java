package cookiesSessions;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 *
 * @see CookieBaseServlet
 * @see CookieVisitsServlet
 * @see CookieConfigServlet
 */
@SuppressWarnings("serial")
public class CookieVisitsServlet extends CookieBaseServlet {

    public static final String VISIT_DATE = "Visited";
    public static final String VISIT_COUNT = "Count";

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //log.info("GET " + request.getRequestURL().toString());

		System.out.println("request.getRequestURI() "+request.getRequestURI());

		// void sendError(int sc, String msg)
		// Sends an error response to the client using the specified status code and
		// clears the buffer. The server will preserve cookies and may clear or update
		// any headers needed to serve the error page as a valid response.
		// If an error-page declaration has been made for the web application
		// corresponding to the status code passed in, it will be served back the error page

		if (request.getRequestURI().endsWith("favicon.ico")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        prepareResponse("CookieServer", response);

        Map<String, String> cookies = getCookieMap(request);

        String visitDate = cookies.get(VISIT_DATE);
        String visitCount = cookies.get(VISIT_COUNT);

        PrintWriter out = response.getWriter();
        out.printf("<p>");

        // Update visit count as necessary and output information.
        if ((visitDate == null) || (visitCount == null)) {
            visitCount = "0";

            out.println("You have never been to this webpage before! ");
            out.println("Thank you for visiting.");
        } else {
            visitCount = Integer.toString(Integer.parseInt(visitCount) + 1);

            out.println("You have visited this website " + visitCount + " times.");
            out.printf("Your last visit was on " + visitDate);
        }

        out.println("</p>");

        // Checks if the browser indicates visits should not be tracked.
        // Try this in Safari private browsing mode.

		// getIntHeader(String name)
		// Returns the value of the specified request header as an int.
		// If the request does not have a header of the specified name, this method returns -1.
		// If the header cannot be converted to an integer, this method throws a
		// NumberFormatException.


		// DNT (Do Not Track) request header indicates the user's tracking preference.
		// It lets users indicate whether they would prefer privacy rather than personalized content.
		// 0 - The user prefers to allow tracking on the target site.
		//1 - The user prefers not to be tracked on the target site.
        if (request.getIntHeader("DNT") != 1) {
            System.out.println("cookie: " + getDate());
            response.addCookie(new Cookie("Visited", getDate()));
            response.addCookie(new Cookie("Count", visitCount));
        } else {
            clearCookies(request, response);
            out.printf("<p>Your visits will not be tracked.</p>");
        }

        finishResponse(request, response);
    }
}