let id;
let token;
let storageKey = 'token';
let storageKeyId = 'id';

function login() {
    let userName = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let user = {
        username: userName,
        password: password,
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "POST",
        url: "http://localhost:8086/login",
        data: JSON.stringify(user),
        success: function (data) {
            alert("Đăng nhập thành công! ")
            console.log(data)
            token = data.accessToken;
            id = data.id;
            localStorage.setItem(storageKey, token)
            localStorage.setItem(storageKeyId, id)


        },
        error: function (error) {
            alert("Đăng nhập thất bại!")
            console.log(error)

        }
    })
}

function logout() {
    token = ""
    id = ""
    localStorage.setItem("token", token)
    localStorage.setItem("id", id)
    window.location.href="pages/samples/login.html"

}