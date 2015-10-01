package go_euro.localization.business;

import go_euro.localization.Dao.LocationDao;
import go_euro.localization.domain.Location;
import go_euro.localization.domain.LocationConsolidated;
import go_euro.localization.generators.CsvGenerator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LocationBoTest {

	@Mock
	private LocationDao dao;
	
	@Mock
	private CsvGenerator csvGenerator;
	
	@InjectMocks
	private LocationBo locationBo = new LocationBo(dao, csvGenerator);
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGenerateWriteCsvFileWithValidInput(){
		String cityName = "Dublin";
		Mockito.when(dao.getLocationFor(cityName)).thenReturn(locationConsolidatedBuilder());
		
		locationBo.generateCsvFileLocationsFor(cityName);
		
		Mockito.verify(dao, Mockito.times(1)).getLocationFor(cityName);
		Mockito.verify(csvGenerator, Mockito.times(1)).writeCsvFile(Mockito.any(LocationConsolidated.class), Mockito.anyString());
	}
	
	@Test
	public void shouldGenerateWriteCsvWithNullInput(){
		String cityName = null;
		locationBo.generateCsvFileLocationsFor(cityName);

		Mockito.verify(dao, Mockito.times(0)).getLocationFor(cityName);
		Mockito.verify(csvGenerator, Mockito.times(0)).writeCsvFile(Mockito.any(LocationConsolidated.class), Mockito.anyString());
	}
	
	@Test
	public void shouldGenerateAValidFileName(){
		String cityName = "Berlin";
		
		Mockito.when(dao.getLocationFor(cityName)).thenReturn(locationConsolidatedBuilder());
		
		locationBo.generateCsvFileLocationsFor(cityName);
		
		Mockito.verify(dao, Mockito.times(1)).getLocationFor(cityName);
		
		Mockito.verify(csvGenerator, Mockito.times(1)).writeCsvFile(Mockito.any(LocationConsolidated.class), Mockito.anyString());
	}
	
	@Test
	public void shouldNotCallCsvGeneratorWhenThereAreNoSuggestions(){
		String cityName = "Berlin";
		
		Mockito.when(dao.getLocationFor(cityName)).thenReturn(emptylocationConsolidatedBuilder());
		
		locationBo.generateCsvFileLocationsFor(cityName);
		
		Mockito.verify(dao, Mockito.times(1)).getLocationFor(cityName);
		
		Mockito.verify(csvGenerator, Mockito.times(0)).writeCsvFile(Mockito.any(LocationConsolidated.class), Mockito.anyString());
	}
	
	public List<Location> locationConsolidatedBuilder(){
		List<Location> locations = new ArrayList<>();
		locations.add(new Location(Long.valueOf(1), "test 1", "location", Double.valueOf(100), Double.valueOf(200)));
		locations.add(new Location(Long.valueOf(2), "test 2", "location2", Double.valueOf(200), Double.valueOf(400)));
		
		return locations;
	}
	
	public List<Location> emptylocationConsolidatedBuilder(){
		List<Location> locations = new ArrayList<>();
		
		return locations;
	}
	
}
