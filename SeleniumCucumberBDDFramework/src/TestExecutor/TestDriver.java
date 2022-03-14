package TestExecutor;


import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;


public class TestDriver {
	public static void main(String[] args) {
		try {
			
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("./testng.xml");//path to xml..
			testng.setTestSuites(suites);
			testng.run();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		} 
}
