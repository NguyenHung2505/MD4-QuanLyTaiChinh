let show = document.getElementById("display");
let addForm = document.getElementById("addForm")

showAllCategory();

function showAllCategory() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8086/categories",
        success: function (data) {
            display(data);
        },
        error: function (error) {
            console.log(error)
        }
    })

}

// hiển thị
function display(data) {
    var content = ``;
    console.log(data)
    for (let i = 0; i < data.length; i++) {
        content += getCategory(data[i])
    }
    document.getElementById("display").innerHTML = content;
}


function getCategory(categories) {

    return `<tr>
                   <td>${categories.id}</td>
                   <td>${categories.name}</td>
                   <td>${categories.parentCategory.name}</td>
                   <td><button type="button" class="btn btn-outline-success btn-fw" onclick="showEditForm(${categories.id})">Edit</button></td>     
                   <td><button type="button" class="btn btn-outline-danger btn-fw" onclick="showDeleteForm(${categories.id})">Delete</button></td>
                   </tr>`
}


// hàm xóa
function showDeleteForm(id) {
    if (confirm("Are you sure you want to delete this category ?")) {
        $.ajax({
            headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
            },
            type: 'DELETE',
            url: 'http://localhost:8086/categories/' + id,
            success: function () {
                showAllCategory()
            },
            error: function (error) {
                console.log(error)
            }
        })
    }
}


//hàm tạo
function createCategory() {
    let name = document.getElementById("name").value;
    let type = document.getElementById("categoryType").value;

    let newCategory = {
        name: name,
        parentCategory: {
            id: type
        }
    };


    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        enctype: 'multipart/form-data',
        url: "http://localhost:8086/categories/",
        data: JSON.stringify(newCategory),
        success: function () {
            alert("Create successfully !")
            showAllCategory();
            $('#addModal').modal('hide');

        },
        errors: function (error) {
            console.log(error)
        }
    })
}


function showAddForm() {
    $("#addModal").modal("show");
    showAllCategoryType()
}


//hàm tìm kiếm

function searchCategory() {
    let searchName = document.getElementById("search");
    $.ajax({
        type: "GET",
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8086/getChildCategory/" + searchName.value,
        success: function (data) {
            display(data)
        }
    });
}

let editId = 0;


//hàm sửa
function update() {
    // let id = document.getElementById("id").value;

    document.getElementById('id').value = id;
    let name1 = document.getElementById("category-name").value;
    let type1 = document.getElementById("category-type").value;


    let newCategory2 = {
        name: name1,
        parentCategory: {
            id: type1
        }
    };


    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        enctype: 'multipart/form-data',
        url: "http://localhost:8086/categories/" + id,
        data: JSON.stringify(newCategory2),
        success: function () {
            alert("Edit successfully !")
            showAllCategory();
            $('#editModal').modal('hide');
        },
        errors: function (error) {
            console.log(error)
        }
    })
}

function showEditForm(editId) {
    id = editId;
    $('#editModal').modal('show');

    showAllCategoryType2()

}