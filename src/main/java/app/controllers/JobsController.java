package app.controllers;

import app.miner.models.Job;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

public class JobsController extends AppController {

	public void index() {
		String jobId = param("jobId");
		if(jobId == null){
			
		}else{
			jobById(jobId);
		}
	}
	
	public void newForm() {
    }

	@POST
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
