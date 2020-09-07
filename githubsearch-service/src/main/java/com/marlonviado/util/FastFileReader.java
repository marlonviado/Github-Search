package com.marlonviado.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * User to read file
 * @author marlon_viado
 *
 */
public class FastFileReader extends FileReader {
	
	public FastFileReader(File file) throws FileNotFoundException {
		super(file);
	}

}
