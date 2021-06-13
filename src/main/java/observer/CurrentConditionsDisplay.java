package observer;

/**
 *  CurrentConditionsDisplay is one of the observers that are "observing" WeatherData" */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	// Registering itself with subject
	// The interface defines a contract, and your code can work with any class that implements the
	// interface, without having to know the concrete class -
	// it can even work with classes that didn't exist yet when the code was written.
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
