package com.dasbiersec.readers;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class FixedFileStreamReaderTest
{
	@Test
	public void testFileReadSuccess() throws IOException
	{
		FixedFileStreamReader fixedFileReader = new FixedFileStreamReader("src/test/resources/Test_File_1.txt");

		fixedFileReader.setLineLength(5);


		BufferedReader reader = new BufferedReader(fixedFileReader);
		String line = reader.readLine();

		assertEquals("LINE1", line);
	}
}
