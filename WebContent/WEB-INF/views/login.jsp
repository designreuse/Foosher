<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

  <title>Foosher - Log-in</title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
	
	<style>
	body {
	  background: url(https://dl.dropboxusercontent.com/u/23299152/Wallpapers/wallpaper-22705.jpg) no-repeat center center fixed; 
	  -webkit-background-size: cover;
	  -moz-background-size: cover;
	  -o-background-size: cover;
	  background-size: cover;
	  font-family: 'Roboto', sans-serif;
	}
	
	.login-card {
	  padding: 40px;
	  width: 274px;
	  background-color: #F7F7F7;
	  margin: 0 auto 10px;
	  border-radius: 2px;
	  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	  overflow: hidden;
	}
	
	.login-card h1 {
	  font-weight: 100;
	  text-align: center;
	  font-size: 2.3em;
	}
	
	.login-card input[type=submit] {
	  width: 100%;
	  display: block;
	  margin-bottom: 10px;
	  position: relative;
	}
	
	.login-card input[type=text], input[type=password] {
	  height: 44px;
	  font-size: 16px;
	  width: 100%;
	  margin-bottom: 10px;
	  -webkit-appearance: none;
	  background: #fff;
	  border: 1px solid #d9d9d9;
	  border-top: 1px solid #c0c0c0;
	  /* border-radius: 2px; */
	  padding: 0 8px;
	  box-sizing: border-box;
	  -moz-box-sizing: border-box;
	}
	
	.login-card input[type=text]:hover, input[type=password]:hover {
	  border: 1px solid #b9b9b9;
	  border-top: 1px solid #a0a0a0;
	  -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
	  -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
	  box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
	}
	
	.login {
	  text-align: center;
	  font-size: 14px;
	  font-family: 'Arial', sans-serif;
	  font-weight: 700;
	  height: 36px;
	  padding: 0 8px;
	/* border-radius: 3px; */
	/* -webkit-user-select: none;
	  user-select: none; */
	}
	
	.login-submit {
	  /* border: 1px solid #3079ed; */
	  border: 0px;
	  color: #fff;
	  text-shadow: 0 1px rgba(0,0,0,0.1); 
	  background-color: #4d90fe;
	  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
	}
	
	.login-submit:hover {
	  /* border: 1px solid #2f5bb7; */
	  border: 0px;
	  text-shadow: 0 1px rgba(0,0,0,0.3);
	  background-color: #357ae8;
	  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
	}
	
	.login-card a {
	  text-decoration: none;
	  color: #666;
	  font-weight: 400;
	  text-align: center;
	  display: inline-block;
	  opacity: 0.6;
	  transition: opacity ease 0.5s;
	}
	
	.login-card a:hover {
	  opacity: 1;
	}
	
	.login-help {
	  width: 100%;
	  text-align: center;
	  font-size: 12px;
	}
</style>

</head>

<body>

  <div class="login-card">
    <h1>Log-in</h1><br>
  <form name='loginForm' action="<c:url value='/login' />" method='POST'>
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="#">Register</a> <br/> <a href="#">Forgot Password</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>

</html>