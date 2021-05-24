package webServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Servlet implementation class WebServlet
 */
@javax.servlet.annotation.WebServlet("/WebServlet")
public class WebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/mysummertrips";
		Connection conn = null;
		try {
			 //Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("Error al cargar el driver");
		}
		try {
			conn = DriverManager.getConnection(url, usuario, password);
			if (conn != null) {
				System.out.println("Conexión a base de datos " + url + " ... Ok");
			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		String nombre = request.getParameter("name");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telephone");
		String opinion = request.getParameter("resumen");
		
		PrintWriter out;
		out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Datos a Introducir a la Base de Datos</title></head>");
		out.println("<body>");
		out.println("<h1>Estos son los datos que se introducir�n a la Base de Datos 'Coches':</h1>");
		out.println("<h2>"+nombre+"</h2>");
		out.println("<h2>"+email+"</h2>");
		out.println("<h2>"+telefono+"</h2>");
		out.println("<h2>"+opinion+"</h2>");
		out.println("<p>Si observa que en esta p�gina los datos no est�n en may�sculas (si es as� como lo ha indicado en los cuadros del formulario), no se preocupe, en la base de datos S� est�n en may�sculas.</p>");
		out.println("<hr/>");
		out.println("<h1>Estos son los registros actuales de la base de datos:</h1>");
		out.println("<h2>|Matr�cula|\t|Marca|\t|Modelo|\t|Color|</h2>");
		
		out.println("</body></html>");

		try {
			Statement st = conn.createStatement();
			//st.execute("delete from TablaPrueba where nombre='Alfredo'");
			st.execute("insert into feedback values ('"+nombre+"','"+email+"','"+telefono+"','"+opinion+"')");
			//st.execute("update TablaPrueba set codigo=22223 where nombre='Alfredo'");
			
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		try {
			conn.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
