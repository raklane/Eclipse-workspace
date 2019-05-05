package Package1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcatTest {

	@Test
	public void test() {
		JunitClass junit = new JunitClass();
		String result = junit.concat("Rakesh ", "Kumar");
		assertEquals("Rakesh Kumar", result);
	}

}
