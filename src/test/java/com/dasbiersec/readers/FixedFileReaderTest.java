package com.dasbiersec.readers;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;

public class FixedFileReaderTest
{
	@Test
	public void testFileReadSuccess() throws IOException
	{
		FixedFileReader fixedFileReader = new FixedFileReader("src/test/resources/Test_File_1.txt");

		fixedFileReader.setLineLength(5);


		BufferedReader reader = new BufferedReader(fixedFileReader);
		String line = reader.readLine();

		assertEquals("LINE1", line);
	}
}
