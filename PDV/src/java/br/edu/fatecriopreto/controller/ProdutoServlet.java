/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fatecriopreto.controller;

import br.edu.fatecriopreto.bean.Produto;
import br.edu.fatecriopreto.model.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hanna
 */
public class ProdutoServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String pagina = "";
        ProdutoModel pModel = new ProdutoModel();
        HttpSession sessao = request.getSession();
        if(acao.equals("listar")){
            
            List<Produto> produtos = pModel.listar();
            //sessao  para cada usuario podemos ter um espaco na memoria do servidor, chamado sessao
            
            sessao.setAttribute("produtos", produtos);
            pagina = "listaProdutos.jsp";
        }
        else if(acao.equals("editar")){
               int id = Integer.parseInt(request.getParameter("idProduto"));
               Produto produto = pModel.getProduto(id);
               sessao.setAttribute("produto", produto);
               pagina = "incluiAlteraProduto.jsp";               
            }
        else if(acao.equals("deletar"))
        {
            
        }
        
        response.sendRedirect(pagina);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        if(acao.equals("salvar")){
            Produto produto = new Produto();
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setPreco(Float.parseFloat(request.getParameter("preco")));
            produto.setEstoque(Integer.parseInt(request.getParameter("estoque")));
            
            ProdutoModel pModel = new ProdutoModel();
            pModel.inserir(produto);
            
            response.sendRedirect("ProdutoServlet?acao=listar");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
