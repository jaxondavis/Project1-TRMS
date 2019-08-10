var clickLogin = ()=>{
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            
        }
    }

    xhr.open("POST", "http://localhost:8080/ReimbursementApp/login",true);
    xhr.send();
}

window.onload = ()=>{
    document.querySelector("#login").addEventListener("click", clickLogin, false);
}