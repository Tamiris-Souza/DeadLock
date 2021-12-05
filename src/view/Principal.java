package view;

import controller.threadController;

public class Principal {

	public static void main(String[] args) {
		
		Thread t1 = new threadController();
		Thread t2 = new threadController();
		
		t1.start();
		t2.start();
		
	}

}
