package staff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import buyers.Order;
import buyers.Promotion;
import shared.Document;
import shared.Inventory;

public class Operator extends Staff{
		
	public Operator(String username, String password) {
		super(username,password);
	}
	
	public void addDoc(Document doc) throws IOException {
		Writer output = new BufferedWriter(new FileWriter("documents.txt", true));
		output.append("\n"+doc.getIsbn()+";"+doc.getTitle()+";"+doc.getAuthor()+";"+doc.getPrice());
		output.close();
	}
	
	public void removeDoc(int isbn) throws IOException {
		File fileName = new File("documents.txt");
		File tempFile = new File("documents1.txt");

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = Integer.toString(isbn);
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.contains(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close();
		fileName.delete();
		tempFile.renameTo(fileName);
	}
	
	public void updateDoc(Document doc) throws IOException {
		removeDoc((int)doc.getIsbn());
		addDoc(doc);		
	}
}
