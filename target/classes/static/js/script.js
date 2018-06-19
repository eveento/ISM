var user='';
function initUser(){
    user={"login": $('#login').val(), "password": $('#password').val(), "name": $('#name').val(),
			    "email": $('#email').val()};
}
function addUserAjax(){
	initUser();
	$.ajax({
		type : 'POST',
		url: '/user',
		data: JSON.stringify(user),
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		success : function(user) {
			console.log("succes");
		    window.location.href="/index";
		},
		error: function(){
			window.location.href="/index";
		}

	});
}

function checkLogin(){
    login=$("#login").val();
    password=$("#password").val();
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url: 'user/login',
		data:{
		    "login": login,
		    "password": password
		},
		success : function(user) {
		    alert("Succsess! You are logged in!");
		    window.location.href="/index";
		},
		error : function() {
		    alert("Fail! Please try again!");
		}
	});
}