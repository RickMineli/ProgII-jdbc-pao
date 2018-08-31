package pkg3esoft2018.pao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pkg3esoft2018.util.ConnectionManager;

public class PaoRepository {
    
    public List<Pao> obterPaes() {
        List<Pao> paes = new ArrayList<>();
        ConnectionManager cm = ConnectionManager.getInstance();
        try (             
              PreparedStatement ps = cm.prepareStatement("select id, nome from pao");
              ResultSet rs = ps.executeQuery()){            
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                Pao novo = new Pao(id, nome);
                paes.add(novo);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paes;
    }
    
    
    	public void inserir(Pao novo) {
		ConnectionManager cm = ConnectionManager.getInstance();
                try (   PreparedStatement  psInsert = cm.prepareStatement("insert into pao (id, nome) values (null,?)");)						
			{
                        psInsert.setString(1,(novo.getNome()));
                        psInsert.execute();
                } catch (Exception e) {
			e.printStackTrace();	
		}		
	}
}
