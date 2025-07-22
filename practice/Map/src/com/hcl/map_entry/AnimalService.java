package com.hcl.map_entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

interface IAnimal {
	public List<Map.Entry<Integer, List<Animal>>> getAnimalByAge();
	public List<Map.Entry<Integer, List<Animal>>> getAnimalByName();
	
	
}

public class AnimalService implements IAnimal {
	public List<Animal> listOfAnimals = new ArrayList<>();

	public boolean addAnimals(Animal animal) {
		return listOfAnimals.add(animal);
	}

	public List<Animal> getListOfAnimal() {
		return listOfAnimals;
	}
	@Override
	public List<Map.Entry<Integer, List<Animal>>> getAnimalByAge() {
	    return listOfAnimals.stream()
	        .collect(Collectors.groupingBy(Animal::getAge))
	        .entrySet()
	        .stream()
	        .toList(); // Converts the Set to a List
	}

	
	public List<Map.Entry<Integer, List<Animal>>> getAnimalByAgeT() {
		List<Map.Entry<Integer, List<Animal>>> resultEntries = new ArrayList<>();
		Map<Integer, List<Animal>> map = new HashMap<>();
		List<Animal> myList = null;
		for (Animal animal : listOfAnimals) {
			int age = animal.getAge();
			if (!map.containsKey(age)) {
				myList = new ArrayList<Animal>();
				map.put(age, myList);
			}
			myList.add(animal);
		}
		resultEntries.addAll(map.entrySet());
//		resultEntries.sort(Map.Entry.comparingByKey());
		return resultEntries;

	}
	
	@Override
	public List getAnimalByName() {
		 
		return listOfAnimals.stream()
		        .collect(Collectors.groupingBy(Animal::getName))
		        .entrySet()
		        .stream()
		        .toList(); // Converts the Set to a List;
	}

	public static void main(String[] args) {
		AnimalService animalService = new AnimalService();
		animalService.addAnimals(new Animal("Cat", 23));
		animalService.addAnimals(new Animal("Dog", 23));
		animalService.addAnimals(new Animal("Hourse", 20));
		animalService.addAnimals(new Animal("Tiger", 25));
		animalService.addAnimals(new Animal("Mouse",33));
		
		System.err.println(animalService.getListOfAnimal().size());
		List<Map.Entry<Integer, List<Animal>>> resuEntries = animalService.getAnimalByAge();
		
//		for (Map.Entry<Integer, List<Animal>> animalAgePair : resuEntries) {
//			System.out.print(animalAgePair.getKey() + ": ");
//			List<Animal> listOfAnimals = animalAgePair.getValue();
//			for(Animal animal:listOfAnimals) {
//				System.out.print(animal.getName()+",");
//			}
//			System.out.println();
//		}
		
		animalService.getAnimalByAge().forEach(entry -> {
		    System.out.print(entry.getKey() + ": ");
		    entry.getValue().forEach(animal -> System.out.print(animal.getName() + ", "));
		    System.out.println();
		});


	}

	

}
