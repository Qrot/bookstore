new Vue({
    el: '#head',
    data: {
        lead: "sale books online",
        welcome: "您好，管理员！",
    }
});

let addBook = new Vue({
    el: '#addBook',
    data: {
        bookName: '',
        bookISBN: '',
        bookAuthor: '',
        bookPublilsh: '',
        bookPubTime: '',
        bookKind: '',
        bookPrice: '',
        bookStorage: '',
        bookCover: '',
        bookSummary: '',
    },
    methods: {
        add() {
            let book = {
                'bookname': this.bookName, 'isbn': this.bookISBN, 'author': this.bookAuthor,
                'publish': this.bookPublilsh, 'publtime': this.bookPubTime, 'kind': this.bookKind,
                'price': this.bookPrice, 'storage': this.bookStorage, 'summary': this.bookSummary
            }
            axios.post('/addbook', {
                book
            }).then((response) => {
                console.log(response);
            }).catch((error) => {
                console.log(error);
            })
        },
    }
});

let bookmgr = new Vue({

})


// 页内内容切换
$(function () {
    $('#left-list .list-group-item').click(function () {
        var $this = this;
        $($('#left-list .list-group-item')).each(function (i, el) {
            var rightel = $('#right-list .right-content').eq(i);
            if ($this == el) {
                $($this).addClass('active');
                rightel.removeClass('d-none');
            } else {
                $(el).removeClass('active');
                rightel.addClass('d-none');
            }
        })
    });
});

// 查看书籍简介
$('[data-toggle="popover"]').popover();