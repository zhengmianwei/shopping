package thread;

public class ThreadSych {
	public static void main(String args[]) {
		for(int i = 0; i < 10; i++) {
			Thread3 t1 = new Thread3();
			t1.start();
		}
	}

}
class Thread3 extends Thread {
	static int i = 0;
	public synchronized void  print() {
		i++;
		System.out.println(this.getName()+"..."+i);
	}
	public void run() {
		while(i < 30) {
			print();
		}
	}
}
