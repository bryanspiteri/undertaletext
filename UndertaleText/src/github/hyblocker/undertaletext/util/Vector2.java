package github.hyblocker.undertaletext.util;

public class Vector2 {
	public double x,y;
	
	public static Vector2 zero = new Vector2(0,0);
	
	public Vector2(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	public boolean equals(Vector2 check){
		if(check.x==this.x && check.y == this.y) {
			return true;
		}
		return false;
	}
}
