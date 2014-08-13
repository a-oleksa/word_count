// Alan Oleksa
// COSC 460, Program #1 - Word Freqency
//  wordc.java
// This is the main program which constructs the Reader and prints
// the output

import java.io.*;
import java.util.Scanner;
import java.math.*;
import java.text.DecimalFormat;

public class wordc
{
	public static void main( String[] args ) throws FileNotFoundException
	{
		
		// Optional, use scanner so that document to be analyzed
		//  can be entered by user
		Scanner sc = new Scanner( System.in );
		String x = sc.next();
		
		// Construct a new instance of Reader object, and
		//  pass the document we want to analyze as the 
		//  argument
		Reader read = new Reader( x ); 
	
		// Construct an array of pairs and fill it with the
		//  sorted pair from read object
		Pair p[] = read.content();

		DecimalFormat df = new DecimalFormat("##.##");		

		// Loop through the top 50 index's of Pair array
		//  which correspond to top 50 used words
		for( int i = 0; i < 50; i++ )
		{
			float percent = ((float)p[i].intgetSecond() / (float)read.numwords()) * (float)100.0;
			System.out.println( i+1 + " Word: " + p[i].getFirst() + " number " + p[i].getSecond() + " percent: " + df.format( percent  ) + "%" );
		}


	}


	public static int convInt( Pair p )
	{
		return ((Integer)p.getSecond()).intValue();
	}

	public static String convS( Pair p )
	{
		return String.valueOf( p.getFirst() );
	}

	}
