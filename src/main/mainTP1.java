package main;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class mainTP1 {
	
	public static void main(String[] args) {
		
		LectureFichier lecture = new LectureFichier();
		lecture.lireFichier("commandes.txt");
	}
	
}
