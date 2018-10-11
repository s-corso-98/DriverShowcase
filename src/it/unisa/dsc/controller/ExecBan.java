package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.dsc.model.AziendaDAO;
import it.unisa.dsc.model.AziendaDTO;
import it.unisa.dsc.model.UtenteDAO;
import it.unisa.dsc.model.UtenteDTO;

@WebServlet("/ExecBan")
public class ExecBan extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException , ServletException
	{
		UtenteDAO u1=new UtenteDAO();
		AziendaDAO az1=new AziendaDAO();
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String id=(String)request.getParameter("ListUt");
		try {
					az1.doDelete(id);
					u1.doDelete(id);
					out.println("<script type='text/javascript'>");
					out.println("alert('Utente cancellato con successo');");
					out.println("location='view/Home.jsp';");
					out.println("</script>");

			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException , ServletException
	{
		response.setContentType("text/html");
		UtenteDAO u1=new UtenteDAO();
		AziendaDAO az1=new AziendaDAO();
		PrintWriter out= response.getWriter();
		
		try {
			List<UtenteDTO> listaUtenti=u1.doRetrieveAll();
			List<AziendaDTO> listaAziende=az1.doRetrieveAll();
			for(int i=0;i<listaUtenti.size();i++)
				out.append("<option name='id' value="+listaUtenti.get(i).getCodicefiscale()+">"+listaUtenti.get(i).getCodicefiscale()+"</option>");
			for(int j=0;j<listaAziende.size();j++)
				out.append("<option name='Pi' value="+listaAziende.get(j).getPIVA()+">"+listaAziende.get(j).getPIVA()+"</option>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
