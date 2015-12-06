package app.controllers;

import org.javalite.activeweb.AppController;

import app.miner.models.Job;

public class JobsController extends AppController {

	public void index() {
		String jobId = param("jobId");
		if(jobId == null){
			
		}else{
			jobById(jobId);
		}
	}
	
	public void create(){
		String jobId = param("jobId");
		if(jobId != null){
			
		}
	}

	private void jobById(String jobId) {
		Job job = Job.findById(Long.valueOf(jobId));
		view("job", job);
		render("job");
	}

}
