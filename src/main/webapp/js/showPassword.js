function showPassword() {
    
    var key_attr = $('#senha').attr('type');
    
    if(key_attr != 'text') {
        $('.checkbox').addClass('show');
        $('#senha').attr('type', 'text');
    } else {
        $('.checkbox').removeClass('show');
        $('#senha').attr('type', 'password');
    }
    
}