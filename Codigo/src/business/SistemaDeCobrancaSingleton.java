package business;

public class SistemaDeCobrancaSingleton {
	private static final SistemaDeCobrancaSingleton INSTANCIA = new SistemaDeCobrancaSingleton();
	
	public static SistemaDeCobrancaSingleton getInstancia() {
		return INSTANCIA;
	}
	
	public void cobrarAluno() {};
}
