import java.io.*;
import java.util.Scanner;

public class read
{	
	private final File fFile;
	public read( String fn )
	{
		fFile = new File( fn );	
	}

	public void processLines() throws FileNotFoundException
	{
		Scanner sc = new Scanner(fFile);
		try
		{
			// use scanner to read in each line
			// pass data into function to parse
			while( sc.hasNextLine() )
				parseLine( sc.nextLine() );
		}
		finally 
		{
			//verify the stream is closed to please jre
			sc.close();
		}
	}

	protected void parseLine( String l )
	{
		Scanner sc = new Scanner( l );
		sc.useDelimiter("=");
		if( sc.hasNext() )
		{
			String name = sc.next();
			String value = sc.next();
			log( "Name is : " + quote( name.trim() ) + " , and value is : " + quote( value.trim() ));
		} else {
			//something went wrong
		}

		sc.close();
	}

	private static void log( Object o )
	{
		System.out.println( String.valueOf( o ) );
	}

	private String quote( String t )
	{
		String q = "'";
		return q + t + q;
	}
}
