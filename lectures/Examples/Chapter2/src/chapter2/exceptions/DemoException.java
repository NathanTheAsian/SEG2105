package chapter2.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DemoException {

	private final static Logger logger = Logger.getLogger("bitacora.subnivel.Control");

//What is the problem?
public void demo1() {
	FileInputStream inputStream = null;
	try {
		File file = new File("./tmp.txt");
		inputStream = new FileInputStream(file);

		// use the inputStream to read a file

		// do NOT do this
		inputStream.close();
	} catch (FileNotFoundException e) {
		logger.log(Level.SEVERE, "something");
	} catch (IOException e) {
		logger.log(Level.SEVERE, "something");
	}
}


public void closeResourceInFinally() {
	FileInputStream inputStream = null;
	try {
		File file = new File("./tmp.txt");
		inputStream = new FileInputStream(file);

		// use the inputStream to read a file

	} catch (FileNotFoundException e) {
		logger.log(Level.SEVERE, "something");
	} finally {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "something");
			}
		}
	}
}


public void doNotDoThis() throws Exception {  }

public void doThis() throws NumberFormatException {  }

/**
* This method does something extremely useful ...
*
* @param input
* @throws MyBusinessException if ... happens
*/
//public void doSomething(String input) throws MyBusinessException {  }


// Good or bad?
public void catchMostSpecificExceptionFirst() {
	try {
		doSomething("A message");
	} catch (NumberFormatException e) {
		logger.log(Level.SEVERE, "something");
	} catch (IllegalArgumentException e) {
		logger.log(Level.SEVERE, "something");
	}
}
public void doSomething(String input) {}

// Good or Evil?
public void doNotCatchThrowable() {
	try {
		// do something
	} catch (Throwable t) {
		// don't do this!
	}
}

}
