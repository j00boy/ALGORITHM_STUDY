##########
## Create folders
import os 

## Find folder names: day_<number>
folder_names = os.listdir(os.getcwd())

is_traversed = False

## Get last folder name formatted "day_{day}"
for folder_name in folder_names:
    if folder_name[0] < "d":
        pass
    
    if folder_name[:3] == "day":
        last_name = folder_name
        is_traversed = True
    elif is_traversed and folder_name[:3]:
        break
    
result = last_name.split("_")
last_cnt = int(result[1])

## Modify its range when needed
for i in range(1, 11):
    day = last_cnt + i

    if (day >= 100) {
        print("day_100 이상은 만들 수 없습니다")
        break;
    }

    os.system(f'mkdir day_{day}')
    os.chdir(f'day_{day}')
    
    os.system(f'touch .gitkeep README.md')
    os.chdir('..')
