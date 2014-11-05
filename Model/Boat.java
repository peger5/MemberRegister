package Model;

/*
 * Model class representing a boat. Contains mutator and accessor methods
 */
public class Boat {
	
	public enum Type {
		Sailboat, Motorsailer, Kayak, Other
	}
	
	private Type boatType;
	private double boatLength;
	
	public Boat(Type m_type,double m_length){
		this.boatLength = m_length;
		this.boatType = m_type;
	}
	
	public void editBoatType(Type m_type) {
		this.boatType = m_type;
	}

	public void editBoatLength(double m_length) {
		this.boatLength = m_length;
	}

	public Type getBoatType() {
		return boatType;
	}

	public double getBoatLength() {
		return boatLength;
	}
	
	

}
