package com.obs.dto;
import java.util.*;

public class DefaultPassword {
	
	
		public char[] set_Password()
		{
			
			System.out.print("Your new password is : ");

			String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String Small_chars = "abcdefghijklmnopqrstuvwxyz";
			String numbers = "0123456789";
					String symbols = "!@#$^&*_.)";


			String values = Capital_chars + Small_chars +
							numbers + symbols;

			// Using random method
			Random rndm_method = new Random();

			char[] password = new char[8];

			for (int i = 0; i < 8; i++)
			{
				password[i] =
				values.charAt(rndm_method.nextInt(values.length()));

			}
	
			return password;
			
			
		}
	}