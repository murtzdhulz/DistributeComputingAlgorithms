/**
 * @(#)Client_Mur.java
 *
 *
 * @author 
 * @version 1.00 2014/2/13
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.Naming.*;

public class Client_Mur {

    public Client_Mur() {
    }
    
    public static void main (String[] args)throws Exception {
    	IMurInter i=(IMurInter)Naming.lookup("//localhost/Calc_Mur");
    	System.out.println("Result of Addition is "+i.add(40,20));
    	System.out.println("Result of Subtraction is "+i.sub(40,20));
    	System.out.println("Result of Multiplication is "+i.mul(40,20));
    	System.out.println("Result of Division is "+i.div(40,20));
    	System.out.println("Result of Modulus is "+i.mod(40,20));
}
    
    
}