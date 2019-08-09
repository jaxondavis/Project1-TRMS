--CREATE USER reimbursementdb IDENTIFIED BY p4ssw0rd;
--
--GRANT CONNECT, RESOURCE TO  reimbursementdb;
--GRANT DBA TO reimbursementdb WITH ADMIN OPTION;

CREATE TABLE employee(
    employeeId NUMBER PRIMARY KEY,
    firstname VARCHAR2(50) NOT NULL,
    lastname VARCHAR2(50) NOT NULL,
    birthdate DATE,
    reportsTo NUMBER, --FK: FROM EMPLOYEE EMPLOYEEID
    addressId NUMBER, --FK: FROM ADDRESS ADDRESSID
    availableId NUMBER --FK: FROM AVAILABLEREIMBURSEMENT AVAILABLEID
);

CREATE TABLE login(
    loginId NUMBER PRIMARY KEY,
    username VARCHAR2(50) UNIQUE NOT NULL,
    password VARCHAR2(50) NOT NULL, --MAY HASH AND SALT IF HAVE TIME
    email VARCHAR2(320) NOT NULL, --WILL BE VALIDATED ON CLIENT SIDE USING REGEX BEFORE SUBMITTED TO DB -- EMAIL REQUIRED FOR THE PROGRAM
    employeeId NUMBER NOT NULL --FK: FROM EMPLOYEE EMPLOYEEID --CAN'T HAVE LOGINS FOR NON-EMPLOYEES OF THE COMPANY
);

--THIS TABLE WON'T BE UPDATED AFTER INITIAL POPULATION; WILL USE EMPLOYEE TYPES SUCH AS BENCO, DEPTHEAD, EMPLOYEE,ETC
CREATE TABLE employeetype(
    typeId NUMBER PRIMARY KEY,
    type VARCHAR2(25) NOT NULL
);

--DON'T WANT EMPTY ADDRESS INFO TAKING UP SPACE IN DB ESP. SINCE IT WILL BE BEING REFERENCED BY EMPLOYEE TABLE
--IF AN EMPLOYEE IS HOMELESS THEY JUST WON'T NEED TO REFERENCE THIS TABLE
CREATE TABLE address(
    addressId NUMBER PRIMARY KEY,
    address VARCHAR2(75) NOT NULL,
    city VARCHAR2(50) NOT NULL,
    state VARCHAR2(50) NOT NULL,
    zipcode VARCHAR2(10)
);

--LOOKUP TABLE BETWEEN EMPLOYEE AND EMPLOYEETYPE; DUE TO MANY TO MANY RELATIONSHIP
--NOT NULL BECAUSE IF EMPLOYEE IS DELETED WILL CASCADE ON DELETE
CREATE TABLE employeehastype(
    employeeId NUMBER NOT NULL, --FK: FROM EMPLOYEE EMPLOYEEID
    typeId NUMBER NOT NULL --FK: FROM EMPLOYEETYPE TYPEID
);

--STARTS WITH THE TOTALAVAILABLE AMOUNT; ONCE THE AWARDED AMOUNT IS AWARDED IT WILL BE SUBTRACTED FROM CURRENT AVAILABLE FUNDS
CREATE TABLE availablereimbursement(
    availableId NUMBER PRIMARY KEY,
    availableFunds NUMBER(38,2) NOT NULL --DEFAULT VALUE = 1000.00
);

--
CREATE TABLE application(
    appId NUMBER PRIMARY KEY,
    justification VARCHAR2(500 CHAR),
    submitdate DATE, --WILL AUTOMATICALLY INSERT SYSTEM CURRENT DATETIME IN THIS WHEN REQUEST STATUS CHANGES FROM UNSUBMITTED TO PENDING
    employeeId NUMBER NOT NULL, --FK: FROM EMPLOYEE EMPLOYEEID
    reqId NUMBER NOT NULL, --FK: FROM REQUESTSTATUS REQID --DEFAULT UNSUBMITTED TILL USER SUBMITS APPLICATION THEREFORE CHANGING TO PENDING
    eventId NUMBER NOT NULL --FK: FROM EVENT EVENTID
);

--THIS TABLE WON'T BE UPDATED AFTER INITIAL POPULATION; WILL USE APPROVED, DENIED, PENDING, UNSUBMITTED
CREATE TABLE requeststatus(
    reqId NUMBER PRIMARY KEY,
    status VARCHAR2(10)
);

CREATE TABLE event(
    eventId NUMBER PRIMARY KEY,
    eventname VARCHAR2(50),
    eventdate VARCHAR2(25),
    eventtime VARCHAR2(25),
    eventcost NUMBER(38,2),
    eventdescription VARCHAR2(500 CHAR),
    locationId NUMBER,
    formatId NUMBER,
    typeId NUMBER,
    gradeId NUMBER,
    presentationId NUMBER
);

CREATE TABLE eventlocation (
    locationId NUMBER PRIMARY KEY,
    location VARCHAR2(75) NOT NULL,
    city VARCHAR2(50) NOT NULL,
    state VARCHAR2(50) NOT NULL,
    zipcode VARCHAR2(10)
);

--WILL NOT UPDATE TABLE AFTER INITIAL POPULATION; WILL HOLD VALUES GRADE,PRESENTATION,(MAYBE)PASS/FAIL
CREATE TABLE gradingformat(
    formatId NUMBER PRIMARY KEY,
    formatType VARCHAR2(25) NOT NULL
);

--WILL NOT UPDATE TABLE AFTER INITIAL POPULATION; WILL HOLD VALUES (UNIVERSITY COURSES, 0.80)(SEMINARS,0.60)(CERTPREP,0.75)(CERTIFICATION,1.00)(TECHTRAINING,0.90)(OTHER,0.30)
CREATE TABLE eventtype(
    typeId NUMBER PRIMARY KEY,
    type VARCHAR2(25) NOT NULL,
    coverage NUMBER(1,2) NOT NULL
);

--MOST LIKELY WON'T UPDATE THIS TABLE AFTER INITIAL POPULATION; WILL HOLD VALUES A,B,C,D,F,PASS,FAIL
CREATE TABLE grades(
    gradeId NUMBER PRIMARY KEY,
    grade VARCHAR2(10) NOT NULL
);

CREATE TABLE presentations(
    presentationId NUMBER PRIMARY KEY,
    presentationPath VARCHAR2(260 CHAR) NOT NULL --STORING A VIDEO OR PICTURE LIKE THIS IS TABOO--JUST GOING TO STORE ON SERVER AND PUT PATH HERE
);

CREATE SEQUENCE employeeidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE loginidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE employeetypeidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE addressidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE availableidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE appidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE reqidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE eventidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE locationidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE formatidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE eventtypeidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE gradeidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE presentationidseq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE OR REPLACE PROCEDURE insertavailablereimbursement(funds NUMBER)
AS
BEGIN
    INSERT INTO availablereimbursement(availablefunds) VALUES(funds);
END insertavailablereimbursement;
/

CREATE OR REPLACE PROCEDURE updateavailablereimbursement(availid NUMBER, funds NUMBER)
AS
BEGIN
    

CREATE OR REPLACE PROCEDURE insertapplication(justified VARCHAR2, employeei NUMBER, requeststatusid NUMBER, eventi NUMBER)
AS
BEGIN
    INSERT INTO application(justification, employeeid, reqid,eventid) VALUES(justified,employeei,requeststatusid,eventi);
END insertapplication;
/

CREATE OR REPLACE PROCEDURE updateapplication( applicationid NUMBER, justified VARCHAR2, submitted DATE, employeei NUMBER, requeststatusid NUMBER, eventi NUMBER, gradei NUMBER, presentationi NUMBER)
AS
BEGIN
    UPDATE application SET justification = justified,  submitdate = submitted, employeeid = employeei,reqid = requeststatusid, eventid = eventi, gradeid = gradei, presentationid = presentationi 
        WHERE appid = applicationid;
END updateapplication;
/

CREATE OR REPLACE PROCEDURE deleteapplication(applicationid NUMBER)
AS
BEGIN
    DELETE FROM application WHERE appid = applicationid;
END  deleteapplication;
/

CREATE OR REPLACE PROCEDURE insertevent
( eventnam VARCHAR2, eventdat VARCHAR2, eventtim VARCHAR2, eventcos NUMBER, eventdes VARCHAR2, locationi NUMBER, formati NUMBER, typei NUMBER)
AS 
BEGIN
    INSERT INTO event( eventname, eventdate, eventtime, eventcost, eventdescription,locationid,formatid,typeid)
    VALUES(eventnam,eventdat,eventtim,eventcos,eventdes,locationi, formati, typei);
END insertevent;
/

CREATE OR REPLACE PROCEDURE updateevent(eventi NUMBER,eventnam VARCHAR2, eventdat VARCHAR2, eventtim VARCHAR2, eventcos NUMBER, eventdes VARCHAR2, locationi NUMBER, formati NUMBER, typei NUMBER)
AS
BEGIN
    UPDATE event SET eventname = eventnam, eventdate = eventdat, eventtime = eventtim, eventcost =eventcos, eventdescription = eventdes,locationid = locationi, formatid = formati, typeid = typei
        WHERE eventid = eventi;
END updateevent;
/

CREATE OR REPLACE PROCEDURE deleteevent(eventi NUMBER)
AS
BEGIN
    DELETE FROM event WHERE eventid = eventi;
END deleteevent;
/

CREATE OR REPLACE PROCEDURE inserteventlocation(loc VARCHAR2, cit VARCHAR2, stat VARCHAR2, zip VARCHAR2)
AS
BEGIN
    INSERT INTO eventlocation(location,city,state,zipcode) VALUES(loc, cit, stat,zip);
END inserteventlocation;
/

CREATE OR REPLACE PROCEDURE updateeventlocation(locid NUMBER, loc VARCHAR2, cit VARCHAR2, stat VARCHAR2, zip VARCHAR2)
AS
BEGIN
    UPDATE eventlocation SET location = loc, city = cit, state = stat, zipcode=zip WHERE locationid = locid;
END updateeventlocation;
/

CREATE OR REPLACE PROCEDURE deleteeventlocation(locid NUMBER)
AS
BEGIN
    DELETE FROM eventlocation WHERE locationid = locid;
END deleteeventlocation;
/

CREATE OR REPLACE PROCEDURE insertpresentations(prespath VARCHAR2)
AS 
BEGIN
    INSERT INTO presentations(presentationpath) VALUES(prespath);
END insertpresentations;
/

CREATE OR REPLACE PROCEDURE updatepresentations(presid NUMBER, prespath VARCHAR2)
AS
BEGIN
    UPDATE presentations SET presentationpath = prespath WHERE presentationid = presid;
END updatepresentations;
/

CREATE OR REPLACE PROCEDURE deletepresentations(presid NUMBER)
AS
BEGIN
    DELETE FROM presentations WHERE presentationid = presid;
END deletepresentations;
/
