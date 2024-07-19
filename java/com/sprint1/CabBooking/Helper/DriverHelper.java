package com.sprint1.CabBooking.Helper;

import com.sprint1.CabBooking.bean.DriverBean;
import com.sprint1.CabBooking.entity.Driver;

public class DriverHelper {
	public static DriverBean generateDriverBean(Driver d) {
		DriverBean bean = null;
		if (d != null)
			bean = new DriverBean ( d, true);

		return bean;
	}

}
