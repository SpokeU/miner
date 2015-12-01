    <@form controller="steps" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="step_name" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input id="job_name" name="name" type="text" class="form-control"
                       placeholder="Project name">
            </div>
        </div>

        <div class="form-group">
            <label for="job_description" class="col-sm-2 control-label">Description</label>

            <div class="col-sm-10">
                <input id="step_description" name="description" type="text" class="form-control"
                       placeholder="Project description">
            </div>
        </div>
        <div class="form-group">
            <label for="job_description" class="col-sm-2 control-label">Description</label>

            <div class="col-sm-10">
                <select name="step_name" class="form-control">
                	<option value="get_page">Get page</option>
                	<option value="element_iterator">Element iterator</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-sm">Create</button>
            </div>
        </div>
    </@form>