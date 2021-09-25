package _00_init.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class MyContextListener implements ServletContextListener {

	public MyContextListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			while (DriverManager.getDrivers().hasMoreElements()) {
				DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
			}
			System.out.println("jdbc Driver close");
			AbandonedConnectionCleanupThread.checkedShutdown();
			System.out.println("clean thread success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void contextInitialized(ServletContextEvent sce) {
	}

}
