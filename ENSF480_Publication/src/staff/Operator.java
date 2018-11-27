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
	
	private void addDoctoFile(Document doc) throws IOException {
		Writer output = new BufferedWriter(new FileWriter("documents.txt", true));
		output.append("\n"+doc.getIsbn()+";"+doc.getTitle()+";"+doc.getAuthor()+";"+doc.getPrice());
		output.close();
	}
	
	private void removeDocfromFile(int isbn) throws IOException {
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
	
	public Inventory addDoc(Document doc, Inventory inventory) throws IOException {
		inventory.add(doc);
		addDoctoFile(doc);
		return inventory;
	}
	
	public Inventory removeDoc(int index, int isbn, Inventory inventory) throws IOException {
		inventory.getList().remove(index);
		return inventory;
	}
	
	public Inventory updateDoc(int index, Document doc, Inventory inventory) throws IOException {
		
		removeDocfromFile((int)doc.getIsbn());
		addDoctoFile(doc);		
		inventory.getList().remove(index);
		inventory.add(doc);
		return inventory;
	}
}
