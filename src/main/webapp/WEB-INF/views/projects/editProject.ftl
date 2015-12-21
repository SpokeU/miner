<div class="col-md-2">
    <#include "edit_project_nav.ftl">
</div>
<div class="col-md-10">
    <@form controller="projects" action="update" method="post" class="form-horizontal project-form">
        <input name="id" value="${project.id}" type="hidden"/>
        <div class="form-group">
            <label for="project_name" class="col-sm-2">Name</label>

            <div class="col-sm-6">
                <input id="job_name" name="name" value="${project.name}" type="text" class="form-control"
                       placeholder="Project name">
            </div>
        </div>

        <div class="form-group">
            <label for="job_description" class="col-sm-2">Description</label>

            <div class="col-sm-6">
                <input id="project_description" name="description" value="${project.description}" type="text"
                       class="form-control"
                       placeholder="Project description">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default btn-primary">Save</button>
            </div>
        </div>
    </@form>
<hr/>
<h4>Jobs</h4>
<div class="row">
    <div class="col-md-4">
        <a class="btn btn-default" href="/jobs/new_form"><span class="glyphicon glyphicon-plus"></span> Add Job</a>
    </div>
</div>
<div class="row row-grid">
    <div class="col-md-6">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Job Name</th>
                <th>Job Steps</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Parse deshevse</td>
                <td>get page, parse, eahc</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</div>