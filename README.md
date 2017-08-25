# BreakJava8TierComp
Java8 Tiered Compilation will incorrectly change caller argument 

run class my.trade.TM1 with JVM_OPTIONS "java -ea -XX:+UseG1GC -verbose:gc -XX:+PrintGCDateStamps -Xms1g -Xmx2g -cp java99.jar my.trade.TM1" to reproduce this issue on Windows x64 



p <=0 
Exception in thread "main" java.lang.AssertionError: p : 0.0 > 0 (?) 
	at my.own.AskRecord.setP(AskRecord.java:81)
	at my.trade.TM1.case8(TM1.java:102)
	at my.trade.TM1.mainTest(TM1.java:128)
	at my.trade.TM1.main(TM1.java:145)

![Java Bugs 8148175](JDK-8148175.jpg?raw=true "Java Bugs 8148175")


For JAVA 8 build 144 afterward, please use '-XX:-Inline' to prevent this issue because TieredCompilation is being disabled puzzlingly.
