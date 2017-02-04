/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fatecriopreto.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hanna
 */
public class Conexao {
    public static final String CLASSFORNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/pdv";
    public static final String USUARIO = "root";
    public static final String SENHA = "102030";
    
    
    public Conexao(){}
    
    private Connection cnn;
    private ResultSet rs; //equivalente ao datareader no asp
    private Statement stmt; //igual ao command, prepara o lugar para executa comandos
    
    public void Conectar(){
        try{
            Class.forName(CLASSFORNAME);
            setCnn(DriverManager.getConnection(URL, USUARIO, SENHA));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Fechar()
    {
        try{
            if(!cnn.isClosed()){
                getCnn().close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }  

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}
