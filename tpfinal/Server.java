// import java.io.*;
// import java.net.*;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
// import java.util.Arrays;
// import java.util.List;

// public class Server {
//     public static void main(String[] args) {
//         try {
//             ServerSocket serverSocket = new ServerSocket(5000);
//             System.out.println("Server is running...");

//             Registry registry = LocateRegistry.getRegistry();
//             Compute compute = (Compute) registry.lookup("Compute");

//             while (true) {
//                 Socket clientSocket = serverSocket.accept();
//                 new Thread(new ClientHandler(clientSocket, compute)).start();
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

// class ClientHandler implements Runnable {
//     private Socket clientSocket;
//     private Compute compute;

//     public ClientHandler(Socket clientSocket, Compute compute) {
//         this.clientSocket = clientSocket;
//         this.compute = compute;
//     }

//     @Override
//     public void run() {
//         try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//              PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

//             String request = in.readLine();
//             String[] parts = request.split(":");
//             String service = parts[0];
//             String data = parts[1];

//             System.out.println("Server: Service " + service + " requested with data: " + data);

//             String result = "";

//             switch (service) {
//                 case "1":
//                     List<Integer> numbers = Arrays.asList(data.split(",")).stream().map(Integer::parseInt).toList();
//                     result = String.valueOf(compute.sum(numbers));
//                     break;
//                 case "2":
//                     String[] range = data.split(",");
//                     int start = Integer.parseInt(range[0]);
//                     int end = Integer.parseInt(range[1]);
//                     result = compute.primeNumbers(start, end).toString();
//                     break;
//                 case "3":
//                     result = compute.toUpperCase(data);
//                     break;
//                 case "4":
//                     int number = Integer.parseInt(data);
//                     result = String.valueOf(compute.factorial(number));
//                     break;
//             }

//             System.out.println("Server: Service " + service + " completed with result: " + result);
//             out.println(result);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 12345; // Porta que o servidor estará ouvindo
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Servidor iniciado na porta " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Mensagem recebida: " + inputLine);
                    out.println("Mensagem recebida: " + inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}