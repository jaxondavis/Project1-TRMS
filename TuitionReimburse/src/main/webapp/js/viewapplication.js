var loadApplication = (application) => {
    //as creating each account div and button next to it make sure to add event listeners to the buttons and id = appId
    //let applications = document.querySelector("#applications");
    //let div = document.createElement("div");
    //let p = document.createElement("p");
    //div.id = application.applicationID;
    //p.innerText = "Event Name: "+application.eventName + " Event Date: " + application.eventDate + " Event Time: " + application.eventTime + " Application Status: " + application.requestStatus;
    //div.append(p);
    //applications.append(div);
    document.getElementById("eventname").value = application.eventName;
}

var getApplication = ()=>{
    let xhr = new XMLHttpRequest();
    console.log("in getApplications");
    xhr.onreadystatechange = ()=>{
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.readyState +" "+xhr.status)
            let application= JSON.parse(xhr.response);
            console.log(application);
            loadApplication(application);
        }
    }
    xhr.open("POST", "http://localhost:8080/TuitionReimburse/myAccount/loadApplications",true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("appID="+id);
}

window.onload = function()
{
    getApplication();
}