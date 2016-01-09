$('#signin-form').validate({
	errorClass : "form-error-class",
	validClass : "form-valid-class",
		rules :{
			"usuario.nome" : {
				required : true
			},
			"usuario.email" : {
				required : true,
				email : true
			},
			"usuario.login" : {
				required : true,
				minlength : 4
			},
			"usuario.senha" : {
				required : true,
				minlength : 6
			}
		}
});