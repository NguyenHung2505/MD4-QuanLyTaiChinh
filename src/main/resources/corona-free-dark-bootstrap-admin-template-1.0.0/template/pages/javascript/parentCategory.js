function showAllCategoryType(){
    $.ajax({
        type: "GET",
        headers:{
            Authorization: 'Bearer' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/parent-categories",
        success: function (item) {
            console.log(item)
            let str = ` `;
            for (let i = 0; i < item.length; i++) {
                str += `<option value = ${item[i].id}>${item[i].name}</option>`
            }
            $("#categoryType").html(str);
        }
    })
}

function showAllCategoryType2(){
    $.ajax({
        type: "GET",
        headers:{
            Authorization: 'Bearer' + localStorage.getItem('token')
        },
        url: "http://localhost:8086/parent-categories",
        success: function (item) {
            console.log(item)
            let str = ` `;
            for (let i = 0; i < item.length; i++) {
                str += `<option value = ${item[i].id}>${item[i].name}</option>`
            }
            $("#category-type").html(str);
        }
    })
}