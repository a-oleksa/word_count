// Alan Oleksa
// COSC 460, Program #1 - Word Freqency
//  word.java
// This class receives the words passed in from Reader 
// and calculates the freqency of the word.  This class uses
// a TreeMap to store the words and then passes values onto
// and List which, sorts the data based on freqency ( using 
// java's sort api, merge sort )

import java.util.*;

public class word
{
	private int wordfreq; // Integer to count all words in document
	private TreeMap<String,Pair> words; //Red-Black tree used to store words + pairs
	private List<Pair> wordList; 

	// Constructor, initialize values and create instances of objects
	public word()
	{
		wordfreq = 0;
		words = new TreeMap<String,Pair>();
		wordList = new ArrayList<Pair>();
	}

	// update the word database by passing a word through
	//  as an argument then, if the word exists increment a 
	//  counter, otherwise add the word to the tree
	public void update( String w )
	{
		// retrieve the value ( pair ) at which this key( String) points to
		Pair p = (Pair)words.get( w );
		wordfreq++;

		// Determine if p is pointing to a pair object,
		if( p == null )
		{
			// If p does not point to an object than the key (word)
			//  is not in the tree so, we add it to the tree
			//  using the word as the key and the pair as the value
			words.put( w, new Pair( w, 1 ));
		}
		else
		{
			// If p points to a Pair than update that pair
			update( p );
		}
	}

	// Internal method to update the pair's counter, pass the Pair which
	//  the tree pointed to as the argument
	private void update( Pair p )
	{
			// Increment second object in pair ( the counter )
			int c = p.intgetSecond();
			c++;
			p.setSecond( c );
	}

	// This is where all the 'magic' is done
	//  first populate the list with the values from the tree
	//  then use Collection ( since it is ArrayList implements it )
	//  to sort the pairs, based on their second (counter variable )
	//  finally, convert the list into an array of Pairs and return it
	public Pair[] pairs()
	{
		wordList.addAll( words.values() );
		// Use collection's sort method a merge sort
		// which is guaranteed O( n log n ), to sort through
		// pair ( second object ), also the tree kept the data
		// in alphabetical order so if any frequencies match
		// the lexographical one will be first
		Collections.sort( wordList );
		return (Pair[])wordList.toArray( new Pair[0] );
	}

	// returns the total number of words in the document	
	public int totalcount()
	{
		return wordfreq;
	}
}
