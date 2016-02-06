/**
 * @(#)Server_Mur.java
 *
 *
 * @author 
 * @version 1.00 2014/2/13
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.Naming.*;

public class Server_Mur {

    public Server_Mur() {
    }
    public static void main (String[] args)throws Exception {
    	System.out.println("Server is now running!!!");
    	Naming.rebind("Calc_Mur",new Calc_Mur());
    	
   }
}

/*
Output:

Server side:
Server is now running!!!

Client side:
Result of Addition is 60.0
Result of Subtraction is 20.0
Result of Multiplication is 800.0
Result of Division is 2.0
Result of Modulus is 0.0
*/