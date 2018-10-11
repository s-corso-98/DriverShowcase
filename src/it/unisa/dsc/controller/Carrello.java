package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.dsc.model.AccessoriDTO;
import it.unisa.dsc.model.AutoDTO;
import it.unisa.dsc.model.CarrelloDTO;
import it.unisa.dsc.model.MotoDTO;

@WebServlet("/Carrello")
public class Carrello extends HttpServlet{

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	response.setContentType("text/html");
	HttpSession session=request.getSession(false);
	CarrelloDTO help=(CarrelloDTO)session.getAttribute("ShoppingCart");
	PrintWriter out=response.getWriter();
	
	if(request.getParameter("tipo").equals("Accessori"))
	{
	List<AccessoriDTO> helpList=new ArrayList<AccessoriDTO>();
	helpList=help.getListAcc();
	//OTTENIMENTO ACCESSORIO DA INSERIRE NEL CARRELLO
	AccessoriDTO helpItem=new AccessoriDTO();
	helpItem.setCodiceFiscale(request.getParameter("Cf"));
	helpItem.setDescrizione(request.getParameter("Desc"));
	helpItem.setMarca(request.getParameter("Marca"));
	helpItem.setModello(request.getParameter("Modello"));
	helpItem.setPartitaIva(request.getParameter("Iv"));
	helpItem.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
	helpItem.setIdAccessori(Integer.parseInt(request.getParameter("Id")));
	
	//INSERIMENTO ACCESSORIO NEL CARRELLO AGGIORNANDO LA VARIABILE DI SESSIONE SHOPPING CART
	helpList.add(helpItem);
	help.setListAcc(helpList);
	session.setAttribute("ShoppingCart",help);
	
	out.println("<script type='text/javascript'>");
	out.println("alert('Prodotto aggiunto al carrello con successo');");
	out.println("location='view/Home.jsp';");
	out.println("</script>");
	}
	
	if(request.getParameter("tipo").equals("Auto"))
	{
	List<AutoDTO> helpList=new ArrayList<AutoDTO>();
	helpList=help.getListAut();
	//OTTENIMENTO ACCESSORIO DA INSERIRE NEL CARRELLO
	AutoDTO helpItem=new AutoDTO();
	helpItem.setCodiceFiscale(request.getParameter("Cf"));
	helpItem.setDescrizione(request.getParameter("Desc"));
	helpItem.setMarca(request.getParameter("Marca"));
	helpItem.setModello(request.getParameter("Modello"));
	helpItem.setPartitaIva(request.getParameter("Iv"));
	helpItem.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
	helpItem.setIdA(Integer.parseInt(request.getParameter("Id")));
	
	//INSERIMENTO ACCESSORIO NEL CARRELLO AGGIORNANDO LA VARIABILE DI SESSIONE SHOPPING CART
	helpList.add(helpItem);
	help.setListAut(helpList);
	session.setAttribute("ShoppingCart",help);
	
	out.println("<script type='text/javascript'>");
	out.println("alert('Prodotto aggiunto al carrello con successo');");
	out.println("location='view/Home.jsp';");
	out.println("</script>");
	}
	
	if(request.getParameter("tipo").equals("Moto"))
	{
	List<MotoDTO> helpList=new ArrayList<MotoDTO>();
	helpList=help.getListMot();
	//OTTENIMENTO ACCESSORIO DA INSERIRE NEL CARRELLO
	MotoDTO helpItem=new MotoDTO();
	helpItem.setCodiceFiscale(request.getParameter("Cf"));
	helpItem.setDescrizione(request.getParameter("Desc"));
	helpItem.setMarca(request.getParameter("Marca"));
	helpItem.setModello(request.getParameter("Modello"));
	helpItem.setPartitaIva(request.getParameter("Iv"));
	helpItem.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
	helpItem.setIdMoto(Integer.parseInt(request.getParameter("Id")));
	
	//INSERIMENTO ACCESSORIO NEL CARRELLO AGGIORNANDO LA VARIABILE DI SESSIONE SHOPPING CART
	helpList.add(helpItem);
	help.setListMot(helpList);
	session.setAttribute("ShoppingCart",help);
	
	out.println("<script type='text/javascript'>");
	out.println("alert('Prodotto aggiunto al carrello con successo');");
	out.println("location='view/Home.jsp';");
	out.println("</script>");
	}
	
}

public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
{
	HttpSession session=request.getSession(false);
	CarrelloDTO help=(CarrelloDTO)session.getAttribute("ShoppingCart");
	int id=Integer.parseInt(request.getParameter("remove"));
	PrintWriter out=response.getWriter();
	
	
	
	
	List <AccessoriDTO> help2= new ArrayList<AccessoriDTO>();
	help2=help.getListAcc();
	if(request.getParameter("tipo").equals("Accessori"))
	{
		for(int i=0;i<help2.size();i++)
		{
			if(id==help2.get(i).getIdAccessori())
			{
				help2.remove(i);
				help.setListAcc(help2);
			}
		}
	}
	
	
	List <AutoDTO> help3= new ArrayList<AutoDTO>();
	help3=help.getListAut();
	if(request.getParameter("tipo").equals("Auto"))
	{
		for(int i=0;i<help3.size();i++)
		{
			if(id==help3.get(i).getIdA())
			{
				help3.remove(i);
				help.setListAut(help3);
			}
		}
	}
	
	
	
	List <MotoDTO> help4= new ArrayList<MotoDTO>();
	help4=help.getListMot();
	if(request.getParameter("tipo").equals("Moto"))
	{
		for(int i=0;i<help4.size();i++)
		{
			if(id==help4.get(i).getIdMoto())
			{
				help4.remove(i);
				help.setListMot(help4);
			}
		}
	}
	session.setAttribute("ShoppingCart", help);
	out.println("<script type='text/javascript'>");
	out.println("alert('Prodotto rimosso dal carrello con successo');");
	out.println("location='view/Home.jsp';");
	out.println("</script>");
}
}
