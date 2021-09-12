   
        $.ajax({  
            type:"post", 
            url:"https://whattodrink.herokuapp.com/CCC",   
            dataType:"json",
            success:
                function(data){  
                    console.log(data);  
                    console.log(data[0][0]); 
                    console.log(data[1]); 
                }
        });  

