# BreakJava8TierComp
Java8 Tiered Compilation will incorrectly change caller argument 

run class my.trade.TM1 with JVM_OPTIONS "-ea -XX:+UseG1GC -verbose:gc -XX:+PrintGCDateStamps -Xms1g -Xmx2g" to reproduce this issue on Windows x64 



p <=0 
Exception in thread "main" java.lang.AssertionError: p : 0.0 > 0 (?) 
	at my.own.AskRecord.setP(AskRecord.java:81)
	at my.trade.TM1.case8(TM1.java:102)
	at my.trade.TM1.mainTest(TM1.java:128)
	at my.trade.TM1.main(TM1.java:145)
