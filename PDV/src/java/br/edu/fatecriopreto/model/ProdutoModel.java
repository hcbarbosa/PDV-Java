/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fatecriopreto.model;

import br.edu.fatecriopreto.bean.Produto;
import br.edu.fatecriopreto.data.HibernateUtil;
import br.edu.fatecriopreto.data.ProdutoData;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Hanna
 */
public class ProdutoModel {
    
    public boolean inserir(Produto produto)
    {
        //ProdutoData pData = new ProdutoData();
        //return pData.inserir(produto);
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        boolean ok = false;
        try
        {
            Transaction trans = sessao.beginTransaction();
            sessao.save(produto);
            trans.commit();
            ok = true;
        }
        catch(HibernateException e)
        {
            System.out.println(e.getMessage());           
        }
        finally{
        sessao.close();
        }
        return ok;
    }
    
    public boolean editar(Produto produto)
    {
        //ProdutoData pData = new ProdutoData();
        //return pData.editar(produto);
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        boolean ok = false;
        try
        {
            Transaction trans = sessao.beginTransaction();
            sessao.update(produto);
            trans.commit();
            ok = true;
        }
        catch(HibernateException e)
        {
            System.out.println(e.getMessage());           
        }
        finally{
        sessao.close();
        }
        return ok;
    }
    
    public void deletar(int codigo)
    {
        //ProdutoData pData = new ProdutoData();
        //return pData.deletar(codigo);
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sessao.beginTransaction();
        Produto prd = (Produto)sessao.get(Produto.class,codigo);
        sessao.delete(prd);
        trans.commit();
        sessao.close();
    }
    
    public Produto getProduto(int codigo)
    {
        //ProdutoData pData = new ProdutoData();
        //return pData.getProduto(codigo);
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = sessao.beginTransaction();
        Produto prd = (Produto) sessao.get(Produto.class, codigo);
        trans.commit();
        sessao.close();
        return prd;
    }
    
    public List<Produto> listar()
    {
        ProdutoData pData = new ProdutoData();
        return pData.listar();
    }
        
    
}
