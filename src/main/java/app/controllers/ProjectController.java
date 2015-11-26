package app.controllers;

import app.parser.models.Job;
import app.parser.models.Project;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.RESTful;

@RESTful
public class ProjectController extends AppController {

	public void index() {
			view("projects", Project.findAll().include(Job.class));
	}
	
	public void show(){
		String projectId = getId();
		Project project = (Project) Project.where("id = ?", Long.parseLong(projectId)).include(Job.class).get(0);
		view("project", project);
		render("project");
	}

	@GET
	public void newForm() {
	}

	@POST
	public void create() {
		Project p = new Project();
		p.fromMap(params1st());
		p.saveIt();
		redirect(ProjectController.class);
	}

	@DELETE
	public void destroy(){
		Project.findById(Long.parseLong(getId())).deleteCascade();
		flash("message", "Project has been removed");
		redirect(ProjectController.class);
	}

}
