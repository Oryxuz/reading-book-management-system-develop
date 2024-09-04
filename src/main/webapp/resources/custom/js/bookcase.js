function addBookToCase(id) {
    $.ajax({
        url: getContextPath().concat('/user/bookcase/add'),
        type: 'get',
        data: {
            id: id,
        },
        success: function (data, status, xhr) {
            let message = xhr.getResponseHeader('X-Message');
            showSwal('Added!', message, 'success')
                .fire()
                .then(function () {
                    location.replace(getContextPath().concat('/user/bookcase'));
                });
        },
        error: function (xhr, textStatus, errorThrown) {
            let message = xhr.getResponseHeader('X-Message');
            showSwal('Error!', message, 'error').fire();
        }
    });
}

function deleteBookFromCase(bookID) {
    const element = $('.book-'.concat(bookID));
    showSwalWithChoice(
        'Are you sure?',
        "You won't be able to revert this!",
        'warning',
        'Yes, delete it!')
        .fire()
        .then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: getContextPath().concat('/user/bookcase/delete'),
                    type: 'get',
                    data: {
                        bookID: bookID
                    },
                    success: function (data, status, xhr) {
                        let message = xhr.getResponseHeader('X-Message');
                        element.remove();
                        showSwal('Deleted!', message, 'success')
                            .fire();
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        let message = xhr.getResponseHeader('X-Message');
                        showSwal('Error!', message, 'error')
                            .fire();
                    }
                });
            }
        })
}

function deleteAll() {
    const element = $('.book-case');
    showSwalWithChoice(
        'Are you sure?',
        "You won't be able to revert this!",
        'warning',
        'Yes, delete it!')
        .fire()
        .then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: getContextPath().concat('/user/bookcase/deleteAll'),
                    type: 'get',
                    success: function (data, status, xhr) {
                        let message = xhr.getResponseHeader('X-Message');
                        element.remove();
                        showSwal('Deleted!', message, 'success')
                            .fire();
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        let message = xhr.getResponseHeader('X-Message');
                        showSwal('Error!', message, 'error')
                            .fire();
                    }
                });
            }
        })
}