package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** SimpleHelloServlet for the SimpleHelloServer example */
@SuppressWarnings("serial")
public class VisitsServlet extends HttpServlet {

	private static int totalNumberVisits = 0;

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>" + String.valueOf(totalNumberVisits) + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}