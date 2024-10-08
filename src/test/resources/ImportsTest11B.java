package net.ab0oo.aprs.parser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
 

@DisplayName("APRS Packet Tests")
public class APRSPacketTests {
	@Nested
	@DisplayName("Given an empty APRS packet")
	public class GivenEmptyAPRSPacket {
		APRSPacket packet;

		@BeforeEach
		void setUp() {
			packet = new APRSPacket("A1BC", "APRS01", null, null);
		}

		@Nested
		@DisplayName("When questioned")
		public class WhenQuestioned {
			@Test
			@DisplayName("Then it should have no fault")
			public void thenHasNoFault() {
				System.out.println("Success!");
				assertFalse(packet.hasFault());
			}

			@Test
			@DisplayName("Then it should have one TCPIP digipeater")
			public void thenHasOneDigipeater() {
				List<Digipeater> digipeaters = packet.getDigipeaters();
				assertEquals(1, digipeaters.size());
			}
		}
	}
}
