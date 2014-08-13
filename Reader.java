// Alan Oleksa
// COSC 460, Program #1 - Word Freqency
//  Reader.java
// The Reader class is used to open a file stream
// and read in data to be processed.  This class
// also passes the words onto the counting class which
// calculates freqencies

import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;

public class Reader
{
	private final File fFile; //Object for storing document location
	private word data; // word object which gets freqencies of words

	// Constructor, which argument for the filename to be loaded
	//  also constructs the word object and begins processing the 
	//  document
	public Reader( String fn ) throws FileNotFoundException
	{
		fFile = new File( fn );
		data = new word();
		processLine( );
	}

	// Internal method to process each line of the document
	private void processLine( ) throws FileNotFoundException
	{
		Scanner sc = new Scanner( fFile );
		try
		{
			// process text by line and pass data onto
			// seperate function to parse words
			while( sc.hasNextLine() ) 
				parseLine( sc.nextLine() );	
		}
		finally
		{
			sc.close();
		}
	}

	// Internal method which parses each line from the process line method
	//  this method  will send each word onto the word object so, its
	//  frequency can be determined
	private void parseLine( String l )
	{
		// neat little object which will break up a string into words,
		// using delimiters given by user.
		StringTokenizer	st = new StringTokenizer( l.toLowerCase(), " ,:.\"-'?;!\n\r\t[]()$&/" );

		// loop through tokens ( words ) and pass them onto the word
		//  object in order to update word frequencies
		while( st.hasMoreTokens() )
		{
			String temp = st.nextToken();
			if( temp.length() > 5 )
				data.update( temp );
		}

	}

	// return the sorted Pairs from the word object
	public Pair[] content()
	{
		return data.pairs();
	}

	// return the total number of words from the word object
	public int numwords()
	{
		return data.totalcount(); 
	}
}
