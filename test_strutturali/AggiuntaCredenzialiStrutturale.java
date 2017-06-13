package test_strutturali;
import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import p4_comotti_michele_usecase1_11_14.AppleStore;
import p4_comotti_michele_usecase1_11_14.Credenziali;
import p4_comotti_michele_usecase1_11_14.EstrazioneCredenzialiImpl;
import p4_comotti_michele_usecase1_11_14.GoogleStore;
import p4_comotti_michele_usecase1_11_14.WinStore;

public class AggiuntaCredenzialiStrutturale {
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
	// test in cui l'aggiunta credenziali google va a buon fine a livello di struttura
	@Test
	public void testGoogleTrue() throws RemoteException {
		Credenziali cred = new Credenziali();
		Credenziali cred_server = new Credenziali();
		
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")),"michele");
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), "pass");
		
		String userServer = estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")));
		String passServer = estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")));
		cred_server.setUsername(userServer);
		cred_server.setPassword(passServer);
		
		
		boolean response = false;
    	while(response == false){
    		 cred.setUsername("michele");
    		 cred.setPassword("pass");
    		 if(cred.getUsername().equals(cred_server.getUsername()) && cred.getPassword().equals(cred_server.getPassword())){
    	    		response = true;
    		 }else{
    			 response = false;
    		 }
    	    	
    	    	
    	}
    	
    	assertTrue(response);
	}
	// test in cui l'aggiunta credenziali google non va a buon fine a livello di struttura
	@Test
	public void testGoogleFalse() throws RemoteException {
		Credenziali cred = new Credenziali();
		Credenziali cred_server = new Credenziali();
		
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")),"michele");
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), "pass");
		
		String userServer = estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")));
		String passServer = estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")));
		cred_server.setUsername(userServer);
		cred_server.setPassword(passServer);
		
		
		boolean response = false;
    	while(response == false){
    		 cred.setUsername("jack");
    		 cred.setPassword("savoretti");
    		 if(cred.getUsername().equals(cred_server.getUsername()) && cred.getPassword().equals(cred_server.getPassword())){
    	    		response = true;
    		 }else{
    			 response = false;
    			 break;
    		 }
    	    	
    	    	
    	}
    	
    	assertFalse(response);
	}
	// test in cui l'aggiunta credenziali windows va a buon fine a livello di struttura
	@Test
	public void testWindowsTrue() throws RemoteException {
		Credenziali cred = new Credenziali();
		Credenziali cred_server = new Credenziali();
		
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")),"michele");
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), "pass");
		
		String userServer = estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")));
		String passServer = estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")));
		cred_server.setUsername(userServer);
		cred_server.setPassword(passServer);
		
		
		boolean response = false;
    	while(response == false){
    		 cred.setUsername("michele");
    		 cred.setPassword("pass");
    		 if(cred.getUsername().equals(cred_server.getUsername()) && cred.getPassword().equals(cred_server.getPassword())){
    	    		response = true;
    		 }else{
    			 response = false;
    		 }
    	    	
    	    	
    	}
    	
    	assertTrue(response);
	}
	// test in cui l'aggiunta credenziali windows non va a buon fine a livello di struttura
	@Test
	public void testWindowsFalse() throws RemoteException {
		Credenziali cred = new Credenziali();
		Credenziali cred_server = new Credenziali();
		
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")),"michele");
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), "pass");
		
		String userServer = estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")));
		String passServer = estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")));
		cred_server.setUsername(userServer);
		cred_server.setPassword(passServer);
		
		
		boolean response = false;
    	while(response == false){
    		 cred.setUsername("jack");
    		 cred.setPassword("savoretti");
    		 if(cred.getUsername().equals(cred_server.getUsername()) && cred.getPassword().equals(cred_server.getPassword())){
    	    		response = true;
    		 }else{
    			 response = false;
    			 break;
    		 }
    	    	
    	    	
    	}
    	
    	assertFalse(response);
	}
	// test in cui l'aggiunta credenziali apple va a buon fine a livello di struttura
	@Test
	public void testAppleTrue() throws RemoteException {
		Credenziali cred = new Credenziali();
		Credenziali cred_server = new Credenziali();
		
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")),"michele");
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), "pass");
		
		String userServer = estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")));
		String passServer = estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")));
		cred_server.setUsername(userServer);
		cred_server.setPassword(passServer);
		
		
		boolean response = false;
    	while(response == false){
    		 cred.setUsername("michele");
    		 cred.setPassword("pass");
    		 if(cred.getUsername().equals(cred_server.getUsername()) && cred.getPassword().equals(cred_server.getPassword())){
    	    		response = true;
    		 }else{
    			 response = false;
    			 
    		 }
    	    	
    	    	
    	}
    	
    	assertTrue(response);
	}
	// test in cui l'aggiunta credenziali apple non va a buon fine a livello di struttura
	@Test
	public void testAppleFalse() throws RemoteException {
		Credenziali cred = new Credenziali();
		Credenziali cred_server = new Credenziali();
		
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")),"michele");
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), "pass");
		
		String userServer = estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")));
		String passServer = estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")));
		cred_server.setUsername(userServer);
		cred_server.setPassword(passServer);
		
		
		boolean response = false;
    	while(response == false){
    		 cred.setUsername("jack");
    		 cred.setPassword("savoretti");
    		 if(cred.getUsername().equals(cred_server.getUsername()) && cred.getPassword().equals(cred_server.getPassword())){
    	    		response = true;
    		 }else{
    			 response = false;
    			 break;
    		 }
    	    	
    	    	
    	}
    	
    	assertFalse(response);
	}

}
