package it.unisa.dsc.model;

public class AccessoriDTO {
	
	private int idAccessori;
	private String marca;
	private String modello;
	private String descrizione;
	private String CodiceFiscale;
	private String PartitaIva;
	private double prezzo;
	private byte[] img;
	
	public AccessoriDTO(int id,String m,String mod,String desc,String pivacf,double p,byte[] im,int type)
	{
		this.idAccessori=id;
		this.marca=m;
		this.modello=mod;
		this.descrizione=desc;
		this.prezzo=p;
		this.img=im;
		if(type==1)
		{
		this.PartitaIva=pivacf;
		this.CodiceFiscale=null;
		}
		else
		{
		this.CodiceFiscale=pivacf;
		this.PartitaIva=null;
		}
	}
	
	public AccessoriDTO(int id)
	{
		this.idAccessori=id;
		this.marca=null;
		this.modello=null;
		this.descrizione=null;
		this.prezzo=0;
	
		this.img=null;
		this.PartitaIva=null;
		this.CodiceFiscale=null;
	}

	public AccessoriDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAccessori() {
		return idAccessori;
	}

	public void setIdAccessori(int idAccessori) {
		this.idAccessori = idAccessori;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}

	public String getPartitaIva() {
		return PartitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		PartitaIva = partitaIva;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
}
