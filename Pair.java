// Alan Oleksa
// COSC 460, Program #1 - Word Freqency
//  Pair.java
//   The Pair class is used to pair words with their freqency   
 
import java.util.*;
public class Pair implements Comparable<Pair>
{
	private Object a, b;

	// constructer, take in to objects
	// and set their values
	public Pair( Object a, Object b )
	{
		this.a = a;
		this.b = b;

	}

	// return first object
	public Object getFirst() 
	{
		return a;
	}

	//return second object
	public Object getSecond()
	{
		return b;
	}
	
	// change first object by passing
	//  an object as an argument
	public void setFirst( Object x )
	{
		a = x;
	}

	// change second object by passing 
	// and object as an argument
	public void setSecond( Object x )
	{
		b = x;
	}
	
	// public overide for the equals method
	//  take argument c( second pair ) and
	//  and see if both pairs first object
	// are equal
	public final boolean equals( Object c )
	{
		// verify the object c being passed in
		//  is of the Pair class
		if( !(c instanceof Pair))
			return false;

		// cast c to Pair
		final Pair second = (Pair)c;
		return equal( second.a, this.a ); 
	}

	// Internal method for checking equality
	private static final boolean equal( Object f, Object s )
	{
		// ternary operator if the first pair is null then
		//  return the second pair set to null, otherwise
		//  check if f equals s
		return f == null ? s == null : f.equals( s );
	}

	// overide implementation of compareto
	//  returns 0 if to pairs ( second part ) are equal
	//  returns < 0 if this object is less than the argument
	//  returns > 0  if this object is greater than the argument
	public int compareTo( Pair c )
	{
		// just subtract this object from the arugment
		return c.intgetSecond() - this.intgetSecond();
	}

	// overide toString method so, that pairs can be returned as a string
	public String toString()
	{
		return a + " " + b;
	}

	// method that automatically casts the seconds 
	//  object in the pair to an Integer
	public int intgetSecond( )
	{
		return ((Integer)b).intValue();
	}
}
