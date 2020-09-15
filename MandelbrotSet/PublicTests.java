import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && 
					x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && 
					z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && 
					y.getImag().compareTo(b) == 0);
	}
	
	@Test
	public void testAdd() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(3);
		ComplexNumber test = new ComplexNumber(a, b);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(3);
		ComplexNumber test2 = new ComplexNumber(c, d);
		MyDouble testCase = new MyDouble(10);
		MyDouble testCase2 = new MyDouble(6);
		ComplexNumber sum = test.add(test2);
		assertTrue(sum.getReal().equals(testCase) && 
					sum.getImag().equals(testCase2));
		
		a = new MyDouble(-11);
		b = new MyDouble(4);
		test = new ComplexNumber(a, b);
		c = new MyDouble(6);
		d = new MyDouble(7);
		test2 = new ComplexNumber(c, d);
		testCase = new MyDouble(-5);
		testCase2 = new MyDouble(11);
		sum = test.add(test2);
		assertTrue(sum.getReal().equals(testCase) && 
					sum.getImag().equals(testCase2));
	}
	
	@Test
	public void testSubtract() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(3);
		ComplexNumber test = new ComplexNumber(a, b);
		MyDouble c = new MyDouble(3);
		MyDouble d = new MyDouble(5);
		ComplexNumber test2 = new ComplexNumber(c, d);
		MyDouble testCase = new MyDouble(2);
		MyDouble testCase2 = new MyDouble(-2);
		ComplexNumber diff = test.subtract(test2);
		assertTrue(diff.getReal().equals(testCase) && 
					diff.getImag().equals(testCase2));

		a = new MyDouble(-10.4);
		b = new MyDouble(-7.23);
		test = new ComplexNumber(a, b);
		c = new MyDouble(3.76);
		d = new MyDouble(-4.9);
		test2 = new ComplexNumber(c, d);
		testCase = new MyDouble(-14.16);
		testCase2 = new MyDouble(-2.33);
		diff = test.subtract(test2);
		assertTrue(diff.getReal().equals(testCase) && 
					diff.getImag().equals(testCase2));
	}
	
	@Test
	public void testMult() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(3);
		ComplexNumber test = new ComplexNumber(a, b);
		MyDouble c = new MyDouble(3);
		MyDouble d = new MyDouble(5);
		ComplexNumber test2 = new ComplexNumber(c, d);
		MyDouble testCase = new MyDouble(0);
		MyDouble testCase2 = new MyDouble(34);
		ComplexNumber product = test.multiply(test2);
		assertTrue(product.getReal().equals(testCase) && 
					product.getImag().equals(testCase2));
		
		a = new MyDouble(-18);
		b = new MyDouble(-11);
		test = new ComplexNumber(a, b);
		c = new MyDouble(-7);
		d = new MyDouble(-26.34);
		test2 = new ComplexNumber(c, d);
		testCase = new MyDouble(-163.74);
		testCase2 = new MyDouble(551.12);
		product = test.multiply(test2);
		assertTrue(product.getReal().equals(testCase) && 
					product.getImag().equals(testCase2));
	}
	@Test
	public void testDiv() {
		MyDouble a = new MyDouble(-1);
		MyDouble b = new MyDouble(-9);
		ComplexNumber test = new ComplexNumber(a, b);
		MyDouble c = new MyDouble(0.5);
		MyDouble d = new MyDouble(2.1);
		ComplexNumber test2 = new ComplexNumber(c, d);
		MyDouble testCase = new MyDouble(-4.16309);
		MyDouble testCase2 = new MyDouble(-0.51502);
		ComplexNumber quotient = test.divide(test2);
		assertTrue(quotient.getReal().equals(testCase) && 
					quotient.getImag().equals(testCase2));
		
		a = new MyDouble(-3.44);
		b = new MyDouble(0);
		test = new ComplexNumber(a, b);
		c = new MyDouble(-1.72);
		d = new MyDouble(41);
		test2 = new ComplexNumber(c, d);
		testCase = new MyDouble(0.00351);
		testCase2 = new MyDouble(0.08376);
		quotient = test.divide(test2);
		assertTrue(quotient.getReal().equals(testCase) && 
					quotient.getImag().equals(testCase2));
	}
	
	@Test
	public void testEqComp() {
		MyDouble a = new MyDouble(-64);
		MyDouble b = new MyDouble(55);
		ComplexNumber case1 = new ComplexNumber(a, b);
		MyDouble c = new MyDouble(-64);
		MyDouble d = new MyDouble(55);
		ComplexNumber case2 = new ComplexNumber(c, d);
		assertTrue(case1.equals(case2)); //tests the equals method
		
		a = new MyDouble(2);
		b = new MyDouble(2);
		ComplexNumber compareCase = new ComplexNumber(a, b);
		c = new MyDouble(4);
		d = new MyDouble(4);
		ComplexNumber compareCase2 = new ComplexNumber(c, d);
		int compare = compareCase.compareTo(compareCase2);
		assertTrue(compare < 0);
		
		a = new MyDouble(-5);
		b = new MyDouble(-7);
		compareCase = new ComplexNumber(a, b);
		c = new MyDouble(-4.98);
		d = new MyDouble(-4.12);
		compareCase2 = new ComplexNumber(c, d);
		compare = compareCase.compareTo(compareCase2);
		assertTrue(compare > 0);
		
		a = new MyDouble(-4);
		b = new MyDouble(-4);
		compareCase = new ComplexNumber(a, b);
		c = new MyDouble(-4);
		d = new MyDouble(-4);
		compareCase2 = new ComplexNumber(c, d);
		compare = compareCase.compareTo(compareCase2);
		assertTrue(compare == 0);
	}
	
	@Test
	public void testNorm() {
		MyDouble a = new MyDouble(4);
		MyDouble b = new MyDouble(4);
		ComplexNumber test = new ComplexNumber(a, b);
		MyDouble norm = ComplexNumber.norm(test);
		MyDouble testCase = new MyDouble(Math.sqrt(32));
		assertTrue(norm.equals(testCase));
		
		a = new MyDouble(-5);
		b = new MyDouble(7);
		test = new ComplexNumber(a, b);
		norm = ComplexNumber.norm(test);
		testCase = new MyDouble(Math.sqrt(74));
		assertTrue(norm.equals(testCase));
		
		a = new MyDouble(0);
		b = new MyDouble(0);
		test = new ComplexNumber(a, b);
		norm = ComplexNumber.norm(test);
		testCase = new MyDouble(Math.sqrt(0));
		assertTrue(norm.equals(testCase));
	}
	@Test
	public void testToString() {
		MyDouble a = new MyDouble(4), b = new MyDouble(7);
		MyDouble c = new MyDouble(-4), d = new MyDouble(7);
		MyDouble e = new MyDouble(4), f = new MyDouble(-7);
		MyDouble g = new MyDouble(-4), h = new MyDouble(-7);
		ComplexNumber testCase = new ComplexNumber(a, b);
		ComplexNumber testCase1 = new ComplexNumber(c, d);
		ComplexNumber testCase2 = new ComplexNumber(e, f);
		ComplexNumber testCase3 = new ComplexNumber(g, h);
		String complexNumStr = testCase.toString();
		String complexNumStr1 = testCase1.toString();
		String complexNumStr2 = testCase2.toString();
		String complexNumStr3 = testCase3.toString();
		assertTrue(complexNumStr1.equals("-4.0+7.0i"));
		assertTrue(complexNumStr.equals("4.0+7.0i"));
		assertTrue(complexNumStr2.equals("4.0-7.0i"));
		assertTrue(complexNumStr3.equals("-4.0-7.0i"));
	}
	
	@Test
	public void testParse() {
		String a = "-4.232+3.92i";
		ComplexNumber testParse = ComplexNumber.parseComplexNumber(a);
		MyDouble realCase = new MyDouble(-4.232);
		MyDouble imagCase = new MyDouble(3.92);
		assertTrue(testParse.getReal().equals(realCase) && 
				   testParse.getImag().equals(imagCase));
		
		a = "       52   -   30.729i    ";
		testParse = ComplexNumber.parseComplexNumber(a);
		realCase = new MyDouble(52);
		imagCase = new MyDouble(-30.729);
		assertTrue(testParse.getReal().equals(realCase) && 
				   testParse.getImag().equals(imagCase));
		
		a = "    -   0   -   8.82i    ";
		testParse = ComplexNumber.parseComplexNumber(a);
		realCase = new MyDouble(0);
		imagCase = new MyDouble(-8.82);
		assertTrue(testParse.getReal().equals(realCase) && 
				   testParse.getImag().equals(imagCase));
		
		a = "-3.14-0i";
		testParse = ComplexNumber.parseComplexNumber(a);
		realCase = new MyDouble(-3.14);
		imagCase = new MyDouble(0);
		assertTrue(testParse.getReal().equals(realCase) && 
				   testParse.getImag().equals(imagCase));
		
		a = " 5.9  -  73.44i";
		testParse = ComplexNumber.parseComplexNumber(a);
		realCase = new MyDouble(5.9);
		imagCase = new MyDouble(-73.44);
		assertTrue(testParse.getReal().equals(realCase) && 
				   testParse.getImag().equals(imagCase));
	}
}
