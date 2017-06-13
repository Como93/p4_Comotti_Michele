package test_strutturali;
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import p4_comotti_michele_usecase1_11_14.AppleStore;
import p4_comotti_michele_usecase1_11_14.Credenziali;
import p4_comotti_michele_usecase1_11_14.EstrazioneCredenzialiImpl;
import p4_comotti_michele_usecase1_11_14.GoogleStore;
import p4_comotti_michele_usecase1_11_14.WinStore;

public class ModificaCredenzialiStrutturali {
	
	private EstrazioneCredenzialiImpl estr;
	
	private GoogleStore google;
	
	private WinStore windows;
	
	private AppleStore apple;
	
	@Before
	public void setUp() throws Exception {
		estr = new EstrazioneCredenzialiImpl();
		google = new GoogleStore();
		windows = new WinStore();
		apple = new AppleStore();
	}
	// test in cui la modifica credenziali google va a buon fine a livello di funzione
	@Test
	public void testGoogle1() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		google.setCredenzialiGoogle(c_iniziali);
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getUsername());
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getPassword());
		
		if(google.getCredenzialiGoogle() == null){
			assertNotNull(google.getCredenzialiGoogle());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), user);
    					estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti");
    					c_server.setUsername(estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    	 google.setCredenzialiGoogle(c_modificate);	
    						 response = true;
    		    		 }else{
    		    			 response = false;
    		    		 }
    					
    				break;
    			}
			}
			
			
		}
		
		assertTrue(response);
		assertEquals("jack",google.getCredenzialiGoogle().getUsername());

		assertEquals("savoretti",google.getCredenzialiGoogle().getPassword());
	}
	// test in cui la modifica credenziali google non va a buon fine a livello di funzione
	@Test
	public void testGoogle2() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		google.setCredenzialiGoogle(c_iniziali);
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getUsername());
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getPassword());
		
		if(google.getCredenzialiGoogle() == null){
			assertNotNull(google.getCredenzialiGoogle());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), user);
    					estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			 break;
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		assertFalse(response);
		assertNotEquals("jack",google.getCredenzialiGoogle().getUsername());

		assertNotEquals("savoretti",google.getCredenzialiGoogle().getPassword());
		
	}
	/* test in cui la modifica credenziali google non va a buon fine a livello di funzione,
	 *  in particolare l'utente non conferma le credenziali inserite nel while
	 */
	@Test
	public void testGoogle3() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		google.setCredenzialiGoogle(c_iniziali);
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getUsername());
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getPassword());
		
		if(google.getCredenzialiGoogle() == null){
			assertNotNull(google.getCredenzialiGoogle());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 0;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    					
    				break;
    				case 1:
    					estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), user);
    					estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti");
    					c_server.setUsername(estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		assertFalse(response);
		
	}
	// test in cui l'element del visitor non ha le credenziali
	@Test
	public void testGoogle4() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		
		
		google.setCredenzialiGoogle(null);
		
		
		
		if(google.getCredenzialiGoogle() == null){
			assertNull(google.getCredenzialiGoogle());

		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    					
    				break;
    				case 1:
    					estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), user);
    					estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti");
    					c_server.setUsername(estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		
		
	}
	
	// test in cui la modifica credenziali windows va a buon fine a livello di funzione
	@Test
	public void testWindows1() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		windows.setCredenzialiWin(c_iniziali);
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getUsername());
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getPassword());
		
		if(windows.getCredenzialiWin() == null){
			assertNotNull(windows.getCredenzialiWin());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), user);
    					estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti");
    					c_server.setUsername(estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    	    		windows.setCredenzialiWin(c_modificate);
    		    		 }else{
    		    			 response = false;
    		    		 }
    					
    				break;
    			}
			}
			
			
		}
		
		assertTrue(response);
		
		assertEquals("jack",windows.getCredenzialiWin().getUsername());

		assertEquals("savoretti",windows.getCredenzialiWin().getPassword());
		
	}
	// test in cui la modifica credenziali windows non va a buon fine a livello di funzione
	@Test
	public void testWindows2() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		windows.setCredenzialiWin(c_iniziali);
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getUsername());
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getPassword());
		
		if(windows.getCredenzialiWin() == null){
			assertNotNull(windows.getCredenzialiWin());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), user);
    					estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			 break;
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		assertFalse(response);
		
		assertNotEquals("jack",windows.getCredenzialiWin().getUsername());

		assertNotEquals("savoretti",windows.getCredenzialiWin().getPassword());
	}
	/* test in cui la modifica credenziali windows non va a buon fine a livello di funzione,
	 *  in particolare l'utente non conferma le credenziali inserite nel while
	 */
	@Test
	public void testWindows3() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		windows.setCredenzialiWin(c_iniziali);
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getUsername());
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getPassword());
		
		if(windows.getCredenzialiWin() == null){
			assertNotNull(windows.getCredenzialiWin());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 0;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), user);
    					estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		assertFalse(response);
		
	}
	// test in cui l'element del visitor non ha le credenziali
	@Test
	public void testWindows4() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		windows.setCredenzialiWin(null);
		
		
		if(windows.getCredenzialiWin() == null){
			assertNull(windows.getCredenzialiWin());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 0;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), user);
    					estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		
		
	}
	// test in cui la modifica credenziali apple va a buon fine a livello di funzione
	@Test
	public void testApple1() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		apple.setCredenzialiApple(c_iniziali);
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getUsername());
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getPassword());
		
		if(apple.getCredenzialiApple() == null){
			assertNotNull(apple.getCredenzialiApple());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), user);
    					estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti");
    					c_server.setUsername(estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    	    		apple.setCredenzialiApple(c_modificate);
    		    		 }else{
    		    			 response = false;
    		    		 }
    					
    				break;
    			}
			}
			
			
		}
		
		assertTrue(response);
		assertEquals("jack",apple.getCredenzialiApple().getUsername());

		assertEquals("savoretti",apple.getCredenzialiApple().getPassword());
		
	}
	// test in cui la modifica credenziali apple non va a buon fine a livello di funzione
	@Test
	public void testApple2() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		apple.setCredenzialiApple(c_iniziali);
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getUsername());
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getPassword());
		
		if(apple.getCredenzialiApple() == null){
			assertNotNull(apple.getCredenzialiApple());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 1;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), user);
    					estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			 break;
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		assertFalse(response);
		
		assertNotEquals("jack",apple.getCredenzialiApple().getUsername());

		assertNotEquals("savoretti",apple.getCredenzialiApple().getPassword());
		
	}
	/* test in cui la modifica credenziali apple non va a buon fine a livello di funzione,
	 *  in particolare l'utente non conferma le credenziali inserite nel while
	 */
	@Test
	public void testApple3() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		apple.setCredenzialiApple(c_iniziali);
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getUsername());
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getPassword());
		
		if(apple.getCredenzialiApple() == null){
			assertNotNull(apple.getCredenzialiApple());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 0;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), user);
    					estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			 
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		assertFalse(response);
		
	}
	// test in cui l'element del visitor non ha le credenziali
	@Test
	public void testApple4() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		boolean response = false;
		
		apple.setCredenzialiApple(null);
		
		if(apple.getCredenzialiApple() == null){
			assertNull(apple.getCredenzialiApple());
		}else{
			while(response == false){
				String user = "jack";
				String pass = "savoretti";
				
    			int scelta = 0;
    			
    			switch(scelta){
    				case 0:
    					response = false;
    				break;
    				case 1:
    					estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), user);
    					estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), pass);
    					c_modificate.setUsername("jack");
    					c_modificate.setPassword("savoretti1");
    					c_server.setUsername(estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					c_server.setPassword(estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
    					 if(c_modificate.getUsername().equals(c_server.getUsername()) && c_modificate.getPassword().equals(c_server.getPassword())){
    		    	    		response = true;
    		    		 }else{
    		    			 response = false;
    		    			 
    		    		 }
    					
    				break;
    			}
    			break;
			}
			
			
		}
		
		
		
	}

}
