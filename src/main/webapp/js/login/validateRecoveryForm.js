$('#recovery-form').validate({
	errorClass : "form-error-class",
	validClass : "form-valid-class",
	rules : {
		"emailTo" : {
			required : true,
			email : true
		}
	}
});