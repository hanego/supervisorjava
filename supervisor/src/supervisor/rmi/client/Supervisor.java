package supervisor.rmi.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Supervisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parameters.setParameters("config.xml");

		while(true){
			System.out.print("#");
			String cmd = lireString();
			if(cmd.compareTo("")==0)
				continue;
			StringTokenizer tokenizer = new StringTokenizer(cmd, " ");
			ArrayList<String> cmds = new ArrayList<String>();
			int i = 0;

			while ( tokenizer.hasMoreTokens() ) {
				cmds.add(tokenizer.nextToken());
				i++;
			}

			if(cmds.get(0).compareTo("exit")==0){
				System.exit(0);
			}
			else if(cmds.get(0).compareTo("help")==0){
				showHelp();
			}
			else{

				Proxy proxy = Parameters.getProxy(cmds.get(0));

				if(proxy!=null){
					try{
						if(!proxy.launchCommand(cmds))
							System.out.println("Impossible de lancer la commande.");
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				else
					System.out.println("Erreur dans la commande. La machine n'existe pas.");		
			}
		}

	}

	public static String lireString(){//lecture d'une chaine
		String ligne_lue=null;
		try{
			InputStreamReader lecteur=new InputStreamReader(System.in);
			BufferedReader entree=new BufferedReader(lecteur);
			ligne_lue=entree.readLine();
		}
		catch(IOException err){
			System.exit(0);
		}
		return ligne_lue;
	} 

	public static void showHelp(){

	}

}