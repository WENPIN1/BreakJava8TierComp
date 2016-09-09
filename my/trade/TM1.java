package my.trade;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import my.own.AskRecord;

/*
 * 
 * */
 

public class TM1 {

	final public static int BID_COUNT = 1000_000;	
	public static Logger logger = Logger.getLogger(TM1.class.toString());

	private AtomicLong bqn = new AtomicLong();
	
	private BEngine bideng  = BEngine.getInstance();
	
	final public static double[] AMOUNT_SEGMENT= 
	{
		3.8, 3.81, 3.82, 3.83, 3.84,3.85, 3.86, 3.87, 3.88, 3.89,
		3.9, 3.95, 
		4.0, 4.05, 4.1, 4.15, 4.2, 4.25, 4.3, 4.35, 4.4, 4.45,
		4.5, 4.55, 4.6, 4.65, 4.7, 4.75, 4.8, 4.85, 4.9, 4.95, 
		5.0, 5.05, 5.1
	};

	final public static int AMOUNT_SEG_SIZE = AMOUNT_SEGMENT.length;
	

	public  AskRecord genAR(int a, int b, double c, double d,
		double f, double g, double h, String i, String j, String k,
		String l, double m, double n, long o, int p) {

		return new AskRecord(bqn.getAndIncrement(), a, b, c, d, f, g, h, i, j,
			k, l, m, n, o, p);
	}
	
	
	private void case8() {
		final int len = BID_COUNT;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		Random random = new Random();

		long tm0 = 0;
		long tm1 = 0;



		AskRecord[] aArr = new AskRecord[len];
		int aIx = 0;

		for (long i = 0; i < BID_COUNT; i++) {
			// LOOP FOR 1000_000 TIMES

			int rc = 1;
			int hr = 1;
			double w, p;
			w = 1 + random.nextInt(5);
			p = w;
			double am = AMOUNT_SEGMENT[random.nextInt(AMOUNT_SEG_SIZE)];
			double lw = 10 + random.nextInt(30) * 10;
			double lp = Math.max(5, random.nextInt(10) * 10);
			lp = Math.min(lw, lp);
			String ua = "abcd" + String.valueOf(i % 100);
			String cr = "GSP";
			String rt = "HH";
			String rd = "2016-09-09";
			double sw = 0;
			double sp = 0;
			long da = System.currentTimeMillis();

			aArr[aIx++] = genAR(rc, hr, w, p, am, lw,
				lp, ua, cr, rt, rd, sw, sp, da, 0);
		}

		int aIx1 = 0;

		for (long i = 0; i < BID_COUNT; i++) {
			try  {
					AskRecord askrec = aArr[aIx1++];
					// TODO
					double w0 = askrec.getW();
					double a0 = askrec.getA();
					double p0 = askrec.getP();
					double lw = askrec.getLW();
					double lp = askrec.getLP();

					tm0 = System.nanoTime();
					final double tktLeft = bideng.trade(a0, lw, lp, w0);
					if (tktLeft > 0D) { // CALL OBJECT SETTER WHEN GREATER THAN
						assert (tktLeft > 0) : "(tktLeft >0) ? " + tktLeft;
						double w = tktLeft;
						double p = tktLeft;
						askrec.setW(w);
						askrec.setP(p);
						askrec.setD(System.currentTimeMillis());
						askrec.setD(System.currentTimeMillis());
					}
					tm1 = System.nanoTime() - tm0;

			}
			finally {
//				System.out.println(i);
			}

			if (tm1 != 0) {
				min = Math.min(tm1, min);
				max = Math.max(tm1, max);
			}

		}
		String minfo = String.format("Max: %,d ; Min: %,d", max, min);
		print(minfo);

	}

	public void mainTest() {

		try{
			long t0 = System.nanoTime();
			case8();
			long t1 = System.nanoTime() - t0;
			print("end: taken : " + t1 / BID_COUNT + " ms.");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, e.toString(), e);
		}

	}

	private static void print(String msg) {
		logger.info(msg);
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		TM1 tm = new TM1();
		tm.mainTest();
	}


}
