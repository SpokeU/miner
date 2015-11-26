<div class="job-container">
	<div class="row">
		<div class="col-md-8 h4">
			<a href="/job?jobId=${job.id}"><span>${job.name}</span></a>
		</div>
		<div class="col-md-4">
			<a href="/job/edit?jobId=${job.id}"><span>Edit</span></a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			<span>#431</span>
		</div>
		<div class="col-md-2">
			<span>${job.status}</span>
		</div>
		<div class="col-md-2 col-md-offset-3">
			<span>last run by: John</span>
		</div>
		<div class="col-md-2">
			<span>10 hours ago</span>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-primary btn-xs">Run</button>
		</div>
	</div>
</div>
