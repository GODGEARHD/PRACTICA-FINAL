package webServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/PrimerServlet555")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		
		String nombre = request.getParameter("nombre");
		String ape = request.getParameter("ape");
		int num1=-1,num2=-1;
		
		if(nombre==null) {
			num1 = Integer.parseInt(request.getParameter("num1"));
			num2 = Integer.parseInt(request.getParameter("num2"));
		}
		PrintWriter out;
		out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Mi Primer Servlet </title></head>");
		out.println("<body>");
		out.println("<h1>Este es mi Primer Servlet</h1>");
		out.println("<hr/>");
		if(nombre==null) {
			out.println("<h2>SUMA</h2>");
			out.println("<h2>"+(num1+num2)+"</h2>");			
		}else {
			out.println("<h2>"+nombre+"</h2>");
			out.println("<h2>"+ape+"</h2>");
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
