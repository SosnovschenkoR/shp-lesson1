package ru.progschool.lesson2.webloader;

import java.util.HashMap;

public class Contact extends HashMap<String, String> {

	public static final String NAME = "name";
	public static final String PHONE = "phone";

	// Конструктор с параметрами
	public Contact(String name, String phone) {
		super();
		super.put(NAME, name);
		super.put(PHONE, phone);
	}
}
