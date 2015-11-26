<div class="row">
    <div class="col-md-8">
    <@form controller="project" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="job_name" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input id="job_name" name="name" type="text" class="form-control"
                       placeholder="Project name">
            </div>
        </div>

        <div class="form-group">
            <label for="job_description" class="col-sm-2 control-label">Description</label>

            <div class="col-sm-10">
                <input id="job_description" name="description" type="text" class="form-control"
                       placeholder="Project description">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-sm">Create</button>
            </div>
        </div>
    </@form>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-1">
        <button class="btn btn-sm">Add Job</button>
    </div>
    <table>
        <thead>
        <tr>
            <th>Job Name</th>
            <th>Job Steps</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>...</td>
            <td>...</td>
        </tr>
        </tbody>
    </table>
</div>