package it.unisa.dsc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {
	
	
	//RETURN UTENTE PRESI EMAIL E PASSWORD
	public synchronized UtenteDTO doRetrieveByKey(String email, String password) throws ClassNotFoundException{
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			UtenteDTO ub = new UtenteDTO(email, password); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM utente WHERE Email = ? AND Password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
					
			ResultSet res = ps.executeQuery();

			if(res.next())
			{
				
				ub.setNome(res.getString("Nome"));
				ub.setCognome(res.getString("Cognome"));
				ub.setAdmin(res.getBoolean("Admin"));
				ub.setCittà(res.getString("Città"));
				ub.setCodicefiscale(res.getString("CodiceFiscale"));
				ub.setData(res.getDate("DataDiNascita"));
				ub.setDocumento(res.getString("Documento"));
				ub.setNumdocumento(res.getString("NumDocumento"));
				ub.setProvincia(res.getString("Provincia"));
				ub.setRecapito(res.getString("Recapito"));
				ub.setVia(res.getString("Via"));
				return ub;
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
	public synchronized int doDelete(String cf) throws ClassNotFoundException
	{
		Connection conn=null;
		PreparedStatement ps = null;
		try { 
		conn = DriverManagerConnectionPool.getConnection();
		ps = conn.
				prepareStatement("DELETE FROM utente WHERE CodiceFiscale = ? ");
		ps.setString(1, cf);
				
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
	public synchronized int doSave(UtenteDTO ub) throws ClassNotFoundException
	{
		Connection conn=null;
		PreparedStatement ps = null;
		try { 
		conn = DriverManagerConnectionPool.getConnection();
		ps = conn.
				prepareStatement("INSERT INTO utente(CodiceFiscale,Nome,Cognome,Via,Recapito,Email,Admin,Password,DataDiNascita,Documento,NumDocumento,Città,Provincia) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, ub.getCodicefiscale());
		ps.setString(2, ub.getNome());
		ps.setString(3, ub.getCognome());
		ps.setString(4, ub.getVia());
		ps.setString(5, ub.getRecapito());
		ps.setString(6, ub.getEmail());
		ps.setBoolean(7, ub.isAdmin());
		ps.setString(8, ub.getPassword());
		ps.setDate(9,new Date(ub.getData().getTime()));
		ps.setString(10, ub.getDocumento());
		ps.setString(11, ub.getNumdocumento());
		ps.setString(12, ub.getCittà());
		ps.setString(13, ub.getProvincia());
		
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
	public synchronized List<UtenteDTO> doRetrieveAll() throws ClassNotFoundException
	{
		List<UtenteDTO> listaUtenti = new ArrayList<UtenteDTO>();
		Connection conn=null;
		PreparedStatement ps = null;
		try { 
		conn = DriverManagerConnectionPool.getConnection();
		ps = conn.
				prepareStatement("SELECT * FROM utente");
		ResultSet res= ps.executeQuery();
		while(res.next())
			{
				UtenteDTO ub=new UtenteDTO();
				ub.setPassword(res.getString("Password"));
				ub.setEmail(res.getString("Email"));
				ub.setNome(res.getString("Nome"));
				ub.setCognome(res.getString("Cognome"));
				ub.setAdmin(res.getBoolean("Admin"));
				ub.setCittà(res.getString("Città"));
				ub.setCodicefiscale(res.getString("CodiceFiscale"));
				ub.setData(res.getDate("DataDiNascita"));
				ub.setDocumento(res.getString("Documento"));
				ub.setNumdocumento(res.getString("NumDocumento"));
				ub.setProvincia(res.getString("Provincia"));
				ub.setRecapito(res.getString("Recapito"));
				ub.setVia(res.getString("Via"));
				listaUtenti.add(ub);
			}
		return listaUtenti;
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
		return listaUtenti;
		
		
	}
}
