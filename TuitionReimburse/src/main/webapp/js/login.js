var submitLogin = () =>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
        }
    }

    xhr.open("POST", "http://localhost:8080/TuitionReimburse/login",true);
    let payload = jsonBuilder();
    xhr.send(payload);
}

var jsonBuilder = ()=>{
    let form = document.querySelector("#loginForm");
    //let email = form.querySelector("input[name = 'email']").value;
    //let password = form.querySelector("input[name = 'password']").value;
    let elements = form.elements;
    let obj ={};
   // obj.email = email;
    //obj.password = password;
    for(var i = 0 ; i < elements.length-1; i++){
        var item = elements.item(i);
        obj[item.name] = item.value;
        console.log(obj);   
    }
    let json = JSON.stringify(obj);
    return json;
}

window.onload = ()=>{
   document.querySelector("#loginForm").addEventListener("submit", submitLogin,false); 
}