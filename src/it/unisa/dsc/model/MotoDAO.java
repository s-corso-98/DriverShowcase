package it.unisa.dsc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {

	//RETURN UTENTE PRESI EMAIL E PASSWORD
		public synchronized MotoDTO doRetrieveByKey(int id) throws ClassNotFoundException{
			 
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				MotoDTO mb = new MotoDTO(id); 
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE idMoto = ?");
				ps.setInt(1,id);
						
				ResultSet res = ps.executeQuery();

				if(res.next())
				{
					mb.setAnno(res.getInt("Anno"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					return mb;
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
					prepareStatement("DELETE FROM moto WHERE idMoto = ? ");
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
		public synchronized int doSave(MotoDTO mb) throws ClassNotFoundException
		{
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("INSERT INTO moto(idMoto,Marca,Modello,Descrizione,Prezzo,utente_CodiceFiscale,azienda_PIVA,Immagine,Kilometri,Anno) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, mb.getIdMoto());
			ps.setString(2, mb.getMarca());
			ps.setString(3, mb.getModello());
			ps.setString(4, mb.getDescrizione());
			ps.setDouble(5, mb.getPrezzo());
			ps.setString(6, mb.getCodiceFiscale());
			ps.setString(7, mb.getPartitaIva());
			ps.setBytes(8,mb.getImg());
			ps.setDouble(9, mb.getKm());
			ps.setInt(10, mb.getAnno());
			
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
		public synchronized List<MotoDTO> doRetrieveAll() throws ClassNotFoundException
		{
			List<MotoDTO> listaMoto = new ArrayList<MotoDTO>();
			
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM moto group by moto.Marca");
			ResultSet res= ps.executeQuery();
			while(res.next())
				{
					MotoDTO mb=new MotoDTO();
					mb.setIdMoto(res.getInt("idMoto"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setAnno(res.getInt("Anno"));
					listaMoto.add(mb);
				}
			return listaMoto;
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
			return listaMoto;
			
			
		}
		
		public synchronized List<MotoDTO> doRetrieveByMarca(String Marca) throws ClassNotFoundException{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Marca = ?");
				ps.setString(1,Marca);
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	MotoDTO mb=new MotoDTO();
					mb.setAnno(res.getInt("Anno"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(mb);
					
				}
				return listaMoto;
				
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
			 return listaMoto;
		 }
		
		public synchronized List<MotoDTO> doRetrieveByCf(String Cf) throws ClassNotFoundException{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE utente_CodiceFiscale = ?");
				ps.setString(1,Cf);
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	MotoDTO mb=new MotoDTO();
					mb.setIdMoto(res.getInt("idMoto"));
					mb.setAnno(res.getInt("Anno"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(mb);
					
				}
				return listaMoto;
				
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
			 return listaMoto;
		 }
		
		public synchronized List<MotoDTO> doRetrieveByPiva(String Piva) throws ClassNotFoundException{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE azienda_PIVA = ?");
				ps.setString(1,Piva);
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	MotoDTO mb=new MotoDTO();
					mb.setIdMoto(res.getInt("idMoto"));
					mb.setAnno(res.getInt("Anno"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(mb);
					
				}
				return listaMoto;
				
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
			 return listaMoto;
		 }
		
		public synchronized List<MotoDTO> doRetrieveByModello(String Modello) throws ClassNotFoundException{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try { 
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Modello = ? ");
				ps.setString(1,Modello);
				
						
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	MotoDTO mb=new MotoDTO();
					mb.setAnno(res.getInt("Anno"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(mb);
					
				}
				return listaMoto;
				
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
			 return listaMoto;
		 }
		public synchronized List<MotoDTO> doRetrieveByAnno(String Marca,String Modello, Double Kilometri) throws ClassNotFoundException{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Marca=? AND Modello=? AND Kilometri = ? ");
				
				ps.setString(1,Marca);
				ps.setString(2,Modello);
				ps.setDouble(3,Kilometri);
				
				ResultSet res = ps.executeQuery();

				while(res.next())
				{	MotoDTO mb=new MotoDTO();
					mb.setAnno(res.getInt("Anno"));
					mb.setDescrizione(res.getString("Descrizione"));
					mb.setImg(res.getBytes("Immagine"));
					mb.setKm(res.getDouble("Kilometri"));
					mb.setMarca(res.getString("Marca"));
					mb.setModello(res.getString("Modello"));
					mb.setPrezzo(res.getDouble("Prezzo"));
					mb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					mb.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(mb);
					
				}
				return listaMoto;
				
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
			 return listaMoto;
		 }
		
		public synchronized List<MotoDTO> doRetrieveByFilter(String Marca,String Modello, double Kilometri,String Prezzo,int Anno) throws ClassNotFoundException{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				if(Prezzo.contains("-"))
				{
				
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Marca=? AND Modello=? AND Kilometri = ? AND Anno=? AND Prezzo BETWEEN ? AND ? ");
				
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
					MotoDTO m1=new MotoDTO();
					m1.setAnno(res.getInt("Anno"));
					m1.setDescrizione(res.getString("Descrizione"));
					m1.setImg(res.getBytes("Immagine"));
					m1.setKm(res.getDouble("Kilometri"));
					m1.setMarca(res.getString("Marca"));
					m1.setModello(res.getString("Modello"));
					m1.setPrezzo(res.getDouble("Prezzo"));
					m1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					m1.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(m1);
				
					}
				return listaMoto;
				}
			else
				{
					ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Marca=? AND Modello=? AND Kilometri = ? AND Anno=? AND Prezzo >= ? ");
				
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
						MotoDTO m1=new MotoDTO();
						m1.setAnno(res.getInt("Anno"));
						m1.setDescrizione(res.getString("Descrizione"));
						m1.setImg(res.getBytes("Immagine"));
						m1.setKm(res.getDouble("Kilometri"));
						m1.setMarca(res.getString("Marca"));
						m1.setModello(res.getString("Modello"));
						m1.setPrezzo(res.getDouble("Prezzo"));
						m1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						m1.setPartitaIva(res.getString("azienda_PIVA"));
						listaMoto.add(m1);
					
					}
				return listaMoto;
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
			 return listaMoto;
		 }
		
		public synchronized List<MotoDTO> doRetrieveByPrezzo(String Prezzo) throws ClassNotFoundException
		{
			 List<MotoDTO> listaMoto=new ArrayList<MotoDTO>();
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				
				conn = DriverManagerConnectionPool.getConnection();
				if(Prezzo.contains("-"))
				{
				
				ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Prezzo BETWEEN ? AND ? ");
				
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
					MotoDTO m1=new MotoDTO();
					m1.setAnno(res.getInt("Anno"));
					m1.setDescrizione(res.getString("Descrizione"));
					m1.setImg(res.getBytes("Immagine"));
					m1.setKm(res.getDouble("Kilometri"));
					m1.setMarca(res.getString("Marca"));
					m1.setModello(res.getString("Modello"));
					m1.setPrezzo(res.getDouble("Prezzo"));
					m1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
					m1.setPartitaIva(res.getString("azienda_PIVA"));
					listaMoto.add(m1);
				
					}
				return listaMoto;
				}
			else
				{
					ps = conn.
						prepareStatement("SELECT * FROM moto WHERE Prezzo >= ? ");
					String[] parts = Prezzo.split("[+]");
					String part1 = parts[0]; // 004
					Double help=Double.parseDouble(part1);
					ps.setDouble(1,help);
				
					ResultSet res = ps.executeQuery();

					while(res.next())
					{	
						MotoDTO m1=new MotoDTO();
						m1.setAnno(res.getInt("Anno"));
						m1.setDescrizione(res.getString("Descrizione"));
						m1.setImg(res.getBytes("Immagine"));
						m1.setKm(res.getDouble("Kilometri"));
						m1.setMarca(res.getString("Marca"));
						m1.setModello(res.getString("Modello"));
						m1.setPrezzo(res.getDouble("Prezzo"));
						m1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						m1.setPartitaIva(res.getString("azienda_PIVA"));
						listaMoto.add(m1);
					
					}
				return listaMoto;
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
			 return listaMoto;
		 }
}
