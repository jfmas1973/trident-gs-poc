//@formatter:off
/**
 * 
 *       . * .
 *     * RRRR  *    Copyright (c) 2015 OHIM: Office for Harmonization
 *   .   RR  R   .  in the Internal Market (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 * 
 * 	Author: SetforIT
 * 	Modification Date: 09-dic-2015 18:14:07
 * 	SVN Revision Number: $Revision$
 * 
 */
//@formatter:on
package es.jfmas.tests.trident;

public class LaunchApp {

	public static void main(String[] args) {

		long initTime = System.currentTimeMillis();

		MigrateGSApp.convertToJson();

		long elapsedTime = (System.currentTimeMillis() - initTime) / 1000;
		System.out.println("Elapsed Time : " + elapsedTime + " sec");

	}

}
