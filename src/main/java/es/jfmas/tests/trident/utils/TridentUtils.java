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
 * 	Modification Date: 09-dic-2015 19:32:53
 * 	SVN Revision Number: $Revision$
 * 
 */
//@formatter:on
package es.jfmas.tests.trident.utils;

import java.util.Map;

import storm.trident.operation.Filter;
import storm.trident.operation.TridentOperationContext;
import storm.trident.tuple.TridentTuple;
import es.jfmas.tests.trident.model.FlightModel;
import es.jfmas.tests.trident.service.FlightService;

public final class TridentUtils {

	public static class PrintFilter implements Filter {

		private static final long serialVersionUID = -5548105211286862165L;

		@Override
		public void prepare(Map conf, TridentOperationContext context) {}

		@Override
		public void cleanup() {}

		@Override
		public boolean isKeep(TridentTuple tuple) {
			System.out.println(tuple);
			return true;
		}
	}

	public static class ToJsonFilter implements Filter {

		private static final long serialVersionUID = -5548105211286862165L;

		@Override
		public void prepare(Map conf, TridentOperationContext context) {}

		@Override
		public void cleanup() {}

		@Override
		public boolean isKeep(TridentTuple tuple) {
			FlightModel model = (FlightModel) tuple.get(0);
			int result = FlightService.saveAsJson(model);
			return (result == 1);
		}
	}

}
