<div class="container">
	<h2>Plugins</h2>
	<div class="row">
		<div class="col-md-6">
			<input type="text" class="form-control" placeholder="Search for...">
		</div>

		<div class="col-md-2">
			<form action="uploadPlugin" enctype="multipart/form-data"
				method="post">
				<span class="btn btn-default btn-file"> Upload plugin <input
					type="file" name="plugin" />
				</span>
				<button class="btn btn-default" type="submit">Ok</button>
			</form>
		</div>
	</div>
	<h4>Available plugins</h4>
	<div class="row">
		<div class="col-md-8">
			<ul class="list-group">
			<@render partial="plugin" collection=plugins/>
			</ul>
		</div>
	</div>
</div>