
/**** delete_all_data_from_tables ****/
delete from distribution_client;
delete from distribution_lists;
delete from actions;
delete from alerts;
delete from media_viewed;
delete from media;
delete from message_client;
delete from clients;
delete from ips;
delete from messages;

/**************************************************************/

/**** SQL_Init_Data_Script: ****/

/**** messages ****/
insert into messages
values
(1, "msg1", 1, now(), "Group1", now(), now());
DO SLEEP(1);
insert into messages
values
(2, "msg2", 1, now(), "Administrators", now(), now());
DO SLEEP(1);
insert into messages
values
(3, "msg3", 1, now(), "Administrators", now(), now());
insert into messages
values
(4, "msg4", 1, now(), null, now(), now());

/**** ips ****/
insert into ips
values
(1, "1.0.0.1", "1.0.0.2", "supportedType1", 5, 0, now(), now()),
(2, "2.0.0.1", "2.0.0.2", "supportedType2", 10, 0, now(), now()),
(3, "3.0.0.1", "3.0.0.2", "supportedType3", 15, 0, now(), now());

/**** client ****/
insert into clients
values
(1, "client1", "777", "c363e595169b4c83badc50b5c4225b79", "123456", "1.1", 1, true, false, "123", 1, true, true, false, 10, "Hebrew", "Basic", "DemoConfigurationAppDB1", "com.example.roi_b1.democonfigurationapp", "", 1, false, null, now(), now()),
		(2, "client2", "888", "c363e595169b4c83badc50b5c4225b79", "123456", "1.2", 2, true, false, "456", 1, true, true, false, 10, "English", "Admin", "DemoConfigurationAppDB2", "com.example.roi_b2.democonfigurationapp", "", 1, false, "Administrators", now(), now()),
			(3, "client3", "999", "c363e595169b4c83badc50b5c4225b79", "123456", "1.3", 3, true, false, "789", 1, true, true, false, 10, "Japanese", "Basic", "DemoConfigurationAppDB3", "com.example.roi_b3.democonfigurationapp", "", 2, false, "Group1", now(), now());

/**** message_client ****/
insert into message_client
values
(1, 1, 1, now(), now()), (2, 1, 2, now(), now()),
(3, 2, 1, now(), now()), (4, 2, 2, now(), now()), (5, 2, 3, now(), now());

/**** media ****/
insert into media
values
(1, "VIDEO_FILE", 100, true, "", "0000", 10, "", 1, now(), now());
DO SLEEP(1);
insert into media
values
(2, "IMAGE_FILE", 200, false, "", "0001", 20, "", 3, now(), now());
DO SLEEP(1);
insert into media
values
(3, "VIDEO_FILE", 300, true, "", "0002", 30, "", 4, now(), now());
DO SLEEP(1);

/**** media_viewed ****/
insert into media_viewed
values
(1, 1, 1, 1, false, now(), now(), now()),
(2, 1, 2, 3, false, now(), now(), now()),
(3, 2, 3, 4, true, now(), now(), now()),
(4, 3, 1, 1, false, now(), now(), now());

/**** alerts ****/
insert into alerts
values
(1, 1, 1, 1, 0, "Administrators", now(), now()),
(2, 2, 1, 1, 1, null, now(), now()),
(3, 3, 1, 0, 0, "Group1", now(), now()),
(4, 1, 1, 0, 1, "Administrators", now(), now());

/**** actions ****/
insert into actions
values
(1, 1, "executor1", "details1", now(), now()),
(2, 2, "executor2", "details2", now(), now()),
(3, 3, "executor3", "details3", now(), now());

/**** distribution_lists ****/
insert into distribution_lists
values
(1, "distLst1", "allowedType1", 0, "Administrators", now(), now()),
(2, "distLst2", "allowedType2", 0, "Administrators", now(), now()),
(3, "distLst3", "allowedType3", 0, null, now(), now()),
(4, "distLst4", "allowedType4", 0, "Group1", now(), now());

/**** distribution_client ****/
insert into distribution_client
values
(1, 1, 1, now(), now()),
(2, 2, 2, now(), now()),
(3, 3, 3, now(), now()),
(4, 4, 2, now(), now());

/**** current_medium_name ****/
insert into current_medium_name
values
(1, 0, now(), now());

/**************************************************************/



