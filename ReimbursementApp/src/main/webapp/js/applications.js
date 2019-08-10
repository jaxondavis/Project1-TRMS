var loadApplications = (applicationList) => {
//as creating each account div and button next to it make sure to add event listeners to the buttons and id = appId
let applications = document.querySelector("#applications");
applicationList.forEach(element => {
    let div = document.createElement("div");
    let p = document.createElement("p");
    let btn = document.createElement("button");
    div.id = element.applicationId;
    p.innerText = "Event Name :"+element.eventname + " Event Date:" + element.eventDate + " Event Time:" + element.eventTime + " Application Status: " + element.status;
    btn.innerText = "Edit"
    btn.addEventListener("click", clickEditApplication,false);
    div.append(p);
    div.append(btn);
    applications.append(div);
});
}

var clickEditApplication = (event)=>{
    //gets parent node's id then send request
    let currBtn = event.target;
    let id = currBtn.parentNode.id;

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        console.log();
        
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
        }
    }

    xhr.open("POST", "http://localhost:8080/ReimbursementApp/account/applications",true);
    
    let payload = jsonBuilder(id);
    xhr.send(payload);
}

var jsonBuilder = (id)=>{
    let obj = {};
    obj["applicationId"] = id;
    
}

var getApplications = ()=>{
    let xhr = new XMLHttpRequest();

    if (xhr.readyState == 4 && xhr.status == 200) {
        let applications= JSON.parse(xhr.response);
        loadApplications(applications);
    }
    xhr.open("GET", "http://localhost:8080/ReimbursementApp/account/applications", true);
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
    getApplications();
    document.querySelector("#home").addEventListener("click", clickHome, false);
    document.querySelector("#account").addEventListener("click", clickAccount, false);
    document.querySelector("#applications").addEventListener("click", clickApplications, false);
    document.querySelector("#events").addEventListener("click", clickEvents, false);
    document.querySelector("#editaccount").addEventListener("click", clickEditAccount, false);
    document.querySelector("#logout").addEventListener("click", clickLogout, false);
    //document.querySelector("#submit").addEventListener("submit", clickSubmit, false);
}