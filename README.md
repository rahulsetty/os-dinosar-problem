# os-dinosar-problem
This solution uses semaphores to synchronize the passenger processes and car processes:-

  sem car_avail = 0, car_taken = 0, car_filled = 0, passenger_released=0;
   
    process passenger[i=1 to M]
    {
     while (true) do {
             ...
             sleep(random(1000*museo_time));
             P(car_avail); V(car_taken); P(car_filled);
             P(passenger_released);
     }
    }
   
    process car[i=1 to N]
    {        
     while (true) {
             V(car_avail); P(car_taken); V(car_filled);
             sleep(random(1000*ride_time));
             V(passenger_released);
   }
    }
    
    
