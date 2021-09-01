$(document).ready(function () {
    var pjTitle = $("#title");
    var pjTitleEdit = $("#titleEdit");
    var addListLabel = $("#addLabel");
    var addListForm = $("#addList");
    pjTitle.dblclick(function (e) {
        e.preventDefault();
        pjTitleEdit.val(pjTitle.html());
        pjTitle.hide();
        pjTitleEdit.show();
        pjTitleEdit.children("#projectTitle").focus();
    });

    pjTitleEdit.submit(function (e) {
        e.preventDefault();
        let title = $("#projectTitle").val();
        if (title == "") {
            title = "New Project";
        }
        pjTitle.html(title);
        pjTitleEdit.hide();
        pjTitle.show();
    });
    $(document).on('dblclick', ".title", function (e) {
        e.preventDefault();
        let ltTitleEdit = $(this).parent().children(".titleEdit");
        ltTitleEdit.children(".listTitle").val($(this).html());
        ltTitleEdit.children(".listTitle").focus();
        $(this).hide();
        ltTitleEdit.show();

    });
    $(document).on("submit", ".titleEdit", function (e) {
        e.preventDefault();
        let ltTitle = $(this).parent().children(".title");
        let title = $(this).children(".listTitle").val();
        ltTitle.html(title);
        $(this).hide();
        ltTitle.show();
    });

    $(document).on("click", ".addLabel", function (e) {
        e.preventDefault();
        $(this).hide();
        $(this).parent().children("form").show();
        $(this).parent().children("form").children("textarea").focus();
    });

    $(document).on("submit", ".addCard", function (e) {
        e.preventDefault();
        let addCardLabel = $(this).parent().children(".addLabel");
        let content = $(this).children(".addCardContent");
        if (content.val().length > 0) {
            $(this).parents(".list").children(".cardWrap").append(`<div class="cardContent">${content.val()}</div>`);
        }
        content.val("");
        $(this).hide();
        addCardLabel.show();
    });

    $(document).on("click", ".addCardBtn", function (e) {
        e.preventDefault();
        $(this).parent(".addCard").submit();
    });

    $(document).on("click", "#addCardClose", function (e) {
        e.preventDefault();
        $(this).parents(".addCard").children(".addCardContent").val("");
        $(this).parents(".addCard").hide();
        $(this).parents(".cardAddWrap").children(".addLabel").show();
    });

    addListLabel.click(function (e) {
        e.preventDefault();
        addListLabel.hide();
        addListForm.show();
        addListForm.children("#addListTitle").focus();

    });

    addListForm.submit(function (e) {
        e.preventDefault();
        let listTitle = $("#addListTitle");
        if (listTitle.val().length > 0) {
            $("#listWrap").append(`<div class="list">
                <div class="listTitleWrap">
                    <div class="title">${listTitle.val()}</div>
                    <form class="titleEdit">
                        <input class="listTitle" type="text" placeholder="Project Name...">
                    </form>
                </div>
                <div class="cardWrap">
                </div>
                <div class="cardAddWrap">
                    <div class="addLabel">+ Add another card</div>
                    <form class="addCard">
                        <textarea name="" class="addCardContent" cols="30" rows="10" placeholder="card content..."></textarea>
                        <button class="btn btn-green addCardBtn">Add Card</button><span class="close" id="addCardClose">&times</span>
                    </form>
                </div>
            </div>`);
        }
        listTitle.val("");
        addListForm.hide();
        addListLabel.show();
    });

    $("#addListClose").click(function (e) {
        $("#addListTitle").val("");
        addListForm.hide();
        addListLabel.show();
    });
});

$(document).ready(function () {
    var pjTitle = $("#title");
    var pjTitleEdit = $("#titleEdit");
    var addListLabel = $("#addLabel");
    var addListForm = $("#addList");
    pjTitle.dblclick(function (e) {
        e.preventDefault();
        pjTitleEdit.val(pjTitle.html());
        pjTitle.hide();
        pjTitleEdit.show();
        pjTitleEdit.children("#projectTitle").focus();
    });

    pjTitleEdit.submit(function (e) {
        e.preventDefault();
        let title = $("#projectTitle").val();
        if (title == "") {
            title = "New Project";
        }
        pjTitle.html(title);
        pjTitleEdit.hide();
        pjTitle.show();
    });
    $(document).on('dblclick', ".title", function (e) {
        e.preventDefault();
        let ltTitleEdit = $(this).parent().children(".titleEdit");
        ltTitleEdit.children(".listTitle").val($(this).html());
        ltTitleEdit.children(".listTitle").focus();
        $(this).hide();
        ltTitleEdit.show();

    });
    $(document).on("submit", ".titleEdit", function (e) {
        e.preventDefault();
        let ltTitle = $(this).parent().children(".title");
        let title = $(this).children(".listTitle").val();
        ltTitle.html(title);
        $(this).hide();
        ltTitle.show();
    });

    $(document).on("click", ".addLabel", function (e) {
        e.preventDefault();
        $(this).hide();
        $(this).parent().children("form").show();
        $(this).parent().children("form").children("textarea").focus();
    });

    $(document).on("submit", ".addCard", function (e) {
        e.preventDefault();
        let addCardLabel = $(this).parent().children(".addLabel");
        let content = $(this).children(".addCardContent");
        if (content.val().length > 0) {
            $(this).parents(".list").children(".cardWrap").append(`<div class="cardContent">${content.val()}</div>`);
        }
        content.val("");
        $(this).hide();
        addCardLabel.show();
        $(".cardWrap").sortable({
            connectWith: ".cardWrap",
            placeholder: "card-placeholder"
        });
    });

    $(document).on("click", ".addCardBtn", function (e) {
        e.preventDefault();
        $(this).parent(".addCard").submit();
    });

    $(document).on("click", "#addCardClose", function (e) {
        e.preventDefault();
        $(this).parents(".addCard").children(".addCardContent").val("");
        $(this).parents(".addCard").hide();
        $(this).parents(".cardAddWrap").children(".addLabel").show();
    });

    addListLabel.click(function (e) {
        e.preventDefault();
        addListLabel.hide();
        addListForm.show();
        addListForm.children("#addListTitle").focus();

    });

    addListForm.submit(function (e) {
        e.preventDefault();
        let listTitle = $("#addListTitle");
        if (listTitle.val().length > 0) {
            $("#listWrap").append(`<div class="list">
                <div class="listTitleWrap">
                    <div class="title">${listTitle.val()}</div>
                    <form class="titleEdit">
                        <input class="listTitle" type="text" placeholder="Project Name...">
                    </form>
                </div>
                <div class="cardWrap">
                </div>
                <div class="cardAddWrap">
                    <div class="addLabel">+ Add another card</div>
                    <form class="addCard">
                        <textarea name="" class="addCardContent" cols="30" rows="10" placeholder="card content..."></textarea>
                        <button class="btn btn-green addCardBtn">Add Card</button><span class="close" id="addCardClose">&times</span>
                    </form>
                </div>
            </div>`);
        }
        listTitle.val("");
        addListForm.hide();
        addListLabel.show();
        $(".cardWrap").sortable({
            connectWith: ".cardWrap",
            placeholder: "card-placeholder"
        });
    });

    $("#addListClose").click(function (e) {
        $("#addListTitle").val("");
        addListForm.hide();
        addListLabel.show();
    });

    $("#listWrap").sortable({
        placeholder: "list-placeholder",
        handle: ".listTitleWrap",
    });

    $(".cardWrap").sortable({
        connectWith: ".cardWrap",
        placeholder: "card-placeholder"
    });
});