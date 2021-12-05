package controller;

public class threadController extends Thread {
	
	final String RECURSO1 = "Recurso1";
	final String RECURSO2 = "Recurso2";
	
	public threadController() {
		super();
	}
	
	public void run() {
		synchronized(RECURSO1) {
			System.out.println("Thread #1: bloqueou o recurso 1");
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread #1: tentando o acesso ao recurso 2");
		
			synchronized(RECURSO2) {
				System.out.println("Thread #1: bloqueou recurso 2");
			}
		}
		
		synchronized(RECURSO2) {
			System.out.println("Thread #2: bloqueou o recurso 2");
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread #2: tentando o acesso ao recurso 1");
		
			synchronized(RECURSO1) {
				System.out.println("Thread #2: bloqueou recurso 1");
			}
		}
		
		
	}
}
