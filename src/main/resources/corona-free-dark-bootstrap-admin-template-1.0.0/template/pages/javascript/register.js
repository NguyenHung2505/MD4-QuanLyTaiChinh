function singUp() {
    let userName = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let user = {
        username: userName,
        password: password,
        confirmPassword: confirmPassword
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "POST",
        url: "http://localhost:8086/register",
        data: JSON.stringify(user),
        success: function () {
            $('#username').val("");
            $('#password').val("");
            $('#confirmPassword').val("");
            alert("Đăng kí thành công!")

        },
        error: function (error) {
            console.log(error)
            alert("Đăng kí thất bại!")
        }
    })
}
