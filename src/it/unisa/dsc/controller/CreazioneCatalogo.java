package it.unisa.dsc.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.dsc.model.AccessoriDAO;
import it.unisa.dsc.model.AccessoriDTO;
import it.unisa.dsc.model.AutoDAO;
import it.unisa.dsc.model.AutoDTO;
import it.unisa.dsc.model.MotoDAO;
import it.unisa.dsc.model.MotoDTO;


@WebServlet("/CreazioneCatalogo")
public class CreazioneCatalogo extends HttpServlet {
	public static final long serialVersionUID=1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		String x = request.getParameter("tipo");
		HttpSession session=request.getSession(false);
		
		if(x.equals("Auto"))
			{
			AutoDAO a1=new AutoDAO();
			try {
				byte[] help;
				List<AutoDTO> ListAuto=new ArrayList<AutoDTO>();
				ListAuto=a1.doRetrieveAll();
				for(int i=0;i<ListAuto.size();i++)
					{
					help=ListAuto.get(i).getImg();
					Base64.Encoder encoder = Base64.getEncoder();
					String encoding = "data:image/png;base64," + encoder.encodeToString(help);
				out.append(
					"<div class='annuncio' id=\""+ListAuto.get(i).getIdA()+"\">\r\n"+
					"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Auto' method='post'>"+ 
					"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
					"<p> Modello: "+ListAuto.get(i).getModello()+"</p>"+
					"<p> Prezzo: "+ListAuto.get(i).getPrezzo()+"</p>"+
					"<input type='hidden' name='Cf' value="+ListAuto.get(i).getCodiceFiscale()+">"+
					"<input type='hidden' name='Iv' value="+ListAuto.get(i).getPartitaIva()+">"+
					"<input type='hidden' name='Id' value="+ListAuto.get(i).getIdA()+">"+
					"<input type='hidden' name='Km' value="+ListAuto.get(i).getKm()+">"+
					"<input type='hidden' name='Anno' value="+ListAuto.get(i).getAnno()+">"+
					"<input type='hidden' name='Img' value="+encoding+">"+
					"<input type='hidden' name='Marca' value='"+ListAuto.get(i).getMarca()+"'>"+
					"<input type='hidden' name='Modello' value='"+ListAuto.get(i).getModello()+"'>"+
					"<input type='hidden' name='Desc' value='"+ListAuto.get(i).getDescrizione()+"'>"+
					"<input type='hidden' name='Prezzo' value="+ListAuto.get(i).getPrezzo()+">"+
					"<input id='button' type='submit' value='In dettaglio'>"+
					"</form>"+
					"</div>");}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		if(x.equals("Moto"))
			{
			{
				MotoDAO m1=new MotoDAO();
				try {
					byte[] help;
					List<MotoDTO> ListMoto=new ArrayList<MotoDTO>();
					ListMoto=m1.doRetrieveAll();
					for(int i=0;i<ListMoto.size();i++)
						{
						help=ListMoto.get(i).getImg();
						//ByteArrayInputStream bais = new ByteArrayInputStream(help);
						//BufferedImage help2= ImageIO.read(bais);
						Base64.Encoder encoder = Base64.getEncoder();
						String encoding = "data:image/png;base64," + encoder.encodeToString(help);
						out.append(
						"<div class='annuncio' id=\""+ListMoto.get(i).getIdMoto()+"\">\r\n"+
						"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Moto' method='post'>"+ 
						"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
						"<p> Modello: "+ListMoto.get(i).getModello()+"</p>"+
						"<p> Prezzo: "+ListMoto.get(i).getPrezzo()+"</p>"+
						"<input type='hidden' name='Cf' value="+ListMoto.get(i).getCodiceFiscale()+">"+
						"<input type='hidden' name='Iv' value="+ListMoto.get(i).getPartitaIva()+">"+
						"<input type='hidden' name='Id' value="+ListMoto.get(i).getIdMoto()+">"+
						"<input type='hidden' name='Km' value="+ListMoto.get(i).getKm()+">"+
						"<input type='hidden' name='Anno' value="+ListMoto.get(i).getAnno()+">"+
						"<input type='hidden' name='Img' value="+encoding+">"+
						"<input type='hidden' name='Marca' value='"+ListMoto.get(i).getMarca()+"'>"+
						"<input type='hidden' name='Modello' value='"+ListMoto.get(i).getModello()+"'>"+
						"<input type='hidden' name='Desc' value='"+ListMoto.get(i).getDescrizione()+"'>"+
						"<input type='hidden' name='Prezzo' value="+ListMoto.get(i).getPrezzo()+">"+
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
		if(x.equals("Accessori"))
			{
			
			{
				AccessoriDAO ac1=new AccessoriDAO();
				try {
					byte[] help;
					List<AccessoriDTO> ListAccessori=new ArrayList<AccessoriDTO>();
					ListAccessori=ac1.doRetrieveAll();
					for(int i=0;i<ListAccessori.size();i++)
						{
						help=ListAccessori.get(i).getImg();
						//ByteArrayInputStream bais = new ByteArrayInputStream(help);
						//BufferedImage help2= ImageIO.read(bais);
						Base64.Encoder encoder = Base64.getEncoder();
						String encoding = "data:image/png;base64," + encoder.encodeToString(help);
						out.append(
						"<div class='annuncio' id=\""+ListAccessori.get(i).getIdAccessori()+"\">\r\n"+
						"<form action='http://localhost:8080/DriverShowcase/view/Dettaglio.jsp?tipo=Accessori' method='post'>"+ 
						"<img src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
						"<p> Modello: "+ListAccessori.get(i).getModello()+"</p>"+
						"<p> Prezzo: "+ListAccessori.get(i).getPrezzo()+"</p>"+
						"<input type='hidden' name='Img' value="+encoding+">"+
						"<input type='hidden' name='Cf' value="+ListAccessori.get(i).getCodiceFiscale()+">"+
						"<input type='hidden' name='Iv' value="+ListAccessori.get(i).getPartitaIva()+">"+
						"<input type='hidden' name='Id' value="+ListAccessori.get(i).getIdAccessori()+">"+
						"<input type='hidden' name='Marca' value='"+ListAccessori.get(i).getMarca()+"'>"+
						"<input type='hidden' name='Modello' value='"+ListAccessori.get(i).getModello()+"'>"+
						"<input type='hidden' name='Desc' value='"+ListAccessori.get(i).getDescrizione()+"'>"+
						"<input type='hidden' name='Prezzo' value="+ListAccessori.get(i).getPrezzo()+">"+
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

		
		
	}
	


