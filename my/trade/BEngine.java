/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package my.trade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import my.own.BidRecord;


public class BEngine {

	private static Logger logger = Logger.getLogger(BEngine.class.toString());
	
	
	private BEngine() {
		init();
	}
	
	public static BEngine getInstance() {
		return new BEngine();
	}


	public Map<Long, BidRecord> getCache() {
		return null;
	}

	public void init()  {
	
	}

	
	public List<Entry<Long, BidRecord>> matchObjectQuery( double a, double b, double c,
		int d) {

		return new ArrayList<Entry<Long, BidRecord>>();

	}




	public double trade(double a, double b, double c, final double d) {
	
		long t0 = System.nanoTime();
	
		List<Entry<Long, BidRecord>> rl = matchObjectQuery(a, b, c, (int) d);
	
		long t1 = System.nanoTime();
	
		double ta = d;

		if (rl.size() > 0) {
	
		}
	
		return ta;
	
	}
}
