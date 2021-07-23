import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Store {

  private Long id;

  private String storeName;

  private String storeState;

  private BusinessHours businessHour;

  private LocalDateTime createdAt;

public Long getId() {
	return id;
}

public String getStoreName() {
	return storeName;
}

public String getStoreState() {
	return storeState;
}


public BusinessHours getBusinessHour() {
	return businessHour;
}


public LocalDateTime getCreatedAt() {
	return createdAt;
}

@Override
public String toString() {
	return "Store [id=" + id + ", storeName=" + storeName + ", storeState=" + storeState + ", businessHour="
			+ businessHour + ", createdAt=" + createdAt + "]";
}

DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
Date date = dateFormat.parse("12321312");


	/*
	 * Calendar cal = Calendar.getInstance() ; cal.setTime(nDate); int dayNum =
	 * cal.get(Calendar.DAY_OF_WEEK) ;
	 * 
	 */

  
}