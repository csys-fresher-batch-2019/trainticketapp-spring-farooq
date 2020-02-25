

insert into seats(travel_date,train_num,avail_seats)values(to_date('21-04-2020','dd-MM-yyyy'),32636,10);
insert into seats(travel_date,train_num,avail_seats)values(to_date('22-04-2020','dd-MM-yyyy'),32636,10);

insert into seats(travel_date,train_num,avail_seats)values(to_date('21-04-2020','dd-MM-yyyy'),32638,10);

insert into seats(travel_date,train_num,avail_seats)values(to_date('21-04-2020','dd-MM-yyyy'),32639,10);





insert into viewtrain(train_num,train_name,traveldate,boarding_station,destination_station,arr_time,dept_time,route,status,amount)
values(32636,'vaigai expres',to_date('21-04-2020','dd-MM-yyyy'),'chennai','madurai',to_TIMESTAMP('2020-01-0508:00:00','YYYY-MM-DDHH:MI:SS'),
TO_TIMESTAMP('2020-01-0602:00:00','YYYY-MM-DDHH:MI:SS'),'chennai-trichy-madurai','available running',100);

insert into viewtrain(train_num,train_name,traveldate,boarding_station,destination_station,arr_time,dept_time,route,status,amount)
values(32639,'pothigai express',to_date('21-04-2020','dd-MM-yyyy'),'chennai','madurai',to_TIMESTAMP('2020-01-0508:00:00','YYYY-MM-DDHH:MI:SS'),
TO_TIMESTAMP('2020-01-0602:00:00','YYYY-MM-DDHH:MI:SS'),'chennai-trichy-madurai','available running',180);



insert into viewtrain(train_num,train_name,traveldate,boarding_station,destination_station,arr_time,dept_time,route,status,amount)
values(32637,'pandian express',to_date('22-04-2020','dd-MM-yyyy'),'madurai','chennai',TO_TIMESTAMP('2020-01-0102:00:00','YYYY-MM-DDHH:MI:SS'),
TO_TIMESTAMP('2020-01-0212:00:00','YYYY-MM-DDHH:MI:SS'),'madurai-trichy-chennai','available running',150);

insert into viewtrain(train_num,train_name,traveldate,boarding_station,destination_station,arr_time,dept_time,route,status,amount)
values(32638,'intercity express',to_date('21-04-2020','dd-MM-yyyy'),'trichy','tirunelveli',TO_TIMESTAMP('2020-01-0109:00:00','YYYY-MM-DDHH:MI:SS'),
TO_TIMESTAMP('2020-01-0212:00:00','YYYY-MM-DDHH:MI:SS'),'trichy-madurai-tirunelveli','available running',200);
