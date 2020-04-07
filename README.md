# O2System_Back

#### 2020.04.07
#####개인정보와 멤버
1. USER테이블 성(province),도시(city),구역(area) 필드추가
2. 성별: 1-남자, 2-여자
3. /info/update --> @RequestBody추가
4. 파일정보 저장 로직 추가
5. 리스트에서 删除按钮 API로직 변경: 
6. 회원검색조건에 활성화/비활성화(启用/禁用) 조건추가
7. 会员启用/禁用API地址：/member/update/status       parameter: id
8. 初始化密码 : /member/update/reset/password       parameter: id
9. 删除： /member/delete                            parameter: id
10. 列表里添加会员注册时间field
11. 头像图片180X180

#####고객정보
1. 구역area 添加区域字段
2. 영업담당자추가--> key:id, value:realname    (多项)
3. 영업담당자필드추가 : salesman



