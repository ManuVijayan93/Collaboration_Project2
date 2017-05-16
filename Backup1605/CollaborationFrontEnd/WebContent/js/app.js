var app = angular.module("myApp", [ 'ngRoute', 'ngCookies' ])
app.config(function($routeProvider) { // configuring route provider
	console.log('**********From App.js => Entering myApp')
	$routeProvider

	// loads this page first - home

	// Home
	.when('/', {
		templateUrl : 'c_home/home.html',
		css : 'css/home.css'
	})
	.when('/home', {
		templateUrl : 'c_home/home.html'
	})

	// Login
	.when('/login', {
		controller : 'UserController',
		templateUrl : 'c_user/login.html'
	})

	// for a new user to register
	.when('/register', {
		controller : 'UserController',
		templateUrl : 'c_user/register.html'
	})
	// to upload a picture
	.when('/uploadPicture', {
		templateUrl : 'c_user/uploadPicture.html'
	})
	// for a new user to register
	.when('/logout', {
		controller : 'UserController'
	})

})

app.run(function($cookieStore, $rootScope, $location, UserService) {

	if ($rootScope.currentUser == undefined)
		$rootScope.currentUser = $cookieStore.get('currentUser')

})
