<div class="modal fade" id="newPostModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h1 class="modal-title text-center">
					<i class="fa fa-fw fa-pencil"></i>NEW POST
				</h1>
			</div>
			<div class="modal-body col-sm-10 col-sm-offset-1">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-3 text-right" style="font-size: 14px;">
							<label for="mBtitle" class="control-label"> <i
								class="fa fa-fw fa-lg fa-magic"></i>TITLE
							</label>
						</div>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="btitle"
								placeholder="TITLE">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3 text-right">
							<label class="control-label" style="font-size: 14px;"> <i
								class="fa fa-fw fa-lg fa-align-right"></i>CONTENT
							</label>
						</div>
						<div class="col-sm-9">
							<textarea id="bcontent" class="form-control" placeholder="CONTENT"></textarea>
						</div>
					</div>
					<button class="btn btn-block btn-danger"><i class="fa fa-fw fa-file-picture-o"></i>SEARCH IMAGE</button>
				</form><hr>
					
				<div class="panel panel-default">
					<div class="panel-heading">
						<p class="panel-title">Upload Note</p>
					</div>
					<div class="panel-body" style="font-size: 14px;">
						<ul>
							<li>The maximum file size for uploads is <strong>10 MB</strong>.</li>
							<li>Only image files (<strong>JPG, GIF, PNG</strong>) are allowed.</li>
							<li>You can <strong>drag &amp; drop</strong> files from your desktop on this pop up.</li>
						</ul>
					</div>
				</div><hr>
				
				<div style="float:right;">
					<button class="btn btn-default" data-dismiss="modal">CLOSE</button>
		            <button class="btn btn-primary"><i class="fa fa-fw fa-floppy-o"></i>REGIST</button>
	            </div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>
	
<button data-toggle="modal" data-target="#newPostModal">test</button>