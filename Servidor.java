package atv_multicast_java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(4321);
        InetAddress grupo = InetAddress.getByName("230.0.0.0");
        socket.joinGroup(grupo);

        byte[] buffer = new byte[1024];
        while (true) {
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
            socket.receive(pacote);

            String mensagem = new String(pacote.getData(), 0, pacote.getLength());
            String[] campos = mensagem.split(",");
            String username = campos[0];
            int tipoConteudo = Integer.parseInt(campos[1]);

            System.out.println("[Servidor] Usuário cadastrado: " + username + ", Tipo de conteúdo: " + tipoConteudo);

            byte[] resposta = "Usuário cadastrado com sucesso!".getBytes();
            pacote = new DatagramPacket(resposta, resposta.length, pacote.getAddress(), pacote.getPort());
            socket.send(pacote);
        }
    }
}
