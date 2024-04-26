package chapter04;

import java.util.Objects;

public class Rect {
	
	private int w;
	private int h;
	

	
	public Rect(int w2, int h2) {
		// TODO Auto-generated constructor stub
		this.w = w2;
		this.h = h2;
	}

	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(h, w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return h == other.h && w == other.w;
	}
	
	
	

}
