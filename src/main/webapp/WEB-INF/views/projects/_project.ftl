<div class="container">
    <div class="row project-container">
        <div class="col-md-8">
            <a role="button" data-toggle="collapse" href="#project-${project.id}" aria-expanded="false"
               aria-controls="project-${project.id}">
                <span class="glyphicon glyphicon-menu-right text-warning" aria-hidden="true">
            </a>
            <span class="project-name"><a href="/projects/${project.id}">${project.name}</a></span>
        </div>

    <#-- DROPDOWN menu -->
        <div class="col-md-3">
            <div class="dropdown pull-right">
                <a class="dropdown-toggle" type="button" href="dropdownMenu1" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="true">
                    <span class="glyphicon glyphicon-cog" aria-hidden="true">
                </a>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="/projects/editProject/${project.id}">Edit settings</a></li>
                    <li><a href="/projects/delete/${project.id}">Delete</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </div>

        </div>
    </div>

    <div class="collapse" id="project-${project.id}">
        <div class="project-jobs">
        <@render partial="/jobs/job" collection=project.jobs spacer="spacer"></@render>
        </div>
    </div>
</div>


