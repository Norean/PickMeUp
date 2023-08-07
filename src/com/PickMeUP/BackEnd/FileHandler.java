package com.PickMeUP.BackEnd;
import java.io.*;
import java.util.ArrayList;

public class FileHandler{
	public static ArrayList<String> readFile(String filePath){
		ArrayList<String> file = new ArrayList<String>();

		try(FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader)){

			String line;
			while ((line = bufferedReader.readLine()) != null){
				file.add(line);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return file;
	}

	public static void writeFile(String filePath, String content){
		try(FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			bufferedWriter.write(content);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}