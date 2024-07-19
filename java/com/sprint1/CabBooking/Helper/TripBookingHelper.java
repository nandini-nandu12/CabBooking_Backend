package com.sprint1.CabBooking.Helper;

import com.sprint1.CabBooking.bean.CustomerBean;
import com.sprint1.CabBooking.bean.DriverBean;
import com.sprint1.CabBooking.bean.TripBookingBean;
import com.sprint1.CabBooking.entity.TripBooking;

public class TripBookingHelper {
	public static TripBookingBean generateTripBookingBean(TripBooking tb) {
		TripBookingBean bean = null;
		if (tb != null)
			bean = new TripBookingBean(tb, true);
		if (tb.getCustomer() != null)
			bean.setCustomer(new CustomerBean(tb.getCustomer(), true));
		if (tb.getDriver() != null)
			bean.setDriver(new DriverBean(tb.getDriver(), true));

		return bean;
	}
}