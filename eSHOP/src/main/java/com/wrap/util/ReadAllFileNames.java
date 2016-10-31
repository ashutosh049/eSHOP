/**
 * 
 */
package com.wrap.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import com.wrap.imodal.WrapProductColor;
import com.wrap.imodal.WrapProductSize;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 16, 2016
 * @version $Revision$
 */
public class ReadAllFileNames {

	private static String wrapTabId;
	private static String wrapColId;
	private static String wrapCatId;
	private static String wrapProdId;

	private static String uptoTab;
	private static String uptoCol;
	private static String uptoCat;
	/* private static String uptoProd; */

	static int tabCount = 0;
	static int colCount = 0;
	static int catCount = 0;
	static int prodCount = 0;

	public static void main(final String[] args) {
		final File folder = new File(
				"E:\\MYPROJECTS\\docs\\wrapit-tab-structure");
		final File[] listOfFiles = folder.listFiles();
		final String dir_sign = "|--";
		final String scanLvl = "TAB";
		iterateFolder(listOfFiles, dir_sign, scanLvl);
	}

	static Random random = new Random();

	static double getwrapProdMarkedPrice(int argProdCount) {
		double markedPrice = random.nextDouble();
		markedPrice = markedPrice * argProdCount * 1000;
		markedPrice = round(markedPrice, 2);
		return markedPrice;
	}

	static double getwrapProdDiscountPercent(int argProdCount) {
		double discountPercent = random.nextDouble();
		discountPercent = discountPercent * argProdCount * 10;
		discountPercent = round(discountPercent, 2);
		return discountPercent;
	}

	static double getwrapProdTaxPercent(int argProdCount) {
		double taxPercent = random.nextDouble();
		taxPercent = taxPercent * argProdCount;
		taxPercent = round(taxPercent, 2);
		return taxPercent;
	}

	static double getwrapProdShippingChargePercent(int argProdCount) {
		double shipChargePercent = random.nextDouble();
		shipChargePercent = shipChargePercent * argProdCount;
		shipChargePercent = round(shipChargePercent, 2);
		return shipChargePercent;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/*
	 * public static double round(double value, int places) { if (places < 0)
	 * throw new IllegalArgumentException();
	 * 
	 * long factor = (long) Math.pow(10, places); value = value * factor; long
	 * tmp = Math.round(value); return (double) tmp / factor; }
	 */

	static void iterateFolder(File[] listOfFiles, String dir_sign,
			String argScanLvl) {

		for (final File listOfFile : listOfFiles) {

			if (listOfFile.isFile()) {
				// System.out.println(dir_sign + "\t" + listOfFile.getName());
				if (argScanLvl.equals("PROD")) {
					++prodCount;
					wrapProdId = "WRAPROD_" + prodCount;

					String wrapProdName = listOfFile.getName();
					wrapProdName = wrapProdName.replaceAll("-", " ");
					wrapProdName = wrapProdName.substring(0, 12);

					String wrapProdDescription = listOfFile.getName();
					wrapProdDescription = wrapProdDescription.replaceAll("-",
							" ");
					wrapProdDescription = wrapProdDescription.replaceAll(
							".jpeg", "");

					int wrapProdInStockItemsCount = new Random().nextInt(200);
					int wrapProdIsInStock = 1;
					double wrapProdMarkedPrice = getwrapProdMarkedPrice(prodCount);
					double wrapProdDiscountPercent = getwrapProdDiscountPercent(prodCount);
					double wrapProdTaxPercent = getwrapProdTaxPercent(prodCount);
					double wrapProdShippingChargePercent = getwrapProdShippingChargePercent(prodCount);
					String wrapProdSize = WrapProductSize.values()[new Random()
					.nextInt(5)].toString();
					String wrapProdColor = WrapProductColor.values()[new Random()
					.nextInt(3)].toString();

					String wrapProdImagePath = uptoCat + "/"
							+ listOfFile.getName();

					int wrapProdSortOrder = prodCount * 10;

					String prodInsertQuery = "INSERT INTO wrap_product(wrapTabId, wrapColId, wrapCatId, "
							+ "wrapProdId, wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, wrapProdIsInStock, "
							+ "wrapProdMarkedPrice, wrapProdDiscountPercent, wrapProdTaxPercent, wrapProdShippingChargePercent, "
							+ "wrapProdSize, wrapProdColor, wrapProdImagePath,wrapProdSortOrder) VALUES("
							+ "'"
							+ wrapTabId
							+ "',"
							+ "'"
							+ wrapColId
							+ "',"
							+ "'"
							+ wrapCatId
							+ "',"
							+ "'"
							+ wrapProdId
							+ "',"
							+ "'"
							+ wrapProdName
							+ "',"
							+ "'"
							+ wrapProdDescription
							+ "',"
							+ wrapProdInStockItemsCount
							+ ","
							+ wrapProdIsInStock
							+ ","
							+ wrapProdMarkedPrice
							+ ","
							+ wrapProdDiscountPercent
							+ ","
							+ wrapProdTaxPercent
							+ ","
							+ wrapProdShippingChargePercent
							+ ","
							+ "'"
							+ wrapProdSize
							+ "',"
							+ "'"
							+ wrapProdColor
							+ "',"
							+ "'"
							+ wrapProdImagePath
							+ "',"
							+ wrapProdSortOrder + ");";

					System.out.println(prodInsertQuery);
				}
			} else if (listOfFile.isDirectory()) {

				if (argScanLvl.equals("TAB")) {
					++tabCount;
					argScanLvl = "COL";
					wrapTabId = "WRAPTAB_" + tabCount;
					String wrapTabName = listOfFile.getName();
					int wrapTabSortOrder = tabCount * 10;
					final String tabInsertQuery = "INSERT INTO wrap_tab(wrapTabId,wrapTabName,wrapTabSortOrder)"
							+ "VALUES("
							+ "'"
							+ wrapTabId
							+ "',"
							+ "'"
							+ wrapTabName + "'," + wrapTabSortOrder + ");";
					uptoTab = "resources/images/wrapit-tab-structure" + "/"
							+ listOfFile.getName();
				} else if (argScanLvl.equals("COL")) {
					++colCount;
					argScanLvl = "CAT";

					wrapColId = "WRAPCOL_" + colCount;
					String wrapColName = listOfFile.getName();
					int wrapColSortOrder = colCount * 10;

					String colInsertQuery = "INSERT INTO wrap_column(wrapTabId,wrapColId,wrapColName,wrapColSortOrder)"
							+ "VALUES('"
							+ wrapTabId
							+ "','"
							+ wrapColId
							+ "','"
							+ wrapColName
							+ "',"
							+ wrapColSortOrder
							+ ");";

					uptoCol = uptoTab + "/" + listOfFile.getName();
				} else if (argScanLvl.equals("CAT")) {
					++catCount;
					argScanLvl = "PROD";

					wrapCatId = "WRAPCAT_" + catCount;
					String wrapCatName = listOfFile.getName();
					int wrapCatSortOrder = catCount * 10;

					String catInsertQuery = "INSERT INTO wrap_category(wrapTabId, wrapColId, wrapCatId, wrapCatName,"
							+ " wrapCatSizeList, wrapCatColorList, wrapCatSortOrder)"
							+ "VALUES('"
							+ wrapTabId
							+ "',"
							+ "'"
							+ wrapColId
							+ "',"
							+ "'"
							+ wrapCatId
							+ "',"
							+ "'"
							+ wrapCatName
							+ "'"
							+ ",null,"
							+ "null,"
							+ wrapCatSortOrder
							+ ");";

					uptoCat = uptoCol + "/" + listOfFile.getName();
				}

				final File folder_ = new File(listOfFile.getAbsolutePath());
				final File[] listOfFiles_ = folder_.listFiles();
				iterateFolder(listOfFiles_, dir_sign + "\t", argScanLvl);
				// System.out.println("\n");
				if (argScanLvl.equals("PROD")) {
					// System.out.println("PROD---"+uptoProd);
					prodCount = 0;
					argScanLvl = "CAT";
				} else if (argScanLvl.equals("CAT")) {
					// System.out.println("CAT---"+uptoCat);
					catCount = 0;
					argScanLvl = "COL";
				} else if (argScanLvl.equals("COL")) {
					// System.out.println("COL---"+uptoCol);
					colCount = 0;
					argScanLvl = "TAB";
				}

			}

		}
	}

}
