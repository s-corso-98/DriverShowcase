package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

@WebServlet("/ShowAnnunci")
public class ShowAnnunci extends HttpServlet {
	public static final long serialVersionUID=1L;
	
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{
	AutoDAO a1=new AutoDAO();
	MotoDAO m1=new MotoDAO();
	AccessoriDAO ac1=new AccessoriDAO();
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession(false);
	String codicef= (String) session.getAttribute("Cf");
	String partitaI= (String) session.getAttribute("Piva");
	byte[] helpImg;
	List<AutoDTO> helpList = new ArrayList<AutoDTO>();
	List<MotoDTO> helpList2 = new ArrayList<MotoDTO>();
	List<AccessoriDTO> helpList3= new ArrayList<AccessoriDTO>();
	if(codicef==null)
	{
		try {
			helpList=a1.doRetrieveByPiva(partitaI);
			helpList2=m1.doRetrieveByPiva(partitaI);
			helpList3=ac1.doRetrieveByPiva(partitaI);
			
			for(int i=0;i<helpList.size();i++)
			{
				helpImg=helpList.get(i).getImg();
				//ByteArrayInputStream bais = new ByteArrayInputStream(help);
				//BufferedImage help2= ImageIO.read(bais);
				Base64.Encoder encoder = Base64.getEncoder();
				String encoding = "data:image/png;base64," + encoder.encodeToString(helpImg);
				out.append(
				"<form class='announce' action='../ShowAnnunci' method='get'>"+
				"<div  id='inframezzo'>\r\n"+
				"<p> Marca:" +helpList.get(i).getMarca()+"</p>"+
				"<p> Modello:" +helpList.get(i).getModello()+"</p>"+
				"<img id=\"ItemPreview\" src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
				"<input type='hidden' name='id' value='"+helpList.get(i).getIdA()+"'>\r\n"+
				"<input type='hidden' name='tipo' value='Auto'>\r\n"+
				"</div>"+
				"<input id='button' type='submit' value='Rimuovi annuncio'>\r\n"+
				"</form>");
			}
			
			for(int i=0;i<helpList2.size();i++)
			{
				helpImg=helpList2.get(i).getImg();
				//ByteArrayInputStream bais = new ByteArrayInputStream(help);
				//BufferedImage help2= ImageIO.read(bais);
				Base64.Encoder encoder = Base64.getEncoder();
				String encoding = "data:image/png;base64," + encoder.encodeToString(helpImg);
				out.append(
				"<form class='announce' action='../ShowAnnunci' method='get'>"+
				"<div  id='inframezzo'>\r\n"+
				"<p> Marca:" +helpList2.get(i).getMarca()+"</p>"+
				"<p> Modello:" +helpList2.get(i).getModello()+"</p>"+
				"<img id=\"ItemPreview\" src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
				"<input type='hidden' name='id' value='"+helpList2.get(i).getIdMoto()+"'>\r\n"+
				"<input type='hidden' name='tipo' value='Moto'>\r\n"+
				"</div>"+
				"<input id='button' type='submit' value='Rimuovi annuncio'>\r\n"+
				"</form>");
			}
			
			for(int i=0;i<helpList3.size();i++)
			{
				helpImg=helpList3.get(i).getImg();
				//ByteArrayInputStream bais = new ByteArrayInputStream(help);
				//BufferedImage help2= ImageIO.read(bais);
				Base64.Encoder encoder = Base64.getEncoder();
				String encoding = "data:image/png;base64," + encoder.encodeToString(helpImg);
				out.append(
				"<form class='announce' action='../ShowAnnunci' method='get'>"+
				"<div  id='inframezzo'>\r\n"+
				"<p> Marca:" +helpList3.get(i).getMarca()+"</p>"+
				"<p> Modello:" +helpList3.get(i).getModello()+"</p>"+
				"<img id=\"ItemPreview\" src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
				"<input type='hidden' name='id' value='"+helpList3.get(i).getIdAccessori()+"'>\r\n"+
				"<input type='hidden' name='tipo' value='Accessori'>\r\n"+
				"</div>"+
				"<input id='button' type='submit' value='Rimuovi annuncio'>\r\n"+
				"</form>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	else
	{
		try {
			helpList=a1.doRetrieveByCf(codicef);
			helpList2=m1.doRetrieveByCf(codicef);
			helpList3=ac1.doRetrieveByCf(codicef);
			
			for(int i=0;i<helpList.size();i++)
			{
				helpImg=helpList.get(i).getImg();
				//ByteArrayInputStream bais = new ByteArrayInputStream(help);
				//BufferedImage help2= ImageIO.read(bais);
				Base64.Encoder encoder = Base64.getEncoder();
				String encoding = "data:image/png;base64," + encoder.encodeToString(helpImg);
				out.append(
				"<form class='announce' action='../ShowAnnunci' method='get'>"+
				"<div  id='inframezzo'>\r\n"+
				"<p> Marca:" +helpList.get(i).getMarca()+"</p>"+
				"<p> Modello:" +helpList.get(i).getModello()+"</p>"+
				"<img id=\"ItemPreview\" src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
				"<input type='hidden' name='id' value='"+helpList.get(i).getIdA()+"'>\r\n"+
				"<input type='hidden' name='tipo' value='Auto'>\r\n"+
				"<input id='button' type='submit' value='Rimuovi annuncio'>\r\n"+
				"</div>"+
				"</form>");
			}
			
			for(int i=0;i<helpList2.size();i++)
			{
				helpImg=helpList2.get(i).getImg();
				//ByteArrayInputStream bais = new ByteArrayInputStream(help);
				//BufferedImage help2= ImageIO.read(bais);
				Base64.Encoder encoder = Base64.getEncoder();
				String encoding = "data:image/png;base64," + encoder.encodeToString(helpImg);
				out.append(
				"<form class='announce' action='../ShowAnnunci' method='get'>"+	
				"<div  id='inframezzo'>\r\n"+
				"<p> Marca:" +helpList2.get(i).getMarca()+"</p>"+
				"<p> Modello:" +helpList2.get(i).getModello()+"</p>"+
				"<img id=\"ItemPreview\" src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
				"<input type='hidden' name='id' value='"+helpList2.get(i).getIdMoto()+"'>\r\n"+
				"<input type='hidden' name='tipo' value='Moto'>\r\n"+
				"<input id='button' type='submit' value='Rimuovi annuncio'>\r\n"+
				"</div>"+
				"</form>");
			}
			
			for(int i=0;i<helpList3.size();i++)
			{
				helpImg=helpList3.get(i).getImg();
				//ByteArrayInputStream bais = new ByteArrayInputStream(help);
				//BufferedImage help2= ImageIO.read(bais);
				Base64.Encoder encoder = Base64.getEncoder();
				String encoding = "data:image/png;base64," + encoder.encodeToString(helpImg);
				out.append(
				"<form class='announce' action='../ShowAnnunci' method='get'>"+
				"<div  id='inframezzo'>\r\n"+
				"<p> Marca:" +helpList3.get(i).getMarca()+"</p>"+
				"<p> Modello:" +helpList3.get(i).getModello()+"</p>"+
				"<img id=\"ItemPreview\" src=\""+encoding+"\" height=\"230\" width\"390\">\r\n"+
				"<input type='hidden' name='id' value='"+helpList3.get(i).getIdAccessori()+"'>\r\n"+
				"<input type='hidden' name='tipo' value='Accessori'>\r\n"+
				"<input id='button' type='submit' value='Rimuovi annuncio'>\r\n"+
				"</div>"+
				"</form>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
{
	AutoDAO a1=new AutoDAO();
	MotoDAO m1=new MotoDAO();
	AccessoriDAO ac1=new AccessoriDAO();
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("id"));
	System.out.println(request.getParameter("tipo"));
	String tipo=request.getParameter("tipo");
	if(tipo.equals("Auto"))
	{
		try {
			a1.doDelete(id);
			out.println("<script type='text/javascript'>");
			out.println("alert('Annuncio eliminato');");
			out.println("location='view/AnnunciUtente.jsp';");
			out.println("</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	if(tipo.equals("Moto"))
	{
		try {
			m1.doDelete(id);
			out.println("<script type='text/javascript'>");
			out.println("alert('Annuncio eliminato');");
			out.println("location='view/AnnunciUtente.jsp';");
			out.println("</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}	
	
	if(tipo.equals("Accessori"))
	{
		try {
			ac1.doDelete(id);
			out.println("<script type='text/javascript'>");
			out.println("alert('Annuncio eliminato');");
			out.println("location='view/AnnunciUtente.jsp';");
			out.println("</script>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}



}

}
