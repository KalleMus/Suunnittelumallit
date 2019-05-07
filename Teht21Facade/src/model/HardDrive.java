package model;

import supports.Sout;

import java.util.Random;

public class HardDrive {

	private byte[] data;

	public byte[] read(long lba, int size) {
		Sout.dotPrint("Reading data from hard drive. Sector " + lba, 500);
		data = new byte[size];
		Random r = new Random();
		r.nextBytes(data);
		return data;
	}
}
