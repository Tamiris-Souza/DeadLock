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
//A thread 1  bloqueia o recurso 1, a thread 2 bloqueia o recurso 2, 
//posteriormente a thread 1 tenta acessar o recurso 2 e não consegue, 
//e a thread 2 tenta acessar o recurso 1 e não consegue, 
//caracterizando um deadlock de condição de espera circular,
//no qual cada um está a espera de recurso retido pelo membro seguinte dessa cadeia.