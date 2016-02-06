/*The interface specification*/
import java.rmi.*;

public interface IMurInter extends Remote{
	double add(double a,double b)throws RemoteException;
	double sub(double a,double b)throws RemoteException;
	double mul(double a,double b)throws RemoteException;
	double div(double a,double b)throws RemoteException;
	double mod(double a,double b)throws RemoteException;
}

/*Calculator class implementing the interface*/
import java.rmi.*;
import java.rmi.server.*;

class Calc_Mur extends UnicastRemoteObject implements IMurInter{
	public Calc_Mur()throws RemoteException{
	}

	public double add(double a,double b)throws RemoteException{
		return(a+b);
	}
	public double sub(double a,double b)throws RemoteException{
		return(a-b);
	}
	public double mul(double a,double b)throws RemoteException{
		return(a*b);
	}
	public double div(double a,double b)throws RemoteException{
		return(a/b);
	}
	public double mod(double a,double b)throws RemoteException{
		return(a%b);
	}
}

/*Client program*/
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

/*Server program*/
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