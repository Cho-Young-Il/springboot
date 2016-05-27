<div id="profileModal" class="profile-modal container">
	<div class="row">
		<div class="col-xs-12 col-md-4 col-lg-4 col-md-offset-4 bootstrap snippets">
			<div class="widget panel shadow" style="border: 2px solid #003399;">
				<div class="panel-body">
					<hr style="margin-top: 0px;">
					<input type="file" id="profileImageFile" class="profile-image-file">
					<h4 class="mb0">
						PROFILE 
						<a id="modifyModalCloseBtn">
							<i class="fa fa-fw fa-close text-info pull-right" 
							   data-toggle="tooltip" data-original-title="Close"></i>
						</a>
						<a data-toggle="modal" data-target="#deleteConfirm">
							<i class="fa fa-fw fa-cog text-danger pull-right" 
							   data-toggle="tooltip" data-original-title="Delete account"></i>
						</a>
					</h4>
					<hr>
					<ul class="list-table">
						<li style="width: 70px; padding-left: 10px;">
						<img class="img-circle img-bordered-primary"
							id="profileImage" src="" 
							alt="" width="70px" height="70px">
						</li>
						<li class="text-left" style="padding-left: 30px;">
							<h4 class="semibold ellipsis nm" id="profileMname"></h4>
							<p class="text-muted nm" id="profileMid"></p>
						</li>
						<li class="text-right">
							<a class="btn btn-primary" id="profileImageEdit">Edit</a>
							
						</li>
						<li class="text-left">
							<a class="btn btn-danger" id="profileImageDelete">Delete</a>
							
						</li>
					</ul>
				</div>
				<hr>
				<div class="input-group" id="emailDupCheck">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-envelope mycolor"></i>
					</span> 
					<input size="60" maxlength="255" class="form-control"
						placeholder="Email" required="required"
						name="profileMemail" id="profileMemail" type="email">
				</div>
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-lock mycolor"></i>
					</span> 
					<input size="20" maxlength="20" class="form-control"
						required="required" placeholder="Password" name="mpwd"
						id="mpwd" type="password" pattern=".{8,}" 
						title="At least 8 characters">
				</div>
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-lock mycolor"></i>
					</span> 
					<input size="60" maxlength="255" class="form-control"
						required="required" placeholder="Confirm Password"
						name="mpwdConfirm" id="mpwdConfirm" type="password"
						pattern=".{8,}" title="At least 8 characters">
				</div>
				<div class="modify-modal-btn">
					<input type="button" id="modBtn" class="btn btn-primary"
						value="Modify"> 
					<a class="btn btn-success" id="showModPassDiv">
						<i class="fa fa-fw fa-caret-down"></i>
					</a>
				</div>
				
				<div class="mod-pass-div">
				<hr>
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock mycolor"></i>
						</span> 
						<input size="20" maxlength="20" class="form-control"
							required="required" placeholder="Current Password" name="mpwd"
							id="mpwd" type="password" pattern=".{8,}" 
							title="At least 8 characters">
					</div>
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock mycolor"></i>
						</span> 
						<input size="20" maxlength="20" class="form-control"
							required="required" placeholder="New Password" name="mpwd"
							id="mpwd" type="password" pattern=".{8,}" 
							title="At least 8 characters">
					</div>
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock mycolor"></i>
						</span> 
						<input size="20" maxlength="20" class="form-control"
							required="required" placeholder="Confirm Password" name="mpwd"
							id="mpwd" type="password" pattern=".{8,}" 
							title="At least 8 characters">
					</div>
					<div class="modify-modal-btn">
						<input type="button" id="modPass"
							class="btn btn-warning" value="Modify Password">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<div class="modal fade" id="deleteConfirm">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title text-danger">Delete your account?</h4>
			</div>
			<div class="modal-body">
				<div class="input-group">
					<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-lock mycolor"></i>
					</span> 
					<input size="20" maxlength="20" class="form-control"
						required="required" placeholder="Password" name="mpwd" id="mpwd"
						type="password" pattern=".{8,}" title="At least 8 characters">
				</div>
				<div class="input-group">
					<span class="input-group-addon"> 
						<i class="glyphicon glyphicon-lock mycolor"></i>
					</span> 
					<input size="60" maxlength="255" class="form-control"
						required="required" placeholder="Confirm Password"
						name="mpwdConfirm" id="mpwdConfirm" type="password"
						pattern=".{8,}" title="At least 8 characters">
				</div>
			</div>
			<div class="modal-footer">
				<a class="btn btn-default" data-dismiss="modal">Cancle</a> 
				<a class="btn btn-danger">Delete</a>
			</div>
		</div>
	</div>
</div>