import sys
import os

sys.stdin = open ('input.txt', 'r', encoding='UTF-8')

## input.txt  format
'''
첫줄에는 프로젝트 명               IM
문제 개수 == 패키지 개수           2
회사명_문제번호.문제이름            swea_1210_ladder1 
                                  boj_1244_스위치켜고끄기
'''

def touch_file(package_name: str):
    
    platform = package_name.split('_')
    if (platform[0] == 'boj'):
        class_name = "Main"
    elif (platform[0] == 'swea'):
        class_name = "Solution"

    f=open(f'{class_name}.java','w', encoding='utf-8')
    f.write(f'package {packages[i]};\n\n')
    f.write(f'public class {class_name} ' + '{\n\n}')
    f.close()

day = input()
cnt = int(input())
print(f'day: {day}, cnt: {cnt}')

packages = [str(input()) for _ in range(cnt)]

os.chdir(f'{day}/src')

for i in range(cnt):
    os.system(f'mkdir {packages[i]}')   
    os.chdir(f'{packages[i]}')
    touch_file(packages[i])
    os.system('touch input.txt')
    
    os.chdir('..')