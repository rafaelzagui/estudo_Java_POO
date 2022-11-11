import java.io.*;
import java.net.*;

public class Proativo
{
    public static void main (String[] args)
    {
        try
        {
            // fio do telefone fixo preso na parede
            Socket conexao = new Socket ("localhost",12345);

            // tranmissor sempre antes do receptor
            ObjectOutputStream transmissor =
                    new ObjectOutputStream (
                            conexao.getOutputStream ()); // microfone
            /*
            //receptor sempre depois do transmissor
            ObjectInputStream receptor =
            new ObjectInputStream (
            conexao.getInputStream ()); // autofalante
            */

            BufferedReader teclado =
                    new BufferedReader (
                            new InputStreamReader (
                                    System.in));

            Data pai   = new Data ( 8, 5, 1939);
            Data mae   = new Data (16, 3, 1943);
            Data eu    = new Data (19, 1, 1966);
            Data filho = new Data (29, 6, 1992);

            System.out.print ("Pressione ENTER para enviar a primeira data");
            teclado.readLine ();
            transmissor.writeObject (pai);
            transmissor.flush (); // para envio imediato

            System.out.print ("Pressione ENTER para enviar a segunda data");
            teclado.readLine ();
            transmissor.writeObject (mae);
            transmissor.flush (); // para envio imediato

            System.out.print ("Pressione ENTER para enviar a terceira data");
            teclado.readLine ();
            transmissor.writeObject (eu);
            transmissor.flush (); // para envio imediato

            System.out.print ("Pressione ENTER para enviar a quarta e ultima data");
            teclado.readLine ();
            transmissor.writeObject (filho);
            transmissor.flush (); // para envio imediato

            System.out.print ("Pressione ENTER para terminar o programa");
            teclado.readLine ();
            transmissor.writeObject ("FIM");
            transmissor.flush (); // para envio imediato

            transmissor.close();
            /*
            receptor.close();
            */
            conexao.close();
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}
