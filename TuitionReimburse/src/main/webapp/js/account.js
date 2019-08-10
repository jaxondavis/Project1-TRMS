var loadAccount = (account)=>{
    let id = document.querySelector("#employeeid");
    let fname = document.querySelector("#fname");
    let lname = document.querySelector("#lname");
    let email = document.querySelector("#email");
    let birthdate = document.querySelector("#bdate");
    let reportsTo = document.querySelector("#reports2");
    let employeeType = document.querySelector("#emp_type");
    let address = document.querySelector("#address");
    let city = document.querySelector("#city");
    let state = document.querySelector("#state");
    let zipcode = document.querySelector("#zip");
    id.innerHTML = account.employeeid;
    fname.innerHTML = account.firstname;
    lname.innerHTML = account.lastname;
    email.innerHTML = account.email;
    birthdate.innerHTML = account.birthdate;
    reportsTo.innerHTML = account.reportsto;
    employeeType.innerHTML = account.type;
    address.innerHTML = account.address;
    city.innerHTML = account.city;
    state.innerHTML = account.state;
    zipcode.innerHTML = account.zipcode;
}

var getAccount = ()=>{
    let xhr = new XMLHttpRequest();
    console.log(xhr.readyState + " " + xhr.status);
    xhr.onreadystatechange = function()
	{
        if (xhr.readyState == 4 && xhr.status == 200) 
        {
            let account= JSON.parse(xhr.response);
            console.log(account);
            loadAccount(account);
        }
    }
    xhr.open("GET", "http://localhost:8080/TuitionReimburse/loadAccount", true);
    xhr.send();
}

var clickHome = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);

        }
    }

    xhr.open("GET", "http://localhost:8080/ReimbursementApp/",true);
    xhr.send();
}
var clickEditAccount = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/ReimbursementApp/account/edit",true);
    xhr.send();
}
var clickAccount = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);

        }
    }

    xhr.open("GET", "http://localhost:8080/ReimbursementApp/account",true);
    xhr.send();
}
var clickApplications = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/ReimbursementApp/account/applications",true);
    xhr.send();
}
var clickEvents = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }
    xhr.open("GET", "http://localhost:8080/ReimbursementApp/events",true);
    xhr.send();
}
var clickLogout = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/ReimbursementApp/logout",true);
    xhr.send();
}
window.onload = ()=>{
    console.log("before :");
    getAccount();
    console.log("after: ");
    //document.querySelector("#home").addEventListener("click", clickHome, false);
    //document.querySelector("#account").addEventListener("click", clickAccount, false);
    //document.querySelector("#applications").addEventListener("click", clickApplications, false);
    //document.querySelector("#events").addEventListener("click", clickEvents, false);
    //document.querySelector("#editaccount").addEventListener("click", clickEditAccount, false);
    //document.querySelector("#logout").addEventListener("click", clickLogout, false);  
}