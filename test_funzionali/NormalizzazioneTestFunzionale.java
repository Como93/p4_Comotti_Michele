package test_funzionale;
import static org.junit.Assert.*;

import java.io.IOException;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import p4_comotti_michele_usecase1_11_14.App;
import p4_comotti_michele_usecase1_11_14.GoogleStore;
import p4_comotti_michele_usecase1_11_14.WinStore;

public class NormalizzazioneTestFunzionale {
	private static App letfreex;
	private static GoogleStore google;
	private static App app_win;
	private static WinStore windows;
	private static App google_app;
	private static App app_win2;
	//crea oggetti
	@Before
	public void setUp() throws Exception {
		google = new GoogleStore();
		
		windows = new WinStore();
		letfreex = new App("letfreex",google);
		app_win = new App("app_win",windows);
		google_app = new App("google_app",google);
		app_win2 = new App("app_win2",windows);
		
	}
	//test windows normalizzazione di dati da app esistenti
	@Test
	public void testNormalizzazioneWinTrue() throws IOException {
		
		   
		    app_win.normalizzazioneDati();
		    
		    
			assertFalse(app_win.getDati().getRating().isEmpty());
			assertFalse(app_win.getDati().getType().isEmpty());
			assertFalse(Double.isNaN(app_win.getDati().getCount_new()));
			assertFalse(Double.isNaN(app_win.getDati().getCount_revised()));
			assertFalse(app_win.getDati().getName().isEmpty());
			assertFalse(app_win.getDati().getDate_win().isEmpty());
			assertFalse(app_win.getDati().getCount_average().isEmpty());
			assertFalse(app_win.getDati().getMarket().isEmpty());
			assertFalse(app_win.getDati().getAverage_rating().isEmpty());
			assertFalse(app_win.getDati().getNumber_rating().isEmpty());
			
	}
	//test windows normalizzazione di dati da app che non hanno i file con i dati estratti
	@Test
	public void testNormalizzazioneWinFalse() throws IOException {
		
		   
		    app_win2.normalizzazioneDati();
		    
		    
		    assertNull(app_win2.getDati().getRating());
		    assertNull(app_win2.getDati().getType());
		    assertEquals(0.0,app_win2.getDati().getCount_new(),0.0);
		    assertEquals(0.0,app_win2.getDati().getCount_revised(),0.0);
		    assertNull(app_win2.getDati().getName());
		    assertNull(app_win2.getDati().getDate_win());
		    assertNull(app_win2.getDati().getCount_average());
		    assertNull(app_win2.getDati().getMarket());
		    assertNull(app_win2.getDati().getAverage_rating());
		    assertNull(app_win2.getDati().getNumber_rating());
		    
		    
		   
			
	}
	//test google normalizzazione di dati da app esistenti
	@Test
	public void testNormalizzazioneGoogleTrue() throws IOException {
		
		   
		    letfreex.normalizzazioneDati();
		    assertFalse(letfreex.getDati().getPackage_name_os_version().isEmpty());
		    assertFalse(letfreex.getDati().getData_os_version().isEmpty());
		    assertFalse(letfreex.getDati().getOs_version().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_os_version().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_os_version().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_app_version().isEmpty());
			assertFalse(letfreex.getDati().getData_app_version().isEmpty());
		    assertFalse(letfreex.getDati().getApp_version().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_app_version().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_app_version().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_tablet().isEmpty());
			assertFalse(letfreex.getDati().getData_tablet().isEmpty());
		    assertFalse(letfreex.getDati().getTablet().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_tablet().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_tablet().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_language().isEmpty());
			assertFalse(letfreex.getDati().getData_language().isEmpty());
		    assertFalse(letfreex.getDati().getLanguage().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_language().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_language().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_overview().isEmpty());
			assertFalse(letfreex.getDati().getData_overview().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_overview().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_overview().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_country().isEmpty());
			assertFalse(letfreex.getDati().getData_country().isEmpty());
		    assertFalse(letfreex.getDati().getCountry().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_country().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_country().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_carrier().isEmpty());
			assertFalse(letfreex.getDati().getData_carrier().isEmpty());
		    assertFalse(letfreex.getDati().getCarrier().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_carrier().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_carrier().isEmpty());
			assertFalse(letfreex.getDati().getPackage_name_device().isEmpty());
			assertFalse(letfreex.getDati().getData_device().isEmpty());
		    assertFalse(letfreex.getDati().getDevice().isEmpty());
			assertFalse(letfreex.getDati().getDaily_average_device().isEmpty());
			assertFalse(letfreex.getDati().getTotal_average_device().isEmpty());
			
			
			
			
			
	}
	//test google normalizzazione di dati da app che non hanno i file con i dati estratti
	@Test
	public void testNormalizzazioneGoogleFalse() throws IOException {
		
		   
		    google_app.normalizzazioneDati();
		    assertNull(google_app.getDati().getPackage_name_os_version());
		    assertNull(google_app.getDati().getData_os_version());
		    assertNull(google_app.getDati().getOs_version());
		    assertNull(google_app.getDati().getDaily_average_os_version());
		    assertNull(google_app.getDati().getTotal_average_os_version());
		    assertNull(google_app.getDati().getPackage_name_app_version());
		    assertNull(google_app.getDati().getData_app_version());
		    assertNull(google_app.getDati().getApp_version());
		    assertNull(google_app.getDati().getDaily_average_app_version());
		    assertNull(google_app.getDati().getTotal_average_app_version());
		    assertNull(google_app.getDati().getPackage_name_tablet());
		    assertNull(google_app.getDati().getData_tablet());
		    assertNull(google_app.getDati().getTablet());
		    assertNull(google_app.getDati().getDaily_average_tablet());
		    assertNull(google_app.getDati().getTotal_average_tablet());
		    assertNull(google_app.getDati().getPackage_name_language());
		    assertNull(google_app.getDati().getData_language());
		    assertNull(google_app.getDati().getLanguage());
		    assertNull(google_app.getDati().getDaily_average_language());
		    assertNull(google_app.getDati().getTotal_average_language());
		    assertNull(google_app.getDati().getPackage_name_overview());
		    assertNull(google_app.getDati().getData_overview());
		    assertNull(google_app.getDati().getDaily_average_overview());
		    assertNull(google_app.getDati().getTotal_average_overview());
		    assertNull(google_app.getDati().getPackage_name_country());
		    assertNull(google_app.getDati().getData_country());
		    assertNull(google_app.getDati().getCountry());
		    assertNull(google_app.getDati().getDaily_average_country());
		    assertNull(google_app.getDati().getTotal_average_country());
		    assertNull(google_app.getDati().getPackage_name_carrier());
		    assertNull(google_app.getDati().getData_carrier());
		    assertNull(google_app.getDati().getCarrier());
		    assertNull(google_app.getDati().getDaily_average_carrier());
		    assertNull(google_app.getDati().getTotal_average_carrier());
		    assertNull(google_app.getDati().getPackage_name_device());
		    assertNull(google_app.getDati().getData_device());
		    assertNull(google_app.getDati().getDevice());
		    assertNull(google_app.getDati().getDaily_average_device());
		    assertNull(google_app.getDati().getTotal_average_device());
			
			
			
			
			
	}

}
