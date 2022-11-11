import java.io.*;
import java.net.*;

public class Reativo
{
    public static void main (String[] args)
    {
        try
        {
            ServerSocket pedido  = new ServerSocket (12345);

            // fio do telefone fixo preso na parede
            Socket conexao = pedido.accept();

            /*
            // tranmissor sempre antes do receptor
            ObjectOutputStream transmissor =
            new ObjectOutputStream (
            conexao.getOutputStream ()); // microfone
            */
            //receptor sempre depois do transmissor
            ObjectInputStream receptor =
                    new ObjectInputStream (
                            conexao.getInputStream ()); // autofalante

            Object obj=null;
            do
            {
                obj = receptor.readObject();
                System.out.println (obj);

            }
            while (!(obj instanceof String) || !((String)obj).toUpperCase().equals ("FIM"));

            /*
            transmissor.close();
            */
            receptor.close();
            conexao.close();

            pedido.close();
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}
