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
 * 	Modification Date: 09-dic-2015 17:58:22
 * 	SVN Revision Number: $Revision$
 * 
 */
//@formatter:on
package es.jfmas.tests.trident.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.jfmas.tests.trident.model.FlightModel;

public final class MappingUtils {

	private static final ObjectMapper jsonMapper = new ObjectMapper();

	public static String modelToJson(FlightModel model) {
		try {
			return jsonMapper.writeValueAsString(model);
		} catch (Exception e) {
			System.err.println("ERROR CONVERTING TO JSON " + e.getMessage());
		}
		return "";
	}

	public static FlightModel lineToModel(String line) {
		FlightModel model = new FlightModel();
		String[] tokens = line.split(",");
		int step = 0;
		model.Year = tokens[step];
		model.Month = tokens[step++];
		model.DayofMonth = tokens[step++];
		model.DayOfWeek = tokens[step++];
		model.DepTime = tokens[step++];
		model.CRSDepTime = tokens[step++];
		model.ArrTime = tokens[step++];
		model.CRSArrTime = tokens[step++];
		model.UniqueCarrier = tokens[step++];
		model.FlightNum = tokens[step++];
		model.TailNum = tokens[step++];
		model.ActualElapsedTime = tokens[step++];
		model.CRSElapsedTime = tokens[step++];
		model.AirTime = tokens[step++];
		model.ArrDelay = tokens[step++];
		model.DepDelay = tokens[step++];
		model.Origin = tokens[step++];
		model.Dest = tokens[step++];
		model.Distance = tokens[step++];
		model.TaxiIn = tokens[step++];
		model.TaxiOut = tokens[step++];
		model.Cancelled = tokens[step++];
		model.CancellationCode = tokens[step++];
		model.Diverted = tokens[step++];
		model.CarrierDelay = tokens[step++];
		model.WeatherDelay = tokens[step++];
		model.NASDelay = tokens[step++];
		model.SecurityDelay = tokens[step++];
		model.LateAircraftDelay = tokens[step++];

		return model;
	}

}
