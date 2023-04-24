/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.pessoa;
import conexao.executeSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class AcessoDAO extends executeSQL{

    public AcessoDAO(Connection con) {
        super(con);
    }
    
    
    
    public boolean Logar(String login,String senha){
         boolean finalResult = false;
        try{
            String consulta="SELECT login,senha FROM pessoa WHERE login=" + "'"+login+"' AND senha='"+ senha+"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();               
                
            if(rs.next()){
                pessoa a = new pessoa();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO NO CONSULTAR","ERRO",JOptionPane.ERROR_MESSAGE);
        }
        return finalResult;
    }
}
