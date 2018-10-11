package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.dsc.model.AccessoriDAO;
import it.unisa.dsc.model.AccessoriDTO;
import it.unisa.dsc.model.AutoDAO;
import it.unisa.dsc.model.AutoDTO;
import it.unisa.dsc.model.MotoDAO;
import it.unisa.dsc.model.MotoDTO;


/**
 * Servlet implementation class Filtri
 */
@WebServlet("/Filtri")
public class Filtri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String Filtro=request.getParameter("Filtro");
		String tipologia=request.getParameter("TipoFilter");
		if(Filtro.equals("1") && tipologia.equals("Moto"))
		{
			MotoDAO Moto=new MotoDAO();
			
			try {
				List<MotoDTO> ListaMoto=new ArrayList<MotoDTO>();
				ListaMoto=Moto.doRetrieveAll();
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaMoto.size();i++)
				{	
					out.append("<option value="+ListaMoto.get(i).getMarca()+">"+ListaMoto.get(i).getMarca()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("2") && tipologia.equals("Moto"))
		{MotoDAO Moto=new MotoDAO();
			String Marca=request.getParameter("Marca");
			try {
				List<MotoDTO> ListaMoto=new ArrayList<MotoDTO>();
				ListaMoto=Moto.doRetrieveByMarca(Marca);
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaMoto.size();i++)
				{	
					out.append("<option value="+ListaMoto.get(i).getModello()+">"+ListaMoto.get(i).getModello()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("3") && tipologia.equals("Moto"))
		{	String Modello=request.getParameter("Modello");
			MotoDAO Moto=new MotoDAO();
			
			try {
				List<MotoDTO> ListaMoto=new ArrayList<MotoDTO>();
				ListaMoto=Moto.doRetrieveByModello(Modello);
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaMoto.size();i++)
				{	
					out.append("<option value="+ListaMoto.get(i).getKm()+">"+ListaMoto.get(i).getKm()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("4") && tipologia.equals("Moto"))
		{MotoDAO Moto=new MotoDAO();
			String Marca=request.getParameter("Marca");
			String Modello=request.getParameter("Modello");
			Double Km=Double.parseDouble(request.getParameter("Km"));
			try {
				List<MotoDTO> ListaMoto=new ArrayList<MotoDTO>();
				out.append("<option disabled selected value> -- select an option -- </option>");
				ListaMoto=Moto.doRetrieveByAnno(Marca,Modello,Km);
				for(int i=0;i<ListaMoto.size();i++)
				{	
					out.append("<option value="+ListaMoto.get(i).getAnno()+">"+ListaMoto.get(i).getAnno()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("5") && tipologia.equals("Moto"))
		{MotoDAO Moto=new MotoDAO();
			String Marca=request.getParameter("Marca");
			String Modello=request.getParameter("Modello");
			Double	Km=Double.parseDouble(request.getParameter("Km"));
			String Prezzo=request.getParameter("Prezzo");
				int Anno=Integer.parseInt(request.getParameter("Anno"));
			byte[] help;
			
			try {
				List<MotoDTO> ListaMoto=new ArrayList<MotoDTO>();
				
				ListaMoto=Moto.doRetrieveByFilter(Marca,Modello,Km,Prezzo,Anno);
				for(int i=0;i<ListaMoto.size();i++)
				{	
					help=ListaMoto.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
					out.append(
							"<div class='annuncio' id=\""+ListaMoto.get(i).getIdMoto()+"\">\r\n"+
							"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
							"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
							"<p> Modello: "+ListaMoto.get(i).getModello()+"</p>"+
							"<p> Prezzo: "+ListaMoto.get(i).getPrezzo()+"</p>"+
							"<input type='hidden' name='Cf' value="+ListaMoto.get(i).getCodiceFiscale()+">"+
							"<input type='hidden' name='Iv' value="+ListaMoto.get(i).getPartitaIva()+">"+
							"<input type='hidden' name='Id' value="+ListaMoto.get(i).getIdMoto()+">"+
							"<input type='hidden' name='Km' value="+ListaMoto.get(i).getKm()+">"+
							"<input type='hidden' name='Anno' value="+ListaMoto.get(i).getAnno()+">"+
							"<input type='hidden' name='Img' value="+encoding+">"+
							"<input type='hidden' name='Marca' value="+ListaMoto.get(i).getMarca()+">"+
							"<input type='hidden' name='Modello' value="+ListaMoto.get(i).getModello()+">"+
							"<input type='hidden' name='Desc' value="+ListaMoto.get(i).getDescrizione()+">"+
							"<input type='hidden' name='Prezzo' value="+ListaMoto.get(i).getPrezzo()+">"+
							"<input id='button' type='submit' value='In dettaglio'>"+
							"</form>"+
							"</div>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("6") && tipologia.equals("Moto"))
		{
			MotoDAO Moto=new MotoDAO();
			String Prezzo=request.getParameter("Prezzo");
			byte[] help;
			try {
				List<MotoDTO> ListaMoto=new ArrayList<MotoDTO>();
				ListaMoto=Moto.doRetrieveByPrezzo(Prezzo);
				for(int i=0;i<ListaMoto.size();i++)
				{	
					help=ListaMoto.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
					out.append(
							"<div class='annuncio' id=\""+ListaMoto.get(i).getIdMoto()+"\">\r\n"+
							"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
							"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
							"<p> Modello: "+ListaMoto.get(i).getModello()+"</p>"+
							"<p> Prezzo: "+ListaMoto.get(i).getPrezzo()+"</p>"+
							"<input type='hidden' name='Cf' value="+ListaMoto.get(i).getCodiceFiscale()+">"+
							"<input type='hidden' name='Iv' value="+ListaMoto.get(i).getPartitaIva()+">"+
							"<input type='hidden' name='Id' value="+ListaMoto.get(i).getIdMoto()+">"+
							"<input type='hidden' name='Km' value="+ListaMoto.get(i).getKm()+">"+
							"<input type='hidden' name='Anno' value="+ListaMoto.get(i).getAnno()+">"+
							"<input type='hidden' name='Img' value="+encoding+">"+
							"<input type='hidden' name='Marca' value="+ListaMoto.get(i).getMarca()+">"+
							"<input type='hidden' name='Modello' value="+ListaMoto.get(i).getModello()+">"+
							"<input type='hidden' name='Desc' value="+ListaMoto.get(i).getDescrizione()+">"+
							"<input type='hidden' name='Prezzo' value="+ListaMoto.get(i).getPrezzo()+">"+
							"<input id='button' type='submit' value='In dettaglio'>\r\n"+
							"</form>"+
							"</div>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("1") && tipologia.equals("Auto"))
		{
			AutoDAO a1=new AutoDAO();
			
			try {
				List<AutoDTO> ListaAuto=new ArrayList<AutoDTO>();
				ListaAuto=a1.doRetrieveAll();
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaAuto.size();i++)
				{	
					out.append("<option value="+ListaAuto.get(i).getMarca()+">"+ListaAuto.get(i).getMarca()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("2") && tipologia.equals("Auto"))
		{AutoDAO a1=new AutoDAO();
			String Marca=request.getParameter("Marca");
			try {
				List<AutoDTO> ListaAuto=new ArrayList<AutoDTO>();
				ListaAuto=a1.doRetrieveByMarca(Marca);
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaAuto.size();i++)
				{	
					out.append("<option value="+ListaAuto.get(i).getModello()+">"+ListaAuto.get(i).getModello()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("3") && tipologia.equals("Auto"))
		{	String Modello=request.getParameter("Modello");
			AutoDAO a1=new AutoDAO();
			
			try {
				List<AutoDTO> ListaAuto=new ArrayList<AutoDTO>();
				ListaAuto=a1.doRetrieveByModello(Modello);
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaAuto.size();i++)
				{	
					out.append("<option value="+ListaAuto.get(i).getKm()+">"+ListaAuto.get(i).getKm()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("4") && tipologia.equals("Auto"))
		{AutoDAO a1=new AutoDAO();
			String Marca=request.getParameter("Marca");
			String Modello=request.getParameter("Modello");
			Double Km=Double.parseDouble(request.getParameter("Km"));
			try {
				List<AutoDTO> ListaAuto=new ArrayList<AutoDTO>();
				out.append("<option disabled selected value> -- select an option -- </option>");
				ListaAuto=a1.doRetrieveByAnno(Marca,Modello,Km);
				for(int i=0;i<ListaAuto.size();i++)
				{	
					out.append("<option value="+ListaAuto.get(i).getAnno()+">"+ListaAuto.get(i).getAnno()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("5") && tipologia.equals("Auto"))
		{AutoDAO a1=new AutoDAO();
			String Marca=request.getParameter("Marca");
			String Modello=request.getParameter("Modello");
			Double	Km=Double.parseDouble(request.getParameter("Km"));
			String Prezzo=request.getParameter("Prezzo");
				int Anno=Integer.parseInt(request.getParameter("Anno"));
			byte[] help;
			
			try {
				List<AutoDTO> ListaAuto=new ArrayList<AutoDTO>();
				
				ListaAuto=a1.doRetrieveByFilter(Marca,Modello,Km,Prezzo,Anno);
				for(int i=0;i<ListaAuto.size();i++)
				{	
					help=ListaAuto.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
					out.append(
							"<div class='annuncio' id=\""+ListaAuto.get(i).getIdA()+"\">\r\n"+
							"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
							"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
							"<p> Modello: "+ListaAuto.get(i).getModello()+"</p>"+
							"<p> Prezzo: "+ListaAuto.get(i).getPrezzo()+"</p>"+
							"<input type='hidden' name='Cf' value="+ListaAuto.get(i).getCodiceFiscale()+">"+
							"<input type='hidden' name='Iv' value="+ListaAuto.get(i).getPartitaIva()+">"+
							"<input type='hidden' name='Id' value="+ListaAuto.get(i).getIdA()+">"+
							"<input type='hidden' name='Km' value="+ListaAuto.get(i).getKm()+">"+
							"<input type='hidden' name='Anno' value="+ListaAuto.get(i).getAnno()+">"+
							"<input type='hidden' name='Img' value="+encoding+">"+
							"<input type='hidden' name='Marca' value="+ListaAuto.get(i).getMarca()+">"+
							"<input type='hidden' name='Modello' value="+ListaAuto.get(i).getModello()+">"+
							"<input type='hidden' name='Desc' value="+ListaAuto.get(i).getDescrizione()+">"+
							"<input type='hidden' name='Prezzo' value="+ListaAuto.get(i).getPrezzo()+">"+
							"<input id='button' type='submit' value='In dettaglio'>"+
							"</form>"+
							"</div>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("6") && tipologia.equals("Auto"))
		{AutoDAO a1=new AutoDAO();
			String Prezzo=request.getParameter("Prezzo");
			byte[] help;
			try {
				List<AutoDTO> ListaAuto=new ArrayList<AutoDTO>();
				ListaAuto=a1.doRetrieveByPrezzo(Prezzo);
				for(int i=0;i<ListaAuto.size();i++)
				{	
					help=ListaAuto.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
					out.append(
							"<div class='annuncio' id=\""+ListaAuto.get(i).getIdA()+"\">\r\n"+
							"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
							"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
							"<p> Modello: "+ListaAuto.get(i).getModello()+"</p>"+
							"<p> Prezzo: "+ListaAuto.get(i).getPrezzo()+"</p>"+
							"<input type='hidden' name='Cf' value="+ListaAuto.get(i).getCodiceFiscale()+">"+
							"<input type='hidden' name='Iv' value="+ListaAuto.get(i).getPartitaIva()+">"+
							"<input type='hidden' name='Id' value="+ListaAuto.get(i).getIdA()+">"+
							"<input type='hidden' name='Km' value="+ListaAuto.get(i).getKm()+">"+
							"<input type='hidden' name='Anno' value="+ListaAuto.get(i).getAnno()+">"+
							"<input type='hidden' name='Img' value="+encoding+">"+
							"<input type='hidden' name='Marca' value="+ListaAuto.get(i).getMarca()+">"+
							"<input type='hidden' name='Modello' value="+ListaAuto.get(i).getModello()+">"+
							"<input type='hidden' name='Desc' value="+ListaAuto.get(i).getDescrizione()+">"+
							"<input type='hidden' name='Prezzo' value="+ListaAuto.get(i).getPrezzo()+">"+
							"<input id='button' type='submit' value='In dettaglio'>"+
							"</form>"+
							"</div>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("1") && tipologia.equals("Accessori"))
		{
			AccessoriDAO ac1=new AccessoriDAO();
			
			try {
				List<AccessoriDTO> ListaAccessori=new ArrayList<AccessoriDTO>();
				ListaAccessori=ac1.doRetrieveAll();
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaAccessori.size();i++)
				{	
					out.append("<option value="+ListaAccessori.get(i).getMarca()+">"+ListaAccessori.get(i).getMarca()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Filtro.equals("2") && tipologia.equals("Accessori"))
		{AccessoriDAO ac1=new AccessoriDAO();
			String Marca=request.getParameter("Marca");
			try {
				List<AccessoriDTO> ListaAccessori=new ArrayList<AccessoriDTO>();
				ListaAccessori=ac1.doRetrieveByMarca(Marca);
				out.append("<option disabled selected value> -- select an option -- </option>");
				for(int i=0;i<ListaAccessori.size();i++)
				{	
					out.append("<option value="+ListaAccessori.get(i).getModello()+">"+ListaAccessori.get(i).getModello()+"</option>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Filtro.equals("3") && tipologia.equals("Accessori"))
		{AccessoriDAO ac1=new AccessoriDAO();
			String Marca=request.getParameter("Marca");
			String Modello=request.getParameter("Modello");
			String Prezzo=request.getParameter("Prezzo");
			byte[] help;
			
			try {
				List<AccessoriDTO> ListaAccessori=new ArrayList<AccessoriDTO>();
				
				ListaAccessori=ac1.doRetrieveByFilter(Marca,Modello,Prezzo);
				for(int i=0;i<ListaAccessori.size();i++)
				{	
					help=ListaAccessori.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
					out.append(
							"<div class='annuncio' id=\""+ListaAccessori.get(i).getIdAccessori()+"\">\r\n"+
							"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
							"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
							"<p> Modello: "+ListaAccessori.get(i).getModello()+"</p>"+
							"<p> Prezzo: "+ListaAccessori.get(i).getPrezzo()+"</p>"+
							"<input type='hidden' name='Cf' value="+ListaAccessori.get(i).getCodiceFiscale()+">"+
							"<input type='hidden' name='Iv' value="+ListaAccessori.get(i).getPartitaIva()+">"+
							"<input type='hidden' name='Id' value="+ListaAccessori.get(i).getIdAccessori()+">"+
							"<input type='hidden' name='Img' value="+encoding+">"+
							"<input type='hidden' name='Marca' value="+ListaAccessori.get(i).getMarca()+">"+
							"<input type='hidden' name='Modello' value="+ListaAccessori.get(i).getModello()+">"+
							"<input type='hidden' name='Desc' value="+ListaAccessori.get(i).getDescrizione()+">"+
							"<input type='hidden' name='Prezzo' value="+ListaAccessori.get(i).getPrezzo()+">"+
							"<input id='button' type='submit' value='In dettaglio'>"+
							"</form>"+
							"</div>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(Filtro.equals("4") && tipologia.equals("Accessori"))
		{AccessoriDAO ac1=new AccessoriDAO();
			String Prezzo=request.getParameter("Prezzo");
			byte[] help;
			try {
				List<AccessoriDTO> ListaAccessori=new ArrayList<AccessoriDTO>();
				ListaAccessori=ac1.doRetrieveByPrezzo(Prezzo);
				for(int i=0;i<ListaAccessori.size();i++)
				{	
					
					help=ListaAccessori.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
					out.append(
							"<div class='annuncio' id=\""+ListaAccessori.get(i).getIdAccessori()+"\">\r\n"+
							"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
							"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
							"<p> Modello: "+ListaAccessori.get(i).getModello()+"</p>"+
							"<p> Prezzo: "+ListaAccessori.get(i).getPrezzo()+"</p>"+
							"<input type='hidden' name='Cf' value="+ListaAccessori.get(i).getCodiceFiscale()+">"+
							"<input type='hidden' name='Iv' value="+ListaAccessori.get(i).getPartitaIva()+">"+
							"<input type='hidden' name='Id' value="+ListaAccessori.get(i).getIdAccessori()+">"+
							"<input type='hidden' name='Img' value="+encoding+">"+
							"<input type='hidden' name='Marca' value="+ListaAccessori.get(i).getMarca()+">"+
							"<input type='hidden' name='Modello' value="+ListaAccessori.get(i).getModello()+">"+
							"<input type='hidden' name='Desc' value="+ListaAccessori.get(i).getDescrizione()+">"+
							"<input type='hidden' name='Prezzo' value="+ListaAccessori.get(i).getPrezzo()+">"+
							"<input id='button' type='submit' value='In dettaglio'>"+
							"</form>"+
							"</div>");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		
	}
		
}

