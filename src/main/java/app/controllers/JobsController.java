package app.controllers;

import app.miner.ParserManager;
import app.miner.models.Job;

import javax.inject.Inject;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

public class JobsController extends AppController {
	
	@Inject ParserManager parserManager;
	
	public void createJob() {
		view("projectId", param("projectId"));
		render("create_edit_job");
		System.out.println("CreateJob");
    }
	
	public void editJob(){
		Long jobId = Long.valueOf(getId());
		view("jobId",jobId);
		view("job", Job.findById(jobId));
		view("sidebar", "edit_job_nav.ftl");
		render("create_edit_job");
		System.out.println("EditJob");
	}
	
	public void delete(){
		Job.findById(Long.parseLong(getId())).deleteCascade();
		flash("message", "Project has been removed");
		System.out.println("deleteJob");
		redirect(ProjectsController.class);
	}

	@POST
	public void create(){
		System.out.println("Post on create");
		Job job = new Job();
		job.fromMap(params1st());
		job.set("project_id", Integer.parseInt(param("project_id")));
		job.save();
		redirect(JobsController.class, "editJob", job.getId());
	}

	@POST
	public void edit(){
		System.out.println("Post on update");
		Long jobId = Long.valueOf(param("job_id"));
		Job job = Job.findById(jobId);
		job.fromMap(params1st());
		job.save();
		redirect(ProjectsController.class);
	}
	
	public void runJob(){
		String jobId = param("jobId");
		System.out.println("running job with id " + jobId);
		parserManager.executeJob(Long.valueOf(jobId));
		redirect(ProjectsController.class);
	}

}
