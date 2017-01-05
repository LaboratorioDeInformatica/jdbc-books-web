package com.br.labdeinf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.labdeinf.modelo.Publisher;

public class PublishersDAO {

	private Connection connection;

    public PublishersDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Publisher> listarTodos(){
    	List<Publisher> listaPublisher = new ArrayList<Publisher>();
    	String sql = "Select publisherID, publisherName  from books.publishers ";
    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    		preparedStatement.execute();
    		
    		try(ResultSet rs = preparedStatement.getResultSet()){
    			
    			while(rs.next()){
    				Publisher publisher = new Publisher();
    				publisher.setPublisherID(rs.getInt("publisherID"));
    				publisher.setPublisherName(rs.getString("publisherName"));
    				listaPublisher.add(publisher);
    			}
    			
    		}
    		
    	} catch (SQLException e) {
			System.out.println("Problemas para executar o sql da Classe PublishDAO "
					+ "metodo listarTodos "+e);
			e.printStackTrace();
		}
    	
    	return listaPublisher;
    }
    
    public List<Publisher> listarPorSimilaridade(int publisherId , String publisherName){
    	List<Publisher> listaPublisher = new ArrayList<Publisher>();
    	String sql ="Select publisherID, publisherName  from books.publishers " ;
    	
    	if(publisherId != 0 &&  !publisherName.equals("")){
    		sql = sql +  " where publisherID = "+publisherId+" and publisherName like '%"+publisherName+"%'" ;
    	}else if( publisherId != 0 &&  publisherName.equals("")){
    		sql = sql +  " where publisherID ="+publisherId ;
    	}else if(publisherId == 0 &&  !publisherName.equals("")){
    		sql = sql +  " where publisherName like '%"+publisherName+"%'" ;
    	}
    	
    	try(PreparedStatement statement = connection.prepareStatement(sql)){
		
			statement.execute();
			
			try(ResultSet rs = statement.getResultSet()){
				
				while(rs.next()){
					Publisher publisher = new Publisher();
					publisher.setPublisherID(rs.getInt("publisherID"));
					publisher.setPublisherName(rs.getString("publisherName"));
					listaPublisher.add(publisher);
				}
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro na classe PublisherDAO ao executar o método"
					+ " listarPorSimilaridade" +e);
			e.printStackTrace();
		}
    	
    	
    	
    	return listaPublisher;
    	
    }
    
    
    public void salva(String publisherName){
    	String sql  = "INSERT INTO books.publishers(publisherName ) values(?)";
    	try(PreparedStatement statement = connection.prepareStatement(sql)){
    		statement.setString(1, publisherName);
    		statement.execute();
    	} catch (SQLException e) {
			System.out.println("Metodo salva da Classe publihsersDAO com problemas na query"+e);
			e.printStackTrace();
		}
    }
    
    public void remove(Integer publisherID){
    	
    	String sql = "Delete from books.publishers where  publisherID = ?" ;
    	try (PreparedStatement statement = connection.prepareStatement(sql)){
    		statement.setInt(1, publisherID);
    		statement.execute();
			
		} catch (Exception e) {
			System.out.println("O metodo remove da Classe publisherID encontrou problemas para ser executada"+e);
		}
    	
    }
    
    public void update(Integer publisherID ,  String publisherName){
    	
    	String sql =" UPDATE books.publishers SET publisherName = ?  where publisherID = ? ";
    	try (PreparedStatement statement = connection.prepareStatement(sql)){
    		statement.setString(1, publisherName);
    		statement.setInt(2, publisherID);
    		statement.execute();
			
		} catch (Exception e) {
			System.out.println("O metodo update da Classe publisherDAO encontrou problemas para ser executada : "+e);
		}
    	
    }
}
