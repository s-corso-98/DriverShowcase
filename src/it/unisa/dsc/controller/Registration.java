package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.dsc.model.*;



@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession Session=request.getSession(false);
		UtenteDAO help=new UtenteDAO();
		AziendaDAO help2=new AziendaDAO();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String x=request.getParameter("tipologia");
		if(x.equals("Azienda"))
			{
				try
				{
					AziendaDTO a1=new AziendaDTO();
					a1.setNome(request.getParameter("Nome"));
					a1.setEmail(request.getParameter("Email"));
					a1.setPassword(request.getParameter("Password"));
					a1.setCittà(request.getParameter("Citta"));
					a1.setPIVA(request.getParameter("PIVA"));
					a1.setProvincia(request.getParameter("Provincia"));
					a1.setVia(request.getParameter("Via"));
					a1.setRecapito(request.getParameter("Recapito"));
					
				
				
				if(help2.doSave(a1)==1)
				{
				request.setAttribute("namejsp",a1.getNome());
				out.println("<script type='text/javascript'>");
				out.println("alert('Registrazione effettuata con successo');");
				out.println("location='view/Home.jsp';");
				out.println("</script>");
				}
			else
			{
				out.println("<script type='text/javascript'>");
				out.println("alert('Registrazione fallita');");
				out.println("location='view/Home.jsp';");
				out.println("</script>");
			}
				}
				catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
		if(x.equals("Privato"))
		{
		try {
			UtenteDTO u1 = new UtenteDTO();
			u1.setNome(request.getParameter("Nome"));
			u1.setCognome(request.getParameter("Cognome"));
			u1.setEmail(request.getParameter("Email"));
			u1.setPassword(request.getParameter("Password"));
			u1.setAdmin(false);
			u1.setCittà(request.getParameter("Citta"));
			u1.setCodicefiscale(request.getParameter("CodiceFiscale"));
			u1.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Data")));
			u1.setDocumento(request.getParameter("Documento"));
			u1.setNumdocumento(request.getParameter("NumeroDocumento"));
			u1.setProvincia(request.getParameter("Provincia"));
			u1.setVia(request.getParameter("Via"));
			u1.setRecapito(request.getParameter("Recapito"));
			
			if(help.doSave(u1)==1)
				{
				System.out.println("inserimento con successo");
				request.setAttribute("namejsp",u1.getNome());
				request.setAttribute("surnamejsp",u1.getCognome());
					
				out.println("<script type='text/javascript'>");
				out.println("alert('Registrazione effettuata con successo');");
				out.println("location='view/Home.jsp';");
				out.println("</script>");
				}
			else
			{
				System.out.println("Inserimento fallito");
				out.println("<script type='text/javascript'>");
				out.println("alert('Registrazione fallita');");
				out.println("location='view/Home.jsp';");
				out.println("</script>");
		}
					
			
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String x = request.getParameter("azione");
		if(x.equals("Azienda"))
			{
			 out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Nome azienda</label>\r\n" + 
			 		"								<input type=\"text\" name=\"Nome\" placeholder=\"Nome\" required=\"\">\r\n" + 
			 		"							</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Email </label>\r\n" + 
			 		"								<input type=\"email\" name=\"Email\" placeholder=\"Email\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Password </label>\r\n" + 
			 		"								<input type=\"password\" name=\"Password\" placeholder=\"Password\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>PartitaIVA </label>\r\n" + 
			 		"								<input type=\"text\" name=\"PIVA\" placeholder=\"Partita Iva\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Recapito telefonico </label>\r\n" + 
			 		"								<input type=\"text\" name=\"Recapito\" placeholder=\"Recapito\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Provincia </label>\r\n" + 
			 		"								<input type=\"text\" name=\"Provincia\" placeholder=\"Provincia\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Città </label>\r\n" + 
			 		"								<input type=\"text\" name=\"Citta\" placeholder=\"Città\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>\r\n" + 
			 		"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			 		"							<span class=\"agileits_grid\">\r\n" + 
			 		"								<label>Via </label>\r\n" + 
			 		"								<input type=\"text\" name=\"Via\" placeholder=\"Via\" required=\"\">\r\n" + 
			 		"								</span>\r\n" + 
			 		"						</div>");
			
			}
		if(x.equals("Privato"))
			{
			out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Nome </label>\r\n" + 
					"								<input type=\"text\" name=\"Nome\" placeholder=\"Nome\" required=\"\">\r\n" + 
					"							</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Cognome </label>\r\n" + 
					"								<input type=\"text\" name=\"Cognome\" placeholder=\"Cognome\" required=\"\">\r\n" + 
					"							</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Email </label>\r\n" + 
					"								<input type=\"email\" name=\"Email\" placeholder=\"Email\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Password </label>\r\n" + 
					"								<input type=\"password\" name=\"Password\" placeholder=\"Password\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>CodiceFiscale </label>\r\n" + 
					"								<input type=\"text\" name=\"CodiceFiscale\" placeholder=\"CodiceFiscale\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Recapito telefonico </label>\r\n" + 
					"								<input type=\"text\" name=\"Recapito\" placeholder=\"Recapito\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"agileits_w3layouts_main_grid w3ls_main_grid\">\r\n" + 
					"							<span class=\"agileinfo_grid\">\r\n" + 
					"								<label>Data Di Nascita</label>\r\n" + 
					"								<input type=\"date\" id=\"datepicker\" name=\"Data\" type=\"text\" value=\"yyyy/mm/dd\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = '';}\" required=\"\">\r\n" + 
					"							</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Provincia </label>\r\n" + 
					"								<input type=\"text\" name=\"Provincia\" placeholder=\"Provincia\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Città </label>\r\n" + 
					"								<input type=\"text\" name=\"Citta\" placeholder=\"Città\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Via </label>\r\n" + 
					"								<input type=\"text\" name=\"Via\" placeholder=\"Via\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>Documento </label>\r\n" + 
					"								<select name=\"Documento\" id=\"Documento\" placeholder=\"Documento\" required=\"\">" + 
					"					   							<option value=\"Carta Identità\">Carta Identità </option>" + 
					"					                               <option value=\"Patente\">Patente </option>" + 
					"					                               <option value=\"Passaporto\">Passaporto </option>" + 
					"					                               </select>\r\n"+
					"								</span>\r\n" + 
					"						</div>\r\n" + 
					"						<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
					"							<span class=\"agileits_grid\">\r\n" + 
					"								<label>NumeroDocumento </label>\r\n" + 
					"								<input type=\"text\" name=\"NumeroDocumento\" placeholder=\"Numero Documento\" required=\"\">\r\n" + 
					"								</span>\r\n" + 
					"						</div>");
			}
	}
}