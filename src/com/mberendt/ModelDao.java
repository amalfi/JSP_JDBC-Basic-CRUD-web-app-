package com.mberendt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDao {
			
	private Connection conn;
	
	public ModelDao()
	{
		conn = ConnectionClass.getConnection();
	}
	
		public void add(Model model){
			
			try
			{
					String sql = "INSERT INTO tabela(id, kolumna1, kolumna2, kolumna3, kolumna4)" +
						"VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, model.getId());
			ps.setString(2, model.getKolumna1());
			ps.setString(3, model.getKolumna2());
			ps.setString(4, model.getKolumna3());
			ps.setString(5, model.getKolumna4());
			ps.executeUpdate();
			
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
	
		
		public void remove(int id){
			try{
				String sql ="DELETE FROM tabela WHERE id=?";
				
				PreparedStatement ps =conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
		public void edit(Model model)
		{
			try
			{
				String sql = "UPDATE tabela SET kolumna1=?, kolumna2=?, kolumna3=?, kolumna4=? where id"+"=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, model.getKolumna1());
			ps.setString(2, model.getKolumna2());
			ps.setString(3, model.getKolumna3());
			ps.setString(4, model.getKolumna4());
			ps.setInt(5, model.getId());
			ps.executeUpdate();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
			
		public List<Model> getAllModels()
		{
			List<Model> models = new ArrayList<Model>();
			try{
			String sql = "select * from tabela";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
				while(rs.next())
				{
					Model model = new Model();
					model.setId(rs.getInt("id"));
					model.setKolumna1(rs.getString("kolumna1"));
					model.setKolumna2(rs.getString("kolumna2"));
					model.setKolumna3(rs.getString("kolumna3"));
					model.setKolumna4(rs.getString("kolumna4"));
					models.add(model);
			    }
		} catch (SQLException e)
			{
	            e.printStackTrace();
	        }
		
        return models;
    }
		
		
		public Model getModelById(int id) {
			
			Model model = new Model();
			try
			{
				String sql = "SELECT * FROM tabela WHERE id=?";
				PreparedStatement ps  = conn.prepareStatement(sql);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					model.setId(rs.getInt("id"));
					model.setKolumna1(rs.getString("kolumna1"));
					model.setKolumna2(rs.getString("kolumna2"));
					model.setKolumna3(rs.getString("kolumna3"));
					model.setKolumna4(rs.getString("kolumna4"));
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return model;
			
		}
		
		
		
		
		
		
		
}
