$(function () {
    var form = $('#register-form');
    form.validate({
        rules: {
            "username": {
                minlength: 8,
                required: true
            },
            "password": {
                minlength: 8,
                required: true
            },
            "re-password": {
                minlength: 8,
                required: true,
                equalTo: "#password"
            }
        },

        messages: {
            "username": {
                minlength: "Maximum 8 characters",
                required: "Username is required"
            },
            "password": {
                minlength: "Maximum 8 characters",
                required: "Password is required"
            },
            "remember": {
                required: "Remember me is required."
            }
        },

        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.input-group').append(error);
        },
        highlight: function (element) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element) {
            $(element).removeClass('is-invalid');
        },
        submitHandler: function () {
            let getUsername = $('#username').val();
            let getPassword = $('#password').val();
            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                data: {
                    username: getUsername,
                    password: getPassword
                },
                success: function (data, status, xhr) {
                    let message = xhr.getResponseHeader('X-Message');
                    showToast(message, 'success', 350, 1500)
                        .fire()
                        .then(() => {
                            location.replace(getContextPath() + '/waiting');
                        });
                },
                error: function (xhr, textStatus, errorThrown) {
                    let message = xhr.getResponseHeader('X-Message');
                    showToast(message, 'error', 350, 1000)
                        .fire()
                        .then(() => {
                            location.replace(getContextPath() + '/login');
                        });
                }
            })
        },
    });
})
