package ExcSem.Seminar3;

import java.net.*;
import java.io.*;
import java.util.Arrays;

public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(20000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Ожидание клиента на порт " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Просто подключается к " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                //out.writeUTF("Спасибо за подключение к " + server.getLocalSocketAddress()
                //        + "\nПока!");
                String line;
                //while ((line = in.readUTF()).equals("exit")) {
                String[] lines = in.readUTF().split(";");
                System.out.println(Arrays.toString(lines));
                if (Main.passwordValidate(lines[0], lines[1], lines[2])) {
                    out.writeUTF("Данные корректные");
                } else {
                    out.writeUTF("Данные некорректные");
                }
                //}
                server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Время сокета истекло!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 8000;
        try {
            Thread t = new GreetingServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
