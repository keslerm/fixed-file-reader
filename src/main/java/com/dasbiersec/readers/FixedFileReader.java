package com.dasbiersec.readers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Extend version of the FileReader class that supports adding line breaks after reading a specific number of characters
 * for reading fixed length files without any line breaks into common File Parsing libraries like Flatworm.
 *
 * <p>This version is meant to be fed into a BufferedReader and using it otherwise may not work as expected.</p>
 *
 * @author Morgan Kesler
 * @version 1.0
 *
 */
public class FixedFileReader extends FileReader
{
	private int count = 1;
	private int lineLength = 0;

	public FixedFileReader(String s) throws FileNotFoundException
	{
		super(s);
	}

	public int getLineLength()
	{
		return lineLength;
	}

	public void setLineLength(int lineLength)
	{
		this.lineLength = lineLength;
	}

	/**
	 * Reads characters from file into buffer, and after the total lineLength has been read
	 * add a line break.
	 *
	 * @param chars Buffer to read characters into
	 * @param i Offset to start reading from
	 * @param i2 Total characters to read
	 * @return Total characters read
	 * @throws java.io.IOException
	 */
	@Override
	public int read(char[] chars, int i, int i2) throws IOException
	{
		if (lineLength == 0)
			throw new IOException("Line length is not set to a valid amount. Line length MUST be set before processing.");

		// Stores the total characters read into buffer
		int r;

		// Obey and offset if there is one supplied
		if (i > 0)
			skip(i);

		// Begin reading character by character into buffer
		for (r = 0; r < i2; r++)
		{
			// If we have read all the characters of a line into the buffer, append a line break
			if ((count % (lineLength + 1)) == 0)
			{
				chars[r] = '\n';
				count = 1;
				continue;
			}

			// Read next character
			char char1 = (char) read();

			// If the next character was an EOF, then we want to stop reading
			if ((int) char1 == 65535)
			{
				// if the EOF character was the first character read, return -1 to match
				// existing read logic, or return total number of characters read
				if (r == 0)
					return -1;
				else
					return r;
			}

			// Assign character to buffer
			chars[r] = char1;

			// Increment read character count for lineLength logic
			count++;
		}

		return r;

	}
}
