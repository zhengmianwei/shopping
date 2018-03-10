package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientE{
	public static void main(String args[]) {
		Socket socket = null;
		PrintStream ps = null;
		InputStream is = null;
		
		try {
			socket = new Socket("127.0.0.1", 8080);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			ps = new PrintStream(os);
			
			is = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
			ClienThread t = new ClienThread(bufferedReader);
			t.start();
			while(true) {
				System.out.println("请输入");
				String str = br.readLine();
				ps.println(str);
				ps.flush();
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class ClienThread extends Thread{
	private BufferedReader bufferedReader;
	public ClienThread(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	public void run() {
		while(true) {
			try {
				String inStr = bufferedReader.readLine();
				System.out.println("我说...."+inStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

