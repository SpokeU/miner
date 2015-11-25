package app.controllers;

import app.parser.models.Job;
import app.parser.models.Project;
import app.parser.models.Step;
import org.javalite.activeweb.AppController;

import java.util.List;

public class ProjectController extends AppController {

	public void index() {
		String projectId = param("projectId");
		if (projectId == null) {
			view("projects", Project.findAll().include(Job.class));
			render("projectsList");
		}else{
			Project project = (Project) Project.where("id = ?", Long.parseLong(projectId)).include(Job.class).get(0);
			List<Job> jobs = project.getAll(Job.class);
			System.out.println(jobs.get(0).getAll(Step.class));
			view("project", project);
			render("project");
		}
	}
}
