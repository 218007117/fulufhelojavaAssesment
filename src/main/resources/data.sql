CREATE TABLE PRODUCT(
    PRODUCT_ID NUMBER not null primary key,
    PRODUCT_TYPE VARCHAR not null,
    INVESTOR_ID NUMBER not null,
    NAME varchar,
    CURRENT_BALANCE  NUMBER(10,5) default 0 not null

);

CREATE TABLE INVESTOR(
    INVESTOR_ID number not null  primary key,
    NAME varchar,
    LAST_NAME varchar,
    CONTACT_NO varchar,
    ADDRESS varchar,
    AGE NUMBER
);

INSERT INTO INVESTOR(INVESTOR_ID, NAME, LAST_NAME, CONTACT_NO, ADDRESS, AGE) VALUES (1, 'StiLo', 'Komo', '0622148022', 'Sandton', 68);
INSERT INTO INVESTOR(INVESTOR_ID, NAME, LAST_NAME, CONTACT_NO, ADDRESS, AGE) VALUES (2, 'Fulu', 'Tshifhango', '0622148082', 'Sandton', 25);
INSERT INTO INVESTOR(INVESTOR_ID, NAME, LAST_NAME, CONTACT_NO, ADDRESS, AGE) VALUES (3, 'John', 'Smit', '0622148082', 'Sandton', 25);
//
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE, INVESTOR_ID, NAME, CURRENT_BALANCE) VALUES ( 100, 'SAVINGS', 2, 'ALLAN GRAY', 18000.25);
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE,INVESTOR_ID,NAME, CURRENT_BALANCE) VALUES ( 2, 'RETIREMENT', 2, 'DiscoveryRF', 5000.25);
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE, INVESTOR_ID, NAME, CURRENT_BALANCE) VALUES ( 3, 'SAVINGS', 1, 'ABSA', 1525.25);
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE, INVESTOR_ID,NAME, CURRENT_BALANCE) VALUES ( 4, 'RETIREMENT', 1, 'NEDBANK RF', 25000.25 );
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE, INVESTOR_ID, NAME, CURRENT_BALANCE) VALUES ( 5, 'SAVINGS', 1, 'CAPITEC', 8000.25);
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE,INVESTOR_ID, NAME, CURRENT_BALANCE) VALUES ( 6, 'RETIREMENT', 2, 'Momentum RF', 20000.25 );

INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE,INVESTOR_ID, NAME, CURRENT_BALANCE) VALUES ( 7, 'SAVINGS', 2, 'INVESTEC', 200 );
INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE,INVESTOR_ID, NAME, CURRENT_BALANCE) VALUES ( 8, 'RETIREMENT', 2, 'SANLAM', 20000 );
-- INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE) VALUES ( 3, 'SAVINGS' );
-- INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_TYPE) VALUES ( 4, 'RETIREMENT' );