package utils;

public enum Driver {
	CHROME("chrome"), FIREFOX("firefox"), EDGE("edge"), SAFARI("safari");

	String name;

	private Driver(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
