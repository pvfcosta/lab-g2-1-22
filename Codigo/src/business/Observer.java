package business;

public abstract class Observer {
	protected Aluno subject;
	
	public Observer(Aluno subject) {
		this.subject = subject;
		this.subject.setObserver(this);
	}
	
	public void update() {};
}
