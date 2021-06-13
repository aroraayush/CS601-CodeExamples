package observer;

import java.util.*;

/**
 *  This class is the "subject"/ "Observable" that contains data. When something changes, it
 *  will notify its "Observers". */
public class WeatherData implements Subject {
	// custom interface - Observer, implemented by 3 concrete Observers
	private List<Observer> observers;
	// Variables of update() method in Observer interface
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}

	// Register observer with this Subject
	// Passing interface object and not class
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	// Unregister observer with this Subject
	// Passing interface object and not class
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
