package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
public class ServerE {
	public static void main(String args[]) {
		try{
			ServerSocket ss = new ServerSocket(8080);
			System.out.println("服务已启动");
			Set<Socket> set = new HashSet<Socket>();
			while(true) {
				Socket socket = ss.accept();
				set.add(socket);
				ServerThread st = new ServerThread(socket, set);
				st.start();
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerThread extends Thread {
	Socket socket;
	Set<Socket> set;
	public ServerThread(Socket socket, Set<Socket> set) {
		this.socket = socket;
		this.set = set;
	}
	public void run() {
		PrintStream ps;
		try{
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while(true) {
				String str = br.readLine();
				System.out.println(socket.getInetAddress()+" 说   "+str);
				
				for(Socket s : set) {
					OutputStream os = s.getOutputStream();
					ps = new PrintStream(os);
					ps.println(str);
					ps.flush();
				}
				
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}




















