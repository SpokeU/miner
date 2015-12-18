<div class="row">
    <div class="col-md-8">
    <@form controller="projects" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="project_name" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input id="project_name" name="name" type="text" class="form-control"
                       placeholder="Project name">
            </div>
        </div>

        <div class="form-group">
            <label for="project_description" class="col-sm-2 control-label">Description</label>

            <div class="col-sm-10">
                <input id="project_description" name="description" type="text" class="form-control"
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