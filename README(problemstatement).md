# os-dinosar-problem
As the problem statement mentioned there are passengers as m and n single car passengers.
when ever the car is vacant or free to ride it loads the passengers untill when the passengers has to wait for n which is car.
If all n cars are busy riding the passengers then m number passengers have to wait until car is ready.

explaining with the simple algoritham :-
lets consider,

semophores me=1 
mutex= n

process:take a car

wait (me)
wait(mutex)
get a car;
signal(me)

process : return a car

return a car;
signal(mutex)
