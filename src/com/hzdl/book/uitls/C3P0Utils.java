package com.hzdl.book.uitls;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

	private static ComboPooledDataSource dataSource;

	public static ComboPooledDataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new ComboPooledDataSource();
		}
		return dataSource;
	}

}
