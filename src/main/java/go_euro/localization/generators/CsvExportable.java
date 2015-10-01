package go_euro.localization.generators;

import java.util.List;


public interface CsvExportable {
	
	/**
	 * Should get the header to a csv file
	 */
	public String[] getCsvHeader();
	

	/**
	 * Should get the content to a csv file
	 */
	public List<String[]> getDisplayAttributes();

}
