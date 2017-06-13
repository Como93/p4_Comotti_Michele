package test_funzionale;
import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import p4_comotti_michele_usecase1_11_14.AppleStore;
import p4_comotti_michele_usecase1_11_14.Credenziali;
import p4_comotti_michele_usecase1_11_14.EstrazioneCredenzialiImpl;
import p4_comotti_michele_usecase1_11_14.GoogleStore;
import p4_comotti_michele_usecase1_11_14.WinStore;

public class ModificaCredenzialiFunzionale {
	private EstrazioneCredenzialiImpl estr;
	
	private GoogleStore google;
	
	private WinStore windows;
	
	private AppleStore apple;
	
	//creo oggetti
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
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		google.setCredenzialiGoogle(c_iniziali);
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getUsername());
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getPassword());
		
		String user = "jack";
		String password = "savoretti";
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), user);
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), password);
		
		c_modificate.setUsername("jack");
		c_modificate.setPassword("savoretti");
		
		c_server.setUsername(estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
		c_server.setPassword(estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));

		boolean response = google.accesso(c_modificate, c_server);
		
		assertTrue(response);
		
		System.out.println("Modifiche effettuate");
		google.setCredenzialiGoogle(c_modificate);
		
		assertEquals("jack",google.getCredenzialiGoogle().getUsername());

		assertEquals("savoretti",google.getCredenzialiGoogle().getPassword());
		
	}
	// test in cui la modifica credenziali google non va a buon fine a livello di funzione
	@Test
	public void testGoogle2() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		google.setCredenzialiGoogle(c_iniziali);
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getUsername());
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), google.getCredenzialiGoogle().getPassword());
		
		String user = "jack";
		String password = "savoretti";
		
		estr.setEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), user);
		estr.setEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@")), password);
		
		c_modificate.setUsername("jack");
		c_modificate.setPassword("savoretti1");
		
		c_server.setUsername(estr.getEstrazioneUser(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));
		c_server.setPassword(estr.getEstrazionePass(google.toString().substring(google.toString().indexOf(".")+1, google.toString().indexOf("@"))));

		boolean response = google.accesso(c_modificate, c_server);
		
		assertFalse(response);
		
		System.out.println("Modifiche non effettuate");
		
		assertNotEquals("jack",google.getCredenzialiGoogle().getUsername());

		assertNotEquals("savoretti",google.getCredenzialiGoogle().getPassword());
		
	}
	/* test in cui la modifica credenziali non viene effettuata perchè
	 *  non ho salvato nell'element le credenziali */
	@Test
	public void testGoogle3() throws RemoteException {
		
		google.setCredenzialiGoogle(null);
		
		assertNull(google.getCredenzialiGoogle());
		System.out.println("Accesso mai effettuato nel sistema! Bisogna aggiungere prima le credenziali");
		
	}
	// test in cui la modifica credenziali windows va a buon fine a livello di funzione
	@Test
	public void testWindows1() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		windows.setCredenzialiWin(c_iniziali);
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getUsername());
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getPassword());
		
		String user = "jack";
		String password = "savoretti";
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), user);
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), password);
		
		c_modificate.setUsername("jack");
		c_modificate.setPassword("savoretti");
		
		c_server.setUsername(estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
		c_server.setPassword(estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));

		boolean response = windows.accesso(c_modificate, c_server);
		
		assertTrue(response);
		
		System.out.println("Modifiche effettuate");
		
		windows.setCredenzialiWin(c_modificate);
		
		assertEquals("jack",windows.getCredenzialiWin().getUsername());

		assertEquals("savoretti",windows.getCredenzialiWin().getPassword());
		
	}
	// test in cui la modifica credenziali windows non va a buon fine a livello di funzione
	@Test
	public void testWindows2() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		windows.setCredenzialiWin(c_iniziali);
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getUsername());
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), windows.getCredenzialiWin().getPassword());
		
		String user = "jack";
		String password = "savoretti";
		
		estr.setEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), user);
		estr.setEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@")), password);
		
		c_modificate.setUsername("jack");
		c_modificate.setPassword("savoretti1");
		
		c_server.setUsername(estr.getEstrazioneUser(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));
		c_server.setPassword(estr.getEstrazionePass(windows.toString().substring(windows.toString().indexOf(".")+1, windows.toString().indexOf("@"))));

		boolean response = windows.accesso(c_modificate, c_server);
		
		assertFalse(response);
		
		System.out.println("Modifiche non effettuate");
		
		assertNotEquals("jack",windows.getCredenzialiWin().getUsername());

		assertNotEquals("savoretti",windows.getCredenzialiWin().getPassword());
		
	}
	/* test in cui la modifica credenziali non viene effettuata perchè
	 *  non ho salvato nell'element le credenziali */
	@Test
	public void testWindows3() throws RemoteException {
		windows.setCredenzialiWin(null);
		assertNull(windows.getCredenzialiWin());
		System.out.println("Accesso mai effettuato nel sistema! Bisogna aggiungere prima le credenziali");
		
	}
	// test in cui la modifica credenziali apple va a buon fine a livello di funzione
	@Test
	public void testApple1() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		apple.setCredenzialiApple(c_iniziali);
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getUsername());
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getPassword());
		
		String user = "jack";
		String password = "savoretti";
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), user);
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), password);
		
		c_modificate.setUsername("jack");
		c_modificate.setPassword("savoretti");
		
		c_server.setUsername(estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
		c_server.setPassword(estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));

		boolean response = apple.accesso(c_modificate, c_server);
		
		assertTrue(response);
		
		System.out.println("Modifiche effettuate");
		
		apple.setCredenzialiApple(c_modificate);
		
		assertEquals("jack",apple.getCredenzialiApple().getUsername());

		assertEquals("savoretti",apple.getCredenzialiApple().getPassword());
		
	}
	// test in cui la modifica credenziali apple non va a buon fine a livello di funzione
	@Test
	public void testApple2() throws RemoteException {
		Credenziali c_iniziali = new Credenziali();
		Credenziali c_modificate = new Credenziali();
		Credenziali c_server = new Credenziali();
		
		c_iniziali.setUsername("michele");
		c_iniziali.setPassword("pass");
		
		apple.setCredenzialiApple(c_iniziali);
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getUsername());
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), apple.getCredenzialiApple().getPassword());
		
		String user = "jack";
		String password = "savoretti";
		
		estr.setEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), user);
		estr.setEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@")), password);
		
		c_modificate.setUsername("jack");
		c_modificate.setPassword("savoretti1");
		
		c_server.setUsername(estr.getEstrazioneUser(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));
		c_server.setPassword(estr.getEstrazionePass(apple.toString().substring(apple.toString().indexOf(".")+1, apple.toString().indexOf("@"))));

		boolean response = apple.accesso(c_modificate, c_server);
		
		assertFalse(response);
		
		System.out.println("Modifiche non effettuate");
		assertNotEquals("jack",apple.getCredenzialiApple().getUsername());

		assertNotEquals("savoretti",apple.getCredenzialiApple().getPassword());
		
	}
	/* test in cui la modifica credenziali non viene effettuata perchè
	 *  non ho salvato nell'element le credenziali */
	@Test
	public void testApple3() throws RemoteException {
		apple.setCredenzialiApple(null);
		assertNull(apple.getCredenzialiApple());
		System.out.println("Accesso mai effettuato nel sistema! Bisogna aggiungere prima le credenziali");
		
	}
	
}
