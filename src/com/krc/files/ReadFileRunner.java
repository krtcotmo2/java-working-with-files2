package com.krc.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReadFileRunner {

	public static void main(String[] args) throws IOException {
		Path file  = Paths.get("src/resources/read-me.txt");
		//read all lines reads gets all lines at once which could be a memory issue
		List<String> lines = Files.readAllLines(file);
		System.out.println(lines);
		System.out.println();
	
		//read all lines reads gets all lines at once which could be a memory issue
		Function<? super String, ? extends String> lowerCaseMapper = s -> s.toLowerCase();
		Predicate<? super String> notPersonPredicate = s -> !s.contains("person");
		Files.lines(file).map(lowerCaseMapper).filter(notPersonPredicate).forEach(System.out::println);
		
		Path jsonFile  = Paths.get("src/resources/data.json");
		
	}

}
