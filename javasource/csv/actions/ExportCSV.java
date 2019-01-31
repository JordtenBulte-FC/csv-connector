// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package csv.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import com.opencsv.CSVWriter;
import csv.impl.CSV;

/**
 * This action will export to a CSV.
 */
public class ExportCSV extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __file;
	private system.proxies.FileDocument file;
	private java.lang.String microflow;
	private IMendixObject microflowParameter;
	private java.lang.Boolean useSystemContext;
	private java.lang.String separator;
	private java.lang.String quoteCharacter;

	public ExportCSV(IContext context, IMendixObject file, java.lang.String microflow, IMendixObject microflowParameter, java.lang.Boolean useSystemContext, java.lang.String separator, java.lang.String quoteCharacter)
	{
		super(context);
		this.__file = file;
		this.microflow = microflow;
		this.microflowParameter = microflowParameter;
		this.useSystemContext = useSystemContext;
		this.separator = separator;
		this.quoteCharacter = quoteCharacter;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.file = __file == null ? null : system.proxies.FileDocument.initialize(getContext(), __file);

		// BEGIN USER CODE
		ILogNode logger = CSV.getLogger();
		
		logger.debug("Opening CSV file..");
	
		File tmpFile = File.createTempFile("export-", ".csv");
		CSVWriter writer = new CSVWriter(new FileWriter(tmpFile), 
                this.separator.charAt(0), 
                this.quoteCharacter != null ? this.quoteCharacter.charAt(0) : CSVWriter.NO_QUOTE_CHARACTER, 
                CSVWriter.NO_ESCAPE_CHARACTER, "\r\n");
		
		logger.debug("CSV file opened..");
		
		IContext context = getContext();
		if (useSystemContext) {
			context = Core.createSystemContext();
			context.startTransaction();
		}
		
		try {
			context.getData().put(CSV.CONTEXT_WRITER_OBJ, writer);
			if (this.microflowParameter != null) {
				Core.execute(context, this.microflow, this.microflowParameter);
			} else {
				Core.execute(context, this.microflow);
			}
			logger.debug("Sucessfully imported CSV file.");
			
			logger.info("Writing CSV to FileDocument.");
			writer.close();
			Core.storeFileDocumentContent(getContext(), file.getMendixObject(), tmpFile.getName(), new FileInputStream(tmpFile));
			logger.info("Succesfully written FileDocument.");
			
		} finally {
			logger.debug("Closing resources..");
			try {
				writer.close();
			} catch (Exception e) {}
			tmpFile.delete();
		}
		
		
		
		if (useSystemContext && context.isInTransaction()) {
			context.endTransaction();
		}
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "ExportCSV";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}