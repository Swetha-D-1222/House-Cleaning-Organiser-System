# HouseCleaningOrganiserSystem
This is a console based project that I have created in Eclipse IDE.<br/>
This project contains 3 classes Admin, Staff and Customer each having different operations to be performed<br/>
I have inherited these classes from a Main class calles User <br/>
Admin is responsible for maintaining this entire system and can perform operations like <br/>
      1.Add Staff<br/>
            Admin will collect all the staff details and will store it in the staff table and an email and password for login will be generated
            for then using their name and aadhaar no for login.<br/>      
      2.Remove Staff<br/>
      3.View All Customers<br/>
      3.View All Customers<br/>
      4.View All Staffs<br/>
      5.View All payments<br/>
      6.View Daily Routine<br/>
      7.View all Appointments<br/>
Customer can perform operations like<br/> 
      1.Book an Appointment<br/>
          While booking an appointment customer will input the address, staff to do work (male / female) if staffs are available at the moment<br/>
they will be assigned with work in acsending order of the staff_id once a staff is assigned for an appointment his / her active status will be <br/>
marked as 'no' which means he/she is on duty at the moment<br/>
      2.Cancel Appointment<br/>
Staff can perform operations like<br/>
      1.Confirm Appointment<br/>
          The staff will get the appointment_id from the customer and will confirm the appointment and will generate the payment amount which is 
written as default calculation and once the amount is payed the staff will mark it as amount payed and the time_in will be added to daily_routine table<br/>
      2.Appointment Checkout<br/>
          Once the work is complete the staff will enter work done and the time_out will be added to DailyRoutine table<br/>
I have used MYSQL for DB connection<br/>
I have used tables like Admin, Staff, StaffProof, StaffStatus, Appointment , Payment , DailyRoutine , Customer <br/>
