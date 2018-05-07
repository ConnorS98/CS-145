package homeowrk06;

import java.util.ArrayList;

public class Place {
	public ArrayList<String> zip;
	public String cityState;
	
	public ArrayList<String> getZip() {
		return zip;
	}
	
	public void setZip(ArrayList<String> zip) {
		this.zip = zip;
	}
	
	public String getCityState() {
		return cityState;
	}
	
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	
	public String toString() {
		String output = "[";
		output += zip.get(0);
		for (int i = 1; i <= zip.size(); i++) {
			output += ", " + zip.get(i);
		}
		return output += "]";		
	}
	
}
