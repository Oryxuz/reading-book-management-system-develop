function deleteBook(id, btn) {
    const element = $('.book-'.concat(id));
    showSwalWithChoice(
        'Are you sure?',
        "You won't be able to revert this!",
        'warning',
        'Yes, delete it!')
        .fire()
        .then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: getContextPath().concat('/admin/book/delete'),
                    type: 'get',
                    data: {
                        id: id
                    },
                    success: function (data, status, xhr) {
                        let message = xhr.getResponseHeader('X-Message');
                        element.remove();
                        showSwal('Deleted!', message, 'success').fire();
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        let message = xhr.getResponseHeader('X-Message');
                        showSwal('Error!', message, 'error').fire();
                    }
                });
            }
        })
}
