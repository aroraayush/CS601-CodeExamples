package mvc;

/** The code is from Head First Design Patterns book **/  

public interface BeatModelInterface {
	void initialize();
  
	void on();
  
	void off();

	// Set Beats per minute
	void setBPM(int bpm);

	// Get Beats per minute
	int getBPM();
	// Passing object related to interface
	// It's not the interface "object" being passed to the method, still just a regular object.
	// It's just a way of saying "this parameter will accept any object that supports this interface".
	void registerObserver(BeatObserver o);
  
	void removeObserver(BeatObserver o);

  	// Overloading
	void registerObserver(BPMObserver o);
  
	void removeObserver(BPMObserver o);
}
