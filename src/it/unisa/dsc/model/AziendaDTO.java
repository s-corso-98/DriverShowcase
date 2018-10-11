package it.unisa.dsc.model;


public class AziendaDTO {
	private String PIVA;
	private String nome;
	private String via;
	private String recapito;
	private String email;
	private String password;
	private String città;
	private String provincia;
	
	public AziendaDTO(String piv,String n,String v,String r,String e,String pw,String ct,String pr)
	{
		this.PIVA=piv;
		this.nome=n;
		this.via=v;
		this.recapito=r;
		this.email=e;
		this.password=pw;
		this.città=ct;
		this.provincia=pr;
	}
	
	
	public AziendaDTO(String em,String pwd)
	{
		this.PIVA=null;
		this.nome=null;
		this.via=null;
		this.recapito=null;
		this.email=em;
		this.password=pwd;
		this.città=null;
		this.provincia=null;
		
		
	}

	public AziendaDTO()
	{}

	public String getPIVA() {
		return PIVA;
	}


	public void setPIVA(String pIVA) {
		PIVA = pIVA;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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
