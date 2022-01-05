/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function addDanhGia(maSP) {
    fetch("/CuaHangMayTinh/api/add-binhluan", {
        method: 'post',
        body: JSON.stringify({
            "binhLuan": document.getElementById("maDG").value,
            "maSP": maSP
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)

        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("khuvucBL");

        area.innerHTML = `
            <div class="row">
                <div class="col-md-2" style="padding: 10px;">
                    <img class="rounded-circle img-fluid" src="${data.maTK.hinhDD}"/>
                </div>
                <div class="col-md-10 my-date">
                    <p>${data.binhLuan}</p>
                    <i>${moment(data.ngayDang).fromNow()}</i>
                </div>
            </div>
        ` + area.innerHTML
    })
}

function addToGioHang(maSP, tenSP, donGia) {
    event.preventDefault()

    fetch("/CuaHangMayTinh/api/giohang", {
        method: 'post',
        body: JSON.stringify({
            "maSP": maSP,
            "tenSP": tenSP,
            "donGia": donGia,
            "soLuong": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data
    })
}

function updateGioHang(obj, maSP) {
    fetch("/CuaHangMayTinh/api/giohang", {
        method: 'put',
        body: JSON.stringify({
            "maSP": maSP,
            "tenSP": "",
            "donGia": 0,
            "soLuong": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data.counter
        let tongTien = document.getElementById("tienGioHang")
        tongTien.innerText = data.tongTien
    })
}

function deleteGioHang(maSP) {
    if (confirm("Bạn chắc chắn xóa sản phẩm này không?") == true) {
        fetch(`/CuaHangMayTinh/api/giohang/${maSP}`, {
            method: "delete"
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter
            let tongTien = document.getElementById("tienGioHang")
            tongTien.innerText = data.tongTien
//            location.reload()
            let row = document.getElementById(`sanpham${maSP}`)
            row.style.display = "none"
        })
    }
}

function thanhToan(){
    if(confirm("Bạn có đồng ý thanh toán?") == true){
        fetch("/CuaHangMayTinh/api/thanhtoan", {
            method: "post"
        }).then(function (res) {
            return res.json()
        }).then(function (code) {
            console.info(code);
            location.reload();
        })
    }
}

function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}