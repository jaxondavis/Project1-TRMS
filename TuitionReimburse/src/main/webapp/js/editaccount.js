var loadAccount = (account)=>{
    let id = document.querySelector("#employeeid");
    let fname = document.querySelector("#firstname");
    let lname = document.querySelector("#lastname");
    let email = document.querySelector("#email");
    let birthdate = document.querySelector("#birthdate");
    let reportsTo = document.querySelector("#reportsTo");
    let employeeType = document.querySelector("#type");
    let address = document.querySelector("#address");
    let city = document.querySelector("#city");
    let state = document.querySelector("#state");
    let zipcode = document.querySelector("#zipcode");

    id.innerHTML = account.employeeid;
    fname.innerHTML = account.firstname;
    lname.innerHTML = account.lastname;
    email.innerHTML = account.email;
    birthdate.innerHTML = account.birthdate;
    reportsTo.innerHTML = account.reportsTo;
    employeeType.innerHTML = account.employeeType;
    address.innerHTML = account.address;
    city.innerHTML = account.city;
    state.innerHTML = account.state;
    zipcode.innerHTML = account.zipcode;
}

var getAccount = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
    if (xhr.readyState == 4 && xhr.status == 200) {
        let account= JSON.parse(xhr.response);
        loadAccount(account);
    }}
    xhr.open("GET", "http://localhost:8080/TuitionReimburse/account", true);
    xhr.send();
}

var clickHome = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/",true);
    xhr.send();
}

var clickEditAccount = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/account/edit",true);
    xhr.send();
}

var clickAccount = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/account",true);
    xhr.send();
}

var clickApplications = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/account/applications",true);
    xhr.send();
}

var clickEvents = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/events",true);
    xhr.send();
}

var clickSubmit = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
        }
    }

    xhr.open("PUT", "http://localhost:8080/TuitionReimburse/account/edit",true);
    let payload = jsonBuilder();
    xhr.send(payload);
}

var jsonBuilder = ()=>{
    let id = document.querySelector("#employeeid");
    let fname = document.querySelector("#firstname");
    let lname = document.querySelector("#lastname");
    let email = document.querySelector("email");
    let birthdate = document.querySelector("#birthdate");
    let reportsTo = document.querySelector("#reportsTo");
    let employeeType = document.querySelector("type");
    let address = document.querySelector("#address");
    let city = document.querySelector("#city");
    let state = document.querySelector("#state");
    let zipcode = document.querySelector("#zipcode");
    let password = document.querySelector("#password");

    obj[id.name] = id.value;
    //will finish when we know what's not being sent
    
    let json = JSON.stringify(obj);
    return json;
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
    getAccount();
    document.querySelector("#home").addEventListener("click", clickHome, false);
    document.querySelector("#account").addEventListener("click", clickAccount, false);
    document.querySelector("#applications").addEventListener("click", clickApplications, false);
    document.querySelector("#events").addEventListener("click", clickEvents, false);
    document.querySelector("#editaccount").addEventListener("click", clickEditAccount, false);
    document.querySelector("#logout").addEventListener("click", clickLogout, false);
    document.querySelector("#submit").addEventListener("submit", clickSubmit, false);
}