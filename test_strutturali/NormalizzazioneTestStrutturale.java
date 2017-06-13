package test_strutturali;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import p4_comotti_michele_usecase1_11_14.App;
import p4_comotti_michele_usecase1_11_14.Dati;
import p4_comotti_michele_usecase1_11_14.ElementAppStore;
import p4_comotti_michele_usecase1_11_14.GoogleStore;
import p4_comotti_michele_usecase1_11_14.WinStore;



public class NormalizzazioneTestStrutturale {
	private static App letfreex;
	private static GoogleStore google;
	private static App app_win;
	private static WinStore windows;
	
	private static Dati dati;
	ArrayList<String> at = new ArrayList<String>();
	ArrayList<String> dat = new ArrayList<String>();
	ArrayList<Double> dai = new ArrayList<Double>();
	ArrayList<Double> tot = new ArrayList<Double>();
	ArrayList<String> car = new ArrayList<String>();
	ArrayList<String> tab = new ArrayList<String>();
	String pack = null;
	boolean primoCarrier = false;
	boolean primoTablet = false;
	boolean primoVersionCode = false;
	boolean primoVersionOs = false;
	boolean primoCountry = false;
	boolean primoDevice = false;
	boolean primoLanguage = false;
	boolean primoRating = false;
	boolean primoType = false;
	
	ArrayList<String> version_code = new ArrayList<String>();
	ArrayList<String> version_os = new ArrayList<String>();
	ArrayList<String> country = new ArrayList<String>();
	ArrayList<String> device = new ArrayList<String>();
	ArrayList<String> language = new ArrayList<String>();
	ArrayList<String> listaVersion_os = new ArrayList<String>();
	ArrayList<String> listaVersion_code = new ArrayList<String>();
	ArrayList<String> listaCountry = new ArrayList<String>();
	ArrayList<String> listaDevice = new ArrayList<String>();
	ArrayList<String> listaLanguage = new ArrayList<String>();
	ArrayList<String> listaCar = new ArrayList<String>();
	ArrayList<String> listaTab = new ArrayList<String>();
	ArrayList<ArrayList<String>> listaFile = new ArrayList<ArrayList<String>>();
	String name_pack = null;
	String tipo = null;
	Double somma_new = 0.0;
	Double somma_revised = 0.0;
	ArrayList<String> market = new ArrayList<String>();
	ArrayList<String> type = new ArrayList<String>();
	ArrayList<String> date_win = new ArrayList<String>();
	ArrayList<String> rat = new ArrayList<String>();
	ArrayList<Double> average_rating = new ArrayList<Double>();
	ArrayList<Double> count_average = new ArrayList<Double>();
	ArrayList<Integer> number_rating = new ArrayList<Integer>();
	@Before
	public void setUp() throws Exception {
		
		google = new GoogleStore();
		
		windows = new WinStore();
		letfreex = new App("letfreex",google);
		app_win = new App("app_win",windows);
		
		dati = new Dati();
	}

	
	
	@Test
	public void testNormalizzazioneGoogleDati() throws IOException {
		
		ElementAppStore store = letfreex.getStore();
		String s = store.toString().substring(store.toString().indexOf(".")+1, store.toString().indexOf("@"));
    	if(s.equals("GoogleStore")){
    		
    		ArrayList<String> filename = new ArrayList<String>();
    		filename.add("src/rating_google_test/letfreex_app_version.csv");
    		filename.add("src/rating_google_test/letfreex_carrier.csv");
    		filename.add("src/rating_google_test/letfreex_country.csv");
    		filename.add("src/rating_google_test/letfreex_device.csv");
    		filename.add("src/rating_google_test/letfreex_language.csv");
    		filename.add("src/rating_google_test/letfreex_os_version.csv");
    		filename.add("src/rating_google_test/letfreex_overview.csv");
    		filename.add("src/rating_google_test/letfreex_tablets.csv");
    		
    		for(int i = 0; i < filename.size();i++){
    			if(filename.get(i).substring(0).contains(letfreex.getNomeApp()) == true){

    				String f = filename.get(i);
    				
    				if(i > 0){

        		        dat.clear();
        		        dai.clear();
        		        tot.clear();
        		        at.clear();
    				}
    				
    				if(filename.get(i).contains("overview")){
    					 	BufferedReader CSVFile = new BufferedReader(new FileReader(f));
    	    		        
    	    		        String dataRow = CSVFile.readLine(); // Read first line;
    	    		        String[] attr = dataRow.split(",");
    	    		        for(int k = 0; k < attr.length;k++){
    	    		        	at.add(attr[k]);
    	    		        }
    	    		        dati.setAttributi(at);
    	    		        
    	    		        
    	    		        dataRow = CSVFile.readLine();
    	    		        
    	    	         	while(dataRow != null){
    	    		        	String[] values = dataRow.split(",");
    	    		        	for(int t = 0;t < values.length;t++){
    	    		        		switch(dati.getAttributi().get(t)){
    		    		        		case "Date":
    		    		        			dat.add(values[t]);
    		    						break;
    		    						case "Package Name":
    		    							 pack = values[t];
    		    						break;
    		    						case "Daily Average Rating":
    		    							if(values[t].equals("NA")){
												dai.add(0.0);
											} else {
												Double dP = Double.parseDouble(values[t]);
												dai.add(dP);
											}
    		    						break;
    		    						case "Total Average Rating":
    		    							if(values[t].equals("NA")){
												tot.add(0.0);
											} else {
												Double to = Double.parseDouble(values[t]);
												tot.add(to);
											}
    		    						break;
    		    						
    	    		        		}
    	    		        	}
    	    		        	dataRow = CSVFile.readLine();
    	    		        }
    	    		        
    	    		        CSVFile.close();
    	    		        
    	    		        dati.setData_overview(dat);
   		        		 	dati.setPackage_name_overview(pack);
   		        		 	dati.setDaily_average_overview(dai);
   		        		 	dati.setTotal_average_overview(tot);
   		        		 	
   		        		 	ArrayList<String> date = new ArrayList<String>();
   		        		 	date.add("2017-05-08");
   		        		 	date.add("2017-05-09");
   		        		 	date.add("2017-05-10");
   		        		 	assertEquals(date,dati.getData_overview());
   		        		 	assertEquals("com.letfreex",dati.getPackage_name_overview());
   		        		 	ArrayList<Double> daily_average = new ArrayList<Double>();
   		        		 	daily_average.add(4.76);
   		        		 	daily_average.add(4.85);
   		        		 	daily_average.add(4.97);
   		        		 	assertEquals(daily_average,dati.getDaily_average_overview());
   		        		 	ArrayList<Double> total_average = new ArrayList<Double>();
		        		 	total_average.add(4.84);
		        		 	total_average.add(4.85);
		        		 	total_average.add(4.85);
		        		 	assertEquals(total_average,dati.getTotal_average_overview());
    	    		        
    				}else{
    					
    					BufferedReader CSVFile = new BufferedReader(new FileReader(f));
        		        
        		        String dataRow = CSVFile.readLine(); // Read first line;
        		        String[] attr = dataRow.split(",");
        		        for(int k = 0; k < attr.length;k++){
        		        	at.add(attr[k]);
        		        }
        		        dati.setAttributi(at);
        		        
        		        
        		        dataRow = CSVFile.readLine();
        		        
        		        while(dataRow != null){
        		        	String[] values = dataRow.split(",");
        		        	
        		        	for(int t = 0;t < values.length;t++){
        		        		switch(dati.getAttributi().get(t)){
    	    		        		case "Carrier":
    	    							if(primoCarrier == false){
    	    								primoCarrier = true;
    	    								listaFile.add(car);
    	    								car.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < car.size();c++){
    	    									if(car.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									car.add(values[t]);
    	    								}
    	    							
    	    							}
    	    							
    	    							break;
    	    						case "Tablets":
    	    							if(primoTablet == false){
    	    								primoTablet = true;
    	    								listaFile.add(tab);
    	    								tab.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < tab.size();c++){
    	    									if(tab.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									tab.add(values[t]);
    	    								}
    	    								
    	    							}
    	    							
    	    							break;
    	    						case "App Version Code":
    	    							if(primoVersionCode == false){
    	    								primoVersionCode = true;
    	    								listaFile.add(version_code);
    	    								version_code.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < version_code.size();c++){
    	    									if(version_code.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									version_code.add(values[t]);
    	    								}
    	    								
    	    							}
    	    							
    	    							break;
    	    						case "Android OS Version":
    	    							if(primoVersionOs == false){
    	    								primoVersionOs = true;
    	    								listaFile.add(version_os);
    	    								version_os.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < version_os.size();c++){
    	    									if(version_os.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									version_os.add(values[t]);
    	    								}
    	    								
    	    							}
    	    							
    	    							break;
    	    						case "Country":
    	    							if(primoCountry == false){
    	    								primoCountry = true;
    	    								listaFile.add(country);
    	    								country.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < country.size();c++){
    	    									if(country.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									country.add(values[t]);
    	    								}
    	    								
    	    							}
    	    							
    	    							break;
    	    						case "Language":
    	    							if(primoLanguage == false){
    	    								primoLanguage = true;
    	    								listaFile.add(language);
    	    								language.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < language.size();c++){
    	    									if(language.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									language.add(values[t]);
    	    								}
    	    								
    	    							}
    	    							
    	    							break;
    	    						case "Device":
    	    							if(primoDevice == false){
    	    								primoDevice = true;
    	    								listaFile.add(device);
    	    								device.add(values[t]);
    	    							}else{
    	    								boolean duplicato = false;
    	    								for(int c = 0; c < device.size();c++){
    	    									if(device.get(c).equals(values[t]) ){
    	    										duplicato = true;
    	    									}
    	    								}
    	    								if(duplicato == false){
    	    									device.add(values[t]);
    	    								}
    	    								
    	    							}
    	    							
    	    							break;
        		        		}
        		        	}
        		        	dataRow = CSVFile.readLine();
        		        }
        		        
        		        CSVFile.close();
        		        
        		        
        		      
        		        for(int r = 0; r < listaFile.get(0).size(); r++){
        	    		    	   File CSVFile1 = new File(f);
        	    		    	   Scanner inputStream1 = new Scanner(CSVFile1);
        	    		    	   inputStream1.nextLine();
        	    		        	
        	    		           while(inputStream1.hasNextLine()){
        	    	    		        	String dataRow1 = inputStream1.nextLine();
        	    	    		        	String[] values1 = dataRow1.split(",");
        	    	    		        	for(int z = 0; z < values1.length; z++){
        	    	    		        		if(listaFile.get(0).get(r).equals(values1[z])){
        	    	    		        			for(int x = 0; x < values1.length; x++){
        	    	    		        				switch(dati.getAttributi().get(x)){
        	    	    		        					case "Date":
        	    	    		        						dat.add(values1[x]);
        	    	    		        					break;
        	    	    		        					case "Package Name":
        	    	    		        						 pack = values1[x];
        	    	    		        					break;
        	    	    		        					case "Android OS Version":
        	    	    		        						listaVersion_os.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "App Version Code":
        	    	    		        						listaVersion_code.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "Carrier":
        	    	    		        						listaCar.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "Country":
        	    	    		        						listaCountry.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "Device":
        	    	    		        						listaDevice.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "Tablets":
        	    	    		        						listaTab.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "Language":
        	    	    		        						listaLanguage.add(listaFile.get(0).get(r));
        	    	    		        					break;
        	    	    		        					case "Daily Average Rating":
        	    	    		        						if(values1[x].equals("NA")){
        	    													dai.add(0.0);
        	    												} else {
        	    													Double dP = Double.parseDouble(values1[x]);
        	    													dai.add(dP);
        	    												}
        	    	    		        					break;
        	    	    		        					case "Total Average Rating":
        	    												if(values1[x].equals("NA")){
        	    													tot.add(0.0);
        	    												} else {
        	    													Double to = Double.parseDouble(values1[x]);
        	    													tot.add(to);
        	    												}
        	    											break;
        	    	    		        				}
        	    	    		        				
        	    	    		        			}
        	    	    		        		}
        	    	    		        	}
        	    	    		        	
        	    		        	 }
        	    		        	 inputStream1.close();
        	    		        }
    					
        		    if(filename.get(i).contains("os_version")){
   		        		 dati.setData_os_version(dat);
   		        		 dati.setPackage_name_os_version(pack);
   		        		 dati.setOs_version(listaVersion_os);
   		        		 dati.setDaily_average_os_version(dai);
   		        		 dati.setTotal_average_os_version(tot);
   		        		 
   		        		 ArrayList<String> date_os = new ArrayList<String>();
   		        		 date_os.add("2017-05-05");
   		        		 date_os.add("2017-05-06");
   		        		 date_os.add("2017-05-05");
   		        		 date_os.add("2017-05-06");
   		        		 assertEquals(date_os,dati.getData_os_version());
   		        		 assertEquals("com.letfreex",dati.getPackage_name_os_version());
   		        		 ArrayList<String> os = new ArrayList<String>();
  		        		 os.add("Android 4.4");
  		        		 os.add("Android 4.4");
  		        		 os.add("Android 5.1");
  		        		 os.add("Android 5.1");
  		        		 assertEquals(os,dati.getOs_version());
  		        		 ArrayList<Double> daily_os = new ArrayList<Double>();
		        		 daily_os.add(5.00);
		        		 daily_os.add(4.80);
		        		 daily_os.add(5.00);
		        		 daily_os.add(4.87);
		        		 assertEquals(daily_os,dati.getDaily_average_os_version());
		        		 ArrayList<Double> total_os = new ArrayList<Double>();
		        		 total_os.add(5.00);
		        		 total_os.add(4.82);
		        		 total_os.add(5.00);
		        		 total_os.add(4.88);
	        		 	 assertEquals(total_os,dati.getTotal_average_os_version());
  		        		 
   		        		
   		        		 
   		        	}
       		        else if(filename.get(i).contains("app_version")){
       		        	 dati.setData_app_version(dat);
   		        		 dati.setPackage_name_app_version(pack);
   		        		 dati.setApp_version(listaVersion_code);
   		        		 dati.setDaily_average_app_version(dai);
   		        		 dati.setTotal_average_app_version(tot);
   		        		 
   		        		 ArrayList<String> date_ap = new ArrayList<String>();
   		        		 date_ap.add("2017-05-05");
   		        		 date_ap.add("2017-05-06");
   		        		 date_ap.add("2017-05-05");
  		        		 date_ap.add("2017-05-06");
   		        		 assertEquals(date_ap,dati.getData_app_version());
   		        		 assertEquals("com.letfreex",dati.getPackage_name_app_version());
   		        		 ArrayList<String> ap = new ArrayList<String>();
   		        		 ap.add("");
   		        		 ap.add("");
   		        		 ap.add("200008");
   		        		 ap.add("200008");
   		        		 assertEquals(ap,dati.getApp_version());
   		        		 ArrayList<Double> daily_ap = new ArrayList<Double>();
   		        		 daily_ap.add(5.00);
   		        		 daily_ap.add(4.94);
   		        		 daily_ap.add(5.00);
  		        		 daily_ap.add(4.79);
		        		 assertEquals(daily_ap,dati.getDaily_average_app_version());
		        		 ArrayList<Double> total_ap = new ArrayList<Double>();
		        		 total_ap.add(5.00);
		        		 total_ap.add(4.94);
		        		 total_ap.add(5.00);
		        		 total_ap.add(4.81);
	        		 	 assertEquals(total_ap,dati.getTotal_average_app_version());
   		        		
   		        		
       		        }
       		        else if(filename.get(i).contains("carrier")){
      		        	 dati.setData_carrier(dat);
   		        		 dati.setPackage_name_carrier(pack);
   		        		 dati.setCarrier(listaCar);
   		        		 dati.setDaily_average_carrier(dai);
   		        		 dati.setTotal_average_carrier(tot);
   		        		 
   		        		 ArrayList<String> date_ca = new ArrayList<String>();
   		        		 date_ca.add("2017-05-07");
   		        		 date_ca.add("2017-05-08");
   		        		 date_ca.add("2017-05-07");
   		        		 date_ca.add("2017-05-08");
   		        		 assertEquals(date_ca,dati.getData_carrier());
   		        		 assertEquals("com.letfreex",dati.getPackage_name_carrier());
   		        		 ArrayList<String> ca = new ArrayList<String>();
   		        		 ca.add("3");
  		        		 ca.add("3");
  		        		 ca.add("AT&T");
  		        		 ca.add("AT&T");
  		        		 assertEquals(ca,dati.getCarrier());
  		        		 ArrayList<Double> daily_ca = new ArrayList<Double>();
  		        		 daily_ca.add(4.67);
  		        		 daily_ca.add(4.69);
  		        		 daily_ca.add(0.00);
 		        		 daily_ca.add(0.00);
		        		 assertEquals(daily_ca,dati.getDaily_average_carrier());
		        		 ArrayList<Double> total_ca = new ArrayList<Double>();
		        		 total_ca.add(4.83);
		        		 total_ca.add(4.80);
		        		 total_ca.add(5.00);
		        		 total_ca.add(5.00);
	        		 	 assertEquals(total_ca,dati.getTotal_average_carrier());
  		        		 
       		        }
       		        else if(filename.get(i).contains("country")){
      		        	 dati.setData_country(dat);
   		        		 dati.setPackage_name_country(pack);
   		        		 dati.setCountry(listaCountry);
   		        		 dati.setDaily_average_country(dai);
   		        		 dati.setTotal_average_country(tot);
   		        		
   		        		 ArrayList<String> date_co = new ArrayList<String>();
   		        		 date_co.add("2017-05-06");
   		        		 date_co.add("2017-05-07");
   		        		 date_co.add("2017-05-06");
   		        		 date_co.add("2017-05-07");
  		        		 assertEquals(date_co,dati.getData_country());
  		        		 assertEquals("com.letfreex",dati.getPackage_name_country());
  		        		 ArrayList<String> co = new ArrayList<String>();
  		        		 co.add("IT");
  		        		 co.add("IT");
  		        		 co.add("US");
  		        		 co.add("US");
 		        		 assertEquals(co,dati.getCountry());
 		        		 ArrayList<Double> daily_co = new ArrayList<Double>();
 		        		 daily_co.add(4.86);
 		        		 daily_co.add(4.82);
 		        		 daily_co.add(5.00);
		        		 daily_co.add(5.00);
		        		 assertEquals(daily_co,dati.getDaily_average_country());
		        		 ArrayList<Double> total_co = new ArrayList<Double>();
		        		 total_co.add(4.87);
		        		 total_co.add(4.86);
		        		 total_co.add(5.00);
		        		 total_co.add(5.00);
	        		 	 assertEquals(total_co,dati.getTotal_average_country());
   		        		 
       		        }
       		        else if(filename.get(i).contains("device")){
      		        	 dati.setData_device(dat);
   		        		 dati.setPackage_name_device(pack);
   		        		 dati.setDevice(listaDevice);
   		        		 dati.setDaily_average_device(dai);
   		        		 dati.setTotal_average_device(tot);
   		        		
   		        		 ArrayList<String> date_de = new ArrayList<String>();
   		        		 date_de.add("2017-05-05");
   		        		 date_de.add("2017-05-06");
   		        		 date_de.add("2017-05-05");
   		        		 date_de.add("2017-05-06");
 		        		 assertEquals(date_de,dati.getData_device());
 		        		 assertEquals("com.letfreex",dati.getPackage_name_device());
 		        		 ArrayList<String> de = new ArrayList<String>();
 		        		 de.add("HWFRD");
 		        		 de.add("HWFRD");
 		        		 de.add("M3s");
 		        		 de.add("M3s");
		        		 assertEquals(de,dati.getDevice());
		        		 ArrayList<Double> daily_de = new ArrayList<Double>();
		        		 daily_de.add(5.00);
		        		 daily_de.add(5.00);
		        		 daily_de.add(5.00);
		        		 daily_de.add(0.00);
		        		 assertEquals(daily_de,dati.getDaily_average_device());
		        		 ArrayList<Double> total_de = new ArrayList<Double>();
		        		 total_de.add(5.00);
		        		 total_de.add(5.00);
		        		 total_de.add(5.00);
		        		 total_de.add(5.00);
	        		 	 assertEquals(total_de,dati.getTotal_average_device());
       		        }
       		        else if(filename.get(i).contains("language")){
      		        	 dati.setData_language(dat);
   		        		 dati.setPackage_name_language(pack);
   		        		 dati.setLanguage(listaLanguage);
   		        		 dati.setDaily_average_language(dai);
   		        		 dati.setTotal_average_language(tot);
   		        		
   		        		 ArrayList<String> date_la = new ArrayList<String>();
   		        		 date_la.add("2017-05-06");
   		        		 date_la.add("2017-05-07");
   		        		 date_la.add("2017-05-06");
   		        		 date_la.add("2017-05-07");
  		        		 assertEquals(date_la,dati.getData_language());
  		        		 assertEquals("com.letfreex",dati.getPackage_name_language());
  		        		 ArrayList<String> la = new ArrayList<String>();
  		        		 la.add("en");
  		        		 la.add("en");
  		        		 la.add("it");
  		        		 la.add("it");
 		        		 assertEquals(la,dati.getLanguage());
 		        		 ArrayList<Double> daily_la = new ArrayList<Double>();
 		        		 daily_la.add(5.00);
 		        		 daily_la.add(0.00);
 		        		 daily_la.add(4.86);
 		        		 daily_la.add(4.82);
		        		 assertEquals(daily_la,dati.getDaily_average_language());
		        		 ArrayList<Double> total_la = new ArrayList<Double>();
		        		 total_la.add(5.00);
		        		 total_la.add(5.00);
		        		 total_la.add(4.87);
		        		 total_la.add(4.86);
	        		 	 assertEquals(total_la,dati.getTotal_average_language());
       		        }
       		        else if(filename.get(i).contains("tablets")){
      		        	 dati.setData_tablet(dat);
   		        		 dati.setPackage_name_tablet(pack);
   		        		 dati.setTablet(listaTab);
   		        		 dati.setDaily_average_tablet(dai);
   		        		 dati.setTotal_average_tablet(tot);
   		        		 
   		        		 ArrayList<String> date_ta = new ArrayList<String>();
  		        		 date_ta.add("2017-05-06");
  		        		 date_ta.add("2017-05-07");
  		        		 date_ta.add("2017-05-06");
  		        		 date_ta.add("2017-05-07");
 		        		 assertEquals(date_ta,dati.getData_tablet());
 		        		 assertEquals("com.letfreex",dati.getPackage_name_tablet());
 		        		 ArrayList<String> ta = new ArrayList<String>();
 		        		 ta.add("7_up_to_10_inch_tablets");
 		        		 ta.add("7_up_to_10_inch_tablets");
 		        		 ta.add("10_or_more_inch_tablets");
 		        		 ta.add("10_or_more_inch_tablets");
		        		 assertEquals(ta,dati.getTablet());
		        		 ArrayList<Double> daily_ta = new ArrayList<Double>();
		        		 daily_ta.add(4.00);
		        		 daily_ta.add(5.00);
		        		 daily_ta.add(4.83);
		        		 daily_ta.add(5.00);
		        		 assertEquals(daily_ta,dati.getDaily_average_tablet());
		        		 ArrayList<Double> total_ta = new ArrayList<Double>();
		        		 total_ta.add(4.00);
		        		 total_ta.add(4.30);
		        		 total_ta.add(4.83);
		        		 total_ta.add(4.88);
	        		 	 assertEquals(total_ta,dati.getTotal_average_tablet());
   		        		
   		        		
       		        }
       		        listaFile.clear();
    					
    					
    				}
    				
    		        
    		        
    		     
    		      
    			}
    		}
    		
    	}
		
	}
	
	
	@Test
	public void testNormalizzazioneWindowsDati() throws IOException {
		ElementAppStore store = app_win.getStore();
				
		String s = store.toString().substring(store.toString().indexOf(".")+1, store.toString().indexOf("@"));
		
		if(s.equals("WinStore")){
			
    		ArrayList<String> filename = new ArrayList<String>();
    		filename.add("src/rating_win_test/average_over_time_app_win.tsv");
    		filename.add("src/rating_win_test/markets_app_win.tsv");
    		filename.add("src/rating_win_test/new_and_revised_app_win.tsv");
    		
    		for(int i = 0; i < filename.size();i++){
    			if(filename.get(i).substring(0).contains(app_win.getNomeApp()) == true){
    				
    				String f = filename.get(i);
    				File fi = new File(f);
    				
    				Scanner inputStream = new Scanner(fi);
    				String data = inputStream.nextLine();
    				String[] attr = data.split(",");
    				for(int z = 0; z < attr.length;z++){
    					at.add(attr[z]);
    				}
    				dati.setAttributi(at);
    				
    				while(inputStream.hasNextLine()){
    					data = inputStream.nextLine();
    					String[] values = data.split(",");
    					for(int t = 0; t < values.length;t++){
    						switch(dati.getAttributi().get(t)){
    							case "Name":
    								name_pack = values[t];
    							break;
    							case "Date":
    								date_win.add(values[t]);
    							break;
    							case "Rating":
    								if(primoRating == false){
	    								primoRating = true;
	    								rat.add(values[t]);
	    							}else{
	    								boolean duplicato = false;
	    								for(int c = 0; c < rat.size();c++){
	    									if(rat.get(c).equals(values[t]) ){
	    										duplicato = true;
	    									}
	    								}
	    								if(duplicato == false){
	    									rat.add(values[t]);
	    								}
	    								
	    							}
	    						break;
    							case "Type":
    								if(primoType == false){
	    								primoType = true;
	    								type.add(values[t]);
	    							}else{
	    								boolean duplicato = false;
	    								for(int c = 0; c < type.size();c++){
	    									if(type.get(c).equals(values[t]) ){
	    										duplicato = true;
	    									}
	    								}
	    								if(duplicato == false){
	    									type.add(values[t]);
	    								}
	    								
	    							}
    								tipo = values[t];
    							break;
    							case "Count":
    								if(filename.get(i).contains("average_over_time")){
    									Double b = Double.parseDouble(values[t]);
    									count_average.add(b);
    								}
    								else if(filename.get(i).contains("new_and_revised")){
    									
    										if(tipo.equals("New rating")){
    											Double valor = Double.parseDouble(values[t]);
    											somma_new += valor;
    										}else if(tipo.equals("Revised rating")){
    											Double valor1 = Double.parseDouble(values[t]);
    											somma_revised += valor1;
    										}
    									
    								}
    							break;
    							case "Market":
    								market.add(values[t]);
    							break;
    							case "Average rating":
    								Double av = Double.parseDouble(values[t]);
    								average_rating.add(av);
    							break;
    							case "Number of ratings":
    								Integer nu = Integer.parseInt(values[t]);
    								number_rating.add(nu);
    							break;
    						}
    					}
    				}
 		    	  inputStream.close();
 		    	  
 		    	  if(filename.get(i).contains("average_over_time")){
 		    		  dati.setName(name_pack);
 		    		  dati.setDate_win(date_win);
 		    		  dati.setCount_average(count_average);
 		    		  
 		    		  assertEquals("9WZDNCRDKG6M",dati.getName());
 		    		  ArrayList<String> data_win = new ArrayList<String>();
 		    		  data_win.add("Jul 18 12:00 AM");
 		    		  data_win.add("Jul 25 12:00 AM");
 		    		  data_win.add("Aug 1 12:00 AM");
 		    		  data_win.add("Aug 8 12:00 AM");
 		    		  assertEquals(data_win,dati.getDate_win());
 		    		  ArrayList<Double> count_av = new ArrayList<Double>();
 		    		  count_av.add(5.00);
 		    		  count_av.add(5.00);
 		    		  count_av.add(5.00);
 		    		  count_av.add(4.75);
 		    		  assertEquals(count_av,dati.getCount_average());
 		    		  
 		    	  }
 		    	  else if(filename.get(i).contains("new_and_revised")){
 		    		  dati.setRating(rat);
		    		  dati.setType(type);
		    		  dati.setCount_new(somma_new);
		    		  dati.setCount_revised(somma_revised);
		    		  
		    		  ArrayList<String> r = new ArrayList<String>();
		    		  r.add("5");
		    		  r.add("4");
		    		  assertEquals(r,dati.getRating());
		    		  ArrayList<String> t = new ArrayList<String>();
		    		  t.add("New rating");
		    		  t.add("Revised rating");
		    		  assertEquals(t,dati.getType());
		    		  
		    		  assertEquals(69.0,dati.getCount_new(),0.0);
		    		  assertEquals(59.0,dati.getCount_revised(),0.0);
		    		  
		    		  
		    		  
 		    	  }
 		    	 else if(filename.get(i).contains("markets")){
		    		  dati.setMarket(market);
		    		  dati.setAverage_rating(average_rating);
		    		  dati.setNumber_rating(number_rating);
		    		  
		    		  ArrayList<String> mar = new ArrayList<String>();
		    		  mar.add("Hungary");
		    		  mar.add("Indonesia");
		    		  mar.add("India");
		    		  mar.add("Italy");
		    		  assertEquals(mar,dati.getMarket());
		    		  ArrayList<Double> av_rat = new ArrayList<Double>();
		    		  av_rat.add(5.0);
		    		  av_rat.add(4.5);
		    		  av_rat.add(4.2);
		    		  av_rat.add(4.9);
		    		  assertEquals(av_rat,dati.getAverage_rating());
		    		  ArrayList<Integer> num_rat = new ArrayList<Integer>();
		    		  num_rat.add(3);
		    		  num_rat.add(2);
		    		  num_rat.add(9);
		    		  num_rat.add(8);
		    		  assertEquals(num_rat,dati.getNumber_rating());
		    	  }
 		    	  //i = chil.length;
    			  at.clear();
 		       }
    			
    		}
		}
		
	}

	

}
