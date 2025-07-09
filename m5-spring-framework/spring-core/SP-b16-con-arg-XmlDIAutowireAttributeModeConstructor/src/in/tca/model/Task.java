package in.tca.model;

public class Task {
	private int tid;
	private String title;
	private String description;
	
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", title=" + title + ", description=" + description +  "]";
	}

	public Task(int tid, String title, String description) {
		super();
		this.tid = tid;
		this.title = title;
		this.description = description;
	}
	
	
	
	
}
