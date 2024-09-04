$(function () {
    $('#book-form').validate({
        rules: {
            "title": {
                required: true,
                minlength: 10
            },
            "author": {
                required: true,
                minlength: 10
            },
            "publisher": {
                required: true,
            },
            "content": {
                required: true,
                minlength: 10
            },
            "imgInp": {
                required: true,
            },
        },
        messages: {
            "title": {
                minlength: "Maximum 10 characters",
                required: "Title is required"
            },
            "author": {
                minlength: "Maximum 10 characters",
                required: "Author is required"
            },
            "publisher": {
                required: "Publisher is required."
            },
            "imgInp": {
                required: "You must choose picture."
            },
            "content": {
                minlength: "Maximum 10 characters",
                required: "Content is required"
            }
        },
        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.form-group').append(error);
        },
        highlight: function (element) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element) {
            $(element).removeClass('is-invalid');
        },
    })
})

function previewFile(input) {
    var fileField = $("input[type=file]");
    var labelImage = $("#labelImage");
    var file = fileField.get(0).files[0];
    var preViewImage = $("#previewImg");
    if (file) {
        var reader = new FileReader();
        reader.onload = function () {
            labelImage.text(fileField.get(0).files[0].name);
            preViewImage.attr("src", reader.result);
        }
        reader.readAsDataURL(file);
    }
}
