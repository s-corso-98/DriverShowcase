package it.unisa.dsc.model;

public class MotoDTO {
	private int idMoto;
	private String marca;
	private String modello;
	private String descrizione;
	private String CodiceFiscale;
	private String PartitaIva;
	private double prezzo;
	private double km;
	private int anno;
	private byte[] img;
	
	public MotoDTO(int id,String m,String mod,String desc,String pivacf,double p,double k,int a,byte[] im,int type)
	{
		this.idMoto=id;
		this.marca=m;
		this.modello=mod;
		this.descrizione=desc;
		this.prezzo=p;
		this.km=k;
		this.anno=a;
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
	
	public MotoDTO(int id)
	{
		this.idMoto=id;
		this.marca=null;
		this.modello=null;
		this.descrizione=null;
		this.prezzo=0;
		this.km=0;
		this.anno=0;
		this.img=null;
		this.PartitaIva=null;
		this.CodiceFiscale=null;
	}

	public MotoDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(int idMoto) {
		this.idMoto = idMoto;
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

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	
	

}
