
SELECT * FROM step WHERE test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'order by sort_no ;


SELECT * FROM step s 
left join basic_action ba on s.basic_action_entity_id = ba.entity_id 
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;



SELECT s.*, ag.name  FROM step s 
left join action_group ag on s.step_action_group_entity_id  = ag.entity_id 
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;


SELECT sa.* FROM step s 
left join step_attribute sa on s.entity_id = sa.step_entity_id
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;







select * from test_page tp where tp.entity_id ='2e5ab5fb-28a2-4b54-ae05-9dafa44ab72f'

select * from step_attribute sa 
where sa.step_entity_id in (
SELECT entity_id  FROM step WHERE test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
)


SELECT * FROM step s
INNER join step_assertion sa2 on  s.entity_id = sa2.step_entity_id
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;


SELECT * FROM step s
INNER join step_assertion sa2 on  s.entity_id = sa2.step_entity_id
left join step_attribute sa on sa2.entity_id = sa.step_assertion_entity_id  
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;


SELECT sa.* FROM step s
left join step_attribute sa on s.entity_id = sa.step_entity_id
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;


select * from `element` e where name in ('')


select * from `element`;

select * from step_element se ;

select *from step_assertion sa ;


SELECT se.* FROM step s
INNER join step_element se on s.entity_id = se.step_entity_id
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;

select * from step_attribute sa
where sa.step_entity_id in (
SELECT entity_id FROM step WHERE test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b')




SELECT * FROM step s 
Inner join step_element se on s.entity_id=se.step_entity_id 
left join `element` e on se.element_entity_id = e.entity_id  
WHERE s.test_case_entity_id ='d898faf1-ce96-4eda-b520-e88b6bc2548b'
order by s.sort_no ;



select * from basic_action_attribute baa ;


select basic_action.name basic_action_name , basic_action_attribute.name  basic_action_attribute_name  
from basic_action  left join basic_action_attribute  on basic_action_attribute.basic_action_entity_id  = basic_action.entity_id  


select element_entity_id  from step s 
inner join  step_element se on se.step_entity_id = s.test_case_entity_id 
inner join test_case tc on tc.test_case_id = s.test_case_entity_id 




