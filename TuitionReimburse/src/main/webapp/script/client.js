function checkForm(){
            var cost = document.getElementById("cost").value.trim();
            var time = document.getElementById("time").value.trim();
            var symbolCheck = /^[0-9]+(\.[0-9]{1,2})?$/;
            var timeCheck = /^(1[0-2]|0?[1-9]):[0-5][0-9]$/;
            
            if (!timeCheck.test(time)) {
                errorMessage = "Your input does not match the required format";
                document.getElementById("timeError").innerHTML = errorMessage;
                
                return false;
            }
            
            if (!symbolCheck.test(cost)) {
                errorMessage = "Do not enter '$', letters or special characters";
                document.getElementById("error").innerHTML = errorMessage;
                
                return false;
            }
            
            return true;
        };
    
        function empty(){
            document.getElementById("error").innerHTML = "";
            document.getElementById("timeError").innerHTML = "";
            
        }
        
//        function checkForm() {
//            if(!checkVal){
//                return false;
//            }
//            
//            return true;  
//        }
//    