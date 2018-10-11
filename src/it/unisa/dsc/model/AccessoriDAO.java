package it.unisa.dsc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccessoriDAO {
	//RETURN UTENTE PRESI EMAIL E PASSWORD
			public synchronized AccessoriDTO doRetrieveByKey(int id) throws ClassNotFoundException{
				 
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try {
					AccessoriDTO acb = new AccessoriDTO(id); 
					conn = DriverManagerConnectionPool.getConnection();
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE idAccessori = ?");
					ps.setInt(1,id);
							
					ResultSet res = ps.executeQuery();

					if(res.next())
					{
						
						acb.setDescrizione(res.getString("Descrizione"));
						acb.setImg(res.getBytes("Immagine"));
						acb.setMarca(res.getString("Marca"));
						acb.setModello(res.getString("Modello"));
						acb.setPrezzo(res.getDouble("Prezzo"));
						acb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						acb.setPartitaIva(res.getString("azienda_PIVA"));
						return acb;
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
						prepareStatement("DELETE FROM accessori WHERE idAccessori = ? ");
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
			public synchronized int doSave(AccessoriDTO acb) throws ClassNotFoundException
			{
				Connection conn=null;
				PreparedStatement ps = null;
				try { 
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("INSERT INTO accessori(idAccessori,Marca,Modello,Descrizione,Prezzo,utente_CodiceFiscale,azienda_PIVA,Immagine) values(?,?,?,?,?,?,?,?)");
				ps.setInt(1, acb.getIdAccessori());
				ps.setString(2, acb.getMarca());
				ps.setString(3, acb.getModello());
				ps.setString(4, acb.getDescrizione());
				ps.setDouble(5, acb.getPrezzo());
				ps.setString(6, acb.getCodiceFiscale());
				ps.setString(7, acb.getPartitaIva());
				ps.setBytes(8,acb.getImg());
				
				
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
			public synchronized List<AccessoriDTO> doRetrieveAll() throws ClassNotFoundException
			{
				List<AccessoriDTO> listaAccessori = new ArrayList<AccessoriDTO>();
				
				Connection conn=null;
				PreparedStatement ps = null;
				try { 
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM accessori");
				ResultSet res= ps.executeQuery();
				while(res.next())
					{
						AccessoriDTO acb=new AccessoriDTO();
						acb.setIdAccessori(res.getInt("idAccessori"));
						acb.setMarca(res.getString("Marca"));
						acb.setModello(res.getString("Modello"));
						acb.setDescrizione(res.getString("Descrizione"));
						acb.setPrezzo(res.getDouble("Prezzo"));
						acb.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						acb.setPartitaIva(res.getString("azienda_PIVA"));
						acb.setImg(res.getBytes("Immagine"));
						
						listaAccessori.add(acb);
					}
				return listaAccessori;
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
				return listaAccessori;
				
				
			}
			
			public synchronized List<AccessoriDTO> doRetrieveByMarca(String Marca) throws ClassNotFoundException{
				 List<AccessoriDTO> listaAccessori=new ArrayList<AccessoriDTO>();
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try {
					
					conn = DriverManagerConnectionPool.getConnection();
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE Marca = ?");
					ps.setString(1,Marca);
							
					ResultSet res = ps.executeQuery();

					while(res.next())
					{	AccessoriDTO ac=new AccessoriDTO();
						ac.setDescrizione(res.getString("Descrizione"));
						ac.setImg(res.getBytes("Immagine"));
						ac.setMarca(res.getString("Marca"));
						ac.setModello(res.getString("Modello"));
						ac.setPrezzo(res.getDouble("Prezzo"));
						ac.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						ac.setPartitaIva(res.getString("azienda_PIVA"));
						listaAccessori.add(ac);
						
					}
					return listaAccessori;
					
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
				 return listaAccessori;
			 }
			
			public synchronized List<AccessoriDTO> doRetrieveByCf(String Cf) throws ClassNotFoundException{
				 List<AccessoriDTO> listaAccessori=new ArrayList<AccessoriDTO>();
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try {
					
					conn = DriverManagerConnectionPool.getConnection();
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE utente_CodiceFiscale = ?");
					ps.setString(1,Cf);
							
					ResultSet res = ps.executeQuery();

					while(res.next())
					{	AccessoriDTO ac=new AccessoriDTO();
						ac.setIdAccessori(res.getInt("idAccessori"));
						ac.setDescrizione(res.getString("Descrizione"));
						ac.setImg(res.getBytes("Immagine"));
						ac.setMarca(res.getString("Marca"));
						ac.setModello(res.getString("Modello"));
						ac.setPrezzo(res.getDouble("Prezzo"));
						ac.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						ac.setPartitaIva(res.getString("azienda_PIVA"));
						listaAccessori.add(ac);
						
					}
					return listaAccessori;
					
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
				 return listaAccessori;
			 }
			
			public synchronized List<AccessoriDTO> doRetrieveByPiva(String Piva) throws ClassNotFoundException{
				 List<AccessoriDTO> listaAccessori=new ArrayList<AccessoriDTO>();
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try {
					
					conn = DriverManagerConnectionPool.getConnection();
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE azienda_PIVA = ?");
					ps.setString(1,Piva);
							
					ResultSet res = ps.executeQuery();

					while(res.next())
					{	AccessoriDTO ac=new AccessoriDTO();
						ac.setIdAccessori(res.getInt("idAccessori"));
						ac.setDescrizione(res.getString("Descrizione"));
						ac.setImg(res.getBytes("Immagine"));
						ac.setMarca(res.getString("Marca"));
						ac.setModello(res.getString("Modello"));
						ac.setPrezzo(res.getDouble("Prezzo"));
						ac.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						ac.setPartitaIva(res.getString("azienda_PIVA"));
						listaAccessori.add(ac);
						
					}
					return listaAccessori;
					
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
				 return listaAccessori;
			 }
			
			public synchronized List<AccessoriDTO> doRetrieveByModello(String Modello) throws ClassNotFoundException{
				 List<AccessoriDTO> listaAccessori=new ArrayList<AccessoriDTO>();
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try { 
					
					conn = DriverManagerConnectionPool.getConnection();
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE Modello = ? ");
					ps.setString(1,Modello);
					
							
					ResultSet res = ps.executeQuery();

					while(res.next())
					{	AccessoriDTO ac=new AccessoriDTO();
						ac.setDescrizione(res.getString("Descrizione"));
						ac.setImg(res.getBytes("Immagine"));
						ac.setMarca(res.getString("Marca"));
						ac.setModello(res.getString("Modello"));
						ac.setPrezzo(res.getDouble("Prezzo"));
						ac.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						ac.setPartitaIva(res.getString("azienda_PIVA"));
						listaAccessori.add(ac);
						
					}
					return listaAccessori;
					
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
				 return listaAccessori;
			 }
			
			public synchronized List<AccessoriDTO> doRetrieveByFilter(String Marca,String Modello,String Prezzo) throws ClassNotFoundException{
				 List<AccessoriDTO> listaAccessori=new ArrayList<AccessoriDTO>();
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try {
					
					conn = DriverManagerConnectionPool.getConnection();
					if(Prezzo.contains("-"))
					{
					
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE Marca=? AND Modello=? AND Prezzo BETWEEN ? AND ? ");
					
					ps.setString(1,Marca);
					ps.setString(2,Modello);
					String[] parts = Prezzo.split("-");
					String part1 = parts[0]; // 004
					String part2 = parts[1]; // 034556
					double help=Double.parseDouble(part1);
					double help2=Double.parseDouble(part2);
					ps.setDouble(3, help);
					ps.setDouble(4, help2);
				
					ResultSet res = ps.executeQuery();

					while(res.next())
						{	
						AccessoriDTO ac1=new AccessoriDTO();
						ac1.setDescrizione(res.getString("Descrizione"));
						ac1.setImg(res.getBytes("Immagine"));
						ac1.setMarca(res.getString("Marca"));
						ac1.setModello(res.getString("Modello"));
						ac1.setPrezzo(res.getDouble("Prezzo"));
						ac1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						ac1.setPartitaIva(res.getString("azienda_PIVA"));
						listaAccessori.add(ac1);
					
						}
					return listaAccessori;
					}
				else
					{
						ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE Marca=? AND Modello=? AND Prezzo >= ? ");
					
						ps.setString(1,Marca);
						ps.setString(2,Modello);
						String[] parts = Prezzo.split("[+]");
						String part1 = parts[0]; // 004
						Double help=Double.parseDouble(part1);
						ps.setDouble(3,help);
					
						ResultSet res = ps.executeQuery();

						while(res.next())
						{	
							AccessoriDTO ac1=new AccessoriDTO();
							ac1.setDescrizione(res.getString("Descrizione"));
							ac1.setImg(res.getBytes("Immagine"));
							ac1.setMarca(res.getString("Marca"));
							ac1.setModello(res.getString("Modello"));
							ac1.setPrezzo(res.getDouble("Prezzo"));
							ac1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
							ac1.setPartitaIva(res.getString("azienda_PIVA"));
							listaAccessori.add(ac1);
						
						}
					return listaAccessori;
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
				 return listaAccessori;
			 }
			
			public synchronized List<AccessoriDTO> doRetrieveByPrezzo(String Prezzo) throws ClassNotFoundException
			{
				 List<AccessoriDTO> listaAccessori=new ArrayList<AccessoriDTO>();
				 Connection conn = null;
				 PreparedStatement ps = null;
				 try {
					
					conn = DriverManagerConnectionPool.getConnection();
					if(Prezzo.contains("-"))
					{
					
					ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE Prezzo BETWEEN ? AND ? ");
					
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
						AccessoriDTO ac1=new AccessoriDTO();
						ac1.setDescrizione(res.getString("Descrizione"));
						ac1.setImg(res.getBytes("Immagine"));
						ac1.setMarca(res.getString("Marca"));
						ac1.setModello(res.getString("Modello"));
						ac1.setPrezzo(res.getDouble("Prezzo"));
						ac1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
						ac1.setPartitaIva(res.getString("azienda_PIVA"));
						listaAccessori.add(ac1);
					
						}
					return listaAccessori;
					}
				else
					{
						ps = conn.
							prepareStatement("SELECT * FROM accessori WHERE Prezzo >= ? ");
						String[] parts = Prezzo.split("[+]");
						String part1 = parts[0]; // 004
						Double help=Double.parseDouble(part1);
						ps.setDouble(1,help);
					
						ResultSet res = ps.executeQuery();

						while(res.next())
						{	
							AccessoriDTO ac1=new AccessoriDTO();
							ac1.setDescrizione(res.getString("Descrizione"));
							ac1.setImg(res.getBytes("Immagine"));
							ac1.setMarca(res.getString("Marca"));
							ac1.setModello(res.getString("Modello"));
							ac1.setPrezzo(res.getDouble("Prezzo"));
							ac1.setCodiceFiscale(res.getString("utente_CodiceFiscale"));
							ac1.setPartitaIva(res.getString("azienda_PIVA"));
							listaAccessori.add(ac1);
						
						}
					return listaAccessori;
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
				 return listaAccessori;
			 }
	}
