var loadApplications = (applicationList) => {
//as creating each account div and button next to it make sure to add event listeners to the buttons and id = appId
let applications = document.querySelector("#applications");
applicationList.forEach(element => {
    let div = document.createElement("div");
    let p = document.createElement("p");
    let btn = document.createElement("button");
    div.id = element.applicationID;
    p.innerText = "Event Name: "+element.eventName + " Event Date: " + element.eventDate + " Event Time: " + element.eventTime + " Application Status: " + element.requestStatus;
    btn.innerText = "View"
    btn.addEventListener("click", clickViewApplication,false);
    div.append(p);
    div.append(btn);
    applications.append(div);
});
}

var clickViewApplication = (event)=>{
    //gets parent node's id then send request
    let currBtn = event.target;
    let id = currBtn.parentNode.id;

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        console.log(id);
        
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            //loadApplication(xhr.responseText);
        }
    }

    xhr.open("POST", "http://localhost:8080/TuitionReimburse/myAccount/loadApplications",true);
    //let payload = jsonBuilder(id);
    //console.log(payload);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("appID="+id);
    //window.location.pathname = "/TuitionReimburse/myAccount/applications/applicationID";
}

var jsonBuilder = (id)=>{
    let obj = {};
    obj["appID"] = id;
    let s = JSON.stringify(obj);
    //console.log(s);
    return s;
}

var getApplications = ()=>{
    let xhr = new XMLHttpRequest();
    console.log("in getApplications");
    xhr.onreadystatechange = ()=>{
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.readyState +" "+xhr.status)
            let applications= JSON.parse(xhr.response);
            console.log(applications);
            loadApplications(applications);
        }
    }
    xhr.open("GET", "http://localhost:8080/TuitionReimburse/myAccount/loadApplications", true);
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

var clickAccount = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/myAccount",true);
    xhr.send();
}

var clickApplications = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/myAccount/applications",true);
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

var clickLogout = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("GET", "http://localhost:8080/TuitionReimburse/logout",true);
    xhr.send();
}

window.onload = ()=>{
    getApplications();
    //document.querySelector("#home").addEventListener("click", clickHome, false);
    /* document.querySelector("#account").addEventListener("click", clickAccount, false);
    document.querySelector("#applications").addEventListener("click", clickApplications, false);
    document.querySelector("#events").addEventListener("click", clickEvents, false);
    document.querySelector("#editaccount").addEventListener("click", clickEditAccount, false);
    document.querySelector("#logout").addEventListener("click", clickLogout, false); */
    //document.querySelector("#submit").addEventListener("submit", clickSubmit, false);
}