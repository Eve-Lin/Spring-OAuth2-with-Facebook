
<form action="/login" method="post">
    <h2 class="text-center">Sign in</h2>
    <div class="text-center social-btn">
        <a href="/oauth2/authorization/facebook" class="btn btn-primary btn-block"><i class="fa fa-facebook"></i> Sign in with <b>Facebook</b></a>
        <!-- <a href="/oauth2/authorization/google" class="btn btn-info btn-block"><i class="fa fa-google"></i> Sign in with <b>Google</b></a> -->
    </div>
    <div class="or-seperator"><i>or</i></div>
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" class="form-control" name="username" placeholder="Username" required="required">
        </div>
    </div>
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-success btn-block login-btn">Sign in</button>
    </div>
    <div class="clearfix">
        <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
        <a href="#" class="pull-right text-success">Forgot Password?</a>
    </div>
</form>

