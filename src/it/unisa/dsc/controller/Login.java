package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.dsc.model.AziendaDAO;
import it.unisa.dsc.model.AziendaDTO;
import it.unisa.dsc.model.UtenteDAO;
import it.unisa.dsc.model.UtenteDTO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession Session=request.getSession(false);
		UtenteDAO help=new UtenteDAO();
		AziendaDAO help2=new AziendaDAO();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		try {
			UtenteDTO u1 = new UtenteDTO();
			u1=help.doRetrieveByKey(request.getParameter("Email"), request.getParameter("Password"));
			if(u1!=null)
				{
				Session.setAttribute("Logged","Yes");
				Session.setAttribute("Cf", u1.getCodicefiscale());
				Session.setAttribute("name",u1.getNome());
				Session.setAttribute("surname", u1.getCognome());
				Session.setAttribute("Admin", u1.isAdmin());
				RequestDispatcher view = request.getRequestDispatcher("view/Home.jsp");
				view.forward(request, response);
				}
			
			else
			{
				try {
					AziendaDTO az1 = new AziendaDTO();
					az1=help2.doRetrieveByKey(request.getParameter("Email"), request.getParameter("Password"));
					if(az1!=null)
						{
						Session.setAttribute("Logged","Yes");
						Session.setAttribute("Piva", az1.getPIVA());
						Session.setAttribute("name",az1.getNome());
						RequestDispatcher view = request.getRequestDispatcher("view/Home.jsp");
						view.forward(request, response);
						}
					
					else
					{
						out.println("<script type='text/javascript'>");
						out.println("alert('Dati inseriti non corretti');");
						out.println("location='view/Home.jsp';");
						out.println("</script>");
					}		
					
				}  catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
					
			
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
