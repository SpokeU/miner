<#assign editing = job??>
<#assign formAction = editing?string('edit','create')>
<div class="row">
    <#if !editing><h3>New job</h3></#if>
    <div class="col-md-8">
    <@form controller="jobs" method="post" class="form-horizontal" action=formAction>
        <div class="form-group">
            <#if projectId??><input type="hidden" name="project_id" value="${projectId}"/></#if>
            <#if editing><input type="hidden" name="job_id" value="${job.id}"/></#if>
            <label for="job_name" class="col-sm-2 control-label">Name</label>

            <div class="col-sm-10">
                <input id="job_name" name="name" value="${(job.name)!""}" type="text" class="form-control"
                       placeholder="Job name">
            </div>
        </div>

        <div class="form-group">
            <label for="job_description" class="col-sm-2 control-label">Description</label>

            <div class="col-sm-10">
                <input id="job_description" name="description" value="${(job.description)!""}" type="text" class="form-control"
                       placeholder="Job description">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-sm">Save</button>
            </div>
        </div>
    </@form>
    </div>
</div>