package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientA {
	public static void main(String args[]) {
		try{
			Socket socket = new Socket("192.168.0.100", 8080);
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = br.readLine();			
			System.out.println("接收到服务器端信息"+str);
			br.close();
			is.close();
			socket.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
