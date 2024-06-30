// // import java.io.*;
// // import java.net.*;

// // public class Client {
// //     public static void main(String[] args) {
// //         try (Socket socket = new Socket("localhost", 5000);
// //              BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
// //              PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                
// //             // MOstra para o usuario os dados disponiveis
// //             System.out.println("Serviços Disponíveis:");
// //             System.out.println("1. Soma");
// //             System.out.println("2. Números Primos");
// //             System.out.println("3. Maiúsculas");
// //             System.out.println("4. Fatorial");

// //             // Pede para o usuario escolher um serviço
// //             System.out.print("Escolha um serviço: ");
// //             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
// //             String service = reader.readLine();

// //             // Pede para o usuario inserir os dados
// //             System.out.print("Insira os dados: ");
// //             String data = reader.readLine();

// //             out.println(service + ":" + data);
// //             System.out.println("Client: Requested service " + service + " with data: " + data);

// //             String response = in.readLine();
// //             System.out.println("Client: Received result: " + response);


// //             // You can add similar blocks for other services here

// //         } catch (Exception e) {
// //             e.printStackTrace();
// //         }
// //     }
// // }

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Endereço do servidor
        int port = 5000; // Porta do servidor

        String userInput;
        
        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
                do {
                    out.flush();
                    // Mostra para o usuário os serviços disponíveis
                    System.out.println("Serviços Disponíveis:");
                    System.out.println("1. Soma");
                    System.out.println("2. Números Primos");
                    System.out.println("3. Maiúsculas");
                    System.out.println("4. Fatorial");

                    // Pede para o usuário escolher um serviço
                    System.out.print("Escolha um serviço: ");
                    String service = stdIn.readLine();

                    // Pede para o usuário inserir os dados
                    System.out.print("Insira os dados: ");
                    String data = stdIn.readLine();

                    // Envia a escolha do serviço e os dados ao servidor
                    out.println(service + ":" + data);
                    System.out.println("Client: Requested service " + service + " with data: " + data);

                    // Recebe a resposta do servidor
                    String response = in.readLine();
                    System.out.println("Client: Received result: " + response);

                    // Pergunta ao usuário se deseja continuar
                    System.out.print("Deseja realizar outra operação? (sim/não): ");
                    userInput = stdIn.readLine();         
                } while ("sim".equalsIgnoreCase(userInput));
            } catch (UnknownHostException e) {
                System.err.println("Não foi possível encontrar o host: " + serverAddress);
                System.err.println("Erro: " + e.getMessage());
                //break; // Sai do loop se o host não puder ser encontrado
            } catch (IOException e) {
                System.err.println("Não foi possível obter I/O para a conexão com: " + serverAddress);
                //break; // Sai do loop em caso de erro de I/O
            }
        
    }
}

// import java.io.*;
// import java.net.*;

// public class Client {
//     public static void main(String[] args) throws IOException {
//         String serverAddress = "127.0.0.1"; // Endereço do servidor
//         int serverPort = 12345; // Porta do servidor
//         Socket socket = new Socket(serverAddress, serverPort);

//         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

//         // Thread para ler as respostas do servidor
//         new Thread(() -> {
//             try {
//                 String inputLine;
//                 while ((inputLine = in.readLine()) != null) {
//                     System.out.println("Servidor: " + inputLine);
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }).start();

//         String userInput;
//         System.out.println("Digite sua mensagem (digite 'sair' para terminar):");
//         while ((userInput = stdIn.readLine()) != null && !userInput.equalsIgnoreCase("sair")) {
//             out.println(userInput);
//         }

//         socket.close();
//     }
// }