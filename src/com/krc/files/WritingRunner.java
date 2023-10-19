package com.krc.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class WritingRunner {

	public static void main(String[] args) throws IOException {
		Path logFile  = Paths.get("src/errors.log");
		String s = null;
		
		try {	
			s.length();			
		}catch(Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			Calendar cal = Calendar.getInstance();
			String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
			String dte = new SimpleDateFormat(DATE_FORMAT_NOW).format(cal.getTime());

			Files.write(logFile,  dte.getBytes(),StandardOpenOption.APPEND);
			Files.write(logFile, "\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(logFile,  e.getMessage().getBytes(),StandardOpenOption.APPEND);
			Files.write(logFile, "\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(logFile,  sStackTrace.getBytes(),StandardOpenOption.APPEND);
			Files.write(logFile, "\n".getBytes(), StandardOpenOption.APPEND);
		}
		

	}

}
