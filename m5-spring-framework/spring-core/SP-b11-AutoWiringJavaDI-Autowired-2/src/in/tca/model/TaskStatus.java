package in.tca.model;

public class TaskStatus {
	private boolean important;
	private boolean completed;
	
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {
		return "Status [important=" + important + ", completed=" + completed + "]";
	}
	
	
	
}
