package business;

public class ObserverConcrect extends Observer {
	public ObserverConcrect(Aluno subject) {
		super(subject);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void update() {
		System.out.println("Status de pagamento do aluno: " + subject.getEstado());
	};
}
