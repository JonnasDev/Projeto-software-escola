/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabela;

import classes.aluno;
import classes.pessoa;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Laboratorio EEQS 02
 */
public class TabelaAluno extends AbstractTableModel{

    private List<pessoa> linha;
    private List<aluno> linhaAluno;
    private String[] colunas= new String[]{"Login","Senha","Matricula","D.Nascimento","CPF","Nome"};
   
    public TabelaAluno (){
        linha = new ArrayList<pessoa>();
    
    }

    public TabelaAluno(List<pessoa> linha) {
        this.linha = linha;
    }

    @Override
    public int getRowCount() {
        return linha.size();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return colunas.length;  //To change body of generated methods, choose Tools | Templates.
    }
                 
    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        pessoa p = linha.get(linhaIndex);
        aluno a = linhaAluno.get(linhaIndex);
        
        switch (colunaIndex) {
                   case 0:
                           return p.getLogin();
                    case 1:
                            return p.getSenha();
                     case 2:
                             return a.getMatricula();                    
                      case 3:
                              return p.getDnasc();                   
                       case 4:
                               return p.getCpf();                        
                        case 5:
                                return p.getNome();            
            default:
                throw new IndexOutOfBoundsException("erro ao buscar coluna");
    }
    }
    /**
     * @return the linha
     */
    public List<pessoa> getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(List<pessoa> linha) {
        this.linha = linha;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       switch (columnIndex){
       
           case 0:
                return String.class;
            case 1:
                 return String.class;
             case 2:
                  return String.class;
              case 3:
                   return String.class;
               case 4:
                    return String.class;
                case 5:
                     return String.class;
       default:
              return String.class;
       
    }  
    }

}