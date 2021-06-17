package controllers;

import java.io.File;
import java.io.IOException;

public class ThreadCreator {

	public void startExecution() {
		for (int counter = 0; counter < Executor.noOfDevices; counter++) {
			ImplementsRunnable target = new ImplementsRunnable();
			Thread thread = new Thread(target, String.valueOf(counter + 1));

			thread.start();
		}
	}
}

/** Class - Implements Runnable Interface */

class ImplementsRunnable implements Runnable {
	public void run() {
		try {
			new Controller().controllerMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void runBatfile() {
		ProcessBuilder pb = new ProcessBuilder(System.getProperty("user.dir") + File.separator + "GridFiles"
				+ File.separator + "KillBrowserDrivers.bat");
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
