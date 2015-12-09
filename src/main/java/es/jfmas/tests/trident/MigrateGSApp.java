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
 * 	Modification Date: 09-dic-2015 19:13:24
 * 	SVN Revision Number: $Revision$
 * 
 */
//@formatter:on
package es.jfmas.tests.trident;

import storm.trident.TridentTopology;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.tuple.Fields;
import es.jfmas.tests.trident.spout.GSmigrationBatchSpout;
import es.jfmas.tests.trident.utils.TridentUtils;

public final class MigrateGSApp {

	public static void convertToJson() {

		GSmigrationBatchSpout spout = new GSmigrationBatchSpout();

		TridentTopology topology = new TridentTopology();
		topology.newStream("spout", spout).each(new Fields("model"), new TridentUtils.ToJsonFilter());
		StormTopology stormTop = topology.build();

		Config conf = new Config();

		// LocalDRPC drpc = new LocalDRPC();
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("hackaton", conf, stormTop);

	}

}
