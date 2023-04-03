package atv_multicast_java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome de usuário: ");
        String username = sc.nextLine();

        int tipoConteudo = 0;
        while (tipoConteudo != 1 && tipoConteudo != 2) {
            System.out.print("Digite o tipo de conteúdo que deseja receber (1 - Esportes, 2 - Entretenimento): ");
            tipoConteudo = sc.nextInt();
        }

        MulticastSocket socket = new MulticastSocket();
        InetAddress grupo = InetAddress.getByName("230.0.0.0");
        InetSocketAddress endereco = new InetSocketAddress(grupo, 4321);

        String mensagem = username + "," + tipoConteudo;
        byte[] buffer = mensagem.getBytes();

        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco);
        socket.send(pacote);

        byte[] resposta = new byte[1024];
        pacote = new DatagramPacket(resposta, resposta.length);
        socket.receive(pacote);

        mensagem = new String(pacote.getData());
        System.out.println("[Cliente] Recebeu mensagem do servidor: " + mensagem);

        System.out.println("[Cliente] Conexão encerrada!");
        socket.close();
    }
}
