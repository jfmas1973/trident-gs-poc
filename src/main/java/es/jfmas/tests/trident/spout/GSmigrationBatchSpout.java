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
 * 	Modification Date: 09-dic-2015 19:18:53
 * 	SVN Revision Number: $Revision$
 * 
 */
//@formatter:on
package es.jfmas.tests.trident.spout;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import storm.trident.operation.TridentCollector;
import storm.trident.spout.IBatchSpout;
import backtype.storm.Config;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import es.jfmas.tests.trident.model.FlightModel;
import es.jfmas.tests.trident.service.FlightService;
import es.jfmas.tests.trident.utils.ConfigApp;

@SuppressWarnings("all")
public class GSmigrationBatchSpout implements IBatchSpout {

	/** Serial id **/
	private static final long serialVersionUID = 2276677512209006194L;

	private int position = 0;
	private boolean stopped = false;

	@Override
	public void open(Map conf, TopologyContext context) {
		System.out.println("SPOUT OPEN");
		position = 0;
	}

	@Override
	public void emitBatch(long batchId, TridentCollector collector) {
		if (stopped) {
			System.exit(1);
		}
		System.out.println("SPOUT EMIT " + position);
		List<FlightModel> batch = FlightService.readFlights(position, ConfigApp.BATCH_SIZE);
		position = position + batch.size();
		if (batch.size() < ConfigApp.BATCH_SIZE) {
			stopped = true;
		}
		for (FlightModel model : batch) {
			collector.emit(Arrays.asList(new Object[] { model }));
		}
	}

	@Override
	public void ack(long batchId) {
		// Nothing to do
	}

	@Override
	public void close() {
		// Nothing to do
	}

	@Override
	public Map getComponentConfiguration() {
		return new Config();
	}

	@Override
	public Fields getOutputFields() {
		return new Fields("model");
	}

}
