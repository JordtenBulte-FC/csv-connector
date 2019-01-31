package csv.impl;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;

public class CSV {
	public static final String LOGNODE = "CSV";
	public static final String CONTEXT_READER_OBJ = "CSVReader";
	public static final String CONTEXT_WRITER_OBJ = "CSVWriter"; 
	private static ILogNode logger;
	
	
	public static ILogNode getLogger() {
		if (logger == null) {
			logger = Core.getLogger(LOGNODE);
		}
		return logger;
	}
}
