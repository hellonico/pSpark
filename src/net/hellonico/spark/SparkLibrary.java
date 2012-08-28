/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package net.hellonico.spark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import processing.core.PApplet;

/**
 * This is a template class and can be used to start a new processing library or
 * tool. Make sure you rename this class as well as the name of the example
 * package 'template' to your own library or tool naming convention.
 * 
 * @example Hello
 * 
 *          (the tag @example followed by the name of an example included in
 *          folder 'examples' will automatically include the example in the
 *          javadoc.)
 * 
 */

public class SparkLibrary {

	// myParent is a reference to the parent sketch
	PApplet myParent;

	int myVariable = 0;

	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public SparkLibrary(PApplet theParent) {
		myParent = theParent;
		welcome();

	}

	public String getHostAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		SparkLibrary sl = new SparkLibrary(null);
		System.out.println(sl.getPublicAddress());
	}

	/**
	 * Contact an external service to get the IP address
	 */
	public String getPublicAddress() {
		try {
			Socket sock = new Socket("checkip.dyndns.com", 80);
			BufferedReader is = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
			PrintWriter os = new PrintWriter(sock.getOutputStream(), true);
			os.println("GET / HTTP/1.0");
			os.println(); 
			
			String guess = "IP Address: "; 
			String line = "";
			while (line.indexOf(guess) == -1) {
				line = is.readLine();
			}

			String ipAddr = line.substring(line.indexOf(guess) + guess.length(),
					line.indexOf("</body>"));
			return ipAddr;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void welcome() {
		System.out
				.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	public String sayHello() {
		return "hello library.";
	}

	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/**
	 * 
	 * @param theA
	 *            the width of test
	 * @param theB
	 *            the height of test
	 */
	public void setVariable(int theA, int theB) {
		myVariable = theA + theB;
	}

	/**
	 * 
	 * @return int
	 */
	public int getVariable() {
		return myVariable;
	}
}
