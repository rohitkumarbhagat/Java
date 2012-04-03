/**
 * 
 */
package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author erotkur
 * 
 */
public class Ssh_Client
{
	private static ArrayList<String> serverList = new ArrayList<String>();

	public static void main(String[] args) throws IOException
	{
		// Update list
		serverList.add("vivr@10.44.173.39");

		// Main Menu

		for (int i = 0; i < serverList.size(); i++)
		{
			System.out.println("Press " + i + "  for : " + serverList.get(i));
		}

		System.out.println("Press # to exit. ");
		Scanner scanIn = new Scanner(System.in);
		String inputItem = scanIn.nextLine();
		// BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		// String inputItem = console.readLine();
		inputItem = inputItem.trim();

		if (!inputItem.equals("#"))
		{
			int index = Integer.parseInt(inputItem);
			if (index > 0 && index < serverList.size())
			{
				// launch the server

				Runtime runtime = Runtime.getRuntime();
				try
				{
					Process pr = runtime.exec("ssh " + serverList.get(index));
					BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

					/**
					 * Loop through the input stream to print the program output into console.
					 */
					String line;
					while ((line = input.readLine()) != null)
					{
						System.out.println(line);
					}
					/**
					 * Finally close the reader
					 */
					input.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				// try
				// {
				// pr.waitFor();
				// }
				// catch (InterruptedException e)
				// {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

			}
		}

	}
}
