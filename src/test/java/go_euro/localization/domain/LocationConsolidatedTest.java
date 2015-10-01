package go_euro.localization.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LocationConsolidatedTest {
	
	private LocationConsolidated locationConsolidated;
	private LocationConsolidated locationConsolidatedWithNull;

	@Before
	public void setup(){
		locationConsolidated = new LocationConsolidated(locationBuilder());
		locationConsolidatedWithNull = new LocationConsolidated(null);
	}
	
	@Test
	public void shouldHaveAHeaderValue(){
		Assert.assertNotNull(locationConsolidated.getCsvHeader());
	}
	
	@Test
	public void shouldHaveAPopulatedLocationsWithTheRightOrder(){	
		String[] csvInformation = locationConsolidated.getDisplayAttributes().get(0);
		String[] csvInformation2 = locationConsolidated.getDisplayAttributes().get(1);
		
		Assert.assertNotNull(csvInformation[0].equals(1));
		Assert.assertNotNull(csvInformation[1].equals("test 1"));
		Assert.assertNotNull(csvInformation2[2].equals("location2"));
		Assert.assertNotNull(csvInformation2[3].equals(Long.valueOf(200)));
	}
	
	@Test
	public void shouldReturnNotNullObjectWithZeroElements(){
		List<String[]> csvInformation = locationConsolidatedWithNull.getDisplayAttributes();
		Assert.assertNotNull(csvInformation);
		Assert.assertEquals(csvInformation.size(), 0);
	}
	
	
	public List<Location> locationBuilder(){
		List<Location> locations = new ArrayList<>();
		locations.add(new Location(Long.valueOf(1), "test 1", "location", Double.valueOf(100), Double.valueOf(200)));
		locations.add(new Location(Long.valueOf(2), "test 2", "location2", Double.valueOf(200), Double.valueOf(400)));
		
		return locations;
	}
	
}
