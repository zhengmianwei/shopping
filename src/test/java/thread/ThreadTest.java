package thread;

public class ThreadTest {
	public static void main(String args[]) {
		Thread1 t1 = new Thread1("t1");
		Thread1 t2 = new Thread1("t1");
		t1.start();
		t2.start();
		/*Thread2 t2 = new Thread2();
		t1.start();
		t2.setName("t2");
		t2.start();*/
	}
}

class Thread1 extends Thread {
	String name ;
	public Thread1(String name) {
		super(name);
	}
	private int i = 0;
	public void run() {
		
		
		while(i < 50) {
			i++;
			System.out.println(this.getName()+"...."+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread2 extends Thread{
	private int i = 0;
	public void run() {
		while(i < 50) {
			i++;
			System.out.println(this.getName()+"..."+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}