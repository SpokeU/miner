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
        <a class="btn btn-default" href="/jobs/createJob?projectId=${project.id}"><span
                class="glyphicon glyphicon-plus"></span> Add Job</a>
    </div>
</div>

<div class="row row-grid">
    <div class="col-md-10">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th class="jobs-table-header">Job Name</th>
                <th class="jobs-table-header" colspan="2">Job Steps</th>
            </tr>
            </thead>

            <#list jobs as job>
            <tr>
                <td class="jobs-table-name">${job.name}</td>
                <td class="jobs-table-steps"><#list job.steps as step>${step.name}<#if step_has_next>
                    ,</#if> </#list></td>
                <td class="jobs-table-name"><a href="/jobs/editJob/${job.id}">Edit</a></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>