package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.java.CanvasController;
import main.java.util.constants.StringConstants;

public class CanvasControllerTest {
	
	@Test
	public void canReadCommand() {
		CanvasController cc = new CanvasController();
		String commandStr = "C 20 4";
		String testStr = 
				"----------------------" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"|                    |" + StringConstants.NL.getValue() +
				"----------------------";
		
		Assert.assertEquals(testStr, cc.run(commandStr));
	}
}
