package my.own;


public class AskRecord { //implements java.io.Serializable {

//private static final long serialVersionUID = 2429769253245743208L;

	private Long b;
	private Double w;
	private double p;
	private Double amt;
	private Double lw;
	private Double lp;
	private Long dateA;

	/*
	private Integer r;
	private Integer h;
	public Long lvl;
	private Integer lv;

	private String u;
	private String cr;
	private String rt;
	private String rd;
	private String rto;
	private String rrt;
	private Double sw;
	private Double sp;
	private Integer pt;
	private String ort;
	private Integer lct;
	private String ip;
	private String pts;
	private String ptx;

	private Double tm_5;
	private Double tm_10;
	private Double tm_15;
	private Double tm_20;
	private Double tm_25;
	private Double tm_30;
	private Double tm_60;
	private Double tm_9999;
	*/

	public AskRecord(Long bid, int a, int b, double c, double d, double e, double f,
		double g, String h, String i, String j, String k, double l,
		double m, Long n, int o) {
		super();
		this.b = bid;
		this.w = c;
		this.p = d;

		this.amt = e;
		this.lw = f;
		this.lp = g;
		
	}

	public Long getB() {
		return b;
	}

	public double getW() {
		return w;
	}

	public void setW(Double w) {
		this.w = w;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		if (p <= 0){
			System.out.println("p <=0 ");
		}
		assert p > 0 : "p : " + p + " > 0 (?) ";
		this.p = p;
	}

	public double getA() {
		return amt;
	}

	public double getLW() {
		return lw;
	}

	public double getLP() {
		return lp;
	}

	public Long getD() {
		return dateA;
	}

	public void setD(Long dateA) {
		this.dateA = dateA;
	}

	public String toString() {
		return String.format("AskRecord [b=%s, w=%s, p=%s, amt=%s, lw=%s, lp=%s, dateA=%s]", b, w, p, amt,
			lw, lp, dateA);
	}

}
