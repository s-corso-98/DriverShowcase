package it.unisa.dsc.model;

import java.util.ArrayList;
import java.util.List;

public class CarrelloDTO {
	private List<AccessoriDTO> listAcc;
	private List<MotoDTO> listMot;
	private List<AutoDTO> listAut;
	
	public CarrelloDTO(List<AccessoriDTO> l1,List<AutoDTO> l3,List<MotoDTO> l2)
	{
		listAcc=l1;
		listMot=l2;
		listAut=l3;
	}
	
	public CarrelloDTO()
	{
		listAcc=new ArrayList<AccessoriDTO>();
		listMot=new ArrayList<MotoDTO>();
		listAut=new ArrayList<AutoDTO>();
	}

	public List<AccessoriDTO> getListAcc() {
		return listAcc;
	}

	public void setListAcc(List<AccessoriDTO> listAcc) {
		this.listAcc = listAcc;
	}

	public List<MotoDTO> getListMot() {
		return listMot;
	}

	public void setListMot(List<MotoDTO> listMot) {
		this.listMot = listMot;
	}

	public List<AutoDTO> getListAut() {
		return listAut;
	}

	public void setListAut(List<AutoDTO> listAut) {
		this.listAut = listAut;
	}

}
