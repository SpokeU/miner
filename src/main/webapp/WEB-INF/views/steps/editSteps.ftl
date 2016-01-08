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
                <th class="step_table_header">Step Name</th>
                <th class="step_table_header" colspan="2">Step description</th>
            </tr>
            </thead>

        <#list steps as step>
            <tr>
                <td class="step-table-name">${step.name}</td>
                <td class="step-table-description">${step.description}</td>
                <td class="step-table-edit">
                    <div class="col-md-3">
                        <div class="dropdown pull-right">
                            <a class="dropdown-toggle" type="button" href="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"/>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="/steps/editStep/${step.id}">Edit settings</a></li>
                                <li><a href="/steps/delete/${step.id}">Delete...</a></li>
                                <li><a href="/steps/disable/${step.id}">Disable step</a></li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>