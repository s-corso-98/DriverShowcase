package it.unisa.dsc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {

	//RETURN UTENTE PRESI EMAIL E PASSWORD
		public synchronized AutoDTO doRetrieveByKey(int id) throws ClassNotFoundException{
			 
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				AutoDTO ab = new AutoDTO(id); 
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE idAuto = ?");
				ps.setInt(1,id);
						
				ResultSet res = ps.executeQuery();

				if(res.next())
				{
					ab.setAnno(res.getInt("Anno"));
					ab.setDescrizione(res.getString("Descrizione"));
					ab.setImg(res.getBytes("Immagine"));
					ab.setKm(res.getDouble("Kilometri"));
					ab.setMarca(res.getString("Marca"));
					ab.setModello(res.getString("Modello"));
					ab.setPrezzo(res.getDouble("Prezzo"));
					ab.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					ab.setPartitaIva(res.getString("azienda_PIVA"));
					return ab;
				}
				else
					return null;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		 }
		
		
		
		//CANCELLAZIONE UTENTE TRAMITE CODICE FISCALE
		public synchronized int doDelete(int idA) throws ClassNotFoundException
		{
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("DELETE FROM auto WHERE idAuto = ? ");
			ps.setInt(1, idA);
					
			if(ps.executeUpdate()==1)
				return 1;
			else
				return 0;
			}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;

		}
		
		
		//INSERIMENTO UTENTE ALL'INTERNO DEL DB
		public synchronized int doSave(AutoDTO ab) throws ClassNotFoundException
		{
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("INSERT INTO auto(idAuto,Marca,Modello,Descrizione,Prezzo,utente_CodiceFiscale,azienda_PIVA,Immagine,Kilometri,Anno) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, ab.getIdA());
			ps.setString(2, ab.getMarca());
			ps.setString(3, ab.getModello());
			ps.setString(4, ab.getDescrizione());
			ps.setDouble(5, ab.getPrezzo());
			ps.setString(6, ab.getCodiceFiscale());
			ps.setString(7, ab.getPartitaIva());
			ps.setBytes(8,ab.getImg());
			ps.setDouble(9, ab.getKm());
			ps.setInt(10, ab.getAnno());
			
			if(ps.executeUpdate()==1)
				return 1;
			}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;
			
			
		}
		
		
		
		//RETURN DI TUTTI GLI UTENTI DEL DB
		public synchronized List<AutoDTO> doRetrieveAll() throws ClassNotFoundException
		{
			List<AutoDTO> listaAuto = new ArrayList<AutoDTO>();
			
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM auto");
			ResultSet res= ps.executeQuery();
			while(res.next())
				{
					AutoDTO ab=new AutoDTO();
					ab.setIdA(res.getInt("idAuto"));
					ab.setMarca(res.getString("Marca"));
					ab.setModello(res.getString("Modello"));
					ab.setDescrizione(res.getString("Descrizione"));
					ab.setPrezzo(res.getDouble("Prezzo"));
					ab.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					ab.setPartitaIva(res.getString("azienda_PIVA"));
					ab.setImg(res.getBytes("Immagine"));
					ab.setKm(res.getDouble("Kilometri"));
					ab.setAnno(res.getInt("Anno"));
					listaAuto.add(ab);
				}
			return listaAuto;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return listaAuto;
			
			
		}
		
		public synchronized List<AutoDTO> doRetrieveByMarca(String Marca) throws ClassNotFoundException{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE Marca = ?");
				ps.setString(1,Marca);
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	AutoDTO a1=new AutoDTO();
					a1.setAnno(res.getInt("Anno"));
					a1.setDescrizione(res.getString("Descrizione"));
					a1.setImg(res.getBytes("Immagine"));
					a1.setKm(res.getDouble("Kilometri"));
					a1.setMarca(res.getString("Marca"));
					a1.setModello(res.getString("Modello"));
					a1.setPrezzo(res.getDouble("Prezzo"));
					a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					a1.setPartitaIva(res.getString("azienda_PIVA"));
					listaAuto.add(a1);
					
				}
				return listaAuto;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		
		
		public synchronized List<AutoDTO> doRetrieveByCf(String Cf) throws ClassNotFoundException{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE utente_CodiceFiscale = ?");
				ps.setString(1,Cf);
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	AutoDTO a1=new AutoDTO();
					a1.setIdA(res.getInt("idAuto"));
					a1.setAnno(res.getInt("Anno"));
					a1.setDescrizione(res.getString("Descrizione"));
					a1.setImg(res.getBytes("Immagine"));
					a1.setKm(res.getDouble("Kilometri"));
					a1.setMarca(res.getString("Marca"));
					a1.setModello(res.getString("Modello"));
					a1.setPrezzo(res.getDouble("Prezzo"));
					a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					a1.setPartitaIva(res.getString("azienda_PIVA"));
					listaAuto.add(a1);
					
				}
				return listaAuto;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		
		
		public synchronized List<AutoDTO> doRetrieveByPiva(String Piva) throws ClassNotFoundException{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE azienda_PIVA = ?");
				ps.setString(1,Piva);
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	AutoDTO a1=new AutoDTO();
					a1.setIdA(res.getInt("idAuto"));
					a1.setAnno(res.getInt("Anno"));
					a1.setDescrizione(res.getString("Descrizione"));
					a1.setImg(res.getBytes("Immagine"));
					a1.setKm(res.getDouble("Kilometri"));
					a1.setMarca(res.getString("Marca"));
					a1.setModello(res.getString("Modello"));
					a1.setPrezzo(res.getDouble("Prezzo"));
					a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					a1.setPartitaIva(res.getString("azienda_PIVA"));
					listaAuto.add(a1);
					
				}
				return listaAuto;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		
		public synchronized List<AutoDTO> doRetrieveByModello(String Modello) throws ClassNotFoundException{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try { 
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE Modello = ? ");
				ps.setString(1,Modello);
				
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	AutoDTO a1=new AutoDTO();
					a1.setAnno(res.getInt("Anno"));
					a1.setDescrizione(res.getString("Descrizione"));
					a1.setImg(res.getBytes("Immagine"));
					a1.setKm(res.getDouble("Kilometri"));
					a1.setMarca(res.getString("Marca"));
					a1.setModello(res.getString("Modello"));
					a1.setPrezzo(res.getDouble("Prezzo"));
					a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					a1.setPartitaIva(res.getString("azienda_PIVA"));
					listaAuto.add(a1);
					
				}
				return listaAuto;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		public synchronized List<AutoDTO> doRetrieveByAnno(String Marca,String Modello, Double Kilometri) throws ClassNotFoundException{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE Marca=? AND Modello=? AND Kilometri = ? ");
				
				ps.setString(1,Marca);
				ps.setString(2,Modello);
				ps.setDouble(3,Kilometri);
				
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	AutoDTO a1=new AutoDTO();
					a1.setAnno(res.getInt("Anno"));
					a1.setDescrizione(res.getString("Descrizione"));
					a1.setImg(res.getBytes("Immagine"));
					a1.setKm(res.getDouble("Kilometri"));
					a1.setMarca(res.getString("Marca"));
					a1.setModello(res.getString("Modello"));
					a1.setPrezzo(res.getDouble("Prezzo"));
					a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					a1.setPartitaIva(res.getString("azienda_PIVA"));
					listaAuto.add(a1);
					
				}
				return listaAuto;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		
		public synchronized List<AutoDTO> doRetrieveByFilter(String Marca,String Modello, double Kilometri,String Prezzo,int Anno) throws ClassNotFoundException{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				
				if(Prezzo.contains("-"))
					{
					
					ps = conn.
							prepareStatement("SELECT * FROM auto WHERE Marca=? AND Modello=? AND Kilometri = ? AND Anno=? AND Prezzo BETWEEN ? AND ? ");
					
					ps.setString(1,Marca);
					ps.setString(2,Modello);
					ps.setDouble(3,Kilometri);
					ps.setInt(4,Anno);
					String[] parts = Prezzo.split("-");
					String part1 = parts[0]; // 004
					String part2 = parts[1]; // 034556
					double help=Double.parseDouble(part1);
					double help2=Double.parseDouble(part2);
					ps.setDouble(5, help);
					ps.setDouble(6, help2);
				
					ResultSet res = ps.executeQuery();

					while(res.next())
						{	
						AutoDTO a1=new AutoDTO();
						a1.setAnno(res.getInt("Anno"));
						a1.setDescrizione(res.getString("Descrizione"));
						a1.setImg(res.getBytes("Immagine"));
						a1.setKm(res.getDouble("Kilometri"));
						a1.setMarca(res.getString("Marca"));
						a1.setModello(res.getString("Modello"));
						a1.setPrezzo(res.getDouble("Prezzo"));
						a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						a1.setPartitaIva(res.getString("azienda_PIVA"));
						listaAuto.add(a1);
					
						}
					return listaAuto;
					}
				else
					{
						ps = conn.
							prepareStatement("SELECT * FROM auto WHERE Marca=? AND Modello=? AND Kilometri = ? AND Anno=? AND Prezzo >= ? ");
					
						ps.setString(1,Marca);
						ps.setString(2,Modello);
						ps.setDouble(3,Kilometri);
						ps.setInt(4,Anno);
						String[] parts = Prezzo.split("[+]");
						String part1 = parts[0]; // 004
						Double help=Double.parseDouble(part1);
						ps.setDouble(5,help);
					
						ResultSet res = ps.executeQuery();

						while(res.next())
						{	
							AutoDTO a1=new AutoDTO();
							a1.setAnno(res.getInt("Anno"));
							a1.setDescrizione(res.getString("Descrizione"));
							a1.setImg(res.getBytes("Immagine"));
							a1.setKm(res.getDouble("Kilometri"));
							a1.setMarca(res.getString("Marca"));
							a1.setModello(res.getString("Modello"));
							a1.setPrezzo(res.getDouble("Prezzo"));
							a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
							a1.setPartitaIva(res.getString("azienda_PIVA"));
							listaAuto.add(a1);
						
						}
					return listaAuto;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		
		public synchronized List<AutoDTO> doRetrieveByPrezzo(String Prezzo) throws ClassNotFoundException
		{
			 List<AutoDTO> listaAuto=new ArrayList<AutoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				if(Prezzo.contains("-"))
				{
				
				ps = conn.
						prepareStatement("SELECT * FROM auto WHERE Prezzo BETWEEN ? AND ? ");
				
				String[] parts = Prezzo.split("-");
				String part1 = parts[0]; // 004
				String part2 = parts[1]; // 034556
				double help=Double.parseDouble(part1);
				double help2=Double.parseDouble(part2);
				ps.setDouble(1, help);
				ps.setDouble(2, help2);
			
				ResultSet res = ps.executeQuery();

				while(res.next())
					{	
					AutoDTO a1=new AutoDTO();
					a1.setAnno(res.getInt("Anno"));
					a1.setDescrizione(res.getString("Descrizione"));
					a1.setImg(res.getBytes("Immagine"));
					a1.setKm(res.getDouble("Kilometri"));
					a1.setMarca(res.getString("Marca"));
					a1.setModello(res.getString("Modello"));
					a1.setPrezzo(res.getDouble("Prezzo"));
					a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					a1.setPartitaIva(res.getString("azienda_PIVA"));
					listaAuto.add(a1);
				
					}
				return listaAuto;
				}
			else
				{
					ps = conn.
						prepareStatement("SELECT * FROM auto WHERE Prezzo >= ? ");
					String[] parts = Prezzo.split("[+]");
					String part1 = parts[0]; // 004
					Double help=Double.parseDouble(part1);
					ps.setDouble(1,help);
				
					ResultSet res = ps.executeQuery();

					while(res.next())
					{	
						AutoDTO a1=new AutoDTO();
						a1.setAnno(res.getInt("Anno"));
						a1.setDescrizione(res.getString("Descrizione"));
						a1.setImg(res.getBytes("Immagine"));
						a1.setKm(res.getDouble("Kilometri"));
						a1.setMarca(res.getString("Marca"));
						a1.setModello(res.getString("Modello"));
						a1.setPrezzo(res.getDouble("Prezzo"));
						a1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						a1.setPartitaIva(res.getString("azienda_PIVA"));
						listaAuto.add(a1);
					
					}
				return listaAuto;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return listaAuto;
		 }
		
}
