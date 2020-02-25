create table registration 
( 
user_id number,
user_name varchar2(20) not null, 
pass varchar2(20) not null, 
email_id varchar2(200) not null, 
phone_num char(10) not null, 
gender char(1) not null, 
dob date not null, 
city_name varchar2(25) not null, 
blocklist number(1) default '0',
constraint user_id_pk primary key (user_id), 
constraint same_uq unique(email_id), 
constraint gender_ck check (gender in ('M','F')),
constraint phone_num_ck check (phone_num not like '%[^0-9]%'),
constraint blocklist_ck check( blocklist in (1,0))
);


create table viewtrain
(
train_num number ,
train_name varchar2(20),
traveldate date,
boarding_station varchar2(20) not null,
destination_station varchar2(20) not null,
arr_time timestamp not null,
dept_time timestamp not null,
route varchar2(30) not null,
status varchar2(20) not null,
amount number not null,
constraint train_num1_pk primary key (train_num),
constraint station_ck check (boarding_station <> destination_station),
constraint time_ck check (arr_time <> dept_time),
constraint status_ck check (status in('available running','available yet to start','not available','cancelled')),
constraint same_name_and_srcdest_uq unique(train_name,boarding_station,destination_station)
);

create table seats
(
travel_date date,
train_num number not null,
avail_seats number ,
constraint same_tr_number_date unique(train_num,travel_date),
constraint train_num_fk foreign key (train_num)REFERENCES viewtrain(train_num)
);

Create table noOfSeats(
no_of_seats number not null,
constraint seats_pk primary key (no_of_seats)
);


create table booking
(
pnr_num number ,
train_num number ,
user_id number not null,
boarding_station varchar2(20) not null,
destination_station varchar2(20) not null,
no_of_seats number not null,
curr_status varchar2(20) default 'no status',
travel_date date not null,
booked_date timestamp,
amount number default '0',
constraint user_id_fk foreign key (user_id) references registration(user_id),
constraint train_number_fk foreign key (train_num)REFERENCES viewtrain(train_num),
constraint station1_ck check (boarding_station <> destination_station),
constraint seats_fk foreign key (no_of_seats) references noOfSeats(no_of_seats)
--constraint same_id_date_uq unique(user_id,travel_date,train_num)
);



create table bookingQueue
(
pnr_num number ,
train_num number ,
user_id number not null,
boarding_station varchar2(20) not null,
destination_station varchar2(20) not null,
no_of_seats number default '0',
curr_status varchar2(20) default 'no status',
travel_date date not null,
booked_date timestamp,
amount number default '0'
);

create or replace function findavail(i_train_num IN number,i_travel_date in date) 
 return number AS 
 v_remaining_seats number;
 v_booked_seats number;
 v_seats number;
begin
select avail_seats into v_seats from seats where train_num = i_train_num and travel_date=i_travel_date;
return v_seats;
end findavail;


create or replace PROCEDURE PR_booking_status
(
i_train_num  in number ,
i_user_id IN number,
i_boarding_station IN varchar2,
i_destination_station IN varchar2,
i_no_of_seats IN number,
i_travel_date in date
) AS 
V_booking_Seats number;
confirmation number;
v_ck number;
ck number;
v_blocked_list number;
v_total number;
v_seats number;
BEGIN
V_booking_Seats :=0;
confirmation :=0;
v_ck :=0;

    V_booking_seats := findavail (I_train_num,i_travel_date);
    
  -- v_total := total();
   --v_seats:= totalseats();
   update seats set avail_seats = v_booking_seats-i_no_of_seats where train_num= i_train_num and travel_date=i_travel_date;
   
   select avail_seats into confirmation from seats where train_num= i_train_num and travel_date=i_travel_date;
    v_ck :=i_no_of_seats+confirmation;
    ck := (i_no_of_seats-confirmation)-i_no_of_seats;
 
   IF confirmation <= 0  THEN
   
   insert into bookingQueue (user_id,pnr_num,train_num,boarding_station,destination_station,no_of_seats,curr_status,travel_date,booked_date)
   values(i_user_id,pnr_num_seq.nextval,i_train_num,i_boarding_station,i_destination_station,ck,'waiting list',i_travel_date,systimestamp);

   
   insert into booking (user_id,pnr_num,train_num,boarding_station,destination_station,no_of_seats,curr_status,travel_date,booked_date)
   values(i_user_id,pnr_num_seq.nextval,i_train_num,i_boarding_station,i_destination_station,v_ck,'confirmed',i_travel_date,systimestamp);
      
      
   ELSE
   
   insert into booking (user_id,pnr_num,train_num,boarding_station,destination_station,no_of_seats,curr_status,travel_date,booked_date)
   values(i_user_id,pnr_num_seq.nextval,i_train_num,i_boarding_station,i_destination_station,i_no_of_seats,'confirmed',i_travel_date,systimestamp);

  END IF;

  
  
  COMMIT;
END PR_booking_status;


create sequence pnr_num_seq start with 123456789 increment by 1;

create sequence user_id_seq start with 1000 increment by 1;

commit;

Create table noOfSeats(
no_of_seats number not null,
constraint seats_pk primary key (no_of_seats)
);
