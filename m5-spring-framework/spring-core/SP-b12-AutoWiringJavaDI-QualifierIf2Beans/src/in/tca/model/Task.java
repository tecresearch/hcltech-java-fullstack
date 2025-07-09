package in.tca.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Task {
	private int tid;
	private String title;
	private String description;
	@Autowired
	private TaskStatus status;
	
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", title=" + title + ", description=" + description + "status"+status+ "]";
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	
	
	
}
