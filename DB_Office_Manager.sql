CREATE TABLE project (
    id_project   NUMBER NOT NULL,
    name         VARCHAR2(225) NOT NULL,
    PRIMARY KEY ( id_project ) ENABLE
    
);

CREATE TABLE staff (
    id_staff     NUMBER NOT NULL,
    username     VARCHAR(225) NOT NULL,
    roless       NUMBER NOT NULL,
    status       NUMBER(1, 0),
    names        VARCHAR2(225) NOT NULL,
    email        VARCHAR2(225) NOT NULL,
    phone        VARCHAR2(225),
    avatar       VARCHAR2(225),
    addr_sky     VARCHAR2(225),
    addr_fb      VARCHAR2(225),
    address      VARCHAR2(225),
    levelss      NUMBER,
    major        VARCHAR2(225),
    finishs      VARCHAR2(225),
    school       VARCHAR2(15),
    id_project   NUMBER NOT NULL,
    PRIMARY KEY ( id_staff ) ENABLE,
    FOREIGN KEY ( id_project )
        REFERENCES project ( id_project )
    ENABLE
);

CREATE TABLE timesheet (
    id_ts        NUMBER NOT NULL,
    task         VARCHAR2(225) NOT NULL,
    times        VARCHAR2(225) NOT NULL,
    results      NUMBER(1, 0) NOT NULL,
    note         VARCHAR2(225),
    status       NUMBER(1, 0) NOT NULL,
    id_project   NUMBER NOT NULL,
    id_staff     NUMBER NOT NULL,
    PRIMARY KEY ( id_ts ) ENABLE,
    FOREIGN KEY ( id_project )
        REFERENCES project ( id_project )
    ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE TABLE news (
    id_new     NUMBER NOT NULL,
    title      VARCHAR2(225) NOT NULL,
    image      VARCHAR2(225),
    dates      VARCHAR2(225) NOT NULL,
    contentt   VARCHAR2(225),
    id_staff   NUMBER NOT NULL,
    PRIMARY KEY ( id_new ) ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE TABLE bugs (
    id_bugs    NUMBER NOT NULL,
    names      VARCHAR2(225) NOT NULL,
    id_staff   NUMBER NOT NULL,
    PRIMARY KEY ( id_bugs ) ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE TABLE commentbugs (
    id_cm      NUMBER NOT NULL,
    status     NUMBER(1, 0) NOT NULL,
    id_bugs    NUMBER NOT NULL,
    id_staff   NUMBER NOT NULL,
    PRIMARY KEY ( id_cm ) ENABLE,
    FOREIGN KEY ( id_bugs )
        REFERENCES bugs ( id_bugs )
    ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE TABLE request (
    id_request     NUMBER NOT NULL,
    request_type   NUMBER NOT NULL,
    status         NUMBER(1, 0) NOT NULL,
    id_staff       NUMBER NOT NULL,
    PRIMARY KEY ( id_request ) ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE TABLE reports (
    id_report          NUMBER NOT NULL,
    id_project         NUMBER NOT NULL,
    id_staff           NUMBER NOT NULL,
    calendar_effort    VARCHAR2(225),
    report_effort      VARCHAR2(225),
    aprproved_effort   VARCHAR2(225),
    PRIMARY KEY ( id_report ) ENABLE,
    FOREIGN KEY ( id_project )
        REFERENCES project ( id_project )
    ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE TABLE slide (
    id_slide   NUMBER NOT NULL,
    image      VARCHAR2(225) NOT NULL,
    contentt   VARCHAR2(225),
    id_staff   NUMBER NOT NULL,
    PRIMARY KEY ( id_slide ) ENABLE,
    FOREIGN KEY ( id_staff )
        REFERENCES staff ( id_staff )
    ENABLE
);

CREATE SEQUENCE report_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE request_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE bugs_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE slide_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE staff_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE timesheet_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE project_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE news_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE commentbugs_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

--drop table slide;
--drop table reports;
--drop table request;
--drop table commentbugs;
--drop table bugs;
--drop table news;
--drop table timesheet;
--drop table staff;
--drop table project;