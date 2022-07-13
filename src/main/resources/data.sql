insert into person (id, creation_date, name, status, type) values (1, '2022-07-12 20:00:00' , 'Carl', 'ACTIVE', 'CANDIDATE');
insert into person (id, creation_date, name, status, type) values (2, '2019-07-12 20:00:00' , 'Davi', 'ACTIVE', 'INTERVIEWER');
insert into person (id, creation_date, name, status, type) values (3, '2019-07-12 20:00:00' , 'Ingrid', 'ACTIVE', 'INTERVIEWER');



insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (1, 1, '9:00', '10:00', '2022-07-18', true, false, false);
insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (2, 1, '9:00', '12:00', '2022-07-13', false, false, true);

insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (3, 2, '9:00', '16:00', '2022-07-18', true, false, true);

insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (4, 3, '12:00', '18:00', '2022-07-18', false, false, false);
insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (5, 3, '12:00', '18:00', '2022-07-20', false, false, false);
insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (6, 3, '9:00', '12:00', '2022-07-12', false, false, false);
insert into slot (id, person_id, init_time, end_time, slot_date, repeat, repeat_everyday, repeat_everyweek) values (7, 3, '9:00', '12:00', '2022-07-14', false, false, false);