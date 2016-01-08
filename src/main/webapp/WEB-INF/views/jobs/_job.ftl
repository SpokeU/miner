<div class="job-container">
	<div class="row">
		<div class="col-md-8">
			<a class="job-name" href="/job?jobId=${job.id}"><span>${job.name}</span></a>
		</div>
		<div class="col-md-4">
			<a href="/jobs/editJob/${job.id}"><span>Edit</span></a>
			/
			<a href="/jobs/delete/${job.id}"><span>Delete</span></a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<span>#${job.id}</span>
		</div>
		<div class="col-md-2">
			<span>${job.status!'INACTIVE'}</span>
		</div>
		<div class="col-md-2 col-md-offset-3">
			<span>last run by: John</span>
		</div>
		<div class="col-md-2">
			<span>10 hours ago</span>
		</div>
		<div class="col-md-2">
			<a href="/jobs/runJob?jobId=${job.id}" class="btn btn-primary btn-xs">Run</a>
		</div>
	</div>
</div>
