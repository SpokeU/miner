package app.controllers;

import org.javalite.activeweb.AppController;

import app.miner.plugin.Plugins;

public class AdminController extends AppController{

	public void index(){
		System.out.println("adminPage");
	}
	
	public void plugins(){
		view("plugins", Plugins.all());
		
	}
	
}
