package br.edu.ifspcjo.ads.cjoweb2.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifspcjo.ads.cjoweb2.model.ToDo;

public class ToDoUtil {
	public List<ToDo> getToDoList(String ToDo){
		List<ToDo> ToDoList = new ArrayList<>();
		
		if(ToDo.length() > 0) {
			
			String[] lines = ToDo.split("\n");
			
			for(int i = 0; i < lines.length; i++) {
				String[] data = lines[i].split("\\s*;\\s*");
				
				if(data.length == 3){
					ToDo NewToDo = new ToDo();
					
					NewToDo.setId(Integer.parseInt(data[0]));
					NewToDo.setDescription(data[1]);
					NewToDo.setDate(data[2]);
					ToDoList.add(NewToDo);
				}
			}
		}
		return ToDoList;
	}
}
