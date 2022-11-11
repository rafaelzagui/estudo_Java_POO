import java.io.*;
import java.net.*;

public class Proativo {
    public static void main(String[] args) {
        try {
            //fio do telefone na parede
            Socket conexao = new Socket ("localhost",5050);

            //Lendo as informações que vem atraves pelo teclado
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            // receptor esta associado ao socket lendo as coisas que vem do socket
            BufferedReader receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream())); //auto falante

            PrintWriter transmissor = new PrintWriter(conexao.getOutputStream());//microfone

            String texto;
            do {
                texto = teclado.readLine();
                transmissor.println(texto);
                transmissor.flush(); //para envio imediato
            } while (!texto.toUpperCase().equals("FIM"));
            transmissor.close();
            receptor.close();
            conexao.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
