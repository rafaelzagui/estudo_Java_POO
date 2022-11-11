import java.io.*;
import java.net.*;

public class Reativo {
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket pedido = new ServerSocket(5050);
            //fio do telefone preso na parede
            Socket conexao = pedido.accept();//uma das pontas do fio
            BufferedReader receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream())); // autofalante
           // PrintWriter transmissor = new PrintWriter(conexao.getOutputStream());//Microfone
            String texto;
            do {
                texto = receptor.readLine();
                System.out.println(texto);
            }while (!texto.toUpperCase().equals("FIM"));

            receptor.close();
            conexao.close();
            pedido.close();

        } catch (Exception erro)
        {
            System.out.println("Opa temos um erro !! ");
            System.err.println(erro.getMessage());

        }
    }
}