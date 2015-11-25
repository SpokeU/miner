package app.controllers;

import java.util.Arrays;
import java.util.List;

import org.javalite.activeweb.AppController;

import app.parser.models.Job;
import app.parser.models.Project;
import app.parser.models.Step;

public class ProjectController extends AppController {

	public void index() {
		String projectId = param("projectId");
		if (projectId == null) {
			view("projects", Project.findAll());
			render("projectsList");
		}else{
			Project project = (Project) Project.where("id = ?", Long.parseLong(projectId)).include(Job.class).get(0);
			List<Job> jobs = project.getAll(Job.class);
			System.out.println(jobs.get(0).getAll(Step.class));
			view("project", project);
			render("project");
		}
	}
	
	private List<Project> getProjects(){
		return Arrays.asList(
				Project.create("id", 1L, "name", "Test Proj", "description", "this project is for test puproses"),
				Project.create("id", 2L, "name", "Second Proj", "description", "this ispuproses")

				);
				
	}

}
