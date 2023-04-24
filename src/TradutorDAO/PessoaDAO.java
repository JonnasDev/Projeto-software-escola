/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TradutorDAO;

import classes.aluno;
import classes.pessoa;
import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.OPTION;
import jdk.nashorn.internal.ir.CatchNode;

/**
 *
 * @author Laboratorio EEQS 03
 */
public class PessoaDAO {

    public boolean inserirPessoa(pessoa ps) {

        String sql = "INSERT INTO pessoa (nome,cpf,Dnasc,genero,login,senha)VALUES(?,?,?,?,?,?);";
        boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, ps.getNome());
            pst.setString(2, ps.getCpf());
            pst.setString(3, ps.getDnasc());
            pst.setInt(4, ps.getGenero());
            pst.setString(5, ps.getLogin());
            pst.setString(6, ps.getSenha());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "erro ao inserir pessoa!!!", "Erro;", JOptionPane.ERROR_MESSAGE);
        }

        return retorno;

    }

    public boolean inserirAluno(aluno al) {
        String sql = "INSERT INTO aluno (matricula,turma,fkcpf)VALUES(?,?,?);";
        boolean retorno = false;
        PreparedStatement ps = Conexao.getPreparedStatement(sql);
        try {
            ps.setString(1, al.getMatricula());
            ps.setString(2, al.getTurma());
            ps.setString(3, al.getCpf());

            if (ps.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "erro ao inserir Aluno!!!", "Erro;", JOptionPane.ERROR_MESSAGE);
        }

        return retorno;
    }

    public int UltRegistro() {
        int valor = 0;
        String sql = "SELECT * FROM aluno";
        pessoa retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            res.last();
            valor = Integer.parseInt(res.getString("matricula"));
            valor++;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Aluno, Dados Incorretos!!!", "Acesso;", JOptionPane.ERROR_MESSAGE);
        }

        return valor;

    }
public pessoa buscarpessoaNome(String nome) {

        String sql = "SELECT * From pessoa Where nome=?";
        pessoa retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, nome);
            ResultSet res = pst.executeQuery();

            if (res.next()) {

                retorno = new pessoa();
     
           retorno.setCpf(res.getString("cpf"));
                retorno.setDnasc(res.getString("dnasc"));
                retorno.setGenero(res.getInt("genero"));
                retorno.setLogin(res.getString("login"));
                retorno.setNome(res.getString("nome"));
                retorno.setSenha(res.getString("senha"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    
    
    public pessoa buscarpessoa(String mat) {

        String sql = "SELECT * From pessoa Where cpf=?";
        pessoa retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);

        try {

            pst.setString(1, mat);
            ResultSet res = pst.executeQuery();

            if (res.next()) {

                retorno = new pessoa();
     
           retorno.setCpf(res.getString("cpf"));
                retorno.setDnasc(res.getString("dnasc"));
                retorno.setGenero(res.getInt("genero"));
                retorno.setLogin(res.getString("login"));
                retorno.setNome(res.getString("nome"));
                retorno.setSenha(res.getString("senha"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
 public aluno buscarAluno (String mat) {

        String sql = "SELECT turma,fkcpf FROM aluno where matricula=?";
        aluno a = new aluno();

PreparedStatement pst = Conexao.getPreparedStatement (sql);
try {
      pst.setString (1, mat);
       ResultSet res = pst.executeQuery();
    
if(res.next())  
{          
         a.setCpf(res.getString("fkcpf"));
         a.setTurma(res.getString("turma"));
}
}
catch (SQLException ex) {
Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

}

return a;
}
 public aluno buscarAlunoCpf (String cpf) {

        String sql = "SELECT turma,fkcpf,matricula FROM aluno where fkcpf=?";
        aluno a = new aluno();
        //boolean VAluno =false;

PreparedStatement pst = Conexao.getPreparedStatement (sql);
try {
      pst.setString (1, cpf);
       ResultSet res = pst.executeQuery();
    
if(res.next())  
{         
        // VAluno=true;
    
         a.setCpf(res.getString("fkcpf"));
         a.setTurma(res.getString("turma"));
         a.setMatricula(res.getString("matricula"));
}
//if(!VAluno){ JOptionPane.showMessageDialog(null, "Esta pessoa não é um aluno!!", "Acesso;", JOptionPane.ERROR_MESSAGE); }//

}

catch (SQLException ex) {
Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);

}

return a;
}
 public boolean AtualizarAluno (aluno a)  {
     
    String sql= "UPDATE  aluno SET fkcpf=?,turma=?,Dnasc=? WHERE matricula=?";
    PreparedStatement pst = Conexao.getPreparedStatement (sql);
     
     try {
         pst.setString(1, a.getCpf());
         pst.setString(2, a.getTurma());
         pst.setString(3, a.getDnasc());
         pst.setString(4, a.getMatricula());
         
         if (pst.executeUpdate()>0);
         
         {             
             return true;         
         }
         
     } catch (SQLException e) {
         Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
     }
     

       return false;
 }

 public boolean AtualizarPessoa (pessoa p)  {
 
     String sql="UPDATE pessoa SET dnasc=?, login=?, nome=?, senha=?, genero=? WHERE cpf=?";
    PreparedStatement pst = Conexao.getPreparedStatement (sql);
     
     try {
       
         pst.setString(1, p.getDnasc());
         pst.setString(2, p.getLogin());
         pst.setString(3, p.getNome());
         pst.setString(4, p.getSenha());
         pst.setInt(5, p.getGenero());
         pst.setString(6, p.getCpf());

         if (pst.executeUpdate()>0) 
         
         {
             return true;
         }
 
     } catch (Exception e) {
         Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
   
    }

       return false;
}
 
 public boolean excluirPessoa (String cpf){
 
     String sql="DELETE FROM pessoa WHERE cpf=?";
     String sqlaluno="DELETE FROM aluno WHERE fkcpf=?";
     
      PreparedStatement pst = Conexao.getPreparedStatement (sql);
      PreparedStatement pstAL = Conexao.getPreparedStatement (sqlaluno);
      Boolean retorno = false;
      
      try {
         pstAL.setString(1, cpf );
          
         while(pstAL.executeUpdate()>0){
             
         retorno = true;
         }
         
         pst.setString(1, cpf);
         
         while (pst.executeUpdate()>0){
         
         retorno = true;
         }
         
     } catch (SQLException e) { 
          Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, e);
     }
       return false;
 
    }   
 
      public List<pessoa> listarpessoas() {
      
          
     List<pessoa> listapessoa = new ArrayList<pessoa>();
     boolean retorno;
     String sql = "select * FROM pessoa";
     
     PreparedStatement pst = Conexao.getPreparedStatement (sql);
     
          try {
              
              ResultSet res = pst.executeQuery();
              while(res.next())
              {
              
              pessoa linha = new pessoa();             
              linha.setLogin(res.getString("login"));
              linha.setSenha(res.getString("senha"));
              linha.setDnasc(res.getString("dnasc"));
              linha.setCpf(res.getString("cpf"));
              linha.setNome(res.getString("nome"));
              
              listapessoa.add(linha);
           
              
              }
          } catch (SQLException ex) {
              Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
     
         return listapessoa;
      }
      public List<pessoa> listaraluno() {
      
     List<pessoa> listapessoa = new ArrayList<pessoa>();
     boolean retorno;
     String sqlAluno="select fkcpf FROM aluno";
     String sql = "select nome FROM pessoa where cpf=?";
     
     PreparedStatement pst = Conexao.getPreparedStatement (sql);
     PreparedStatement pstAluno = Conexao.getPreparedStatement (sqlAluno);
     
     
          try {
              
                ResultSet resAluno = pstAluno.executeQuery();
             
                while(resAluno.next()){ 
                 
                  pst.setString(1, resAluno.getString("fkcpf"));
               
                  ResultSet res = pst.executeQuery();
              while(res.next()){
              
              pessoa linha = new pessoa();             
              linha.setNome(res.getString("nome"));
              listapessoa.add(linha);
              
              }
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
     
         return listapessoa;
      }
      public List<pessoa> listarTodasPessoas(){
      String sql = "SELECT * FROM pessoa";
      List<pessoa> retorno = new ArrayList<pessoa>();
      PreparedStatement pst = Conexao.getPreparedStatement(sql);
      try {
          ResultSet res = pst.executeQuery();
          while(res.next())
          {
          pessoa item = new pessoa();
          item = new pessoa();
          item.setCpf("cpf");
          item.setDnasc("Dnasc");
          item.setLogin("login");
          item.setNome("nome");
          item.setSenha("senha");
          }
       }catch (SQLException ex) {
              Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        return retorno;
     
      
      
      
      }
     
}
//****NÂO APAGA O CACETE DESSA CHAVE*****// 