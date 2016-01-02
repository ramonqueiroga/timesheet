jQuery.extend(jQuery.validator.messages, {
    required: "Esse campo é obrigatório.",
    remote: "Please fix this field.",
    email: "Por favor, digite um email válido.",
    url: "Por favor, digite uma URL válida.",
    date: "Por favor, digite uma data válida.",
    dateISO: "Please enter a valid date (ISO).",
    number: "Por favor, digite um número válido.",
    digits: "Please enter only digits.",
    creditcard: "Please enter a valid credit card number.",
    equalTo: "Please enter the same value again.",
    accept: "Please enter a value with a valid extension.",
    maxlength: jQuery.validator.format("Please enter no more than {0} characters."),
    minlength: jQuery.validator.format("Por favor, digite no mínimo {0} caracteres."),
    rangelength: jQuery.validator.format("Please enter a value between {0} and {1} characters long."),
    range: jQuery.validator.format("Please enter a value between {0} and {1}."),
    max: jQuery.validator.format("Please enter a value less than or equal to {0}."),
    min: jQuery.validator.format("Please enter a value greater than or equal to {0}.")
});