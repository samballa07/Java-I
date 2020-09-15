import java.awt.Color;

/*
 * Methods which allow for the drawing of Mendelbrot sets.
 */
public class MandelbrotTools {
	
	/* 
	 * This method performs a computation similar to norm. It is: a^2 + b^2, 
	 * where a is the real number and be is imag. This number is them compared 
	 * to the static variable Controller.DIVERGENCE_BOUNDARY.
	 * If the computed variable is bigger, then it returns true, else false
	 */
	public static boolean isBig(ComplexNumber num) {
		//these three lines of code performs a^2 + b^2
		MyDouble realSquare = num.getReal().multiply(num.getReal());
		MyDouble imagSquare = num.getImag().multiply(num.getImag());
		MyDouble sum = realSquare.add(imagSquare);
		
		if (sum.compareTo(Controller.DIVERGENCE_BOUNDARY) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * This method takes in a ComplexNumber which represents Z of the zero 
	 * index. It then calculates a sequence of numbers starting with that 
	 * initial Z until either the limit is bet or if the isBig() method returns
	 * true.The return index is an integer which represents which index the 
	 * loops stops at.
	 */
	public static int divergence(ComplexNumber zeroIndex) {
		int count = 0;
		int index = -1; //returns -1 if isBig(0 never returns true
		ComplexNumber tempIndex = zeroIndex;
		do {
			ComplexNumber currentIndex = tempIndex;
			ComplexNumber squared = currentIndex.multiply(currentIndex);
			tempIndex = squared.add(zeroIndex);
			count++;
			if (isBig(tempIndex) == true) {
				index = count;
				break; //will terminate once a certain index is bigger
			}
		} while(count < Controller.LIMIT);
		return index;
	}
	
	
	/* This method selects a non-black color for a point which DIVERGED when 
	 * tested with the Mandelbrot recurrence, based on how many terms in the 
	 * sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was 
	 * first to be "too big".  This value could be anything from 0 to 
	 * Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if 
	 * clause below which says "modify this block to create your own color 
	 * scheme".  When someone runs the program and selects "Student Color 
	 * Scheme", the code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;
		
		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}
		
		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}
		
		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			
			
			/***************************************************************
			 * Modify this block to create your own color scheme!          *
			 ***************************************************************/
			returnValue = Color.WHITE;  // take out and return something useful 
			
			
		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}
	
}
