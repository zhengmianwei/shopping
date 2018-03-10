package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerA {
	public static void main(String args[]) {
		try{
			ServerSocket ss = new ServerSocket(8080);
			System.out.println("启动服务器，端口号为:8080");
			// 接收请求返回socket
			Socket socket = ss.accept();
			System.out.println("接收请求");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			while(true){
				ps.print("hello:"+br.readLine());
				System.out.println("已经向客户端发送消息");
				ps.close();
				os.close();
				socket.close();
				ss.close();
			}	
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
