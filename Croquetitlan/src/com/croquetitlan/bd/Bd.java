package com.croquetitlan.bd;

import com.croquetitlan.servlet.credenciales;

public class Bd {
	public static class Conexion{
		private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost/croquetitlan_db?serverTimezone=UTC";
		private static final String USER = credenciales.getUser();
		private static final String PASSWORD = credenciales.getPassword();
		public static String getDriver() {
			return DRIVER;
		}
		public static String getUrl() {
			return URL;
		}
		public static String getUser() {
			return USER;
		}
		public static String getPassword() {
			return PASSWORD;
		}
	}
}