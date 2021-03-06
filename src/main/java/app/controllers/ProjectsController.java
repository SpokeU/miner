package app.controllers;

import app.miner.models.Job;
import app.miner.models.Project;
import app.miner.models.Step;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import java.util.List;

public class ProjectsController extends AppController {

    public void index() {
        view("projects", Project.findAll().include(Job.class));
    }

    public void newForm() {
    }

    public void editProject() {
        String projectId = getId();
        Project project = Project.findById(Long.parseLong(projectId));
        List<Job> jobs = Job.where("project_id = ?", Long.parseLong(projectId)).include(Step.class);
        view("project", project);
        view("jobs", jobs);
        view("sidebar", "edit_project_nav.ftl");
    }

    @POST
    public void create() {
        Project p = new Project();
        p.fromMap(params1st());
        p.save();
        redirect(ProjectsController.class, "editProject", p.get("id"));
    }

    public void view() {
        String projectId = getId();
        Project project = (Project) Project.where("id = ?", Long.parseLong(projectId)).include(Job.class).get(0);
        view("project", project);
        render("project");
    }

    @POST
    public void update() {
        Project project = new Project().fromMap(params1st());
        project.set("id", Long.parseLong(param("id")));
        if (!project.save()) {
            view("project", project);
            view("errors", project.errors());
            render("edit_form");
        } else {
            flash("message", "Post has been updated");
            redirect(ProjectsController.class, "view", param("id"));
        }
    }

    public void delete() {
        Project.findById(Long.parseLong(getId())).deleteCascade();
        flash("message", "Project has been removed");
        redirect(ProjectsController.class);
    }

}
