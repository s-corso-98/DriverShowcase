package it.unisa.dsc.model;

import java.util.Date;

public class UtenteDTO {
	private String codicefiscale;
	private String nome;
	private String cognome;
	private String via;
	private String recapito;
	private boolean admin;
	private String email;
	private String password;
	private Date data;
	private String documento;
	private String numdocumento;
	private String città;
	private String provincia;
	
	
	public UtenteDTO(String c,String n,String co,String v,String r,boolean a,String e,String pw,Date d,String dc,String nmdc,String ct,String pr)
	{
		this.codicefiscale=c;
		this.nome=n;
		this.cognome=co;
		this.via=v;
		this.recapito=r;
		this.admin=a;
		this.email=e;
		this.password=pw;
		this.data=d;
		this.documento=dc;
		this.numdocumento=nmdc;
		this.città=ct;
		this.provincia=pr;
	}
	
	public UtenteDTO(String em,String pwd)
	{
		this.codicefiscale=null;
		this.nome=null;
		this.cognome=null;
		this.via=null;
		this.recapito=null;
		this.admin=false;
		this.email=em;
		this.password=pwd;
		this.data=null;
		this.documento=null;
		this.numdocumento=null;
		this.città=null;
		this.provincia=null;
		
		
	}


	public UtenteDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}


	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public String getRecapito() {
		return recapito;
	}


	public void setRecapito(String recapito) {
		this.recapito = recapito;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getNumdocumento() {
		return numdocumento;
	}


	public void setNumdocumento(String numdocumento) {
		this.numdocumento = numdocumento;
	}


	public String getCittà() {
		return città;
	}


	public void setCittà(String città) {
		this.città = città;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
}
