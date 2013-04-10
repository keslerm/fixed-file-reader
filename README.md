Fixed File Reader
=================

I wrote this library when I needed to parse some fixed delimited flat files that contained no new line breaks, and instead relied on reading X characters for each line. I wanted to use one of the many available Java based flat file parsers (For example FlatWorm) to generate Java objects, but almost none of the ones I could find supported files in this manner. 

Instead of writing something to parse the files into the correct format, I extended the existing FileReader Java class to handle the task of putting line breaks every X characters automatically.

This is meant to be pushed into a BufferedReader to utilize getLine(), any other usage may not have the correct effect.

This is not a verbose and featureful library, it was written with one specific usage in mind and that's about it.
