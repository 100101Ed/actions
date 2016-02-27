package com.sqa.em.maven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class mavenTest {

	public Properties systemProps;

	@Test(enabled = false)
	public void e() throws IOException {
		// File[] files = File.listRoots();
		// for (File f : files) {
		// System.out.println(f.getPath());
		// }
		// How to find a path on a file
		System.out.println("Trying out Properies File");
		Properties props = new Properties();
		// System.out.println(new
		// File(mavenTest.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
		InputStream fis = this.getClass().getClassLoader()
				.getResourceAsStream("SharedUIMap/element.properties");
		// FileInputStream fis = new FileInputStream(
		// "./../../maven-play/src/main/resources/shareUIMap/element.properties");
		// FileOutputStream fos = new
		// FileOutputStream("./maven-play/src/main/resources/shareUIMap/element.properties");
		props.load(fis);
		System.out.println("Username:" + props.getProperty("mpuser"));
		System.out.println("Password:" + props.getProperty("mppass"));
		props.setProperty("mapusername", "newusername");
		props.setProperty("mappassword", "mappassword");
		// props.store(fos, "Ed Has Successfully Updates His Properties File
		// !!!");
	}

	// @Test //
	@BeforeClass
	public void initClass() {
		String env = System.getProperty("envSelect");
		String propertiesDevFileLocation = System.getProperty("config.dev");
		String propertiesProFileLocation = System.getProperty("config.pro");
		if (env.equals("dev")) {
			System.out.println("Loading Development Environment");
			this.systemProps = loadProperties(propertiesDevFileLocation);
		} else if (env.equals("pro")) {
			System.out.println("Loading Production Environment");
			this.systemProps = loadProperties(propertiesProFileLocation);
		} else {
			try {
				throw new IllegalPropertyFileSpecifiedException();
			} catch (IllegalPropertyFileSpecifiedException e) {
				System.out.println(e.toString());
			}
		}
	}

	private Properties loadProperties(String url) {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(url);
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		System.out.println("Props = " + props.getProperty("environment"));
		for (Object prop : props.values()) {
			System.out.println(prop);
		}
		return props;
	}

	@Test(enabled = true)
	public void changeFileNameTest() {
		// String fileLoc = System.getProperty("envSelect");
		System.out.println("Environment: " + System.getenv("envSelect"));
		// System.out.println("Testing File Name properties change " + fileLoc);
		// getProperties("maveuser");
	}

	@Test(enabled = false)
	public void f() {
		String validPass = "123";
		String validUser = "ed";
		String username = System.getProperty("mp.user");
		String password = System.getProperty("mp.pass");
		System.out.println("Validating User...");
		if (username.equalsIgnoreCase(validUser)) {
			if (password.equalsIgnoreCase(validPass)) {
				System.out.println("You have been granted access " + username);
			} else {
				System.out.println(
						"Sorry, you have been denied access: Incorrect password provided.");
			}
		} else {
			System.out.println("Sorry, invalid user not found in system:" + username);
		}
		System.out.println("*******************************************************************");
		System.out.println("What is going on Maven.." + System.getProperty("mapusername"));
		System.out.println("What is going on Maven.." + System.getProperty("mappassword"));
	}
}
// InputStream in =
// this.getClass().getClassLoader().getResourceAsStream("pro.properties");
// Properties props = new Properties();
// try {
// props.load(in);
// } catch (IOException e) {
// System.out.println(e.toString());
// }
// System.out.println("Props = " + props.getProperty("environment"));
// loadProperties("asdf");