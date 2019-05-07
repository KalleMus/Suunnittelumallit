package model;

import supports.Sout;

public class CPU {

	public void freeze() {
		Sout.dotPrint("CPU frozen", 500);
	}
	public void jump(long position) {
		Sout.dotPrint("CPU jumping into boot address", 500);
		Sout.print("Address: " + position, 2000);
	}
	public void execute() {
		Sout.print("All systems up and running.", 60000);
	}

}
