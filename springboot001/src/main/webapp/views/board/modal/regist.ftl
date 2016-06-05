<div class="modal fade fileDrop" id="newPostModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="file-drag"></div>
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h1 class="modal-title text-center">
					<i class="fa fa-fw fa-pencil"></i>NEW POST
				</h1>
			</div>
			<div class="modal-body col-sm-10 col-sm-offset-1">
				<form class="form-horizontal" id="boardAddForm" role="form" enctype="multipart/form-data">
					<div class="form-group">
						<div class="col-sm-3 text-right" style="font-size: 14px;">
							<label for="mBtitle" class="control-label"> <i
								class="fa fa-fw fa-lg fa-magic"></i>TITLE
							</label>
						</div>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="btitle"
								name="btitle" maxlength="50" required="required" placeholder="TITLE">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3 text-right">
							<label class="control-label" style="font-size: 14px;"> <i
								class="fa fa-fw fa-lg fa-align-right"></i>CONTENT
							</label>
						</div>
						<div class="col-sm-9">
							<textarea id="bcontent" class="form-control" required="required" placeholder="CONTENT"></textarea>
							<h6 class="pull-right" id="cntMsg" style="font-weight: 700; color: #31708f;">200 remaining</h6>
						</div>
					</div>
					<div id="mnoHidden" style="display: none;">${loginMember.mno}</div>
					<input id="attachFiles" type="file" multiple="multiple" style="display: none;">
					<button id="searchImage" class="btn btn-block btn-danger">
						<i class="fa fa-fw fa-file-picture-o"></i>SEARCH IMAGE
					</button><hr>

					<div id="attachFileThumbDiv" class="row"></div>
	
					<div class="panel panel-default">
						<div class="panel-heading">
							<p class="panel-title">Upload Note</p>
						</div>
						<div class="panel-body" style="font-size: 13px;">
							<ul>
								<li>The maximum file size for uploads is <strong>10 MB</strong>.</li>
								<li>Only image files (<strong>JPG, GIF, PNG</strong>) are allowed.</li>
								<li>You can <strong>drag &amp; drop</strong> files from your desktop on this window.</li>
							</ul>
						</div>
					</div><hr>
					<div style="float:right;">
						<button class="btn btn-default" data-dismiss="modal">CLOSE</button>
			            <button class="btn btn-primary" type="submit">
			            	<i class="fa fa-fw fa-floppy-o"></i>REGIST
			            </button>
		            </div>
	            </form>
			</div>
			<div class="modal-footer" style="border: 0px;"></div>
		</div>
	</div>
</div>
