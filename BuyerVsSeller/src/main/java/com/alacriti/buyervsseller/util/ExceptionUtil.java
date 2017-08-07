package com.alacriti.buyervsseller.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ExceptionUtil {

	//private static final AppLogger log = LogUtil.getLogger(ExceptionUtil.class);

	public static String getStackTrace(Throwable aThrowable) {
		//log.debugPrintCurrentMethodName();
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
	System.out.println("Throwable Message: " + aThrowable.getMessage()
				+ "\n Stacktrace: ");
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}

}