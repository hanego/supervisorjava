package supervisor.rmi.common;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


public class GlobalPlugin  extends UnicastRemoteObject{
	
	protected String name;
	protected HashMap<String,String> inputParams = new HashMap<String,String>();
	protected Host host;
	
	public GlobalPlugin(Host host) throws RemoteException{
		this.host = host;
	}
	
	public void setParam(HashMap<String,String> lstParam){
		this.inputParams = lstParam;
	}
	
	public String getName(){
		return name;
	}
}
