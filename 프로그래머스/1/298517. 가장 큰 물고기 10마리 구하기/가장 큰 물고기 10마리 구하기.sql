select id as ID, length as LENGTH
from fish_info
order by length desc, id asc
limit 10;