package javadesktop;

import java.util.Objects;

public class MyValues {
    int value;
    public MyValues() {}
    public MyValues(int v) {
    	value=v;
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyValues other = (MyValues) obj;
		return value == other.value;
	}

    @Override
    public int hashCode() {
    	return this.value*17+3;
    }
    
    
	@Override
	public String toString() {
		return "MyValues [value=" + value + "]";
	}
    
    
}
