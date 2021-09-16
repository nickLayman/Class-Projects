package week4;
//********************************************************************
//  Dictionary.java       Author: Lewis/Loftus
//
//  Represents a dictionary, which is a book. Used to demonstrate
//  inheritance.
//********************************************************************

public class Dictionary extends Book
{
	private int definitions = 52500;
	protected int pages;
	
	public Dictionary (int def) {
		super();
		definitions = def;
		pages = 12;
		super.pages = 12;
		setPages(12);
	}
	
	public Dictionary () {
		super();
//		definitions = 0;
//		setPages(10);
//		pages = 10;
//		super.pages = 14444;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	//}
	//-----------------------------------------------------------------
	//  Prints a message using both local and inherited values.
	//-----------------------------------------------------------------
	public double computeRatio ()
	{
		return definitions/getPages();
	}

	//----------------------------------------------------------------
	//  Definitions mutator.
	//----------------------------------------------------------------
	public void setDefinitions (int numDefinitions)
	{
		definitions = numDefinitions;
	}

	//----------------------------------------------------------------
	//  Definitions accessor.
	//----------------------------------------------------------------
	public int getDefinitions ()
	{
		return definitions;
	}
}
