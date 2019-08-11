var loadApplications = (applicationList) => {
    //as creating each account div and button next to it make sure to add event listeners to the buttons and id = appId
    let applications = document.querySelector("#applications");
    applicationList.forEach(element => {
        let div = document.createElement("div");
        let p = document.createElement("p");
        div.id = element.applicationID;
        p.innerText = "Event Name: "+element.eventName + " Event Date: " + element.eventDate + " Event Time: " + element.eventTime + " Application Status: " + element.requestStatus;
        div.append(p);
        applications.append(div);
    });
    }
    
    var clickViewApplication = (event)=>{
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
    
        xhr.open("POST", "http://localhost:8080/TuitionReimburse/myAccount/loadApplications",true);
        //let payload = jsonBuilder(id);
        //console.log(payload);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send("appID="+id);
        window.location.pathname = "/TuitionReimburse/myAccount/applications/applicationID";
    }