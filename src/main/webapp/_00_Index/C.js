   
        $.ajax({  
            type:"post", 
            url:"http://localhost:8080/whattodrink/CCC",   
            dataType:"json",
            success:
                function(data){  
                    console.log(data);  
                    console.log(data[0][0]); 
                    console.log(data[1]); 
                }
        });  

