package it.unisa.dsc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AziendaDAO {
	
	//RETURN UTENTE PRESI EMAIL E PASSWORD
		public synchronized AziendaDTO doRetrieveByKey(String email, String password) throws ClassNotFoundException{
			 
			 Connection conn = null;
			 PreparedStatement ps = null;
			 try {
				AziendaDTO azb = new AziendaDTO(email, password); 
				conn = DriverManagerConnectionPool.getConnection();
				ps = conn.
						prepareStatement("SELECT * FROM azienda WHERE Email = ? AND Password = ?");
				ps.setString(1, email);
				ps.setString(2, password);
						
				ResultSet res = ps.executeQuery();

				if(res.next())
				{
					
					azb.setNome(res.getString("Nome"));
					azb.setCittà(res.getString("Città"));
					azb.setPIVA(res.getString("PIVA"));
					azb.setProvincia(res.getString("Provincia"));
					azb.setRecapito(res.getString("Recapito"));
					azb.setVia(res.getString("Via"));
					return azb;
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
		public synchronized int doDelete(String piv) throws ClassNotFoundException
		{
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("DELETE FROM azienda WHERE PIVA = ? ");
			ps.setString(1, piv);
					
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
		
		
		//INSERIMENTO UTENTE ALL'INTERNO DEL DB
		public synchronized int doSave(AziendaDTO azb) throws ClassNotFoundException
		{
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("INSERT INTO azienda(PIVA,Nome,Via,Recapito,Email,Password,Città,Provincia) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, azb.getPIVA());
			ps.setString(2, azb.getNome());
			ps.setString(3, azb.getVia());
			ps.setString(4, azb.getRecapito());
			ps.setString(5, azb.getEmail());
			ps.setString(6, azb.getPassword());
			ps.setString(7, azb.getCittà());
			ps.setString(8, azb.getProvincia());
			
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
		public synchronized List<AziendaDTO> doRetrieveAll() throws ClassNotFoundException
		{
			List<AziendaDTO> listaAziende = new ArrayList<AziendaDTO>();
			
			Connection conn=null;
			PreparedStatement ps = null;
			try { 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM azienda");
			ResultSet res= ps.executeQuery();
			while(res.next())
				{
					AziendaDTO azb=new AziendaDTO();
					azb.setPassword(res.getString("Password"));
					azb.setEmail(res.getString("Email"));
					azb.setNome(res.getString("Nome"));
					azb.setCittà(res.getString("Città"));
					azb.setPIVA(res.getString("PIVA"));
					azb.setProvincia(res.getString("Provincia"));
					azb.setRecapito(res.getString("Recapito"));
					azb.setVia(res.getString("Via"));
					listaAziende.add(azb);
				}
			return listaAziende;
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
			return listaAziende;
			
			
		}

}
