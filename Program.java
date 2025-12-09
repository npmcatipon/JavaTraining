

public abstract class Program {
	
	private String name;
	private boolean isRunning = false;
	
	public boolean getIsRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Program() {
		
	}
	
	public Program(String name) {
		this.setName(name);
	}
	
	abstract void run();
	abstract void stop();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
