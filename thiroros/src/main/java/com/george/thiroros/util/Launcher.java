package com.george.thiroros.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.george.thiroros")
@SpringBootApplication
public class Launcher {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Launcher.class, args);
	}

	private static final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static String byteArray2Hex(byte[] bytes) {
		StringBuffer sb = new StringBuffer(bytes.length * 2);
		for (final byte b : bytes) {
			sb.append(hex[(b & 0xF0) >> 4]);
			sb.append(hex[b & 0x0F]);
		}
		return sb.toString();
	}

	public static Long byteArray2Integer(byte[] bytes) {
		long result = 0;
		for (int i = 0; i < 3; i++) {
			result += ((bytes[i] & 0xFF) << (i * 8));
		}
		result += ((bytes[3] & 0x7F) << (3 * 8));
		return result;
	}

}
