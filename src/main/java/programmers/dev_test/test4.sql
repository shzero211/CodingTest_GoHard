-- 코드를 입력하세요
select ID,NAME,count(*)as '임대 가능 일' from PLACES as p inner join SCHEDULES as s on p.ID=s.PLACE_ID group by PLACE_ID order by ID;