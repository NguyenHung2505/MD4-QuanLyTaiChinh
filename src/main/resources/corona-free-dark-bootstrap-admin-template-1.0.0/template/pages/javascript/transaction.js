// let show = document.getElementById("display")
showAllTransaction();

// hien thi
function showAllTransaction() {
    $.ajax({
        type: "GET",
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/transactions",
        success: function (list) {
            console.log("ok");
            loadTableTransaction(list)
        }, error: function () {
            console.log("fail");
        }
    });
}

// load datab
function loadTableTransaction(list) {
    let str = "";
    console.log(list)
    for (let i = 0; i < list.length; i++) {
        str += `<tr>
      <th scope="row">${i + 1}</th>
      <td>${list[i].wallet.name}</td>
      <td>${list[i].childCategory.name}</td>
      <td>${list[i].moneyAmount}</td>
      <td>${list[i].creatAt}</td>
      <td>${list[i].note}</td>
      <td><button class="btn btn-danger" onclick="deleteTransaction(${list[i].id})">Delete</button></td>  
      
    </tr>`
    }
    document.getElementById("display").innerHTML = str;
}

/////////




getChildCategory()

function getChildCategory() {
    $.ajax({
        type: "GET",
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/child-categories",
        success: function (data) {
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#childCategory").html(str);
        },
        error: function (error) {
            console.log(error)
        }
    })
}


getwallet()

function getwallet() {
    $.ajax({
        type: "GET",
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/wallets",
        success: function (data) {
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#wallet").html(str);
        },
        error: function (error) {
            console.log(error)
        }
    })
}


// save
// let addForm = document.getElementById('addForm').value;

function save() {
    let wallet = document.getElementById('wallet').value
    let childCategory = document.getElementById('childCategory').value
    let moneyAmount = document.getElementById('moneyAmount').value
    let creatAt = document.getElementById('creatAt').value
    let note = document.getElementById('note').value


    let transaction = {
        wallet: {
            id: wallet
        },
        childCategory: {
            id: childCategory
        },
        moneyAmount: moneyAmount ,
        creatAt: "2022-07-07 16:32:31" ,
        note: note

}
    console.log(transaction)

    // let formData = new FormData(addForm);
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/transactions",
        data: JSON.stringify(transaction),
        success: function () {
            showAllTransaction()
            $('#exampleModal').modal('hide');
            transaction.reset();
        },
        error: function (error) {
            console.log(error)
            alert("nhap sai ! xin nhap lai @@")
        }
    })
}

/////////

getwallet1()
function getwallet1() {
    $.ajax({
        type: "GET",
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/wallets",
        success: function (data) {
            let str = "";
            for (let i = 0; i < data.length; i++) {
                str += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#1wallet").html(str);
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function tong(id) {
    $.ajax({
        type: "GET",
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/wallets/" + id,
        success: function (wallet) {
           document.getElementById("tong").innerHTML = `${wallet.moneyAmount}`
        },
        error: function (error) {
            console.log(error)
        }
    })
}


function updateSum() {
    tong(document.getElementById('1wallet').value)
}


function deleteTransaction(id) {
    alert("Xóa rồi nhé !")
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8086/transactions/" + id,
        success: function () {

            console.log("ok")
            showAllTransaction()

        }
    });
}
