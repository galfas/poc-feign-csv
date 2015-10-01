package go_euro.localization.generators;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * This class is responsible for generate a CSV file based on a csvExportable.
 * 
 * @author msacilo
 *
 */
public class CsvGenerator {

	
	/**
	 * This method is responsible for creating the CSV file based on a an agnostic data.
	 * 
	 * @param locations
	 * @param csvName
	 */
	public void writeCsvFile(CsvExportable csvExportable , String csvName) {
		
        CSVWriter writer = null;
        
		try {
			writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(csvName), "UTF-8"));
        
			List<String[]> csvData = new ArrayList<String[]>();
			csvData.add(csvExportable.getCsvHeader());
			csvData.addAll(csvExportable.getDisplayAttributes());
			
			writer.writeAll(csvData);
			writer.close();
			System.out.println("The csv file was generated with our suggestions !!");
			
		} catch (UnsupportedEncodingException e) {
			throw new IllegalCharsetNameException("the enconde that was send is not acceptable");
		} catch (IOException e) {
			throw new RuntimeException("Problem was during the file creation");
		}

	}
	
}
