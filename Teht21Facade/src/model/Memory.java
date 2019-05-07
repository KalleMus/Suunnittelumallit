package model;

import supports.Sout;

public class Memory {
	public void load(long position, byte[] data) {
		Sout.dotPrintSL("Reading data into memory",  500);
		Sout.print(data + "", 1000);
	}
}
