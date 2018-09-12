package org.ea.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class App {

	public static Connection connObj;
	public static String JDBC_URL = "jdbc:sqlserver://localhost;databaseName=tempdb;integratedSecurity=false";

	public static void getDbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL,"sa","<yourPassword>");
			if(connObj != null) {
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				System.out.println("Connected");
				System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
			}
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getDbConnection();
	}
}