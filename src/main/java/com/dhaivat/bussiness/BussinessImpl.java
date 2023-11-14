package com.dhaivat.bussiness;

import java.util.ArrayList;
import java.util.List;

import com.dhaivat.data.api.ToDoService;

public class BussinessImpl  {
	
	private final ToDoService toDoService;
	
	public BussinessImpl(ToDoService toDoService) {
		this.toDoService=toDoService;
	}
	public List<String> retriveToDosForSpring(String user) {
		List<String>filterList = new ArrayList<String>();
		List<String>toDos = toDoService.retriveToDos(user);
		for (String toDo : toDos) {
				if(toDo.contains("spring"))
					filterList.add(toDo);
		}
		System.out.println("hello");
		return filterList;
	}

}
