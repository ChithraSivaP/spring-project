///.............................register user...................................

function regcus(){

    let sign={

        username: document.getElementById("username").value,
        password:document.getElementById("password").value,
        email:document.getElementById("email").value,
    }

    console.log(sign);

    $.ajax({

        url: "http://localhost:8080/zomato/signup",

        type: "POST",

        data: JSON.stringify(sign),

        contentType:"application/JSON",

        success: function (data) {
           alert("welcome");
            console.log(data);

                location.href=data.viewName;

        },
        error: function (error) {
            console.log("error");

        }

    });

}


// .......................................login user..........................................
function logcus(){
    console.log("hello");
    alert(username);
    var item = [];
    
       var item = {

                username: document.getElementById("username").value,
        
                password: document.getElementById("password").value,
        
            };
    console.log(item);
    $.ajax({
    type: "POST",
    url: "http://localhost:8080/zomato/login",
    data: JSON.stringify(item),
    contentType:"application/json",
    success: function (result) {
        alert("suc")
        console.log("sucesss");
        console.log(result);

    location.href=result.viewName;

    console.log("hello");
    console.log(result.model.customer.username);
    sessionStorage.setItem("username",result.model.customer.username);
    },
    error: function (result) {
        alert("msg");
    },
});
}

//.........................login admin.....................................
function logadmin(){
    console.log("hello1");
    var item1 = [];
    
       let e=document.getElementById("email").value;
       let p =document.getElementById("password").value;
       var item1 = {

                email: e,
        
                password: p,
        
            };
    console.log(item1);
    $.ajax({
    type: "POST",
    url: "http://localhost:8080/zomato/adlogin",
    data: JSON.stringify(item1),
    contentType:"application/json",
    success: function (result) {
        alert("suc")
        //getAll();
        console.log("sucesss");
        console.log(result);
    location.href=result.viewName;
    console.log("hello");
    console.log(result.model.user.username);
    sessionStorage.setItem("username",result.model.user.username);
    },
    error: function (result) {
        alert("msg");
    },
});
}





// // ................................get full order...............................
function getfull() {
    alert("sucess")
    $('#tableid').DataTable( {
      "ajax": {
        type:"POST",
          "url": "http://localhost:8080/zomato/fullorder",
          "dataSrc": ""
      },
      "columns": [
          { "data": "id" },
          { "data": "ordername" },
          { "data": "buyername" },
          { "data": "res" },
          { "data": "location" }, 
          { "data": "date" },
          { "data": "price" },
          { "data": "cusid"}
      ]
  } );
  }

// ................................insert ...........................................
  
    function insert(){

        var x = [];
    
        let n = document.getElementById("id").value;
    
        let b=document.getElementById("buyername").value;
        let c=document.getElementById("cusid").value;
        let d=document.getElementById("date").value;
        let l=document.getElementById("location").value;
        let o=document.getElementById("ordername").value;
        let p=document.getElementById("price").value;
        let r=document.getElementById("res").value;

    
    
      
    
        console.log(n);
    
            accept(b,c,d,l,o,p,r);
    
    }
    
    
    
    function accept(b,c,d,l,o,p,r){
     
        let ser={
            buyername:b,
            cusid:c,
            date:d,
            location:l,
            ordername:o,
            price:p,
            res:r,
    
        }
    
        console.log(ser);
    
        $.ajax({
    
            url: "http://localhost:8080/zomato/orderentryform",
    
            type: "POST",
    
            data: JSON.stringify(ser),
    
            contentType:"application/JSON",
    
            success: function (data1) {
                console.log("sucess");
                console.log(data1);
    
                    location.href=data1.viewName1;
    
            },
    
            error: function (error) {
    
                console.log("error");
    
            }
    
        });
    
    }
    
   


  //get all function......................................
function getItems() {
    console.log("one member");
    var one = [];
    var one = {

        username :sessionStorage.getItem("username")
    };
    console.log(one);

    $.ajax({
      url: "http://localhost:8080/zomato/customerone",
      type: "POST",
      data: JSON.stringify(one),
      contentType:"application/json",

      success: function (data) {
        // console.log(data);
        var datas = data;
       
        console.log(datas);
        _displayItems(datas);
      },
      error: function (error) {
        console.log(`Error ${error}`);
      },
    });
  }
   // display items.................................
      function _displayItems(datas) {
        const tBody = document.getElementById("no");
        const button = document.createElement("button");
        datas.forEach((item) => {
          let editButton = button.cloneNode(false);
          editButton.innerText = "Edit";
          editButton.setAttribute("onclick", `editItem(${item.id})`);
          let delButton = button.cloneNode(false);
          delButton.innerText = "Delete";
          delButton.setAttribute("onclick", `deleteItem(${item.id})`);
          let tr = tBody.insertRow();
          let td1 = tr.insertCell(0);
          let id = document.createTextNode(item.id);
          td1.appendChild(id);
      let td2 = tr.insertCell(1);
      let ordername = document.createTextNode(item.ordername);
      td2.appendChild(ordername);
      let td3 = tr.insertCell(2);
      let buyername = document.createTextNode(item.buyername);
      td3.appendChild(buyername);
      let td4 = tr.insertCell(3);
      let res = document.createTextNode(item.res);
      td4.appendChild(res);
      let td5 = tr.insertCell(4);
      let location = document.createTextNode(item.location);
      td5.appendChild(location);
      let td6 = tr.insertCell(5);
      let date = document.createTextNode(item.date);
      td6.appendChild(date);
      let td7 = tr.insertCell(6);
      let price = document.createTextNode(item.price);
      td7.appendChild(price);
    });
    no = datas;
  }
  



  function display() {
    $.ajax({
        url: "http://localhost:8080/zomato/datewisecount",
        type: "GET",
      
        contentType:"application/json",

        success: function (data) {
            console.log(data);
        console.log(data);
            let output1 = ''
       for (let objs in data) {
                // set first row
                output1 = '<div class="d-flex">'
                // get data from first array of objects
                data.forEach(item => {
                    output1 += `
                    <div class="row">
                    <div class="col-md-4">
                    <div class="card mb-4 text-white bg-dark" style="width: 16rem;">
     <img class="card-img-top" src="//placeimg.com/290/180/any" alt="Card image cap" style = "width:16rem">
      <div class="card-body col-sm">
        <h5 class="card-title"> Location :${item.ordername}</h5>
        <p class="card-text">Customer name:${item.buyername}</p>
      </div>
      </div>
      </div>
    </div>`
                })
                // close the row
                output1 += '</div>'
            }
          main.insertAdjacentHTML('afterbegin', output1);
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
  }
  