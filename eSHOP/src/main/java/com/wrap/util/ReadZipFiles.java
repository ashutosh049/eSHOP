/**
 * 
 */
package com.wrap.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 11, 2016
 * @version $Revision$
 */
public class ReadZipFiles {

	public static void main(final String[] args) {
		final File folder = new File("D:\\PANDORA-1");
		final File[] listOfFiles = folder.listFiles();

		for (final File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				// System.out.println("File " + listOfFile.getName());
				// Read zip file
				try {

					final ZipFile zf = new ZipFile(listOfFile.getAbsolutePath());
					final Enumeration entries = zf.entries();

					while (entries.hasMoreElements()) {
						final ZipEntry ze = (ZipEntry) entries.nextElement();
						// WrapAuthenticationSuccessHandler
						if (ze.getName().contains("WRITEWELL")) {
							System.out.println("["
									+ listOfFile.getAbsolutePath()
									+ "] ---------->   " + ze.getName());
						}

						final long size = ze.getSize();
						if (size > 0) {
							System.out.println("Length is " + size);
							final BufferedReader br = new BufferedReader(
									new InputStreamReader(zf.getInputStream(ze)));
							final String line;
							/*
							 * while ((line = br.readLine()) != null) {
							 * System.out.println("\t\t--" + line); }
							 */
							br.close();
						}

					}
				} catch (final IOException e) {
					e.printStackTrace();
				}

			} else if (listOfFile.isDirectory()) {
				System.out.println("Directory " + listOfFile.getName());
			}
		}
	}

}
