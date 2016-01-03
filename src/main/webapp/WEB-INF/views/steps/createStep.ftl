    <@form controller="steps" method="post" action="saveStepConfiguration" class="form-horizontal">
        <input type="hidden" name="job_id" value="${jobId}">
        <div class="form-group">
            <label for="step_name" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input id="step_name" name="name" type="text" class="form-control"
                       placeholder="Step name">
            </div>
        </div>

        <div class="form-group">
            <label for="step_description" class="col-sm-2 control-label">Description</label>

            <div class="col-sm-10">
                <input id="step_description" name="description" type="text" class="form-control"
                       placeholder="Step description">
            </div>
        </div>
        <div class="form-group">
            <label for="step-select" class="col-sm-2 control-label">Step:</label>

            <div class="col-sm-10">
                <select id="step-select" name="step_key" class="form-control">
                    <#list steps as step>
                        <option value="${step.key}">${step.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div id="step_configuration">

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-sm">Create</button>
            </div>
        </div>
    </@form>