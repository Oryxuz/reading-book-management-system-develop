function getContextPath() {
    return window.location.protocol + "//" + window.location.host + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function showToast(title, icon, width, timer) {
    return Swal.mixin({
        icon: icon,
        title: title,
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        allowOutsideClick: false,
        timer: timer,
        width: width
    });
}

function showSwalWithChoice(title, text, icon, confirmButtonText) {
    return Swal.mixin({
        title: title,
        text: text,
        icon: icon,
        allowOutsideClick: false,
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: confirmButtonText
    });
}

function showSwal(title, text, icon) {
    return Swal.mixin({
        title: title,
        text: text,
        icon: icon,
        allowOutsideClick: false,
        confirmButtonColor: true,
    });
}
