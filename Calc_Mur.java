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