
package aula4.escola.trycatch;

import aula4.escola.controle.AlunoControle;
import aula4.escola.modelo.Aluno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CadastraAluno {
    
    public void CAluno() {
        
        Scanner ler = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();        
    
        System.out.println("Digite o nome do aluno: ");
               String nome = ler.nextLine();
                System.out.println("Digite a matricula: ");
                String matricula = ler.nextLine();
                
                Aluno a = AlunoControle.cadastrarAluno(nome, matricula);
                    alunos.add(a);
      
                try {
               Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MariaPeixoto", "root", "2010");
                    ResultSet rs = null;
                    PreparedStatement stmt =  con.prepareStatement("select nome, matricula from Aluno");
                    stmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("OK");                        
                    }
        } catch (Exception e) {
        }
             

        
       

    }

}