-- 코드를 입력하세요\
SET @C_o=0;
SET @C_x=0;
SET @C_y=0;
select h.OWNER,h.X,h.Y into @C_o,@C_x,@C_y from HOUSE_LOCATIONS as h where h.OWNER='Carlos';
select h.OWNER,abs(@C_x-h.x)+abs(@C_y-h.y) as DISTANCE from HOUSE_LOCATIONS as h order by DISTANCE desc limit 1;