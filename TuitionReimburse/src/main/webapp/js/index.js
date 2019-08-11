var clickLogin = ()=>{
/*     let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = ()=>{
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.response);
            
        }
    }

    xhr.open("POST", "http://localhost:8080/TuitionReimburse/home",true);
    xhr.send(); */
    window.location.pathname = "/TuitionReimburse/login";
}

window.onload = ()=>{
    document.querySelector("#login").addEventListener("click", clickLogin, false);
}