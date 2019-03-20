package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommandesTestHugo {

	@Test
	void testTerminal() {
		main.mainTP1.ecrireTerminal();
		assertTrue(main.mainTP1.terminalEcrit);
	}

}
