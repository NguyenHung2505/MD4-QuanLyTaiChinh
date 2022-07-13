let show = document.getElementById("display");
let addForm = document.getElementById("addForm");
showAllWallets()
function showAllWallets() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8086/wallets",
        success: function (data) {
            display(data)
        }, error: function (error) {
            console.log(error);
        }
    })
}
function display(data) {
    var content =``;
    for (let i = 0; i < data.length; i++) {
        content += getWallet(data[i])
    }
    document.getElementById("display").innerHTML = content;
}

function getWallet(item) {
    return `<tr>
            <td> ${item.id}</td>
            <td> ${item.name}</td>
            <td> ${item.icon}</td>
            <td> ${item.moneyAmount}</td>
            <td> ${item.moneyType.name}</td>
            <td> ${item.user.username}</td>
            <td><button type="button" class="btn btn-outline-success btn-fw" >Edit</button></td>
            <td><button type="button" class="btn btn-outline-danger btn-fw" onclick="showDeleteForm(${item.id})">Delete</button></td>
        </tr>`

}

function getMoneyType(item){
    var content =``;
    for (let i = 0; i < item.length; i++) {
        content += getTypeName(item[i])
    }
    document.getElementById("showType").innerHTML = content;

}
function getTypeName(item) {
    return `<tr>
            <td> ${item.id}</td>
            <td> ${item.name}</td>
        </tr>`

}

// hàm xóa
function showDeleteForm(id) {
    if (confirm("Do you sure want to delete this wallet??")) {
        $.ajax({
            headers:{
                Authorization: 'Bearer ' + localStorage.getItem("token")
            },
            type: 'DELETE',
            url: 'http://localhost:8086/wallets/' + id,
            success: function () {
                showAllWallets();
            },
            error: function (error) {
                console.log(error)
            }
        })
    }
}

function showAddForm() {
    $("#addModal").modal("show");
    showAllMoneyType()
}

//save house
function saveAdd(){
    let name=document.getElementById('name').value;
    let icon=document.getElementById('icon').value;
    let moneyAmount=document.getElementById('moneyAmount').value;
    let moneyType=document.getElementById('moneyType').value;
    let user = parseInt(localStorage.getItem('id'))
    let wallet = {
        name: name,
        icon: icon,
        moneyAmount: moneyAmount,
        moneyType: {
            id: moneyType
        },
        user: {
            id: user
        }
    }
    console.log(wallet)
    $.ajax({
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json',
        },
        type: "POST",
        url: "http://localhost:8086/wallets",
        data:JSON.stringify(wallet),
        success: function () {
            alert("add new success !")
            showAllWallets()
        }, error: function (error) {
            console.log(error);
        }
    })





}


function searchWallet() {
    let searchName = document.getElementById("search");
    $.ajax({
        type: "GET",
        headers:{
            Authorization: 'Bearer ' + localStorage.getItem("token")
        },
        url: "http://localhost:8086/wallets/findByName/" + searchName.value,
        success: function (data) {
            display(data)
        }
    });
}

function showEditForm() {
    $("#editModal").modal("show");

}
