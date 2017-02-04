/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fatecriopreto.data;

import br.edu.fatecriopreto.bean.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hanna
 */
public class ProdutoData extends Conexao {
 
    public boolean inserir(Produto produto){
        boolean ok = false;
        try{
            Conectar();
            PreparedStatement pst;
            String sql = "insert into produtos values (null, ?,?,?,?)";
            
            pst = getCnn().prepareStatement(sql);
            
            pst.setString(1,produto.getNome());
            pst.setString(2,produto.getDescricao());            
            pst.setFloat(3,produto.getPreco());  
            pst.setInt(4,produto.getEstoque());
            
            pst.executeUpdate();
            
            ok = true;            
        }
        catch(Exception e){
            System.out.println("Erro:" + e.getMessage());
        }
        finally{
            Fechar();
        }
        
        return ok;
    }
    
    
    public boolean editar(Produto produto){
         boolean ok = false;
        try{
           Conectar();
           
           String sql = "update produtos set nome=?, descricao=?, preco=?, estoque=? where codigo = ?";
           PreparedStatement pst = getCnn().prepareStatement(sql);
           
           pst.setString(1,produto.getNome());
           pst.setString(2,produto.getDescricao());            
           pst.setFloat(3,produto.getPreco());  
           pst.setInt(4,produto.getEstoque());
           pst.setInt(5,produto.getCodigo()); 
           
           pst.executeUpdate();
           
            ok = true;            
        }
        catch(Exception e){
            System.out.println("Erro:" + e.getMessage());
        }
        finally{
            Fechar();
        }
        return ok;
    }
    
    
    public boolean deletar(int codigo){
        boolean ok = false;
        try{
            Conectar();
            String sql = "delete from produtos where codigo ="+codigo;
            PreparedStatement pst = getCnn().prepareStatement(sql);
            pst.executeUpdate();
            ok=true;
        }
        catch(Exception e){
            System.out.println("Erro:" + e.getMessage());
        }
        finally{
            Fechar();
        }
        return ok;
    }
    
       public Produto getProduto(int codigo){
           Produto produto = null;
           try{
               Conectar();
               String sql = "select * from produto where codigo="+codigo;
               PreparedStatement pst = getCnn().prepareStatement(sql);               
               ResultSet rs = pst.executeQuery();
               
               if(rs.next())
               {
                  produto = new Produto();
                  produto.setNome(rs.getString("nome"));
                  produto.setCodigo(rs.getInt("codigo"));
                  produto.setDescricao(rs.getString("descricao"));
                  produto.setPreco(rs.getFloat("preco"));
                  produto.setEstoque(rs.getInt("estoque"));
               }
           }
           catch(Exception e)
           {
               System.out.println("Erro:" + e.getMessage());
           }
           finally{
               Fechar();
           }     
           
           return produto;
       }
       
       
       public List<Produto> listar()
       {
           List<Produto> produtos = null;
           try{
               Conectar();
               PreparedStatement pst;
               String sql = "select * from produtos";               
               pst = getCnn().prepareStatement(sql);
               ResultSet rs = pst.executeQuery();               
                 produtos = new ArrayList<>();                 
                 while(rs.next())
                 {
                     Produto produto = new Produto();
                     produto.setCodigo(rs.getInt("codigo"));
                     produto.setNome(rs.getString("nome"));                  
                     produto.setDescricao(rs.getString("descricao"));
                     produto.setPreco(rs.getFloat("preco"));
                     produto.setEstoque(rs.getInt("estoque"));                     
                     produtos.add(produto);
                 }
           }
           catch(Exception e)
           {
               System.out.println("Erro:" + e.getMessage());
           }
           finally{
               Fechar();
           }             
           return produtos;
       }
    
}
