
public class BusinessHours {

  private int offDay;

  private boolean run24;

  private int openTime;

  private int closeTime;

public int getOffDay() {
	return offDay;
}


public boolean isRun24() {
	return run24;
}


public int getOpenTime() {
	return openTime;
}


public int getCloseTime() {
	return closeTime;
}


@Override
public String toString() {
	return "BusinessHours [offDay=" + offDay + ", run24=" + run24 + ", openTime=" + openTime + ", closeTime="
			+ closeTime + "]";
}
  
  
}