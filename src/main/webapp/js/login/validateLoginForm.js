$('#login-form').validate({
	errorClass : "form-error-class",
	validClass : "form-valid-class",
	rules :{
		"usuario" : {
			required : true
		},
		"senha" : {
			required : true,
		}
	}
});