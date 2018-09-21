package com.ecommerce.web.anotherTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ecommerce.web.utilities.CapitalLettersValidation;

@RunWith(Parameterized.class)
public class CapitalLettersTest {
	CapitalLettersValidation clv;
/*@Before
	public void init()
	{
		CapitalLettersValidation clv = new CapitalLettersValidation();
	}
*/	
/*	@Parameters
public static  List<Object> values(){
	return Arrays.asList(new Object[][]{
		{"sh iv a","shiva"}, { "shiva rama krishna","shivaramakrishna"},{"   krishna","krishna"},{"k s h v a a ","kshvaa"},{"ram asd","ram asd"}
		}
	)
	;
	}
*/	
	
	@Parameters
	public static List<Object> values()
	{
		return  Arrays.asList(new String[] {"SHIVARAM","shivaram","RAMAKRISHNA","SHIVAKRISHNA","shiva RAMA Krishna"});
	}
	private String actual;
	//private String expected;
	public CapitalLettersTest(String actual)
	{
		this.actual=actual;
		//this.expected = expected;
	}
/*@Test
public void TrimmingWhiteSpace()
{
	assertEquals(expected,CapitalLettersValidation.capitalLetters(actual));
	
}
*/
	@Test
public void TestCapital() {
	assertTrue(CapitalLettersValidation.isCapital(actual));
}

	
}
