package test_funzionale;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AggiuntaCredenzialiFunzionale.class, ModificaCredenzialiFunzionale.class,
		NormalizzazioneTestFunzionale.class })
public class TestSuiteFunzionali {

}
