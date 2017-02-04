<%-- 
    Document   : incluiAlteraProduto
    Created on : 14/10/2014, 14:30:35
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
    </head>
    <body>
        <h1>Inclui/Altera Produto</h1>
        
        <form action="ProdutoServlet" method="POST">
            <fieldset>
                <legend>Formulário</legend>
                <input type="hidden" name="acao" value="salvar"/>
                
                <label>Nome:</label>
                <input type="text" name="nome" />
                <br/><br/>
                <label>Descrição:</label>
                <input type="text" name="descricao"/>
                <br/><br/>
                <label>Preço:</label>
                <input type="text" name="preco" />
                <br/><br/>
                <label>Estoque:</label>
                <input type="number" name="estoque"/>
                <br/><br/>
                <input type="submit" value="Salvar" name="salvar"/>
            
            </fieldset>
        </form>
        
    </body>
</html>
