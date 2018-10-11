package it.unisa.dsc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.*;

import it.unisa.dsc.model.AccessoriDAO;
import it.unisa.dsc.model.AccessoriDTO;
import it.unisa.dsc.model.AutoDAO;
import it.unisa.dsc.model.AutoDTO;
import it.unisa.dsc.model.AziendaDAO;
import it.unisa.dsc.model.AziendaDTO;
import it.unisa.dsc.model.MotoDAO;
import it.unisa.dsc.model.MotoDTO;
import it.unisa.dsc.model.UtenteDAO;


@WebServlet("/InserimentoServlet")
public class InserimentoServlet extends HttpServlet{
public static final long serialVersionUID=1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	response.setContentType("text/plain");
	PrintWriter out=response.getWriter();
	String x = request.getParameter("azione");
	HttpSession session = request.getSession(false);
	session.setAttribute("tipologia", x);
	if(x.equals("Auto")) 
		{out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Marca</label>\r\n" + 
				"								<input type=\"text\" name=\"Marca\" placeholder=\"Marca\" required=\"\">\r\n" + 
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Modello</label>\r\n" + 
			"								<input type=\"text\" name=\"Modello\" placeholder=\"Modello\" required=\"\">\r\n" + 
			"							</span>\r\n" + 
			"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Descrizione</label>\r\n" + 
				"								<textarea rows=\"10\" cols=\"100\" name=\"Descrizione\" placeholder=\"Descrizione(max. 1000 caratteri)\" required=\"\">\r\n" +
				"								</textarea>\r\n" +
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Prezzo</label>\r\n" + 
				"								<input type=\"text\" name=\"Prezzo\" placeholder=\"Prezzo\" required=\"\">\r\n" + 
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\" style='color: white;'>\r\n" + 
				"								<label>Immagine</label>\r\n" + 
				"								<input type=\"file\" id=\"img_auto\" name=\"Immagine\" placeholder=\"Immagine\" accept=\"img/*\"required=\"\" onchange=\"loadFile(event)\">\r\n" + 
				"								<img id=\"output\"/> \r\n			"	+	
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Kilometri</label>\r\n" + 
				"								<input type=\"text\" name=\"Km\" placeholder=\"Kilometri\" required=\"\">\r\n" + 
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Anno</label>\r\n" + 
				"								<input type=\"text\" name=\"Anno\" placeholder=\"Anno\" required=\"\">\r\n" + 
				"							</span>\r\n" + 
				"						</div>");
		}
	if(x.equals("Moto"))
	{out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Marca</label>\r\n" + 
			"								<input type=\"text\" name=\"Marca\" placeholder=\"Marca\" required=\"\">\r\n" + 
			"							</span>\r\n" + 
			"						</div>");
	out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
		"							<span class=\"agileits_grid\">\r\n" + 
		"								<label>Modello</label>\r\n" + 
		"								<input type=\"text\" name=\"Modello\" placeholder=\"Modello\" required=\"\">\r\n" + 
		"							</span>\r\n" + 
		"						</div>");
	out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Descrizione</label>\r\n" + 
			"								<textarea rows=\"10\" cols=\"100\" name=\"Descrizione\" placeholder=\"Descrizione(max. 1000 caratteri)\" required=\"\">\r\n" +
			"								</textarea>\r\n" +
			"							</span>\r\n" + 
			"						</div>");
	out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Prezzo</label>\r\n" + 
			"								<input type=\"text\" name=\"Prezzo\" placeholder=\"Prezzo\" required=\"\">\r\n" + 
			"							</span>\r\n" + 
			"						</div>");
	out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\" style='color: white; '>\r\n" + 
			"								<label>Immagine</label>\r\n" + 
			"								<input type=\"file\" accept=\"img/*\" name=\"Immagine\" placeholder=\"Immagine\" required=\"\" onchange=\"loadFile(event)\">\r\n" +
			"								<img id=\"output\" />\r\n	"+	
			"							</span>\r\n" + 
			"						</div>");
	out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Kilometri</label>\r\n" + 
			"								<input type=\"text\" name=\"Km\" placeholder=\"Kilometri\" required=\"\">\r\n" + 
			"							</span>\r\n" + 
			"						</div>");
	out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Anno</label>\r\n" + 
			"								<input type=\"text\" name=\"Anno\" placeholder=\"Anno\" required=\"\">\r\n" + 
			"							</span>\r\n" + 
			"						</div>");}
	if(x.equals("Accessori"))
	{
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Marca</label>\r\n" + 
				"								<input type=\"text\" name=\"Marca\" placeholder=\"Marca\" required=\"\">\r\n" + 
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
			"							<span class=\"agileits_grid\">\r\n" + 
			"								<label>Modello</label>\r\n" + 
			"								<input type=\"text\" name=\"Modello\" placeholder=\"Modello\" required=\"\">\r\n" + 
			"							</span>\r\n" + 
			"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Descrizione</label>\r\n" + 
				"								<textarea rows=\"10\" cols=\"100\" name=\"Descrizione\" placeholder=\"Descrizione(max. 1000 caratteri)\" required=\"\">\r\n" +
				"								</textarea>\r\n" +
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\">\r\n" + 
				"								<label>Prezzo</label>\r\n" + 
				"								<input type=\"text\" name=\"Prezzo\" placeholder=\"Prezzo\" required=\"\">\r\n" + 
				"							</span>\r\n" + 
				"						</div>");
		out.append("<div class=\"w3_agileits_main_grid w3l_main_grid\">\r\n" + 
				"							<span class=\"agileits_grid\" style='color: white; '>\r\n" + 
				"								<label>Immagine</label>\r\n" + 
				"								<input type=\"file\" accept=\"img/*\" name=\"Immagine\" placeholder=\"Immagine\" required=\"\" onchange=\"loadFile(event)\">\r\n" +
				"								<img id=\"output\"/>\r\n	"+	
				"							</span>\r\n" + 
				"						</div>");
	}
}
	

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
{
	AutoDAO help=new AutoDAO();
	MotoDAO help2=new MotoDAO();
	AccessoriDAO help3=new AccessoriDAO();
	response.setContentType("text/html");
	
	HttpSession session=request.getSession(false);
	
	if(session==null)
		{
			System.out.println("Errore");
		}
	
	else
		{
			
			int type;
			if((String)session.getAttribute("Cf")==null)
				type=1;
			else
				type=0;
			
		
	
			String x=(String) session.getAttribute("tipologia");
			
			if(x.equals("Auto"))
			{
				try
				{
					AutoDTO a1=new AutoDTO();
					List <FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					for(FileItem item : items) 
						{
						if(item.isFormField()) 
							{
								
								String fieldName = item.getFieldName();
								if(fieldName.equals("tipologia"))
									continue;
								String fieldValue = item.getString();
								String set="set"+fieldName;
								if(set.equals("setPrezzo")||set.equals("setKm"))
								{
								Method method = a1.getClass().getMethod(set,double.class);
								method.invoke(a1,Double.parseDouble(fieldValue));
								}
								else
								{
									if(set.equals("setAnno"))
									{
										Method method = a1.getClass().getMethod(set,int.class);
										method.invoke(a1,Integer.parseInt(fieldValue));
									}
									else
									{
										Method method = a1.getClass().getMethod(set,String.class);
										method.invoke(a1,fieldValue);
									}
								}
							}
						else
							{
								String fieldName = item.getFieldName();
								String fileName = FilenameUtils.getName(item.getName());
								InputStream fileContent = item.getInputStream();
								byte[] image = IOUtils.toByteArray(fileContent);
								a1.setImg(image);
							}
						}
					
					if(type==0)
						a1.setCodiceFiscale((String)session.getAttribute("Cf"));
					else
						a1.setPartitaIva((String)session.getAttribute("Piva"));
		
					if(help.doSave(a1)==1)
					{
						RequestDispatcher view = request.getRequestDispatcher("view/Home.jsp");
						view.forward(request,response);
					}
					else
						System.out.println("Inserimento fallito");
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}

	
			if(x.equals("Moto"))
			{
				try
				{
					MotoDTO m1=new MotoDTO();
					List <FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					for(FileItem item : items) 
						{
						if(item.isFormField()) 
							{
								
								String fieldName = item.getFieldName();
								if(fieldName.equals("tipologia"))
									continue;
								String fieldValue = item.getString();
								String set="set"+fieldName;
								if(set.equals("setPrezzo")||set.equals("setKm"))
								{
								Method method = m1.getClass().getMethod(set,double.class);
								method.invoke(m1,Double.parseDouble(fieldValue));
								}
								else
								{
									if(set.equals("setAnno"))
									{
										Method method = m1.getClass().getMethod(set,int.class);
										method.invoke(m1,Integer.parseInt(fieldValue));
									}
									else
									{
										Method method = m1.getClass().getMethod(set,String.class);
										method.invoke(m1,fieldValue);
									}
								}
							}
						else
							{
								String fieldName = item.getFieldName();
								String fileName = FilenameUtils.getName(item.getName());
								InputStream fileContent = item.getInputStream();
								byte[] image = IOUtils.toByteArray(fileContent);
								m1.setImg(image);
							}
						}
					
					if(type==0)
						m1.setCodiceFiscale((String)session.getAttribute("Cf"));
					else
						m1.setPartitaIva((String)session.getAttribute("Piva"));
		
					if(help2.doSave(m1)==1)
					{
						RequestDispatcher view = request.getRequestDispatcher("view/Home.jsp");
						view.forward(request,response);
					}
					else
						System.out.println("Inserimento fallito");
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
	
			if(x.equals("Accessori"))
			{
				try
				{
					AccessoriDTO ac1=new AccessoriDTO();
					List <FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					for(FileItem item : items) 
						{
						if(item.isFormField()) 
							{
								
								String fieldName = item.getFieldName();
								if(fieldName.equals("tipologia"))
									continue;
								String fieldValue = item.getString();
								String set="set"+fieldName;
								if(set.equals("setPrezzo"))
								{
								Method method = ac1.getClass().getMethod(set,double.class);
								method.invoke(ac1,Double.parseDouble(fieldValue));
								}
								else
								{
										Method method = ac1.getClass().getMethod(set,String.class);
										method.invoke(ac1,fieldValue);
								}
								
							}
						else
							{
								String fieldName = item.getFieldName();
								String fileName = FilenameUtils.getName(item.getName());
								InputStream fileContent = item.getInputStream();
								byte[] image = IOUtils.toByteArray(fileContent);
								ac1.setImg(image);
							}
						}
					
					if(type==0)
						ac1.setCodiceFiscale((String)session.getAttribute("Cf"));
					else
						ac1.setPartitaIva((String)session.getAttribute("Piva"));
		
					if(help3.doSave(ac1)==1)
					{
						RequestDispatcher view = request.getRequestDispatcher("view/Home.jsp");
						view.forward(request,response);
					}
					else
						System.out.println("Inserimento fallito");
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	
}
}

