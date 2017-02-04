<%-- 
    Document   : listaProdutos
    Created on : 08/10/2014, 14:09:50
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PDV</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        
        <table>
            <thead>
            <tr>
                <th>ID</th> 
                <th>Nome</th> 
                <th>Preço</th> 
                <th>Estoque</th> 
                <th>Editar</th> 
                <th>Excluir</th> 
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtos}" var="prd">
                    <tr>
                        <td>${prd.codigo}</td>
                        <td>${prd.nome}</td>
                        <td><fmt:formatNumber value="${prd.preco}" minFractionDigits="2"/></td>
                        <td>${prd.estoque}</td>
                        <td><a href="ProdutoServlet?acao=editar&idProduto=${prd.codigo}">Editar</a></td>
                        <td><a href="ProdutoServlet?acao=deletar&idProduto=${prd.codigo}">Excluir</a></td>
                        
                    </tr>
                    
                </c:forEach>
                
            </tbody>
        </table>
        
        
    </body>
</html>
