select a.BRANCH_ID,a.NAME from employees a join (
	select max(SALARY) as 'max_salary'
	from employees
	group by BRANCH_ID ) b on (a.SALARY=b.max_salary) group by BRANCH_ID order by a.BRANCH_ID,a.NAME;
