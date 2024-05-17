/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alterstringws_client_application;

/**
 *
 * @author matheus.nazaro_unesp
 */
public class AlterStringWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String upper = "CAIXA ALTA";
        String lower = "caixa baixa";
        System.out.println(lowToUpper(lower));
        System.out.println(upperToLow(upper));
    }

    private static String lowToUpper(java.lang.String lowString) {
        org.me.lowupper.LowToUpper_Service service = new org.me.lowupper.LowToUpper_Service();
        org.me.lowupper.LowToUpper port = service.getLowToUpperPort();
        return port.lowToUpper(lowString);
    }

    private static String upperToLow(java.lang.String upperString) {
        org.me.uppertolow.UpperToLow_Service service = new org.me.uppertolow.UpperToLow_Service();
        org.me.uppertolow.UpperToLow port = service.getUpperToLowPort();
        return port.upperToLow(upperString);
    }
    
}
