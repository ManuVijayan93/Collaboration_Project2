app.factory('UserService', function($http) {

	console.log('**********From userservice.js => Entering UserService')

	var userService = this
	var BASE_URL = "//localhost:8096/Collaboration_BackEnd/"
	
	
	userService.registerUser = function(user) {
		console.log('**********From UserService.js => registerUser() => calling backend for /register')
		return $http.post(BASE_URL + "/register", user)
	}

	userService.login = function(user) {
		console.log('**********From UserService.js => login() => calling backend for /login')
		return $http.post(BASE_URL + "/login", user)
	}
		
	
	
	userService.logout=function(){
		console.log('**********From UserService.js => logout() => calling backend for /logout')
		return $http.put(BASE_URL + "/logout")
	}
	
	
	
	
	
	
	return userService
	})