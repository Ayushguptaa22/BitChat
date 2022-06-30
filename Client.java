import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private boolean done;
	private String message;
	private int prev;
	
	@Override
	public void run() {
		try {
			client=new Socket("127.0.0.1",8080);
			out=new PrintWriter(client.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			InputHandler inHandler =new InputHandler();
			Thread t=new Thread(inHandler);
			t.start();
			
			String inMessage;
			while((inMessage=in.readLine())!=null) {
				System.out.println(inMessage);
			}
			
		}catch(IOException e) {
			shutdown();
		}
	}
	
	public void shutdown() {
		done=true;
		try {
			in.close();
			out.close();
			if(!client.isClosed()) {
				client.close();
			}
		}
		catch(IOException e) {
			//TODO
		}
	}
	
	class InputHandler implements Runnable{
		
		@Override
		public void run() {
			try {
				BufferedReader inReader =new BufferedReader(new InputStreamReader(System.in));
				while(!done) {
					message=inReader.readLine();
					if(message.equals("/quit")) {
						inReader.close();
						shutdown();
					}
					else {
						out.println(message);
						prev=retMsg();
					}
				}
			}
			catch(IOException e) {
				shutdown();
			}
		}
	}
	
	public int retMsg() {
		// TODO Auto-generated method stub
		String[] t= {message};
		Block b=new Block(prev,t);
		System.out.println("Prev: "+prev);
		System.out.println("New: ");
		System.out.println(b.getBlockHash());
		return b.getBlockHash();
	}
	
	public static void main(String args[]) {
		Client client=new Client();
		client.run();
}

}
