package co.com.bancodebogota.events;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	private ThreadPool() {
	}

	public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(30);

}
