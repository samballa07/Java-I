/*
 * Represents a complex number with instance variables for the real and 
 * imaginary numbers. Allows users to manipulate complex numbers with methods
 * like add, subtract, etc..
 */
public class ComplexNumber {
	
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors
		
	
	//Constructor. initializes values for the real and imag instance vars
	public ComplexNumber(MyDouble realIn, MyDouble imagIn) {
		real = realIn;
		imag = imagIn;
	}
	
	//Constructor. Has a parameter for real variable, but sets imag to 0.
	public ComplexNumber(MyDouble realIn) {
		real = realIn;
		imag = new MyDouble(0); //instantiates  a new object, MyDouble, 
								//and sets it to 0
	}
	
	//Copy constructor. Creates a copy of the parameter object
	public ComplexNumber(ComplexNumber otherNum) {
		real = otherNum.real; 
		imag = otherNum.imag;
	}
	
	//allows access to the real instance variable
	public MyDouble getReal() {
		return real;
	}
	
	//allows access to the imag instance variable
	public MyDouble getImag() {
		return imag;
	}
	
	/*adds the ComplexNumber object sent as a parameter to the current object.
	 * Both real values are added together and so are the imaginary values.
	 * New ComplexNumber object is created and returned with the new sums for 
	 * real and imag
	 */
	public ComplexNumber add(ComplexNumber num) {
	//access to the current object private variables are done through getters
		MyDouble realSum = real.add(num.getReal());
		//uses add method from MyDouble
		MyDouble imagSum = imag.add(num.getImag());
		ComplexNumber sumVal = new ComplexNumber(realSum, imagSum);
		return sumVal;
	}
	
	/* Returns a new ComplexNumber object with the real and imag variables of
	 * the parameter object being subtracted from the current object.
	 */
	public ComplexNumber subtract(ComplexNumber num) {
		MyDouble realDiff = real.subtract(num.getReal());
		MyDouble imagDiff = imag.subtract(num.getImag());
		ComplexNumber diffVal = new ComplexNumber(realDiff, imagDiff);
		return diffVal;
	}
	
	/* Returns a ComplexNumber object with the real and imag values resulting
	 * from the product of two binomial complex numbers. Using FOIL, the 
	 * current object was multiplied to the object passed through the parameter.
	 * Like terms are combined and a new ComplexNumber is created
	 */
	public ComplexNumber multiply(ComplexNumber num) {
		MyDouble a = real.multiply(num.getReal());
		MyDouble b = real.multiply(num.getImag());
		MyDouble c = imag.multiply(num.getReal());
		MyDouble d = imag.multiply(num.getImag());
		
		//i^2 is equal to -1
		MyDouble neg = new MyDouble(-1);
		
		//the imag variable(d) must be multiplied by -1 to deal with i^2
		MyDouble newReal = a.add(d.multiply(neg));
		MyDouble newImag = b.add(c); //like terms are combined
		ComplexNumber productVal = new ComplexNumber(newReal, newImag);
		return productVal;
	}
	
	/*This method divides the current object by the object passed through the
	 * parameter. The formula: (a + bi)        (ac + bd)        (bc - ad)
                               --------  =     ----------   +   --------- i
                               (c + di)        (c2 + d2)        (c2 + d2)
     * Returns the quotient as a ComplexNumber object
	 */
	public ComplexNumber divide(ComplexNumber num) {
		MyDouble a = real;
		MyDouble b = imag;
		MyDouble c = num.getReal();
		MyDouble d = num.getImag();
		
		MyDouble numerator1 = a.multiply(c).add(b.multiply(d));
		MyDouble denominator = c.multiply(c).add(d.multiply(d));
		
		MyDouble newReal = numerator1.divide(denominator);
		
		MyDouble numerator2 = b.multiply(c).subtract(a.multiply(d));
		
		MyDouble newImag = numerator2.divide(denominator);
		
		ComplexNumber divideVal = new ComplexNumber(newReal, newImag);
		return divideVal;
		
	}
	
	//Checks to see if the current object is equal to the object passed thru 
	//the parameter. Returns a boolean
	public boolean equals(ComplexNumber num) {
		//uses the equals method from the MyDouble class
		if (real.equals(num.getReal()) && imag.equals(num.getImag())){
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * this method compares the norms of the current object and the object 
	 * passed through parameter. If the current object's norm is less than the 
	 * other object, Then it returns a negative. If its the same, then it
	 * returns 0. It its greater, it returns a positive number.
	 */
	public int compareTo(ComplexNumber num) {
		ComplexNumber currNum = new ComplexNumber(real, imag);
		MyDouble currNorm = norm(currNum);
		MyDouble paramNorm = norm(num);
		
		if (currNorm.compareTo(paramNorm) < 0) {
			return -1;
		} else if (currNorm.compareTo(paramNorm) > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/*
	 * This method creates the string representations of the instance
	 * variables and then constructs a complex number in string format.
	 * It returns this String.
	 */
	public String toString() {
		MyDouble zero = new MyDouble(0);
		String realStr = real.toString();
		String imagStr = imag.toString();
		String returnStr = "";
		
		//depending on what sign is correct(- or +), the right case if executed
		if (real.compareTo(zero) < 0 && imag.compareTo(zero) < 0) {
			returnStr = realStr + imagStr + "i";
		} else if (real.compareTo(zero) >= 0 && imag.compareTo(zero) >= 0) {
			returnStr = realStr + "+" + imagStr + "i";
		} else if(real.compareTo(zero) >= 0 && imag.compareTo(zero) < 0) {
			returnStr = realStr + imagStr + "i";
		} else if (real.compareTo(zero) < 0 && imag.compareTo(zero) >= 0) {
			returnStr = realStr + "+" + imagStr + "i";
		}
		return returnStr;
	}
	
	/*
	 * This static method takes in a ComplexNumber object and then finds its
	 * norm. The norm formula: sqrt(a^2 +b^2). 
	 * a is the real variable and b is the imag variable.
	 * Returns a MyDouble with the norm value.
	 */
	public static MyDouble norm(ComplexNumber num) {
		MyDouble realNum = num.getReal();
		MyDouble imagNum = num.getImag();
		
		MyDouble realNumSquared = realNum.multiply(realNum);
		MyDouble imagNumSquared = imagNum.multiply(imagNum);
		
		MyDouble norm = (realNumSquared.add(imagNumSquared)).sqrt();
	    return norm;
		
	}
	
	/*
	 * Takes in a string representation of a complex number and then parses 
	 * that string to found the real and imaginary numbers. This numbers are 
	 * then turned into MyDouble variables which are used to instantiate a 
	 * new ComplexNumber object. This new object is finally returned.
	 */
	public static ComplexNumber parseComplexNumber(String complexNum) {
		
		//removes trailing and leading whitespace
		String trimStr = complexNum.trim();
		//removes all whitespace in the string
		String newStr = trimStr.replaceAll("\\s", "");

		int counter = 0;
		int counter2 = 0;
		int startSubstring1 = 0;
		int startSubstring2 = 0;
		char tempChar = 't'; //t stands for temp character
		
		//loops through the string until it finds the first variable(real)
		for (int i = 0; i < newStr.length(); i ++) {
			tempChar = newStr.charAt(i);
			if(tempChar == '+') { //terminates loop if "+" is found
				break;
			} else if (tempChar == '-') {
				//terminates loop for the second occurence of "-"
				if (i > 0) {
					break;
				}
				counter++; //is incremented to find the last index of the num
			} else {
				counter++;
			}
		}
		
		counter2 = counter; 
		startSubstring2 = counter2;
		//this loop starts off where the other one ended until it finds "i"
		for (int j = counter2; j < newStr.length(); j++) {
			tempChar = newStr.charAt(j);
			if (tempChar == 'i') {
				break;
			} else if (tempChar == '+') {
				startSubstring2++; //skips the "+" in substring if found
				counter2++;
			} else {
				counter2++;
			}
		}

		String parseString = newStr.substring(startSubstring1, counter);
		String parseString2 = newStr.substring(startSubstring2, counter2);
		
		double realVal = Double.parseDouble(parseString);
		double imagVal = Double.parseDouble(parseString2);
		MyDouble newReal = new MyDouble(realVal);
		MyDouble newImag = new MyDouble(imagVal);
		
		ComplexNumber stringParse = new ComplexNumber(newReal, newImag);
		return stringParse;
		
	}
}


