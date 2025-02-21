SELECT * FROM basic_action ba 
join step s on s.basic_action_entity_id = ba.entity_id 
INNER join test_case tc on tc.entity_id = s.test_case_entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

SELECT * FROM basic_action ba ;

SELECT * FROM step s
left join basic_action ba on s.basic_action_entity_id = ba.entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

SELECT s.*, ag.name FROM step s
left join action_group ag on s.step_action_group_entity_id = ag.entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

SELECT * FROM step s
left join step_attribute sa on s.entity_id = sa.step_entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

select * from step_attribute sa
where sa.step_entity_id in (
SELECT entity_id FROM step WHERE test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0')


SELECT * FROM step s
INNER join step_element se on s.entity_id = se.step_entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

SELECT * FROM step s
INNER join step_element se on s.entity_id = se.step_entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;


SELECT * FROM step s
INNER join step_assertion sa2 on s.entity_id = sa2.step_entity_id
left join step_attribute sa on sa2.entity_id = sa.step_assertion_entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

SELECT * FROM step s
INNER join step_assertion sa2 on s.entity_id = sa2.step_entity_id
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;




SELECT * FROM 
WHERE s.test_case_entity_id ='a62680aa-fe24-4ee9-9259-247b72be83f0'
order by s.sort_no ;

SELECT * FROM `section` s 
left join `element` e on s.entity_id = e.section_entity_id ;



SELECT * FROM test_page tp 
left join test_page_section tps on tp.entity_id = tps.test_page_entity_id 
left join `section` s on s.entity_id = tps.section_entity_id 
left join `element` e on s.entity_id = e.section_entity_id ;


SELECT * FROM test_page tp;

select* FROM `section` s
inner join test_page_section tps on tps.section_entity_id  = s.entity_id 


SELECT DISTINCT s.* FROM test_page tp 
left join test_page_section tps on tp.entity_id = tps.test_page_entity_id 
left join `section` s on s.entity_id = tps.section_entity_id 



SELECT s.* FROM test_page tp 
left join test_page_section tps on tp.entity_id = tps.test_page_entity_id 
left join `section` s on s.entity_id = tps.section_entity_id 

SELECT * from test_instance ti 
inner join test_case_data tcd  on tcd.entity_id = ti.test_case_data_entity_id ;

select* FROM `section` s
inner join test_page_section tps on tps.section_entity_id = s.entity_id


select* FROM `element` e 
left join `section` s on e.section_entity_id =s.entity_id 
left join test_page_section tps on tps.section_entity_id = s.entity_id 
left join test_page tp on tp.entity_id = tps.test_page_entity_id 





select * from `element` e where e.section_entity_id ='2260271f-e12c-43ec-8236-3939f8207e85'
order by e.name 

SELECT * from `section` s where;


SELECT * FROM test_page tp ; d3aecea5-5b09-430e-a01d-3ea2e8d9583c


select* FROM `element` e WHERE section_entity_id ='1ca47678-cd6f-4557-aa54-9ba1f6ecfe6a';

SELECT s.* from test_page tp
left join test_page_section tps on tps.test_page_entity_id = tp.entity_id
left join `section` s on s.entity_id =tps.section_entity_id
WHERE test_page_id = 'LoginMock'
order by section_name;
