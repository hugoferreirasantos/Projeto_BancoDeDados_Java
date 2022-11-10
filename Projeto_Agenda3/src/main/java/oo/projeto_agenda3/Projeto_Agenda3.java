/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package oo.projeto_agenda3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hugo
 */
public class Projeto_Agenda3 {

    public static void main(String[] args) throws SQLException {
        //Iniciar a conexão com valor nulo:
        Connection conexao = null;
        try{
            //Configurar o Driver de Conexão:
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/agendaapi", "root", "");
            
            //Comando para Inserção de Dados:
            String sql = "INSERT INTO agenda(nome,evento,descEvento) VALUES(?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, "Ana Clara");
            ps.setString(2,"Villa Mix");
            ps.setString(3, "Show do Maiara e Mariasa");
            ps.executeUpdate();
            
            
            // Comando para Impresão dos Resultados:
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM agenda");
            while(rs.next()){
                System.out.println("TABELA USUÁRIO");
                System.out.println("NOME: "+rs.getString("nome")+ " - "+"Evento: "+ rs.getString("evento"));
                
                
            }
            
            
            
        }catch(ClassNotFoundException ex){
            System.out.println("Driver do banco de dados não localizado: "+ex.getMessage());
        }catch(SQLException ex){
            System.out.println("Houve um erro ao acessar o banco de dados: "+ex.getMessage());
        }finally{
            if(conexao != null){
                conexao.close();
            }
        }
    }
}
