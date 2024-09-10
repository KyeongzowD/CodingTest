select count(*) as FISH_COUNT
from fish_info
where fish_type= (select fish_type
                 from fish_name_info
                 where fish_name='BASS')
OR fish_type=(select fish_type
                 from fish_name_info
                 where fish_name='SNAPPER');