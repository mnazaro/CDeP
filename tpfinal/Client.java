// import org.jgroups.JChannel;
// import org.jgroups.Message;
// import org.jgroups.ReceiverAdapter;
// import org.jgroups.View;

// import java.io.BufferedReader;
// import java.io.InputStreamReader;

// public class Cliente extends ReceiverAdapter {
//     private JChannel channel;
    
//     public static void main(String[] args) throws Exception {
//         new Cliente().start();
//     }
    
//     private void start() throws Exception {
//         channel = new JChannel();
//         channel.setReceiver(this);
//         channel.connect("ServiceCluster");
//         eventLoop();
//         channel.close();
//     }
    
//     private void eventLoop() throws Exception {
//         BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//         while (true) {
//             System.out.println("Available options:\n1. Sum\n2. Prime Numbers\n3. Uppercase Conversion\n4. Factorial");
//             System.out.print("Choose an option: ");
//             String chosenOption = console.readLine();
//             channel.send(new Message(null, chosenOption));

//             System.out.print("Enter data as per instructions: ");
//             String inputData = console.readLine();
//             channel.send(new Message(null, inputData));
//         }
//     }
    
//     @Override
//     public void receive(Message msg) {
//         System.out.println("Received result from server: " + msg.getObject());
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

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client extends ReceiverAdapter {
    private JChannel channel;
    private boolean running = true;
    
    public static void main(String[] args) throws Exception {
        new Client().start();
    }
    
    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ServiceCluster");
        eventLoop();
        channel.close();
    }
    
    private void eventLoop() throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (running) {
            System.out.println("Available options:\n1. Sum\n2. Prime Numbers\n3. Uppercase Conversion\n4. Factorial");
            System.out.print("Choose an option: ");
            String chosenOption = console.readLine();
            channel.send(new Message(null, chosenOption));

            System.out.print("Enter data as per instructions: ");
            String inputData = console.readLine();
            channel.send(new Message(null, inputData));

            System.out.print("Do you want to perform another operation? (yes/no): ");
            String choice = console.readLine();
            if ("no".equalsIgnoreCase(choice)) {
                running = false;
                channel.send(new Message(null, "exit"));
            }
        }
    }
    
    @Override
    public void receive(Message msg) {
        System.out.println("Received result from server: " + msg.getObject());
    }

    @Override
    public void viewAccepted(View new_view) {
        System.out.println("** view: " + new_view);
    }
}
