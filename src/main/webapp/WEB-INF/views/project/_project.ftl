<div class="container">
    <div class="row">
        <div class="col-md-8">
            <a role="button" data-toggle="collapse" href="#project-${project.id}" aria-expanded="false"
               aria-controls="project-${project.id}">
                <span class="glyphicon glyphicon-menu-right text-warning" aria-hidden="true">
            </a>
            <span class="project-name h4"><a href="/project?projectId=${project.id}">${project.name}</a></span>
        </div>
        <div class="col-md-3">
            <div class="dropdown pull-right">
                <a class="dropdown-toggle" type="button" href="dropdownMenu1" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="true">
                    <span class="glyphicon glyphicon-cog" aria-hidden="true">
                </a>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Edit config</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </div>

        </div>
    </div>

    <div class="collapse" id="project-${project.id}">
        <div class="project-jobs">
            <@render partial="/job/job" collection=project.jobs spacer="spacer"></@render>
        </div>
    </div>
</div>


