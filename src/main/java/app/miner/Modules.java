package app.miner;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import app.miner.plugin.ModuleConfig;

import static app.miner.plugin.ModuleConfig.*;

/**
 *This enum describes which modules exists in app
 */
public enum Modules {

	STEPS(Arrays.asList(KEY, NAME, PROCESSOR_CLASS, CONFIGURATOR_CLASS, VIEW_TEMPLATE, EDIT_TEMPLATE, CREATE_TEMPLATE));
	
	private Modules(List<String> properties){
		this.properties = properties;
	}
	
	private List<String> properties;
	
	public List<ModuleConfig> all(){
		return Lists.newArrayList();
	}
	
	public void get(String key){
		
	}
	
	public List<String> properties(){
		return properties;
	}
}
