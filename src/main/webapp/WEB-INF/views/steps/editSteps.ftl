<p class="lead">Job steps</p>
<small>Help text</small>

<div class="row">
    <div class="col-md-4">
        <a class="btn btn-default" href="/steps/createStep?jobId=${jobId}"><span
                class="glyphicon glyphicon-plus"></span>Add Step</a>
    </div>
</div>

<div class="row row-grid">
    <div class="col-md-10">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th class="jobs_table_header">Job Name</th>
                <th class="jobs_table_header" colspan="2">Job Steps</th>
            </tr>
            </thead>

        <#list steps as step>
            <tr>
                <td class="">${step.name}</td>
                <td class="">${step.description}</td>
                <td class=""><a href="/steps/editStep/${step.id}">Edit</a></td>
            </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>