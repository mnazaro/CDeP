// import org.jgroups.JChannel;
// import org.jgroups.Message;
// import org.jgroups.ReceiverAdapter;
// import org.jgroups.View;

// import java.util.Arrays;
// import java.util.List;

// public class Servidor extends ReceiverAdapter {
//     private JChannel channel;
//     private Compute compute;

//     public static void main(String[] args) throws Exception {
//         new Servidor().start();
//     }

//     private void start() throws Exception {
//         channel = new JChannel();
//         channel.setReceiver(this);
//         channel.connect("ServiceCluster");

//         compute = new ComputeEngine();
//         eventLoop();
//         channel.close();
//     }

//     private void eventLoop() throws Exception {
//         while (true) {
//             // Aguarda mensagens de clientes
//         }
//     }

//     @Override
//     public void receive(Message msg) {
//         String[] parts = msg.getObject().toString().split(":");
//         String service = parts[0];
//         String data = parts[1];

//         String result = "";

//         try {
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
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         try {
//             channel.send(new Message(msg.getSrc(), result));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public void viewAccepted(View new_view) {
//         System.out.println("** view: " + new_view);
//     }
// }

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import java.util.Arrays;
import java.util.List;

public class Server extends ReceiverAdapter {
    private JChannel channel;
    private Compute compute;
    private String chosenOption = null;

    public static void main(String[] args) throws Exception {
        new Server().start();
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ServiceCluster");

        compute = new ComputeEngine();
        eventLoop();
        channel.close();
    }

    private void eventLoop() throws Exception {
        while (true) {
            // Aguarda mensagens de clientes
        }
    }

    @Override
    public void receive(Message msg) {
        if (msg.getObject() instanceof String) {
            String message = (String) msg.getObject();

            if (message.equals("exit")) {
                System.out.println("Client has exited.");
                return;
            }

            if (chosenOption == null) {
                chosenOption = message;
                System.out.println("Service chosen: " + chosenOption);
            } else {
                processRequest(chosenOption, message, msg);
                chosenOption = null;
            }
        }
    }

    private void processRequest(String service, String data, Message msg) {
        String result = "";

        try {
            switch (service) {
                case "1":
                    List<Integer> numbers = Arrays.asList(data.split(",")).stream().map(Integer::parseInt).toList();
                    result = String.valueOf(compute.sum(numbers));
                    break;
                case "2":
                    String[] range = data.split(",");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    result = compute.primeNumbers(start, end).toString();
                    break;
                case "3":
                    result = compute.toUpperCase(data);
                    break;
                case "4":
                    int number = Integer.parseInt(data);
                    result = String.valueOf(compute.factorial(number));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            channel.send(new Message(msg.getSrc(), result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewAccepted(View new_view) {
        System.out.println("** view: " + new_view);
    }
}
