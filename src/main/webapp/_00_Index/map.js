
function initMap() {
   
      navigator.geolocation.getCurrentPosition(function (position) {
        
         destination1=['台北市中正區新生南路一段52之3號','台北市中正區八德路一段82巷9弄18號','台北市中正區八德路一段82巷9弄20之1號','台北市中山區遼寧街38號','台北市大安區市民大道三段136號','台北市中正區青島東路21之10號','台北市大安區新生南路一段1號'];

         
        // 所在位置跟各點的距離
        var service = new google.maps.DistanceMatrixService();
        service.getDistanceMatrix(
          {
            origins: [pos],
            destinations: destination1,
            travelMode: "WALKING", // 交通方式：BICYCLING(自行車)、DRIVING(開車，預設)、TRANSIT(大眾運輸)、WALKING(走路)
            unitSystem: google.maps.UnitSystem.METRIC, // 單位 METRIC(公里，預設)、IMPERIAL(哩)
          },function (response, status) {
            console.log(response);

            // for(let i = 0, len = response.rows[0].elements.length; i < len; i++) {
           
            //   console.log(response.rows[0].elements[i].distance.value);
              
            //   let dd =response.rows[0].elements[i].distance.value;
            //  let storage = sessionStorage; 
            //  storage.setItem(i,dd);

            }


        );
        

        
      });
    
  }


